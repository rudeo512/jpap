package me.caru.jpa.core.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.oderitem.OrderItem;
import me.caru.jpa.core.order.delivery.Delivery;
import me.caru.jpa.core.order.delivery.DeliveryStatus;

/**
 * Order
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 13.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order extends BaseEntity {

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	private Member member;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	public List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Delivery delivery;

	public void setMember(Member member) {
		if (this.member != null) {
			this.member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}


	/*
	비지니스 로직
	 */

	public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
		Order order = new Order();
		order.setMember(member);
		order.setDelivery(delivery);
		Arrays.stream(orderItems).forEach(order::addOrderItem);
		order.setStatus(OrderStatus.ORDER);
		return order;
	}

	public void cancel() {
		if (delivery.getStatus() == DeliveryStatus.COMP) {
			throw new RuntimeException("이미 배송이 완료된 상품은 취소가 불가능합니다.");
		}

		this.setStatus(OrderStatus.CANCEL);
		orderItems.stream().forEach(OrderItem::cancel);
	}

	public Integer getTotalPrice() {
		return orderItems.stream().reduce(0, (sum, orderItem) -> sum += orderItem.getTotalPrice(), (sum1, sum2) -> sum1 + sum2);
	}
}

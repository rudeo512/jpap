package me.caru.jpa.core.oderitem;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.item.Item;
import me.caru.jpa.core.order.Order;

/**
 * OrderItem
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 13.
 */

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY)
	private Order order;

	private Integer orderPrice;
	private Integer count;

	public static OrderItem createOrderItem(Item item, Integer orderPrice, Integer count) {
		OrderItem orderItem = new OrderItem();
		orderItem.setItem(item);
		orderItem.setOrderPrice(orderPrice);
		orderItem.setCount(count);

		item.removeStock(count);
		return orderItem;
	}

	public void cancel() {
		getItem().addStock(count);
	}

	public Integer getTotalPrice() {
		return getOrderPrice() * getCount();
	}
}



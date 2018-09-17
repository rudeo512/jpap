package me.caru.jpa.core.order;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.DateSuper;
import me.caru.jpa.core.order.delivery.Delivery;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.oderitem.OrderItem;

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
public class Order extends DateSuper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@ManyToOne
	private Member member;

	@OneToMany(mappedBy = "order")
	public List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne(mappedBy = "order")
	private Delivery delivery;

	public void setMember(Member member) {
		if (this.member != null) {
			this.member.getOrders().remove(this);
		}
		this.member = member;
		member.getOrders().add(this);
	}
}

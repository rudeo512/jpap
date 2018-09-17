package me.caru.jpa.core.oderitem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.caru.jpa.core.DateSuper;
import me.caru.jpa.core.item.Item;
import me.caru.jpa.core.order.Order;

/**
 * OrderItem
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 13.
 */

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem extends DateSuper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Item item;

	@ManyToOne
	private Order order;

	private Integer orderPrice;
	private Integer count;
}



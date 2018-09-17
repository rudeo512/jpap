package me.caru.jpa.core.order.delivery;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.order.Order;

/**
 * Delivary
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_delivery")
public class Delivery extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String city;
	private String street;
	private String zipcode;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	@OneToOne
	private Order order;

	public void setOrder(Order order) {
		this.order = order;
		order.setDelivery(this);
	}
}

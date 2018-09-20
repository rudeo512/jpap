package me.caru.jpa.core.order.delivery;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.address.Address;
import me.caru.jpa.core.order.Order;

/**
 * Delivary
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_delivery")
public class Delivery extends BaseEntity {

	@Embedded
	private Address address;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;

	@OneToOne
	private Order order;
}

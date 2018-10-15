package me.caru.jpa.core.order;

import static me.caru.jpa.core.order.OrderSpec.*;
import static org.springframework.data.jpa.domain.Specification.*;

import org.springframework.data.jpa.domain.Specification;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * OrderSearch
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 12.
 */

@Getter
@AllArgsConstructor
public class OrderSearch {
	private String memberName;
	private OrderStatus orderStatus;

	public Specification<Order> toSpecification() {
		return where(memberNameLike(memberName)).and(orderStatusEq(orderStatus));
	}
}

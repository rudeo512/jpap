package me.caru.jpa.core.order;

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
}

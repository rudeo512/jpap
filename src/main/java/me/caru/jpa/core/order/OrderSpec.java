package me.caru.jpa.core.order;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import me.caru.jpa.core.member.Member;

/**
 * OrderSpec
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 15.
 */
public class OrderSpec {
	public static Specification<Order> memberNameLike(final String memberName) {
		return (Specification<Order>)(root, criteriaQuery, criteriaBuilder) -> {
			if (StringUtils.isEmpty(memberName)) {
				return null;
			}

			Join<Order, Member> m = root.join("member", JoinType.INNER);
			return criteriaBuilder.like(m.<String>get("name"), "%" + memberName + "%");
		};
	}

	public static Specification<Order> orderStatusEq(final OrderStatus orderStatus) {
		return (Specification<Order>)(root, criteriaQuery, criteriaBuilder) -> {
			if (orderStatus == null) {
				return null;
			}

			return criteriaBuilder.equal(root.get("status"), orderStatus);
		};
	}
}

package me.caru.jpa.core.order;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.querydsl.jpa.impl.JPAQuery;
import me.caru.jpa.core.member.QMember;

/**
 * OrderRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 12.
 */

@Repository
public class OrderRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void save(Order order) {
		entityManager.persist(order);
	}

	public Order findOne(Long id) {
		return entityManager.find(Order.class, id);
	}

	public List<Order> findAll(OrderSearch orderSearch) {
		QOrder qOrder = QOrder.order;
		QMember qMember = QMember.member;
		JPAQuery<Order> jpaQuery = new JPAQuery<Order>(entityManager);
		jpaQuery
			.from(qOrder);

		if (orderSearch.getOrderStatus() != null) {
			jpaQuery.where(qOrder.status.eq(orderSearch.getOrderStatus()));
		}

		if (StringUtils.hasText(orderSearch.getMemberName())) {
			jpaQuery.innerJoin(qOrder.member, qMember).on(qMember.name.like("%" + orderSearch.getMemberName() + "%"));
		}

		return jpaQuery.fetch();

	}
}

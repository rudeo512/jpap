package me.caru.jpa;

import javax.persistence.EntityManager;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.oderitem.OrderItem;
import me.caru.jpa.core.order.Order;
import me.caru.jpa.core.order.delivery.Delivery;
import me.caru.jpa.core.team.Team;

/**
 * Js
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 14.
 */
@Component
@Transactional
@Slf4j
@RequiredArgsConstructor
public class Js implements ApplicationRunner {
	private final EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Team team = new Team("team1");
		entityManager.persist(team);

		Member member1 = new Member("caru1");
		member1.setTeam(team);
		entityManager.persist(member1);

		Member member2 = new Member("caru2");
		member2.setTeam(team);
		entityManager.persist(member2);

		//////
		Delivery delivery = new Delivery();
		OrderItem orderItem1 = new OrderItem();
		OrderItem orderItem2 = new OrderItem();

		Order order = new Order();
		order.setDelivery(delivery);
		order.addOrderItem(orderItem1);
		order.addOrderItem(orderItem2);

		entityManager.persist(order);
	}
}

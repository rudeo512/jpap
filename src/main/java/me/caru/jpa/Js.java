package me.caru.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.address.Address;
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

		List<Team> teams = entityManager.createQuery("select distinct m.team from Member m", Team.class)
			.getResultList();
		teams.stream().forEach(team1 -> log.info("team =={}", team1));

		List<Address> addresses = entityManager.createQuery("select m.address from Member m where m.name=:name", Address.class)
			.setParameter("name", "caru1")
			.getResultList();
		addresses.stream().forEach(address -> log.info("address == {}", address));

		List<String> names = entityManager.createQuery("select distinct m.name From Member m", String.class)
			.getResultList();
		names.stream().forEach(name -> log.info("name == {}", name));

		List<Object[]> resultList = entityManager.createQuery("select m.id, m.name from Member m")
			.getResultList();
		resultList.stream().forEach(row -> {
			log.info("id: {}, name: {}", row[0], row[1]);
		});

		List<Object[]> resultList1 = entityManager.createQuery("select o.member, o.status, o.delivery from Order o")
			.getResultList();
		resultList1.stream().forEach(row -> {
			log.info("member = {}", row[0]);
			log.info("orderItems = {}", row[1]);
			log.info("delivery = {}", row[2]);
		});

		log.info("end");

	}
}

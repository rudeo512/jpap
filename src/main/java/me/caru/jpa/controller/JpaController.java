package me.caru.jpa.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.order.Order;

/**
 * JpaController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 27.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class JpaController {
	private final EntityManager entityManager;

	@GetMapping("/")
	public String home() {
		Member member = entityManager.find(Member.class, 1L);
		member.getTeam();
		List<Order> orders = member.getOrders();
		log.info("1111 ={}", orders.getClass().getName());
		return "home";
	}
}


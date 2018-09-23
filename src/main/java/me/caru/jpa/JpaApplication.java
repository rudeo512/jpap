package me.caru.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.order.Order;

@RestController
@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class JpaApplication {
	private final EntityManager entityManager;

	@GetMapping("/")
	public String home() {
		Member member = entityManager.find(Member.class, 1L);
		member.getTeam();
		List<Order> orders = member.getOrders();
		log.info("1111 ={}", orders.getClass().getName());
		return "";
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(JpaApplication.class);
		springApplication.run(args);
	}
}

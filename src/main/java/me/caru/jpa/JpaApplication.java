package me.caru.jpa;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.member.Member;

@RestController
@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class JpaApplication {
	private final EntityManager entityManager;

	@GetMapping("/")
	public Member home() {
		return entityManager.find(Member.class, 1L);
	}

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(JpaApplication.class);
		springApplication.run(args);
	}
}

package me.caru.jpa;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.team.Team;

@RestController
@SpringBootApplication
@EnableJpaAuditing
@RequiredArgsConstructor
@Slf4j
public class JpaApplication {
	private final EntityManager entityManager;

	@Transactional
	@GetMapping("/")
	public String home() {
		Member member = entityManager.find(Member.class, 1L);
		Team team = member.getTeam();
		Team team1 = entityManager.find(Team.class, 1L);
		log.info("===={}", team == team1);

		return "home";
	}

	public static void main(String[] args) {

		SpringApplication springApplication = new SpringApplication(JpaApplication.class);
		springApplication.run(args);
	}
}

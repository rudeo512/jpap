package me.caru.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import me.caru.jpa.core.member.Member;
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
public class Js implements ApplicationRunner {
	@Autowired
	private EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Team team = Team.builder().name("team1").build();
		entityManager.persist(team);

		Member member1 = Member.builder().name("caru").team(team).build();
		entityManager.persist(member1);

		Member member2 = Member.builder()
			.name("caru2")
			.team(team)
			.build();
		entityManager.persist(member2);

	}
}

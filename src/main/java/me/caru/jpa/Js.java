package me.caru.jpa;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class Js implements ApplicationRunner {
	@Autowired
	private EntityManager entityManager;

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
	}
}

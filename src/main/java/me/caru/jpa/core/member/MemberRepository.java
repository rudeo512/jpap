package me.caru.jpa.core.member;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * MemberRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 08.
 */

@Repository
public class MemberRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Long save(Member member) {
		entityManager.persist(member);
		return member.getId();
	}

	public Member findOne(Long id) {
		return entityManager.find(Member.class, id);
	}

	public List<Member> findAll() {
		return entityManager.createQuery("select m from Member", Member.class).getResultList();
	}

	public List<Member> findByName(String name) {
		return entityManager.createQuery("select m from Member m where m.name = :name", Member.class).setParameter("name", name).getResultList();
	}
}

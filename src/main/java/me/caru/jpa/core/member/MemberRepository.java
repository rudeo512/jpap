package me.caru.jpa.core.member;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * MemberRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 08.
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	List<Member> findByName(String name);
}

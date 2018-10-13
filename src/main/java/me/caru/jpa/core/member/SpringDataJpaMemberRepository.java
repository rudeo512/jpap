package me.caru.jpa.core.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * AddressRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 05.
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, QuerydslPredicateExecutor<Member> {
}

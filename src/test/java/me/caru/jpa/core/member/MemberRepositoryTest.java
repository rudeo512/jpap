package me.caru.jpa.core.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.test.IntegrationTest;

/**
 * MemberServiceTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 10.
 */
@Slf4j
public class MemberRepositoryTest extends IntegrationTest {
	@Autowired
	private MemberRepository memberRepository;

	private static final String savedName = "caru";
	private static Long savedID;

	@Before
	public void before() {
		Member member = new Member();
		member.setName(savedName);
		savedID = memberRepository.save(member);
	}

	@Test
	public void join() {
		// given
		Member member = new Member();
		member.setName("Kim");

		// when
		Long saveId = memberRepository.save(member);

		// then
		assertThat(saveId).isNotNull();
		log.info("saveId == {}", saveId);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void findMembers() {
		// given
		Member member1 = new Member();
		member1.setName("kim");

		Member member2 = new Member();
		member2.setName("kim");

		// when
		memberRepository.save(member1);
		memberRepository.save(member2);

		// then
		fail("예외가 발행해야 한다");

	}

	@Test
	public void findOne() {
		// when
		Member member = memberRepository.findOne(savedID);

		// then
		assertThat(member).isNotNull();
		assertThat(member.getName()).isEqualTo(savedName);
	}
}
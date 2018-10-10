package me.caru.jpa.core.member;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

	@Test
	public void findMembers() {
	}

	@Test
	public void findOne() {
	}
}
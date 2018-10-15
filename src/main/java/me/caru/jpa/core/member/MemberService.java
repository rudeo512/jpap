package me.caru.jpa.core.member;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * MemberService
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 10.
 */

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	@Transactional(readOnly = false)
	public Long join(Member member) {
		validateDuplicationMember(member);
		return memberRepository.save(member).getId();
	}

	public List<Member> findMembers() {
		return memberRepository.findAll();
	}

	public Member findOne(Long memberId) {
		return memberRepository.getOne(memberId);
	}

	private void validateDuplicationMember(Member member) {
		List<Member> members = memberRepository.findByName(member.getName());
		if (members.isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원입니다");
		}
	}

}

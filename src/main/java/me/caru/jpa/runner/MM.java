package me.caru.jpa.runner;

import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.Getter;
import lombok.Setter;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.member.QMember;

/**
 * MM
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 05.
 */

@Setter
@Getter
public class MM {
	private Long i;
	private String n;

	@QueryDelegate(Member.class)
	public static BooleanExpression sds(QMember member, String n) {
		return member.name.eq(n);
	}
}

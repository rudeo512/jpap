package me.caru.jpa.core.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.member.Member;

/**
 * Team
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 14.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_team")
public class Team extends BaseEntity {
	private String name;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Member> members = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}
}

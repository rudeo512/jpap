package me.caru.jpa.core.team;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	private List<Member> members = new ArrayList<>();

	public Team(String name) {
		this.name = name;
	}
}

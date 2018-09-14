package me.caru.jpa.core.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.DateSuper;
import me.caru.jpa.core.team.Team;

/**
 * Member
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 11.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_member")
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id")
public class Member extends DateSuper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String city;
	private String street;
	private String zipcode;

	@ManyToOne(optional = false)
	private Team team;

	public Member(String name) {
		this.name = name;
	}

	public void setTeam(Team team) {
		if (this.team != null) {
			this.team.getMembers().remove(this);
		}
		this.team = team;
		team.getMembers().add(this);
	}
}

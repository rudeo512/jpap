package me.caru.jpa.core.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_member")
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
}

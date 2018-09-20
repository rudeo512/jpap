package me.caru.jpa.core.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.address.Address;
import me.caru.jpa.core.order.Order;
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
public class Member extends BaseEntity {

	private String name;

	@Embedded
	private Address address;

	@OneToMany(mappedBy = "member")
	private List<Order> orders = new ArrayList<>();

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

	@Override
	public String toString() {
		return "Member{" +
			"id=" + getId() +
			", name='" + name + '\'' +
			", address=" + address +
			'}';
	}
}

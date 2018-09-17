package me.caru.jpa.core.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Music
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */

@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("M")
public class Music extends Item {
	private String director;
	private String actor;
}

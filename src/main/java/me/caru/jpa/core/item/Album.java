package me.caru.jpa.core.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Album
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */
@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("A")
public class Album extends Item {
	private String artist;
	private String age;
}

package me.caru.jpa.core.item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Book
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */

@Entity
@Getter
@NoArgsConstructor
@DiscriminatorValue("B")
public class Book extends Item {
	private String author;
	private String isbn;
}

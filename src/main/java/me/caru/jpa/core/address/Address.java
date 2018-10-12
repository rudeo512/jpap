package me.caru.jpa.core.address;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Address
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 20.
 */

@Embeddable
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String city;
	private String street;
	private String zipcode;
}

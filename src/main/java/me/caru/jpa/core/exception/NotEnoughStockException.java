package me.caru.jpa.core.exception;

/**
 * NotEnoughStockException
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 12.
 */
public class NotEnoughStockException extends RuntimeException {
	public NotEnoughStockException(String message) {
		super(message);
	}
}

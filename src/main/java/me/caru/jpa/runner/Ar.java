package me.caru.jpa.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Ar
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 20.
 */

@Component
@Slf4j
public class Ar implements ApplicationRunner {
	@Value("${url.a}")
	private String url;

	@Value("${message.a}")
	private String message;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("url == {}", url);
		log.info("message == {}", message);

	}
}

package me.caru.jpa.controller.rs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Rs
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 27.
 */

@RestController
@RequiredArgsConstructor
@Slf4j
public class RsController {
	private final RsService rsService;

	@GetMapping("/hello")
	public String hello() {
		return "hello " + rsService.getName();
	}
}

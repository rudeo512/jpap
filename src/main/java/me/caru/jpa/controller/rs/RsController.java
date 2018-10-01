package me.caru.jpa.controller.rs;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Resource<String> hello() {
		log.info("caru512");
		Resource<String> stringResource = new Resource<>("hello " + rsService.getName());
		stringResource.add(linkTo(methodOn(RsController.class).hello()).withSelfRel());
		return stringResource;
	}

	@PostMapping("/hello")
	public Map map() {
		Map map = new HashMap();
		map.put("a", "a");
		map.put("b", "b");
		return map;
	}
}

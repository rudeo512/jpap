package me.caru.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 01.
 */
@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Model model) {

		model.addAttribute("name", "caru");
		return "home";
	}
}

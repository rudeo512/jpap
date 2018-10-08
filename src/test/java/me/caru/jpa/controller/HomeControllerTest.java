package me.caru.jpa.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import me.caru.jpa.test.MyTest;

/**
 * HomeControllerTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 01.
 */
@WebMvcTest(HomeController.class)
public class HomeControllerTest extends MyTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void home() throws Exception {
		mockMvc.perform(get("/home"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("home"))
			.andExpect(model().attribute("name", is("caru")))
			.andExpect(content().string(containsString("caru")));
	}
}
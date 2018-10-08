package me.caru.jpa.controller.rs;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import me.caru.jpa.test.MyTest;

/**
 * RsTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 27.
 */
@WebMvcTest(RsController.class)
public class RsControllerTest extends MyTest {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RsService rsService;

	@Test
	public void hello() throws Exception {
		when(rsService.getName()).thenReturn("rudeo");

		mockMvc.perform(get("/hello"))
			.andExpect(content().string(containsString("hello rudeo")))
			.andExpect(status().isOk());

		Assertions.assertThat(outputCapture.toString()).contains("caru512");
	}

	@Test
	public void ddd() throws Exception {
		mockMvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.a", is(equalTo("a"))))
			.andExpect(jsonPath("$.b", is(equalTo("b"))));
	}

	@Test
	public void xml() throws Exception {
		mockMvc.perform(post("/hello").contentType(MediaType.APPLICATION_JSON_UTF8).accept(MediaType.APPLICATION_XML))
			.andDo(print())
			.andExpect(xpath("/Map/a").string("a"))
			.andExpect(xpath("/Map/b").string("b"));
	}
}
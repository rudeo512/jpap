package me.caru.jpa.controller.rs;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import me.caru.jpa.controller.rs.RsController;
import me.caru.jpa.controller.rs.RsService;
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

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RsService rsService;

	@Test
	public void hello() throws Exception {
		when(rsService.getName()).thenReturn("rudeo");

		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
			.andExpect(MockMvcResultMatchers.content().string("hello rudeo"));
	}
}
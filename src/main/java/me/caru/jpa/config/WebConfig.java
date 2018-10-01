package me.caru.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 01.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/m/**")
			.addResourceLocations("classpath:/m/")
			.setCachePeriod(20);
	}
}

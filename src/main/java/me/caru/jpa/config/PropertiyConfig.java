package me.caru.jpa.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import me.caru.jpa.support.YamlPropertySourceFactory;

/**
 * PropertiyConfig
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 13.
 */
@Configuration
@PropertySources({
	@PropertySource(value = "classpath:config/message/${spring.profiles.active:local}-message.yml", factory = YamlPropertySourceFactory.class),
	@PropertySource(value = "classpath:config/url/${spring.profiles.active:local}-url.yml", factory = YamlPropertySourceFactory.class)
})
public class PropertiyConfig {
}

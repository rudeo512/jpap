package me.caru.jpa.support;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

/**
 * YamlPropertySourceFactory
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 13.
 */
public class YamlPropertySourceFactory implements PropertySourceFactory {

	@Override
	public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource resource) throws IOException {
		Properties propertiesFromYaml = loadYamlIntoProperties(resource);
		String sourceName = name != null ? name : resource.getResource().getFilename();
		return new PropertiesPropertySource(sourceName, propertiesFromYaml);
	}

	private Properties loadYamlIntoProperties(EncodedResource resource) {
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(resource.getResource());
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}

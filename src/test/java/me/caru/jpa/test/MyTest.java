package me.caru.jpa.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MyTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 27.
 */
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.yml")
public abstract class MyTest {
}

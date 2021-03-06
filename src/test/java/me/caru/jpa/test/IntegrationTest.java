package me.caru.jpa.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

/**
 * IntegrationTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 10.
 */

@SpringBootTest
@Transactional
public abstract class IntegrationTest extends MyTest {
}

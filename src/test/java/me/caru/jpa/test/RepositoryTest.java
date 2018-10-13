package me.caru.jpa.test;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * RepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 10.
 */

@DataJpaTest(showSql = false)
public abstract class RepositoryTest extends MyTest {
}

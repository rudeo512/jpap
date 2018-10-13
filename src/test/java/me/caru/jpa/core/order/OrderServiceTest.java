package me.caru.jpa.core.order;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import me.caru.jpa.core.address.Address;
import me.caru.jpa.core.exception.NotEnoughStockException;
import me.caru.jpa.core.item.Book;
import me.caru.jpa.core.item.Item;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.test.IntegrationTest;

/**
 * OrderServiceTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 12.
 */
@Slf4j
public class OrderServiceTest extends IntegrationTest {
	@PersistenceContext
	private EntityManager em;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderRepository orderRepository;

	private Member createMember() {
		Member member = new Member();
		member.setName("회원l");
		member.setAddress(new Address("사울", "강가", "123-123"));
		em.persist(member);
		return member;
	}

	private Book createBook(String name, int price, int stockQuantity) {
		Book book = new Book();
		book.setName(name);
		book.setStockQuantity(stockQuantity);
		book.setPrice(price);
		em.persist(book);
		return book;
	}

	@Test
	public void 상품주문() throws Exception {
		//given
		Member member = createMember();
		Item item = createBook("시골 JPA", 10000, 10); //이름, 가격, 재고
		int orderCount = 2;

		//when
		Long orderld = orderService.order(member.getId(), item.getId(), orderCount);

		//then
		Order getOrder = orderRepository.findOne(orderld);

		assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.ORDER);
		assertThat(getOrder.getOrderItems().size()).isEqualTo(1);
		assertThat(getOrder.getTotalPrice()).isEqualTo(10000 * 2);
		assertThat(item.getStockQuantity()).isEqualTo(8);

	}

	@Test(expected = NotEnoughStockException.class)
	public void 상품주문_재고수량초과() throws Exception {
		// given
		Member member = createMember();
		Item item = createBook("시골 JPA", 10000, 10);
		int orderCount = 11;

		// when
		orderService.order(member.getId(), item.getId(), orderCount);

		// then
		fail("재고 수량 부족");

	}

	@Test
	public void 주문취소() {

		//given
		Member member = createMember();
		Item item = createBook("시골 JPA", 10000, 10); //이름, 가격, 재고
		int orderCount = 2;

		Long orderld = orderService.order(member.getId(), item.getId(), orderCount);

		// when
		orderService.cancelOrder(orderld);

		// then
		Order getOrder = orderRepository.findOne(orderld);
		assertThat(getOrder.getStatus()).isEqualTo(OrderStatus.CANCEL);
		assertThat(item.getStockQuantity()).isEqualTo(10);

	}

}


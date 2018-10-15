package me.caru.jpa.core.order;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import me.caru.jpa.core.item.Item;
import me.caru.jpa.core.item.ItemService;
import me.caru.jpa.core.member.Member;
import me.caru.jpa.core.member.MemberRepository;
import me.caru.jpa.core.oderitem.OrderItem;
import me.caru.jpa.core.order.delivery.Delivery;

/**
 * OrderService
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 12.
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final ItemService itemService;

	@Transactional(readOnly = false)
	public Long order(Long memberId, Long itemId, int count) {
		Member member = memberRepository.getOne(memberId);
		Item item = itemService.findOne(itemId);

		Delivery delivery = new Delivery(member.getAddress());
		OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);
		Order order = Order.createOrder(member, delivery, orderItem);

		orderRepository.save(order);
		return order.getId();
	}

	public void cancelOrder(Long orderId) {
		Order order = orderRepository.getOne(orderId);
		order.cancel();
	}

	public List<Order> findOrders(OrderSearch orderSearch) {
		return orderRepository.findAll(orderSearch.toSpecification());
	}
}

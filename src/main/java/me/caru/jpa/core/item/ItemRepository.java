package me.caru.jpa.core.item;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * ItemRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 10. 12.
 */
@Repository
@Slf4j
public class ItemRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Long save(Item item) {
		if (item.getId() != null) {
			entityManager.persist(item);
		} else {
			entityManager.merge(item);
		}
		return item.getId();
	}

	public Item findOne(Long id) {
		return entityManager.find(Item.class, id);
	}

	public List<Item> findAll() {
		return entityManager.createQuery("select i from Item i", Item.class).getResultList();
	}
}

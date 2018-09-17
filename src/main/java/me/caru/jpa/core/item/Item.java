package me.caru.jpa.core.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.caru.jpa.core.DateSuper;
import me.caru.jpa.core.categoryitem.CategoryItem;

/**
 * Item
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 13.
 */
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_item")
public class Item extends DateSuper {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private Integer price;
	private Integer stockQuantity;

	@OneToMany(mappedBy = "item")
	private List<CategoryItem> categoryItems = new ArrayList<>();
}

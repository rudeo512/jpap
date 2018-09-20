package me.caru.jpa.core.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.caru.jpa.core.BaseEntity;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Item extends BaseEntity {

	private String name;
	private Integer price;
	private Integer stockQuantity;

	@OneToMany(mappedBy = "item")
	private List<CategoryItem> categoryItems = new ArrayList<>();
}

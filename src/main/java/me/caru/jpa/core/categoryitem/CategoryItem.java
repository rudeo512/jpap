package me.caru.jpa.core.categoryitem;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.category.Category;
import me.caru.jpa.core.item.Item;

/**
 * CategoryItem
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_category_item")
public class CategoryItem extends BaseEntity {
	@ManyToOne
	private Category category;

	@ManyToOne
	private Item item;

	public void setCategory(Category category) {
		if (this.category != null) {
			this.category.getCategoryItems().remove(this);
		}

		this.category = category;
		this.category.getCategoryItems().add(this);
	}

	public void setItem(Item item) {
		if (this.item != null) {
			this.item.getCategoryItems().remove(this);
		}

		this.item = item;
		this.item.getCategoryItems().add(this);
	}
}

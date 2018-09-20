package me.caru.jpa.core.category;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.caru.jpa.core.BaseEntity;
import me.caru.jpa.core.categoryitem.CategoryItem;

/**
 * Category
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 09. 17.
 */

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_category")
public class Category extends BaseEntity {

	private String name;

	@OneToMany(mappedBy = "category")
	private List<CategoryItem> categoryItems = new ArrayList<>();
}

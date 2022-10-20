package com.stockManager.sinda.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {
	
	Optional<Categories> findCategorieByCodeCategory(String codeCategory);

}

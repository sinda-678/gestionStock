package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Categories;

public interface CategoriesRepository extends JpaRepository<Categories, Long> {

}

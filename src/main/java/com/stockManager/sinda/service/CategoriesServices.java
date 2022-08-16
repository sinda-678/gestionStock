package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.models.Categories;

public interface CategoriesServices {
	
	Categories create(Categories cat);
	
	Categories findOneById(Long id);
	
	List<Categories> findAll();
	
	String delete(Long id);  

}

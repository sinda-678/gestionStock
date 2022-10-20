package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.CategoriesDto;



public interface CategoriesServices {
	
	CategoriesDto save(CategoriesDto catagorieDto);
	
	
	CategoriesDto findByCodeCategory(String id);
	
	List<CategoriesDto > findAll();
	
	void delete(Long id);

	CategoriesDto findById(Long id);  

}

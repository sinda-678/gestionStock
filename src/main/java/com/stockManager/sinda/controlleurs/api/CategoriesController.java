package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.CategoriesDto;
import com.stockManager.sinda.service.CategoriesServices;
@RestController
public class CategoriesController implements CategoriesApi{

private CategoriesServices categoriesServices;

@Autowired
public CategoriesController(CategoriesServices categoriesServices) {
	this.categoriesServices= categoriesServices;
}
	@Override
	public CategoriesDto save(CategoriesDto categoriesDto) {
		// TODO Auto-generated method stub
		return  categoriesServices.save(categoriesDto);
	}

	@Override
	public CategoriesDto findById(Long id) {
		// TODO Auto-generated method stub
		return  categoriesServices.findById(id);
	}

	@Override
	public CategoriesDto findByCodeArticle(String codeCategory) {
		// TODO Auto-generated method stub
		return  categoriesServices.findByCodeCategory(codeCategory);
	}

	@Override
	public List<CategoriesDto> findAll() {
		// TODO Auto-generated method stub
		return  categoriesServices.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 categoriesServices.delete(id);
	}

}

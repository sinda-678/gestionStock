package com.stockManager.sinda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stockManager.sinda.interfaces.CategoriesRepository;
import com.stockManager.sinda.models.Categories;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoriesServiceImple implements CategoriesServices {

private CategoriesRepository cr;
	
	@Autowired
	CategoriesServiceImple(CategoriesRepository cr){
		this.cr=cr;
	}
	
	@Override
	public Categories create(Categories cat) {
		
		
		Categories cate = cr.save(cat);
		return cate;
	}

	@Override
	public Categories findOneById(Long id) {
		Optional<Categories> categorie =cr.findById(id);
		return categorie.get() ;
	}

	@Override
	public List<Categories> findAll() {
		List<Categories> categorie = cr.findAll();
		
		return  categorie;
	
	}

	@Override
	public String delete(Long id) {
		cr.deleteById(id);
		return "ce message a été supprimé avec succès";
	}

}

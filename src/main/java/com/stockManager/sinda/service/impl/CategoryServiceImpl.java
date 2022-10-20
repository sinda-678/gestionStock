package com.stockManager.sinda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.stockManager.sinda.dto.CategoriesDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.CategoriesRepository;

import com.stockManager.sinda.models.Categories;
import com.stockManager.sinda.service.CategoriesServices;

import com.stockManager.sinda.validator.CategoriesValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryServiceImpl  implements CategoriesServices {
	
	private CategoriesRepository categoriesRepository;
	
	
	@Autowired
	public  CategoryServiceImpl(  CategoriesRepository categoriesRepository) {
		this.categoriesRepository =categoriesRepository;
		
	}
	
	@Override
	public CategoriesDto save(CategoriesDto catagorieDto) {
List<String> errors = CategoriesValidator.validate(catagorieDto);
		
		if(!errors.isEmpty()) {
			log.error("La categorie is not valid{}",catagorieDto);
			throw new InvalidEntityException("La categorie  n'est pas valide",ErrorsCodes.CATEGORIES_NOT_VALID);
		}
		return  CategoriesDto.fromEntity(categoriesRepository.save( CategoriesDto.toEntity(catagorieDto))
				);
	}

	@Override
	public CategoriesDto findById(Long id) {
	
		if(id == null) {
			log.error("La Category  ID is null");
			return null;
		}
		Optional<Categories> categories =  categoriesRepository.findById(id) ;
		CategoriesDto cate = 	CategoriesDto.fromEntity(categories.get());
		
		return Optional.of(cate).orElseThrow(()-> new EntityNotFoundException("Aucune categorie avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.CATEGORIES_NOT_FOUND));
	} 

	@Override
	public CategoriesDto findByCodeCategory(String codeCategory) {
		if(!StringUtils.hasLength(codeCategory)) {
			log.error("La Category  du code  is null");
		}
		Optional<Categories> categories = categoriesRepository.findCategorieByCodeCategory(codeCategory);
		return  Optional.of(CategoriesDto.fromEntity(categories.get())).orElseThrow(()-> new EntityNotFoundException("Aucune Category avec code  = " +codeCategory +" n'est valide dans la BD",ErrorsCodes.CATEGORIES_NOT_FOUND));
	}

	@Override
	public List<CategoriesDto> findAll() {
		// TODO Auto-generated method stub
		return   categoriesRepository.findAll().stream()
				.map(CategoriesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id == null) {
			log.error("La Categories  ID is null");
			return ;
		}
		 categoriesRepository.deleteById(id);
	}
	

}

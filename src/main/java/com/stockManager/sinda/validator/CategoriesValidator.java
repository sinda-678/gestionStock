package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.CategoriesDto;


public class CategoriesValidator {
	
	public static List<String> validate(CategoriesDto categoriesDto){
		
		
		List<String> errors =new ArrayList();
		
		if(!StringUtils.hasLength(categoriesDto.getCodeCategory())) {
			errors.add("veuillez entrer le code la categorie");
		}
		if(categoriesDto==null) {
			errors.add("veuillez entrer le code la categorie");
		}
		return errors;
	}

} 

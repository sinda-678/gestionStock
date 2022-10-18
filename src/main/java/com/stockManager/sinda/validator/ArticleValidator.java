package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.ArticleDto;



public class ArticleValidator {

	
	public static List<String> validate(ArticleDto articleDto){
		
		
		List<String> errors =new ArrayList();
		
		if(articleDto==null) {
			errors.add("veuillez renseigner le code de l'article");
			errors.add("veuillez renseigner le prix unitaire de l'article");
			errors.add("veuillez renseigner le prix de l'article");
			errors.add("veuillez renseigner le prix de la tva de l'article");
			errors.add("veuillez renseigner la category de l'article");
		}
		if(!StringUtils.hasLength(articleDto.getCodeArticle())) {
			errors.add("veuillez renseigner le code de l'article");
		
		}
		
		if(articleDto.getPrixUnitaireht() == null) {
			errors.add("veuillez renseigner le prix unitaire de l'article");
		}
		
		if(articleDto.getPrixUnitaireTtc()== null) {
			errors.add("veuillez renseigner le prix de l'article");
		}
		
		if(articleDto.getPrixTva() == null) {
			errors.add("veuillez renseigner le prix de la tva de l'article");
		}
		
		if(articleDto.getCategory()== null) {
			errors.add("veuillez renseigner la category de l'article");
		}
		return errors;
		}
	
}

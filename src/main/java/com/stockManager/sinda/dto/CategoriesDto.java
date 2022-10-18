package com.stockManager.sinda.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.Address;
import com.stockManager.sinda.models.Categories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class CategoriesDto {

	private Long id;
	
	private String codeCategory;
	
	
	private String designation;
	
	@JsonIgnore
	private List<ArticleDto> articles;
	
	
	 public CategoriesDto fromEntity(Categories categories) {
	    	
	    	if( categories== null) {
	    		return null;
	    	}
	    	
	    	return CategoriesDto.builder()
	    			.id(categories.getId())
	    			.codeCategory(categories.getCodeCategory())
	    			.designation(categories.getDesignation())
	    			
	    			.build();
	    }
	    
	    public Categories toEntity( CategoriesDto categoriesDto) {
	    	
	    	if(categoriesDto == null) {
	    		return null;
	    	}
	    	
	    	Categories categorie = new Categories();
	    	categorie.setId(categoriesDto.getId());
	    	categorie.setCodeCategory(categoriesDto.getCodeCategory());
	    	categorie.setDesignation(categoriesDto.getDesignation());
	    	return categorie;
	    	
	    	
	    }
	    

}

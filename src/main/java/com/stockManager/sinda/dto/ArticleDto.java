package com.stockManager.sinda.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stockManager.sinda.models.Address;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Categories;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleDto {
	
	private Long id;
	
	private Long idCompany;
	
	
	private String codeArticle;
   

	private String designation;
    
	
    private BigDecimal prixUnitaireht;
    
	
    private BigDecimal prixTva;
    
	
    private BigDecimal prixUnitaireTtc;
    

	private String photo;
	
	
	private CategoriesDto category;
    
	
	 public static ArticleDto fromEntity(Article article) {
	    	
	    	if(article== null) {
	    		return null;
	    	}
	    	
	    	return  ArticleDto.builder()
	    			.id(article.getId())
	    			.idCompany(article.getIdCompany())
	    			.codeArticle(article.getCodeArticle())
	    			.designation(article.getDesignation())
	    			.prixUnitaireht(article.getPrixUnitaireht())
	    			.prixUnitaireTtc(article.getPrixUnitaireTtc())
	    			.photo(article.getPhoto())
	    			
	    			.build();
	    }
	    
	    public static Article toEntity( ArticleDto articleDto) {
	    	
	    	if(articleDto == null) {
	    		return null;
	    	}
	    	
	    	Article articles = new Article();
	    	
	    	articles.setId(articleDto.getId());
	    	articles.setIdCompany(articleDto.getIdCompany());
	    	articles.setCodeArticle(articleDto.getCodeArticle());
	    	articles.setDesignation(articleDto.getDesignation());
	    	articles.setPrixUnitaireht(articleDto.getPrixUnitaireht());
	    	articles.setPrixUnitaireTtc(articleDto.getPrixUnitaireTtc());
	    	articles.setPhoto(articleDto.getPhoto());
	    	
	    	
	    	return articles;
	    	

}}


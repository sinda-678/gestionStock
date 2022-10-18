package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.ArticleDto;


public interface ArticleService {
	
	ArticleDto save(ArticleDto Dto);
	
	ArticleDto findById(Long id);
	
	ArticleDto findByCodeArticle(String codeArticle);
	
	List<ArticleDto> findAll();
	
	void delete(Long id);

}

package com.stockManager.sinda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.ArticleDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.ArticleRepository;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Categories;
import com.stockManager.sinda.service.ArticleService;

import com.stockManager.sinda.validator.ArticleValidator;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {
	
	private  ArticleRepository  articleRepository;
	
	
	@Autowired
	public  ArticleServiceImpl ( ArticleRepository  articleRepository) {
		
		
		this.articleRepository = articleRepository;
	}
	
	
	
	@Override
	public ArticleDto save(ArticleDto Dto) {
	
		List<String> errors = ArticleValidator.validate(Dto);
		
		if(!errors.isEmpty()) {
			log.error("Article is not valid{}",Dto);
			throw new InvalidEntityException("L'article n'est pas valide",ErrorsCodes.ARTICLE_NOT_VALID);
		}
		return  ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(Dto))
				);
	}

	@Override
	public ArticleDto findById(Long id) {
	
		if(id == null) {
			log.error("L'article  ID is null");
			return null;
		}
		Optional<Article> article =  articleRepository.findById(id) ;
		ArticleDto Dto = 	ArticleDto.fromEntity(article.get());
		
		return Optional.of(Dto).orElseThrow(()-> new EntityNotFoundException("Aucun article avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		if(!StringUtils.hasLength(codeArticle)) {
			log.error("L'article  du code  is null");
		}
		Optional<Article> article =  articleRepository.findArticleByCodeArticle(codeArticle) ;
		return  Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()-> new EntityNotFoundException("Aucun article avec code  = " +codeArticle +" n'est valide dans la BD",ErrorsCodes.ARTICLE_NOT_FOUND));
	}

	@Override
	public List<ArticleDto> findAll() {
		// TODO Auto-generated method stub
		return  articleRepository.findAll().stream()
				.map(ArticleDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id == null) {
			log.error("L'article  ID is null");
			return ;
		}
		articleRepository.deleteById(id);
	}
	

}

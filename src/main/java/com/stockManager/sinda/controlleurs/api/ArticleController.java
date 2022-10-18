package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.ArticleDto;
import com.stockManager.sinda.service.ArticleService;

@RestController
public class ArticleController implements ArticleApi{
	private ArticleService articleService;
	
	@Autowired
	public  ArticleController( ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Override
	public ArticleDto save(ArticleDto Dto) {
		// TODO Auto-generated method stub
		return  articleService.save(Dto) ;
	}

	@Override
	public ArticleDto findById(Long id) {
		// TODO Auto-generated method stub
		return  articleService.findById(id);
	}

	@Override
	public ArticleDto findByCodeArticle(String codeArticle) {
		// TODO Auto-generated method stub
		return articleService.findByCodeArticle(codeArticle);
	}

	@Override
	public List<ArticleDto> findAll() {
		// TODO Auto-generated method stub
		return  articleService.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 articleService.delete(id);
	}

}

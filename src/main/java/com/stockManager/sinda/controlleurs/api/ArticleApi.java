package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.ArticleDto;

@RequestMapping("/api/article")
public interface ArticleApi {

	@PostMapping("/create")
	ArticleDto save(@RequestBody ArticleDto Dto);
	
	@GetMapping("/{idArticle}")
	ArticleDto findById(@PathVariable("idArticle") Long id);
	
	
	@GetMapping("/codeArticle")
	ArticleDto findByCodeArticle(@PathVariable("codeArticle")  String codeArticle);
	
	
	@GetMapping("/all")
	List<ArticleDto> findAll();
	
	
	@DeleteMapping("/delete/{idArticle}")
	void delete(@PathVariable("idArticle") Long id);
	
}

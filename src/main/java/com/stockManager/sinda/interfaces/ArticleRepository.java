package com.stockManager.sinda.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	
	Optional<Article> findArticleByCodeArticle(String codeArticle);
	
	
}

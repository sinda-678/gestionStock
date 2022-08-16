package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}

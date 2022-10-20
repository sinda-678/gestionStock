package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.CategoriesDto;
@RequestMapping("/api/categorie")
public interface CategoriesApi {
	


	@PostMapping("/creates")
	CategoriesDto save(@RequestBody CategoriesDto categoriesDto);
	
	@GetMapping("/{idCategory}")
	CategoriesDto findById(@PathVariable("idCategory") Long id);
	
	
	@GetMapping("/codeCategory")
	CategoriesDto findByCodeArticle(@PathVariable("codeCategory")  String codeCategory);
	
	
	@GetMapping("/all")
	List<CategoriesDto> findAll();
	
	
	@DeleteMapping("/delete/{idCategory}")
	void delete(@PathVariable("idCategory") Long id);
	

}

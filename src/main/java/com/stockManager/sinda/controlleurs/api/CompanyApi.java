package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.CompagnyDto;

@RequestMapping("/api/company")
public interface CompanyApi {

	@PostMapping("/create")
	 CompagnyDto save(@RequestBody CompagnyDto categoriesDto);
	
	@GetMapping("/{idCompany}")
	 CompagnyDto findById(@PathVariable("idCompany") Long id);
	
	
	
	@GetMapping("/all")
	List< CompagnyDto> findAll();
	
	
	@DeleteMapping("/delete/{idCompany}")
	void delete(@PathVariable("idCompany") Long id);
	

}

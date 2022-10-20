package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.CompagnyDto;



public interface CompanyService {

	

CompagnyDto save(CompagnyDto compagnyDto);
	
CompagnyDto findById(Long id);
	
	
	
	List<CompagnyDto> findAll();
	
	void delete(Long id);

	
}

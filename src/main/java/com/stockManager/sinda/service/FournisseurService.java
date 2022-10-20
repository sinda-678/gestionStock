package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.FournisseurDto;



public interface FournisseurService {

FournisseurDto save(FournisseurDto fournisseurDto);
	
FournisseurDto findById(Long id);
	
	List<FournisseurDto> findAll();
	
	void delete(Long id);

}

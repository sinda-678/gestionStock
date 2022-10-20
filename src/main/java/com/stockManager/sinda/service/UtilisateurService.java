package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.UtilisateurDto;



public interface UtilisateurService {


UtilisateurDto save(UtilisateurDto utilisateurDto);
	
UtilisateurDto findById(Long id);
	
	
	
	List<UtilisateurDto> findAll();
	
	void delete(Long id);

	
}

package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.VenteDto;



public interface VenteService {
	
	
	VenteDto save(VenteDto Dto);
	
	VenteDto findById(Long id);
	
	
	
	List<VenteDto > findAll();
	
	void delete(Long id);

}

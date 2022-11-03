package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.VenteDto;

@RequestMapping("/api/vente")
public interface VenteApi {
	
	
	@PostMapping("/create")
	VenteDto save(@RequestBody VenteDto Dto);
	
	
	@GetMapping("/{idVente}")
	VenteDto findById(Long id);
	
	
	@GetMapping("/all")
	List<VenteDto > findAll();
	
	
	@DeleteMapping("/delete/{idVente}")
	void delete(Long id);


}

package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.FournisseurDto;


@RequestMapping("/api/fournisseur")
public interface FournisseurApi {

	

	@PostMapping("/creates")
	FournisseurDto save(@RequestBody FournisseurDto fournisseurDto);
	
	@GetMapping("/{idFournisseur}")
	FournisseurDto findById(@PathVariable("idFournisseur") Long id);
	
	
	
	@GetMapping("/all")
	List<FournisseurDto> findAll();
	
	
	@DeleteMapping("/delete/{idFournisseur}")
	void delete(@PathVariable("idFournisseur") Long id);
	
	
}

package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.UtilisateurDto;

@RequestMapping("/api/utilisateur")

public interface UtilisateurApi {

	@PostMapping("/create")
	UtilisateurDto save(@RequestBody UtilisateurDto  Dto);
	
	@GetMapping("/{idUtilisateur}")
	UtilisateurDto  findById(@PathVariable("idUtilisateur") Long id);
	
	
	@GetMapping("/all")
	List<UtilisateurDto> findAll();
	
	
	@DeleteMapping("/delete/{idUtilisateur}")
	void delete(@PathVariable("idUtilisateur") Long id);
	
}

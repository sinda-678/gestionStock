package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.ClientDto;

@RequestMapping("/api/client")

public interface ClientApi {

	@PostMapping("/create")
	ClientDto save(@RequestBody ClientDto clientDto);
	
	@GetMapping("/{idClient}")
	ClientDto findById(@PathVariable("idClient") Long id);
	
	
	
	@GetMapping("/all")
	List<ClientDto> findAll();
	
	
	@DeleteMapping("/delete/{idClient}")
	void delete(@PathVariable("idClient") Long id);
	

}

package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.ClientDto;



public interface ClientService {
	
ClientDto save(ClientDto clientDto);
	
ClientDto findById(Long id);
	
		
	List<ClientDto> findAll();
	
	void delete(Long id);


}

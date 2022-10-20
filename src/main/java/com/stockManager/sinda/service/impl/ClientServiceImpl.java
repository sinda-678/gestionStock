package com.stockManager.sinda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stockManager.sinda.dto.ClientDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.ClientRepository;

import com.stockManager.sinda.models.Client;
import com.stockManager.sinda.service.ClientService;

import com.stockManager.sinda.validator.ClientValidator;

import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class ClientServiceImpl implements ClientService{
	
	private  ClientRepository  clientRepository;
	
	@Autowired
	public  ClientServiceImpl( ClientRepository  clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public ClientDto save(ClientDto clientDto) {
	
	List<String> errors =ClientValidator.validate(clientDto);
		
		if(!errors.isEmpty()) {
			log.error("Article is not valid{}",clientDto);
			throw new InvalidEntityException("Le client n'est pas valide",ErrorsCodes.CLIENT_NOT_VALID);
		}
		return  ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto))
				);
	}

	@Override
	public ClientDto findById(Long id) {

		if(id == null) {
			log.error("Le client  ID is null");
			return null;
		}
		Optional<Client> client = clientRepository.findById(id) ;
		ClientDto Dto = 	ClientDto.fromEntity(client.get());
		
		return Optional.of(Dto).orElseThrow(()-> new EntityNotFoundException("Aucun client avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.CLIENT__NOT_FOUND));
	}
	
	@Override
	public List<ClientDto> findAll() {
	
		return  clientRepository.findAll().stream()
				.map(ClientDto::fromEntity)
				.collect(Collectors.toList());
	}
	@Override
	public void delete(Long id) {
	
		if(id == null) {
			log.error("L'article  ID is null");
			return ;
		}
		clientRepository.deleteById(id);
	}
	
	}


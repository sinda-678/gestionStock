/*
package com.stockManager.sinda.service.impl;

import java.util.ArrayList;
import java.util.List;
 
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import com.stockManager.sinda.dto.CmdFournisseurDto;

import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.CmdFournisseurRepository;
import com.stockManager.sinda.interfaces.FournisseurRepository;
import com.stockManager.sinda.interfaces.LigneCmdClientRepository;
import com.stockManager.sinda.interfaces.LigneCmdFournisseurRepository;
import com.stockManager.sinda.models.CmdFournisseur;
import com.stockManager.sinda.models.Fournisseur;
import com.stockManager.sinda.models.LigneCmdFournisseur;
import com.stockManager.sinda.service.CmdFournisseurService;
import com.stockManager.sinda.validator.CmdFournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CmdFournisseurServiceImpl implements CmdFournisseurService {
	
	
	private CmdFournisseurRepository cmdFournisseurRepository;
	
	private  LigneCmdFournisseurRepository    ligneCmdFournisseurRepository;
	
	private  FournisseurRepository  fournisseurRepository;
	
	@Autowired
	public CmdFournisseurServiceImpl( CmdFournisseurRepository cmdFournisseurRepository,  LigneCmdFournisseurRepository    ligneCmdFournisseurRepository
			, FournisseurRepository  fournisseurRepository) {
		this.cmdFournisseurRepository = cmdFournisseurRepository;
		this.ligneCmdFournisseurRepository=ligneCmdFournisseurRepository;
		
		this.fournisseurRepository = fournisseurRepository;
	}
	

	@Override
	public CmdFournisseurDto save(CmdFournisseurDto Dto) {
		List<String> errors = CmdFournisseurValidator.validate(Dto);
		if(!errors.isEmpty()) {
			log.error("commande fournisseur n'est pas valide");
			throw new InvalidEntityException("Le client n'est pas valide",ErrorsCodes.CMD_CIENT_NOT_VALID,errors);
		}
		Optional<Fournisseur> fournisseur = fournisseurRepository.findById(Dto.getFournisseur().getId());
		if(fournisseur.isEmpty()) {
			log.warn("fournisseur with ID {} was not found in the BD",Dto.getFournisseur().getId());
			throw new EntityNotFoundException("aucun client avec l'ID" +Dto.getFournisseur().getId() + "n'a eté trouvé dans la BD");
		}
		List<String> fournisseurErrors =new ArrayList<>();
		
		if(Dto.getLignesCmdFournisseurs() != null) {
			Dto.getLignesCmdFournisseurs().forEach(ligneCmdCl->{
				
				if(ligneCmdCl.getFournisseur() != null) {
					
					Optional<Fournisseur> fournisseur = fournisseurRepository.findById(ligneCmdCl.getFournisseur().getId());
					if( fournisseur.isEmpty()) {
						fournisseurErrors.add("l'article avec L'ID" +ligneCmdCl.getFournisseur().getId() +"n'existe pas");
					}else {
						fournisseurErrors.add("impossible d'enreigistrer une commande avec un fournisseur null");
					}
				}
			});
		}
			if(!fournisseurErrors.isEmpty()) {
				log.warn("");
				throw new  InvalidEntityException("le fournisseur n'existe pas dans la base de donnée",ErrorsCodes.FOURNISSEUR__NOT_FOUND,fournisseurErrors);
				
			
		}
		CmdFournisseur saveCmdCl = cmdFournisseurRepository.save(CmdFournisseurDto.toEntity(Dto));
		if(Dto.getLignesCmdFournisseurs()!= null) {
		Dto.getLignesCmdFournisseurs().forEach(ligneCmdCl->{
			LigneCmdFournisseur ligneCmdFournisseur =LigneCmdFournisseur.toEntity(ligneCmdCl);
			ligneCmdFournisseur .setCmdFournisseur(saveCmdCl);
			 ligneCmdFournisseurRepository.save(ligneCmdFournisseur);
		});}
		return CmdFournisseurDto.fromEntity(saveCmdCl);
	}

	@Override
	public CmdFournisseurDto findById(Long id) {
		if(id==null) {
			log.error("commande client ID is NULL");
			return null;
		}
		
		return cmdFournisseurRepository.findById(id)
				.map(CmdFournisseurDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucune commande client avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.FOURNISSEUR__NOT_FOUND));
	}

	@Override
	public CmdFournisseurDto findBycodeCmdClient(String codeCmdClient) {
		// TODO Auto-generated method stub
		if(!StringUtils.hasLength(codeCmdClient)) {
			log.error("commande client code is null");
		}
		
		return cmdClientRepository.findByCodeCmdClient( codeCmdClient)
				.map(CmdClientDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucun code du client = " + codeCmdClient +" n'est valide dans la BD",ErrorsCodes.CMD_CLIENT__NOT_FOUND));
	
	}

	@Override
	public List<CmdClientDto> findAll() {
		// TODO Auto-generated method stub
		return  cmdClientRepository.findAll().stream() 
				.map(CmdClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("commande client ID is NULL");
			return ;
		}
		 cmdClientRepository.deleteById(id);
	}

}*/

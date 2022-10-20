package com.stockManager.sinda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockManager.sinda.dto.ArticleDto;
import com.stockManager.sinda.dto.UtilisateurDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.UtilisateurRepository;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Utilisateur;
import com.stockManager.sinda.service.UtilisateurService;
import com.stockManager.sinda.validator.UtilisateurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UtilisateurServiceImpl  implements UtilisateurService{

	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	 UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository){
		this.utilisateurRepository= utilisateurRepository;
	}
	
	@Override
	public UtilisateurDto save(UtilisateurDto utilisateurDto) {
	List<String> errors = UtilisateurValidator.validate(utilisateurDto);
		
		if(!errors.isEmpty()) {
			log.error("L'utilisateur is not valid{}",utilisateurDto);
			throw new InvalidEntityException("L'utilisateur n'est pas valide",ErrorsCodes.UTILISATUER_NOT_VALID);
		}
		return  UtilisateurDto.fromEntity(utilisateurRepository.save( UtilisateurDto.toEntity(utilisateurDto))
				);
	}

	@Override
	public UtilisateurDto findById(Long id) {

		if(id == null) {
			log.error("L'utilisateur  ID is null");
			return null;
		}
		Optional<Utilisateur> utilisateur =utilisateurRepository.findById(id) ;
		 UtilisateurDto Dto = 	 UtilisateurDto.fromEntity(utilisateur.get());
		
		return Optional.of(Dto).orElseThrow(()-> new EntityNotFoundException("Aucun Utilisateur avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.UTILISATEUR__NOT_FOUND));

	}

	@Override
	public List<UtilisateurDto> findAll() {
		return  utilisateurRepository.findAll().stream()
				.map(UtilisateurDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id == null) {
			log.error("L'utilisateur  ID is null");
			return ;
		}
		utilisateurRepository.deleteById(id);
		
	}

}

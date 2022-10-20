package com.stockManager.sinda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockManager.sinda.dto.ArticleDto;
import com.stockManager.sinda.dto.FournisseurDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.FournisseurRepository;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Fournisseur;
import com.stockManager.sinda.service.FournisseurService;
import com.stockManager.sinda.validator.FournisseurValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

	private FournisseurRepository  fournisseurRepository;
	@Autowired
	public FournisseurServiceImpl( FournisseurRepository  fournisseurRepository) {
		this.fournisseurRepository= fournisseurRepository;
	}
	
	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
List<String> errors = FournisseurValidator.validate( fournisseurDto);
		
		if(!errors.isEmpty()) {
			log.error("Fournisseur is not valid{}", fournisseurDto);
			throw new InvalidEntityException("Fournisseur n'est pas valide",ErrorsCodes.FOURNISSEUR_NOT_VALID);
		}
		return FournisseurDto.fromEntity(fournisseurRepository.save(FournisseurDto.toEntity(fournisseurDto))
				);
	}

	@Override
	public FournisseurDto findById(Long id) {
		if(id == null) {
			log.error("Fournisseur  ID is null");
			return null;
		}
		Optional<Fournisseur> fournisseur =fournisseurRepository.findById(id) ;
		FournisseurDto  Dto = FournisseurDto .fromEntity(fournisseur.get());
		
		return Optional.of(Dto).orElseThrow(()-> new EntityNotFoundException("Aucun Fournisseur avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.FOURNISSEUR__NOT_FOUND));
	
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
				return  fournisseurRepository.findAll().stream()
						.map(FournisseurDto::fromEntity)
						.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id == null) {
			log.error("Le Fournisseur  ID is null");
			return ;
		}
		fournisseurRepository.deleteById(id);
	}

}

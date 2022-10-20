package com.stockManager.sinda.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockManager.sinda.dto.ArticleDto;
import com.stockManager.sinda.dto.CompagnyDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.CompanyRepository;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Company;
import com.stockManager.sinda.service.CompanyService;
import com.stockManager.sinda.service.impl.ArticleServiceImpl;
import com.stockManager.sinda.validator.CompagnyValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {
	
	private CompanyRepository companyRepository;
	@Autowired
	public  CompanyServiceImpl( CompanyRepository companyRepository) {
		
		this.companyRepository = companyRepository;
	}


	@Override
	public CompagnyDto save(CompagnyDto compagnyDto) {
List<String> errors = CompagnyValidator.validate(compagnyDto);
		
		if(!errors.isEmpty()) {
			log.error("la compagnie is not valid{}",compagnyDto);
			throw new InvalidEntityException("La companie  n'est pas valide",ErrorsCodes.COMPANY_NOT_VALID);
		}
		return  CompagnyDto.fromEntity(companyRepository.save(CompagnyDto.toEntity(compagnyDto))
				);
	}

	@Override
	public CompagnyDto findById(Long id) {

		if(id == null) {
			log.error("La companie  ID is null");
			return null;
		}
		Optional<Company> compagnie =  companyRepository.findById(id) ;
		 CompagnyDto  Dto = 	 CompagnyDto .fromEntity(compagnie.get());
		
		return Optional.of(Dto).orElseThrow(()-> new EntityNotFoundException("Aucun article avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.COMPANY__NOT_FOUND));
	
	}

	@Override
	public List<CompagnyDto> findAll() {
		// TODO Auto-generated method stub
				return  companyRepository.findAll().stream()
						.map(CompagnyDto::fromEntity)
						.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		if(id == null) {
			log.error("La company  ID is null");
			return ;
		}
		companyRepository.deleteById(id);
	}

		
	
}

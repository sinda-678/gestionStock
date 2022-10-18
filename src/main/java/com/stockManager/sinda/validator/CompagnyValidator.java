package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.CompagnyDto;



public class CompagnyValidator {
	
public static List<String> validate(  CompagnyDto  compagnyDto){
		
		
		List<String> errors =new ArrayList();
		
		if(compagnyDto==null) {
			errors.add("veuillez entrer le nom de la compagnie");
			errors.add("veuillez entrer la description de la compagnie");
			errors.add("veuillez entrer le code fiscal de la compagnie");
			errors.add("veuillez entrer le site web de la compagnie");
			errors.add("veuillez entrer le numero de la compagnie");
			errors.add("veuillez entrer l'email de la compagnie");
			errors.add("veuillez entrer l'addresse de la compagnie");
			
		}
		
		if(!StringUtils.hasLength(compagnyDto.getNom())) {
			errors.add("veuillez entrer le nom de la compagnie");
		}
		
		if(!StringUtils.hasLength(compagnyDto.getDescription())) {
			errors.add("veuillez entrer la description de la compagnie");
		}

		if(!StringUtils.hasLength(compagnyDto.getCodeFiscal())) {
			errors.add("veuillez entrer le code fiscal de la compagnie");
		}

		
		if(!StringUtils.hasLength(compagnyDto.getSiteWeb())) {
			errors.add("veuillez entrer le site web de la compagnie");
		}

		if(!StringUtils.hasLength(compagnyDto.getNumero())) {
			errors.add("veuillez entrer le numero de la compagnie");
		}
		
		if(!StringUtils.hasLength(compagnyDto.getNumero())) {
			errors.add("veuillez entrer le numero de la compagnie");
		}
		
		if(!StringUtils.hasLength(compagnyDto.getMail())) {
			errors.add("veuillez entrer l'email de la compagnie");
		}
		
		if(compagnyDto.getAddress()==null) {
			
			errors.add("veuillez entrer l'addresse de la compagnie");
		}
		
		if(compagnyDto.getAddress().getAddress1()==null) {
			
			errors.add("veuillez entrer l'addresse1 de la compagnie");
		}

		if( compagnyDto.getAddress().getCodePostal()== null) {
	
	errors.add("veuillez entrer le code postale de la compagnie");
		}


		if( compagnyDto.getAddress().getPays()== null) {
	
	errors.add("veuillez entrer le pays de la compagnie");
		}


		if( compagnyDto.getAddress().getVille()== null) {
	
			errors.add("veuillez entrer la ville de la compagnie");
		}
		return errors;
	}

}

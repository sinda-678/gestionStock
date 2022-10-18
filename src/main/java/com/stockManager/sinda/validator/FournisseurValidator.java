package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.FournisseurDto;





public class FournisseurValidator {

public static List<String> validate(FournisseurDto fournisseurDto){
		
		
		List<String> errors =new ArrayList();
		
		if(fournisseurDto == null) {
			
			errors.add("veuillez renseigner le nom du fournisseur");
			errors.add("veuillez renseigner le prenom du fournisseur");
			errors.add("veuillez renseigner le numero du fournisseur");
			errors.add("veuillez renseigner l'address du fournisseur");
			
			
		}
		
		
		if(!StringUtils.hasLength(fournisseurDto.getNom())) {
			errors.add("veuillez renseigner le nom du fournisseur");
		
		}
		
		if(!StringUtils.hasLength(fournisseurDto.getPrenom())) {
			errors.add("veuillez renseigner le prenom du fournisseur");
		
		}
		
		if(!StringUtils.hasLength(fournisseurDto.getNumero())) {
			errors.add("veuillez renseigner le numero du fournisseur");
		
		}
		
		if(fournisseurDto.getAddress()==null) {
			errors.add("veuillez renseigner l'address du fournisseur");	
		}

		if(fournisseurDto.getAddress().getAddress1()==null) {
			errors.add("veuillez renseigner l'address1 du fournisseur");	
		}
		
		if(fournisseurDto.getAddress().getCodePostal()==null) {
			errors.add("veuillez renseignerle code postale du fournisseur");	
		}
		
		if(fournisseurDto.getAddress().getPays()==null) {
			
			errors.add("veuillez renseigner le pays du fournisseur");	
		}
		if(fournisseurDto.getAddress().getVille()==null) {
			errors.add("veuillez renseigner le ville du fournisseur");
		
		}
		

return errors;
}
}

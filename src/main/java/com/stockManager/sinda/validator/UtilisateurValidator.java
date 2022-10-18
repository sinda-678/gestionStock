package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.UtilisateurDto;



public class UtilisateurValidator {
	
public static List<String> validate(UtilisateurDto utilisateurDto){
		
		
		List<String> errors =new ArrayList();
		
		if(utilisateurDto== null) {
			errors.add("veuillez entrer le nom de l'utilisateur");
			errors.add("veuillez entrer le prenom de l'utilisateur");
			errors.add("veuillez entrer le mt de passe de l'utilisateur");
			errors.add("veuillez entrer l'email de l'utilisateur");
			errors.add("veuillez renseigner l'addresse de  l'utilisateur");
			
		}
		
		
		if(!StringUtils.hasLength( utilisateurDto.getNom())) {
			errors.add("veuillez entrer le nom de l'utilisateur");
		}
		
		if(!StringUtils.hasLength( utilisateurDto.getPrenom())) {
			errors.add("veuillez entrer le prenom de l'utilisateur");
		}
		if(!StringUtils.hasLength( utilisateurDto.getEmail())) {
			errors.add("veuillez entrer l'email de l'utilisateur");
		}
		
		if(!StringUtils.hasLength( utilisateurDto.getMotDePasse())) {
			errors.add("veuillez entrer le mot de passe de l'utilisateur");
		}
		
		if(utilisateurDto.getDateDeNaissance()== null) {
			errors.add("veuillez entrer la date de naissance  de l'utilisateur");
		}
	

		
		if(utilisateurDto.getAddress()== null) {
			errors.add("veuillez renseigner l'addresse de  l'utilisateur");
		}else {
			
			
		

		
				if(!StringUtils.hasLength( utilisateurDto.getAddress().getAddress1())) {
					errors.add("le champ 'addresse1' est obligatoire");
				}
				
				if(!StringUtils.hasLength( utilisateurDto.getAddress().getVille())) {
					
					errors.add("le champ 'ville' est obligatoire");
				}
				
				if(!StringUtils.hasLength( utilisateurDto.getAddress().getCodePostal())) {
					errors.add("le champ'code postal' est obligatoire");
				}
				
				if(!StringUtils.hasLength( utilisateurDto.getAddress().getPays())) {
					errors.add("le champ 'pays' est obligatoire");
				}

		}
		return errors;
}

}

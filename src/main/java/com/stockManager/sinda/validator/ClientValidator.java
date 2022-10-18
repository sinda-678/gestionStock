package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.ClientDto;



public class ClientValidator {

public static List<String> validate(ClientDto clientDto){
		
		
		List<String> errors =new ArrayList();
		if(clientDto == null) {
			errors.add("veuillez renseigner le nom du client");
			errors.add("veuillez renseigner le prenom du client");
			errors.add("veuillez renseigner l'email du client");
			errors.add("veuillez renseigner le numero de telephone du client");
		}
		
		if(!StringUtils.hasLength(clientDto.getNom())) {
			errors.add("veuillez renseigner le nom du client");
		}
		
		if(!StringUtils.hasLength(clientDto.getPrenom())) {
			errors.add("veuillez renseigner le prenom du client");
		}
		

		
		

		if(!StringUtils.hasLength(clientDto.getMail())) {
			errors.add("veuillez renseigner l'email du client");
		}
		

		if(!StringUtils.hasLength(clientDto.getNumero())) {
			errors.add("veuillez renseigner le numero de telephone du client");
		}
		return errors;
}

	
	
}

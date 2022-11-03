package com.stockManager.sinda.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.CmdClientDto;



public class CmdClientValidator {


public static List<String> validate(CmdClientDto cmdClientDto){
		
		
		List<String> errors =new ArrayList();
		
		if(cmdClientDto==null) {
			errors.add("veuillez renseigner le code de la commande du client");
			errors.add("veuillez renseigner la date de commande du client");
			errors.add("veuillez renseigner les informations  du client");
		}
	
		
		if(!StringUtils.hasLength( cmdClientDto.getCodeCmdClient())) {
			errors.add("veuillez renseigner le code de la commande du client");
		}
	

		if(cmdClientDto.getDateCommande()== null) {
			errors.add("veuillez renseigner la date de commande du client");
		}
		
		
		

		if(cmdClientDto.getClient()==null|| cmdClientDto.getId() == null) {
			errors.add("veuillez renseigner les informations  du client");
		}
		return errors;
}

	
	
}

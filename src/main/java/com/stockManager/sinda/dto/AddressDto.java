package com.stockManager.sinda.dto;

import javax.persistence.Column;

import com.stockManager.sinda.models.Address;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class AddressDto {

	
	private String address1;
	
	
    private String address2;
	
	
    private String ville;
	
	
    private String codePostal;
	
	
    private String pays;
	
    public AddressDto fromEntity(Address adress) {
    	
    	if(adress== null) {
    		return null;
    	}
    	
    	return AddressDto.builder()
    			.address1(adress.getAddress1())
    			.address2(adress.getAddress2())
    			.ville(adress.getVille())
    			.codePostal(adress.getCodePostal())
    			.pays(adress.getPays())
    			.build();
    }
    
    public Address toEntity(AddressDto adressDto) {
    	
    	if(adressDto == null) {
    		return null;
    	}
    	
    	Address addresse = new Address();
    	
    	addresse.setAddress1(adressDto.getAddress1());
    	addresse.setAddress2(adressDto.getAddress2());
    	addresse.setCodePostal(adressDto.getCodePostal());
    	addresse.setPays(adressDto.getPays());
    	addresse.setVille(adressDto.getVille());
    	
    	return addresse;
    	
    	
    }
    
}

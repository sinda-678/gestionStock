package com.stockManager.sinda.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.Company;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class CompagnyDto {
	
	private Long id;
	
	private String code;
	
	
    private String nom;
	
	
    private AddressDto address;
	
	
    private String description;
	
	
    private String codeFiscal;
	
	
    private String siteWeb;
	
	
    private String numero;
	
	
    private String mail;
	
	
    private String photo;
	
	
    private List<UtilisateurDto> utilisateur;

	
	public static CompagnyDto fromEntity(Company company) {
		if(company == null) {
			return null;
		}
		
		return  CompagnyDto.builder()
				.id(company.getId())
				.code(company.getCode())
				.nom(company.getNom())
				.description(company.getDescription())
				.codeFiscal(company.getCodeFiscal())
				.siteWeb(company.getSiteWeb())
				.numero(company.getNumero())
				.mail(company.getMail())
				.photo(company.getPhoto())
				.build();
	}
	
    public static Company  toEntity( CompagnyDto  compagnyDto) {
    	
    	if(compagnyDto == null) {
    		return null;
    	}
    	Company  company = new Company();
    	 company.setId(compagnyDto.getId());
    	 company.setCode(compagnyDto.getCode());
    	 company.setNom(compagnyDto.getNom());
    	 company.setDescription(compagnyDto.getDescription());
    	 company.setCodeFiscal(compagnyDto.getCodeFiscal());
    	 company.setSiteWeb(compagnyDto.getSiteWeb());
    	 company.setNumero(compagnyDto.getNumero());
    	 company.setMail(compagnyDto.getMail());
    	 company.setPhoto(compagnyDto.getPhoto());
    	 
    	 return company;
    }
}

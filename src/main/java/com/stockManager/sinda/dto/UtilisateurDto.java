package com.stockManager.sinda.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.Utilisateur;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class UtilisateurDto {

	private Long id;
	
	private String nom;
	

    private String prenom;
	
	
    private AddressDto address;
	
	
    private Instant dateDeNaissance;
	
	
    private String motDePasse;
	
    private String email;
	
    private String photo;
    
   
    private int numerotel;
    
    
    private CompagnyDto company;
    
   @JsonIgnore
    private List<RoleDto> roles;

   public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
	   if(utilisateur == null) {
		   return null;
	   }
	   return  UtilisateurDto.builder()
			   .id(utilisateur.getId())
			   .nom(utilisateur.getNom())
			   .prenom(utilisateur.getPrenom())
			   .dateDeNaissance(utilisateur.getDateDeNaissance())
			   .motDePasse(utilisateur.getMotDePasse())
			   .photo(utilisateur.getPhoto())
			   .numerotel(utilisateur.getNumerotel())
			   .build();
   }
	
   public static Utilisateur toEntity(UtilisateurDto utilisateurDto) {
	   
	   if(utilisateurDto == null) {
		   return null;
		   
	   }
	   Utilisateur  utilisateure = new  Utilisateur();
	   utilisateure.setId(utilisateurDto.getId());
	   utilisateure.setNom(utilisateurDto.getNom());
	   utilisateure.setPrenom(utilisateurDto.getPrenom());
	   utilisateure.setMotDePasse(utilisateurDto.getMotDePasse());
	   utilisateure.setPhoto(utilisateurDto.getPhoto());
	   utilisateure.setNumerotel(utilisateurDto.getNumerotel());
	   utilisateure.setDateDeNaissance(utilisateurDto.getDateDeNaissance());
	   return utilisateure;
	   
   }
}

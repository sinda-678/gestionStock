package com.stockManager.sinda.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.Fournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class FournisseurDto {


	private Long id;
	
	private String nom;
	
	
    private String prenom;
	
	
    private AddressDto address;
	
	
    private String photo;
	
	
    private String numero;
	
	@JsonIgnore
    private List<CmdFournisseurDto> cmdfournisseurs;

	public static FournisseurDto fromEntity(Fournisseur fournisseur) {
		
		if( fournisseur == null) {
			return null;
		}
		
		return FournisseurDto.builder()
				.id(fournisseur.getId())
				.nom(fournisseur.getNom())
				.prenom(fournisseur.getPrenom())
				.photo(fournisseur.getPhoto())
				.numero(fournisseur.getNumero())
				.build();
	}
	
	public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
		if(fournisseurDto == null) {
			return null;
		}
		Fournisseur fournisseure = new Fournisseur();
		fournisseure.setId( fournisseurDto.getId());
		fournisseure.setNom( fournisseurDto.getNom());
		fournisseure.setPrenom( fournisseurDto.getPrenom());
		fournisseure.setPhoto( fournisseurDto.getPhoto());
		fournisseure.setNumero( fournisseurDto.getNumero());
		return fournisseure;
	}
	
	
}

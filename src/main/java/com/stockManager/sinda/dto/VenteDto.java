package com.stockManager.sinda.dto;

import java.time.Instant;

import com.stockManager.sinda.models.Vente;

import lombok.Builder;
import lombok.Data;
@Data
@Builder


public class VenteDto {

	private Long id;
	
	private Long idCompany;
	

	private String codeVente;
    
	
	private Instant dateVente;
	
    private String commentaire;
	
    public VenteDto fromEntity(Vente vente) {
    	if(vente == null) {
    		return null;
    	}
    	return VenteDto.builder()
    			.id( vente.getId())
    			.codeVente( vente.getCodeVente())
    			.idCompany( vente.getIdCompany())
    			.dateVente( vente.getDateVente())
    			.commentaire( vente.getCommentaire())
    			.build();
    	
    }
    
    public Vente toEntity(VenteDto venteDto) {
    	if(venteDto== null) {
    		return null;
    	}
    	
    	Vente ventes =new Vente();
    	 ventes.setId( venteDto.getId());
    	 ventes.setCodeVente( venteDto.getCodeVente());
    	 ventes.setIdCompany( venteDto.getIdCompany());
    	 ventes.setCommentaire( venteDto.getCommentaire());
    	 ventes.setDateVente( venteDto.getDateVente());
    	 return ventes;
    }
	
}

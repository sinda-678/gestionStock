package com.stockManager.sinda.dto;

import java.math.BigDecimal;

import com.stockManager.sinda.models.LigneVente;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class LigneVenteDto {

	
	private Long id;
	
	private VenteDto vente;
	
	
    private BigDecimal prixUnitaire;
    
	
    private BigDecimal quantity;

	public   LigneVenteDto fromEntiy( LigneVente  ligneVente) {
		if( ligneVente == null) {
			return null;
		}
		return  LigneVenteDto.builder()
				.id( ligneVente.getId())
				.prixUnitaire( ligneVente.getPrixUnitaire())
				.quantity( ligneVente.getQuantity())
				.build();
	}
	public LigneVente toEntity(LigneVenteDto ligneVenteDto) {
		if( ligneVenteDto == null) {
			return null;
		}
		 LigneVente ligne = new  LigneVente();
		 ligne.setId(ligneVenteDto.getId());
		 ligne.setPrixUnitaire(ligneVenteDto.getPrixUnitaire());
		 ligne.setQuantity(ligneVenteDto.getQuantity());
		 return ligne;
	}
}

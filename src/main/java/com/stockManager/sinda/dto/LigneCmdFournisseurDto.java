package com.stockManager.sinda.dto;

import java.math.BigDecimal;

import com.stockManager.sinda.models.LigneCmdFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class LigneCmdFournisseurDto {

	private Long id;
	
	private ArticleDto article;
	
    private CmdFournisseurDto cmdFournisseur;
	
    private BigDecimal prixUnitaire;
	
    private BigDecimal quantity;
	
    public LigneCmdFournisseurDto  fromEntity(LigneCmdFournisseur ligneCmdFournisseur) {
    	if( ligneCmdFournisseur == null) {
    		return null;
    	}
    	
    	return  LigneCmdFournisseurDto.builder()
    			.id(ligneCmdFournisseur.getId())
    			.prixUnitaire(ligneCmdFournisseur.getPrixUnitaire())
    			.quantity(ligneCmdFournisseur.getQuantity())
    			.build();
    }
    
    public LigneCmdFournisseur toEntity( LigneCmdFournisseurDto  ligneCmdFournisseurDto) {
    	if( ligneCmdFournisseurDto == null) {
    		return null;
    	}
    	LigneCmdFournisseur ligneCmdFournisseure = new LigneCmdFournisseur();
    	 ligneCmdFournisseure.setId( ligneCmdFournisseurDto.getId());
    	 ligneCmdFournisseure.setPrixUnitaire( ligneCmdFournisseurDto.getPrixUnitaire());
    	 ligneCmdFournisseure.setQuantity( ligneCmdFournisseurDto.getQuantity());
    	 return  ligneCmdFournisseure;
    }
}

package com.stockManager.sinda.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.CmdFournisseur;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class CmdFournisseurDto {

	private Long id;
	
    private String codeCmdFournisseur;

   
    private Instant dateCmdFournisseur;
   
    private FournisseurDto fournisseur;
    
   @JsonIgnore
    private List<LigneCmdFournisseurDto> lignesCmdFournisseurs;

   public CmdFournisseurDto fromEntity( CmdFournisseur  cmdFournisseur) {
	   if(cmdFournisseur == null) {
		   return null;
	   }
	   
	   return  CmdFournisseurDto.builder()
			   .id(cmdFournisseur.getId())
			   .codeCmdFournisseur(cmdFournisseur.getCodeCmdFournisseur())
			   .dateCmdFournisseur(cmdFournisseur.getDateCmdFournisseur())
			   .build();
   }
   
   public  CmdFournisseur  toEntity( CmdFournisseurDto  cmdFournisseurDto) {
	   if( cmdFournisseurDto == null) {
		   return null;
	   }
	   
	   CmdFournisseur  cmdFournisseure = new CmdFournisseur();
	   cmdFournisseure.setId(cmdFournisseurDto.getId());
	   cmdFournisseure.setCodeCmdFournisseur(cmdFournisseurDto.getCodeCmdFournisseur());
	   cmdFournisseure.setDateCmdFournisseur(cmdFournisseurDto.getDateCmdFournisseur());
	   return cmdFournisseure;
	   
   }
	
}

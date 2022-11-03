package com.stockManager.sinda.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.CmdClient;
import com.stockManager.sinda.models.EtatCommande;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class CmdClientDto {

	private Long id;

    private String codeCmdClient;
	    

	private Instant dateCommande;
	
    private EtatCommande etatCommande;
	
    private Long idCompany;

	private ClientDto client;
	
	private List<LigneCmdClientDto> lignesCmdClients;
	
	
	public CmdClientDto formEntity(CmdClient cmdClient) {
		if(cmdClient == null) {
			return null;
		}
		
		return  CmdClientDto.builder()
				.id( cmdClient.getId())
				.codeCmdClient( cmdClient.getCodeCmdClient())
				.dateCommande( cmdClient.getDateCommande())
				.idCompany(cmdClient.getIdCompany())
				.etatCommande(cmdClient.getEtatCommande())
				.build();
	}

	public static CmdClient toEntity(CmdClientDto cmdClientDto) {
		if(cmdClientDto == null) {
			return null;
		}
		
		CmdClient cmdclient = new 	CmdClient();
		 cmdclient.setId(cmdClientDto.getId());
		 cmdclient.setCodeCmdClient(cmdClientDto.getCodeCmdClient());
		 cmdclient.setDateCommande(cmdClientDto.getDateCommande());
		 cmdclient.setIdCompany(cmdClientDto.getIdCompany());
		 cmdclient.setEtatCommande(cmdClientDto.getEtatCommande());
		 return  cmdclient;
	}

	public boolean isCommandeLivree() {
		return EtatCommande.Livree.equals(this.etatCommande);
		
	}
}

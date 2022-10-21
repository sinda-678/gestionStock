package com.stockManager.sinda.dto;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.CmdClient;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class CmdClientDto {

	private Long id;

    private String codeCmdClient;
	    

	private Instant dateCommande;
	

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
		 
		 return  cmdclient;
	}

	public static CmdClientDto fromEntity(CmdClient saveCmdCl) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

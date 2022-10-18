package com.stockManager.sinda.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.Categories;
import com.stockManager.sinda.models.Client;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class ClientDto {
	
	private Long id;
	
	private String nom;
	    

	private String prenom;
	
	
	
	
	 
	
	private String mail;
	    
	
	private String photo;
	
	
	private String numero;
	
	private AddressDto address;
	
	@JsonIgnore
	private List<CmdClientDto> cmdClients;

	public ClientDto fromEntity(Client client) {
		if(client == null) {
			return null;
		}
		
		return ClientDto.builder()
				.id(client.getId())
				.nom(client.getNom())
				.prenom(client.getPrenom())
				.mail(client.getMail())
				.photo(client.getPhoto())
				.numero(client.getNumero())
				.build();
	}
		  public Client toEntity(  ClientDto  clientDto) {
			if(clientDto == null) {
				return null;
			}
			 
			Client client = new Client();
			client.setId(clientDto.getId());
			client.setNom(clientDto.getNom());
			client.setPrenom(clientDto.getPrenom());
			client.setMail(clientDto.getMail());
			client.setPhoto(clientDto.getPhoto());
			client.setNumero(clientDto.getNumero());
			return client;
		
	}
	
}

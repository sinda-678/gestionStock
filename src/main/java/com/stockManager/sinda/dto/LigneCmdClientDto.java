package com.stockManager.sinda.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stockManager.sinda.models.LigneCmdClient;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class LigneCmdClientDto {

	private Long id;
	
	private ArticleDto article;
	
	@JsonIgnore
    private CmdClientDto cmdClient;
	
	
    private BigDecimal prixUnitaire;
	
	
    private BigDecimal quantity;
    
public LigneCmdClientDto fromEntity(LigneCmdClient ligneCmdClient) {
	if( ligneCmdClient == null) {
		return null;
	}
	return LigneCmdClientDto.builder()
			.id(ligneCmdClient.getId())
			.prixUnitaire(ligneCmdClient.getPrixUnitaire())
			.quantity(ligneCmdClient.getQuantity())
			.build();
}
	
public static LigneCmdClient toEntity(LigneCmdClientDto ligneCmdClientDto) {
	if(ligneCmdClientDto == null) {
		return null;
	}
	
	LigneCmdClient ligneCmdCliente = new LigneCmdClient();
	ligneCmdCliente.setId(ligneCmdClientDto.getId());
	ligneCmdCliente.setPrixUnitaire( ligneCmdClientDto.getPrixUnitaire());
	ligneCmdCliente.setQuantity(ligneCmdClientDto.getQuantity());
	return ligneCmdCliente;
}
}

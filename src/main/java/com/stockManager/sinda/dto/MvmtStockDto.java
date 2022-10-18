package com.stockManager.sinda.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.stockManager.sinda.models.MvmtStck;

import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class MvmtStockDto {

	private Long id;
	
	private String designation;
	
	
    private Instant datemvt;
	

    private BigDecimal quantity;
	
	
    private ArticleDto article;
    
    public  MvmtStockDto fromEntity(MvmtStck mvmtStock) {
    	if(mvmtStock== null) {
    		return null;
    	}
    	return  MvmtStockDto.builder()
    			.id(mvmtStock.getId())
    			.designation(mvmtStock.getDesignation())
    			.datemvt(mvmtStock.getDatemvt())
    			.quantity(mvmtStock.getQuantity())
    			.build();
    }
    
	public MvmtStck toEntity( MvmtStockDto  mvmtStockDto) {
		if( mvmtStockDto == null ) {
			return null;
		}
		 MvmtStck mvmtStocke = new  MvmtStck();
		 mvmtStocke.setId(mvmtStockDto.getId());
		 mvmtStocke.setDesignation(mvmtStockDto.getDesignation());
		 mvmtStocke.setDatemvt(mvmtStockDto.getDatemvt());
		 mvmtStocke.setQuantity(mvmtStockDto.getQuantity());
		 return  mvmtStocke;
	}
}

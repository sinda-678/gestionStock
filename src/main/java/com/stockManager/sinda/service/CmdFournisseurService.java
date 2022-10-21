package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.CmdFournisseurDto;



public interface CmdFournisseurService {
	 CmdFournisseurDto save( CmdFournisseurDto Dto);
		
	 CmdFournisseurDto findById(Long id);
	
	 CmdFournisseurDto findByCodeCmdFournisseur(String codeCmdFournisseur);
	
	List< CmdFournisseurDto> findAll();
	
	void delete(Long id);
	

}

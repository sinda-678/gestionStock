package com.stockManager.sinda.service;

import java.util.List;

import com.stockManager.sinda.dto.CmdClientDto;

public interface CmdClientService {


	 CmdClientDto save( CmdClientDto Dto);
	
	 CmdClientDto findById(Long id);
	
	 CmdClientDto findBycodeCmdClient(String codeCmdClient);
	
	List< CmdClientDto> findAll();
	
	void delete(Long id);
	
}

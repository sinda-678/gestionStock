package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.CmdClientDto;
import com.stockManager.sinda.service.CmdClientService;

@RestController
public class CmdClientController implements CmdClientApi {

	private CmdClientService cmdClientService;
	 
	 @Autowired
	public CmdClientController(CmdClientService cmdClientService) {
		this.cmdClientService = cmdClientService;
	}
	@Override
	public CmdClientDto save(CmdClientDto Dto) {
		// TODO Auto-generated method stub
		return cmdClientService.save(Dto);
	}

	@Override
	public CmdClientDto findById(Long id) {
		// TODO Auto-generated method stub
		return cmdClientService.findById(id);
	}

	@Override
	public CmdClientDto findByCodeCmdClient(String codeCmdClient) {
		// TODO Auto-generated method stub
		return cmdClientService.findBycodeCmdClient(codeCmdClient);
	}

	@Override
	public List<CmdClientDto> findAll() {
		// TODO Auto-generated method stub
		return cmdClientService.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		cmdClientService.delete(id);
	}

}

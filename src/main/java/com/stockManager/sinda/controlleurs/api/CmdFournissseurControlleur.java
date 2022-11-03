package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.CmdFournisseurDto;
import com.stockManager.sinda.service.CmdFournisseurService;

@RestController
public class CmdFournissseurControlleur implements CmdFournisseurApi {

	private CmdFournisseurService cmdFournisseurService;
	
	@Autowired
	public CmdFournissseurControlleur(CmdFournisseurService cmdFournisseurService) {
		this.cmdFournisseurService =  cmdFournisseurService;
	}
	@Override
	public CmdFournisseurDto save(CmdFournisseurDto Dto) {
		// TODO Auto-generated method stub
		return  cmdFournisseurService.save(Dto);
	}

	@Override
	public CmdFournisseurDto findById(Long id) {
		// TODO Auto-generated method stub
		return  cmdFournisseurService.findById(id);
	}


	@Override
	public List<CmdFournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return  cmdFournisseurService.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 cmdFournisseurService.delete(id);
	}

}

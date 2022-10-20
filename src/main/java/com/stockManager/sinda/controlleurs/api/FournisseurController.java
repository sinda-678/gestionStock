package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.FournisseurDto;
import com.stockManager.sinda.service.FournisseurService;
@RestController
public class FournisseurController implements FournisseurApi {

	private FournisseurService  fournisseurService ;
	
	public FournisseurController(FournisseurService  fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	
	@Override
	public FournisseurDto save(FournisseurDto fournisseurDto) {
		// TODO Auto-generated method stub
		return fournisseurService.save(fournisseurDto);
	}

	@Override
	public FournisseurDto findById(Long id) {
		// TODO Auto-generated method stub
		return fournisseurService.findById(id);
	}

	@Override
	public List<FournisseurDto> findAll() {
		// TODO Auto-generated method stub
		return fournisseurService.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		fournisseurService.delete(id);
	}

}

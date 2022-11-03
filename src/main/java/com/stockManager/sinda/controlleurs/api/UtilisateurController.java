package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.UtilisateurDto;
import com.stockManager.sinda.service.UtilisateurService;

@RestController
public class UtilisateurController implements UtilisateurApi {
 private UtilisateurService utilsateurService;
 
 
 @Autowired
 public UtilisateurController(UtilisateurService utilsateurService) {
	 this.utilsateurService = utilsateurService;
 }
	@Override
	public UtilisateurDto save(UtilisateurDto Dto) {
		// TODO Auto-generated method stub
		return utilsateurService.save(Dto);
	}

	@Override
	public UtilisateurDto findById(Long id) {
		// TODO Auto-generated method stub
		return utilsateurService.findById(id);
	}

	@Override
	public List<UtilisateurDto> findAll() {
		// TODO Auto-generated method stub
		return utilsateurService.findAll();
	}

	@Override
	public void delete(Long id) {
		utilsateurService.delete(id);
	}

}

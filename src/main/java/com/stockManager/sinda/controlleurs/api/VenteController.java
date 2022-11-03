package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.dto.VenteDto;
import com.stockManager.sinda.service.VenteService;
@RestController
public class VenteController implements  VenteApi {

	private  VenteService venteservice;
	
	
	@Autowired
	public VenteController(VenteService venteservice) {
		this.venteservice =   venteservice;
	}
	
	
	@Override
	public VenteDto save(VenteDto Dto) {
		// TODO Auto-generated method stub
		return  venteservice.save(Dto);
	}

	@Override
	public VenteDto findById(Long id) {
		// TODO Auto-generated method stub
		return venteservice.findById(id);
	}

	@Override
	public List<VenteDto> findAll() {
		// TODO Auto-generated method stub
		return  venteservice.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 venteservice.delete(id);
	}

}

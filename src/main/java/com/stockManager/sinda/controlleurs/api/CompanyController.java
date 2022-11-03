package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stockManager.sinda.dto.CompagnyDto;
import com.stockManager.sinda.service.CompanyService;

public class CompanyController implements CompanyApi {

	private CompanyService companyService;
	
	
	@Autowired
	public CompanyController( CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@Override
	public CompagnyDto save(CompagnyDto categoriesDto) {
		// TODO Auto-generated method stub
		return companyService.save(categoriesDto);
	}

	@Override
	public CompagnyDto findById(Long id) {
		// TODO Auto-generated method stub
		return companyService.findById(id);
	}

	@Override
	public List<CompagnyDto> findAll() {
		// TODO Auto-generated method stub
		return companyService.findAll();
	}

	@Override
	public void delete(Long id) {
		companyService.delete(id);
	}

}

package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.CmdFournisseurDto;



@RequestMapping("/api/cmdFournisseur")
public interface CmdFournisseurApi {



	@PostMapping("/create")
	CmdFournisseurDto save(@RequestBody CmdFournisseurDto  Dto);
	
	@GetMapping("/{idCmdfournisseur}")
	CmdFournisseurDto  findById(@PathVariable("idCmdFournisseur") Long id);
	
	
	
	@GetMapping("/all")
	List<CmdFournisseurDto > findAll();
	
	
	@DeleteMapping("/delete/{idCmdFournisseur}")
	void delete(@PathVariable("idCmdFournisseur") Long id);
	
	
	
}

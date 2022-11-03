package com.stockManager.sinda.controlleurs.api;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stockManager.sinda.dto.CmdClientDto;


@RequestMapping("/api/cmdArticle")
public interface CmdClientApi {

	

	@PostMapping("/create")
	CmdClientDto save(@RequestBody CmdClientDto Dto);
	
	@GetMapping("/{idCmdClient}")
	CmdClientDto findById(@PathVariable("idCmdClient") Long id);
	
	
	@GetMapping("/codeCmdClient")
	CmdClientDto findByCodeCmdClient(@PathVariable("codeCmdClient")  String codeCmdClient);
	
	
	@GetMapping("/all")
	List<CmdClientDto> findAll();
	
	
	@DeleteMapping("/delete/{idCmdClient}")
	void delete(@PathVariable("idCmdClient") Long id);
	
	
}

package com.stockManager.sinda.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.ClientDto;
import com.stockManager.sinda.dto.CmdClientDto;
import com.stockManager.sinda.dto.LigneCmdClientDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.ArticleRepository;
import com.stockManager.sinda.interfaces.ClientRepository;
import com.stockManager.sinda.interfaces.CmdClientRepository;
import com.stockManager.sinda.interfaces.LigneCmdClientRepository;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Client;
import com.stockManager.sinda.models.CmdClient;
import com.stockManager.sinda.models.LigneCmdClient;
import com.stockManager.sinda.service.CmdClientService;
import com.stockManager.sinda.validator.CmdClientValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class CmdClientServiceImpl implements CmdClientService {
	
	private CmdClientRepository cmdClientRepository;
	
	private LigneCmdClientRepository ligneCmdClientRepository;
	private ClientRepository clientRepository;
	
	private ArticleRepository articleRepository;
	
	@Autowired
	public  CmdClientServiceImpl(CmdClientRepository cmdClientRepository,ClientRepository clientRepository,
			ArticleRepository articleRepository,LigneCmdClientRepository ligneCmdClientRepository) {
		
		this.cmdClientRepository = cmdClientRepository;
		this.clientRepository = clientRepository;
		this.articleRepository =  articleRepository;
		this.ligneCmdClientRepository =  ligneCmdClientRepository;
	}
	
	@Override
	public CmdClientDto save(CmdClientDto Dto) {
		// TODO Auto-generated method stub
		List<String> errors = CmdClientValidator.validate(Dto);
		if(!errors.isEmpty()) {
			log.error("commande client n'est pas valide");
			throw new InvalidEntityException("Le client n'est pas valide",ErrorsCodes.CMD_CIENT_NOT_VALID,errors);
		}
		Optional<Client> client = clientRepository.findById(Dto.getClient().getId());
		if(client.isEmpty()) {
			log.warn("client with ID {} was not found in the BD",Dto.getClient().getId());
			throw new EntityNotFoundException("aucun client avec l'ID" +Dto.getClient().getId() + "n'a eté trouvé dans la BD");
		}
		List<String> articleErrors =new ArrayList<>();
		
		if(Dto.getLignesCmdClients() != null) {
			Dto.getLignesCmdClients().forEach(ligneCmdCl->{
				
				if(ligneCmdCl.getArticle() != null) {
					
					Optional<Article> article = articleRepository.findById(ligneCmdCl.getArticle().getId());
					if(article.isEmpty()) {
						articleErrors.add("l'article avec L'ID" +ligneCmdCl.getArticle().getId() +"n'existe pas");
					}else {
						articleErrors.add("impossible d'enreigistrer une commande avec un article null");
					}
				}
			});
		}
			if(!articleErrors.isEmpty()) {
				log.warn("");
				throw new  InvalidEntityException("l'article n'existe pas dans la base de donnée",ErrorsCodes.ARTICLE_NOT_FOUND,articleErrors);
				
			
		}
		CmdClient saveCmdCl =  cmdClientRepository.save(CmdClientDto.toEntity(Dto));
		if(Dto.getLignesCmdClients() != null) {
		Dto.getLignesCmdClients().forEach(ligneCmdCl->{
			LigneCmdClient ligneCmdClient =LigneCmdClientDto.toEntity(ligneCmdCl);
			ligneCmdClient .setCmdClient(saveCmdCl);
			 ligneCmdClientRepository.save(ligneCmdClient);
		});}
		return CmdClientDto.fromEntity(saveCmdCl);
	}

	@Override
	public CmdClientDto findById(Long id) {
		if(id==null) {
			log.error("commande client ID is NULL");
			return null;
		}
		
		return cmdClientRepository.findById(id)
				.map(CmdClientDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucune commande client avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.CMD_CLIENT__NOT_FOUND));
	}

	@Override
	public CmdClientDto findBycodeCmdClient(String codeCmdClient) {
		// TODO Auto-generated method stub
		if(!StringUtils.hasLength(codeCmdClient)) {
			log.error("commande client code is null");
		}
		
		return cmdClientRepository.findByCodeCmdClient( codeCmdClient)
				.map(CmdClientDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("Aucun code du client = " + codeCmdClient +" n'est valide dans la BD",ErrorsCodes.CMD_CLIENT__NOT_FOUND));
	
	}

	@Override
	public List<CmdClientDto> findAll() {
		// TODO Auto-generated method stub
		return  cmdClientRepository.findAll().stream() 
				.map(CmdClientDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null) {
			log.error("commande client ID is NULL");
			return ;
		}
		 cmdClientRepository.deleteById(id);
	}

}

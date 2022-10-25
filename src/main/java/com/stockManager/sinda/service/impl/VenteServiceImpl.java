package com.stockManager.sinda.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.stockManager.sinda.dto.ArticleDto;
import com.stockManager.sinda.dto.ClientDto;
import com.stockManager.sinda.dto.CmdClientDto;
import com.stockManager.sinda.dto.LigneVenteDto;
import com.stockManager.sinda.dto.VenteDto;
import com.stockManager.sinda.exception.EntityNotFoundException;
import com.stockManager.sinda.exception.ErrorsCodes;
import com.stockManager.sinda.exception.InvalidEntityException;
import com.stockManager.sinda.interfaces.ArticleRepository;
import com.stockManager.sinda.interfaces.LigneVenteRepository;
import com.stockManager.sinda.interfaces.VenteRepository;
import com.stockManager.sinda.models.Article;
import com.stockManager.sinda.models.Client;
import com.stockManager.sinda.models.CmdClient;
import com.stockManager.sinda.models.LigneVente;
import com.stockManager.sinda.models.Vente;
import com.stockManager.sinda.service.VenteService;
import com.stockManager.sinda.validator.VenteValidator;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class VenteServiceImpl implements VenteService {
	
	private ArticleRepository articleRepository;
	private  VenteRepository venteRepository;
	private LigneVenteRepository ligneVenteRepository;
	@Autowired
	public VenteServiceImpl(ArticleRepository articleRepository,VenteRepository venteRepository,LigneVenteRepository ligneVenteRepository) {
		this.articleRepository=articleRepository;
		this.ligneVenteRepository=ligneVenteRepository;
		this.articleRepository= articleRepository;
	}
	@Override
	public VenteDto save(VenteDto Dto) {
		List<String> errors = VenteValidator.validate(Dto);
		if(!errors.isEmpty()) {
			log.error("la vente is not valid{}",Dto);
			throw new InvalidEntityException("L'objet vente n'est pas valide",ErrorsCodes.VENTE_NOT_VALID,errors);
		}
		List<String> articleErrors =new ArrayList<>();
		
				Dto.getLigneVente().forEach(ligneVenteDto->{
					Optional<Article> article = articleRepository.findById(ligneVenteDto.getVente().getId());
					if(article.isEmpty()) {
						articleErrors .add("aucun article avec l'ID" +ligneVenteDto.getVente().getId()+"n'a été trouvé dans la BDD");
					}
				});
				if(articleErrors.isEmpty()) {
					log.error("la vente is not valid{}",Dto);
					throw new InvalidEntityException("un ou plusieurs article n'ont pas été dans la BDD",ErrorsCodes.VENTE_NOT_VALID,errors);
				}
				Vente saveVente =  venteRepository.save(VenteDto.toEntity(Dto));

				Dto.getLigneVente().forEach(ligneVenteDto->{
				LigneVente ligneVente= LigneVenteDto.toEntity(ligneVenteDto);
				ligneVente.setVente(saveVente);
					ligneVenteRepository.save(ligneVente);
				});
		return VenteDto.fromEntity(saveVente);
	} 

	@Override
	public VenteDto findById(Long id) {
		if(id == null) {
			log.error("Le client  ID is null");
			return null;
		}
		Optional<Vente> client = venteRepository.findById(id) ;
		VenteDto Dto = 	VenteDto.fromEntity(client.get());
		
		return Optional.of(Dto).orElseThrow(()-> new EntityNotFoundException("Aucune vente  avecL'ID = " +id +" n'est valide dans la BD",ErrorsCodes.VENTE__NOT_FOUND));
		
	}


	@Override
	public List<VenteDto> findAll() {
		return  venteRepository.findAll().stream()
				.map(VenteDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Long id) {

		if(id == null) {
			log.error("L'article  ID is null");
			return ;
		}
		venteRepository.deleteById(id);
	}
		
	

}

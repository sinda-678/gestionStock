package com.stockManager.sinda.controlleurs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockManager.sinda.interfaces.CategoriesRepository;
import com.stockManager.sinda.models.Categories;

@RestController
@RequestMapping("api/v1")
public class CategoriesControlleurs {
	
	private CategoriesRepository cr;
	
	@Autowired
	CategoriesControlleurs(CategoriesRepository cr){
		this.cr=cr;
	}
 //recupere tous l'entité de categorie
	@GetMapping("/all")
public ResponseEntity<List<Categories>> getAll(){
		List<Categories> categorie = cr.findAll();
		
		return  new ResponseEntity<List<Categories>>(categorie,HttpStatus.OK) ;
		
		
		
	}
	//pour recuperer un identifiant
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Categories> getOne(@PathVariable("id") Long id){
		
		Optional<Categories> categorie =cr.findById(id);
		
		return new ResponseEntity<Categories>(categorie.get() ,HttpStatus.OK);
		
	}
	
	//pour la creation ou la modification des entités

	@PostMapping("/jessi")
	public ResponseEntity<Categories> getJessi(@RequestBody Categories catego){
		Categories cate = cr.save(catego);
		
		return new  ResponseEntity<Categories>(cate, HttpStatus.OK);
		
		
	}
	
	//pour la suppression des entités
	@DeleteMapping("/del/{id}")
          String getDell(@PathVariable("id") Long id){
		cr.deleteById(id);
		
		
		return "cet element a été supprimer avec succès";
		
		
		
	}
	
} 

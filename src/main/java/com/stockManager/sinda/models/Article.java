package com.stockManager.sinda.models;





import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="article")
public class Article{
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_company")
	private Long idCompany;
	
	@Column(name="code_article")
	private String codeArticle;
   
	@Column(name="designation")
	private String designation;
    
	@Column(name="prix_unitaire_ht")
    private BigDecimal prixUnitaireht;
    
	@Column(name="prix_tva")
    private BigDecimal prixTva;
    
	@Column(name="prix_unitaire_ttc")
    private BigDecimal prixUnitaireTtc;
    
	@Column(name="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Categories category;
    
}

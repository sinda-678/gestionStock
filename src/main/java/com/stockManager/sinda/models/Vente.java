package com.stockManager.sinda.models;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Vente")
public class Vente extends AbstractEntity {
	
	@Column(name="id_company")
	private Long idCompany;
	
	@Column(name="code_vente")
	private String codeVente;
    
	@Column(name="date_vente")
	private Instant dateVente;
	
	@Column(name="commentaires")
    private String commentaire;
	

}

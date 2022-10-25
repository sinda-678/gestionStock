package com.stockManager.sinda.models;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="Vente")
public class Vente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_company")
	private Long idCompany;
	
	@Column(name="code_vente")
	private String codeVente;
    
	@Column(name="date_vente")
	private Instant dateVente;
	
	@Column(name="commentaires")
    private String commentaire;
	
}

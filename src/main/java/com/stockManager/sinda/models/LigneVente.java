package com.stockManager.sinda.models;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LigneVente")
public class LigneVente extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="vente_id")
	private Vente vente;
	
	@Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;
    
	@Column(name="quantite")
    private BigDecimal quantity;

}

package com.stockManager.sinda.models;

import java.math.BigDecimal;

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
@Table(name="LignrCmdFournisseur")
public class LigneCmdFournisseur extends AbstractEntity {
	
	@Column(name="article")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="cmdFournisseur")
    private CmdFournisseur cmdFournisseur;
	
	@Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;
	
	@Column(name="quantite")
    private BigDecimal quantity;
}

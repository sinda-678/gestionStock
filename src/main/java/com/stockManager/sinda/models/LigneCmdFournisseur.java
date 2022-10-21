package com.stockManager.sinda.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stockManager.sinda.dto.LigneCmdFournisseurDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LignrCmdFournisseur")
public class LigneCmdFournisseur  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="article")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="cmdFournisseur")
    private CmdFournisseur cmdFournisseur;
	
	@Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;
	
	@Column(name="quantite")
    private BigDecimal quantity;

	public static LigneCmdFournisseur toEntity(LigneCmdFournisseurDto ligneCmdCl) {
		// TODO Auto-generated method stub
		return null;
	}
}

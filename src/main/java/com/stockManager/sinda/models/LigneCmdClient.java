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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LigneCmdClient")
public class LigneCmdClient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="article_id")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name="cmdClient_id")
    private CmdClient cmdClient;
	
	@Column(name="prix_unitaire")
    private BigDecimal prixUnitaire;
	
	@Column(name="quantite")
    private BigDecimal quantity;

}

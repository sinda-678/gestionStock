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
@Table(name="MvmStock")
public class MvmtStck {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="date_mvt")
    private Instant datemvt;
	
	@Column(name="quantite")
    private BigDecimal quantity;
	
	@ManyToOne
	@JoinColumn(name="article")
    private Article article;
    

}

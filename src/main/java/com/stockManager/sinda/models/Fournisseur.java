package com.stockManager.sinda.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name="fournisseur")
public class Fournisseur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
	@Embedded
    private Address address;
	
	@Column(name="photo")
    private String photo;
	
	@Column(name="num")
    private String numero;
	
	@OneToMany(mappedBy ="fournisseur")
    private List<CmdFournisseur> cmdfournisseurs;

}

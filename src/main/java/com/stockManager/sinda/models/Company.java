package com.stockManager.sinda.models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="company")
public class Company extends AbstractEntity {
	
	@Column(name="code")
	private String code;
	
	@Column(name="nom")
    private String nom;
	
	@Embedded
    private Address address;
	
	@Column(name="description")
    private String description;
	
	@Column(name="code_fiscal")
    private String codeFiscal;
	
	@Column(name="site_web")
    private String siteWeb;
	
	@Column(name="numero")
    private String numero;
	
	@Column(name="mail")
    private String mail;
	
	@Column(name="photo")
    private String photo;
	
	@OneToMany(mappedBy="company")
    private List<Utilisateur> utilisateur;

}

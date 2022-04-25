package com.stockManager.sinda.models;



import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Utilisateur")
public class Utilisateur  extends AbstractEntity {
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
    private String prenom;
	
	@Embedded
    private Address address;
	
	@Column(name="date_de_naissance")
    private Instant dateDeNaissance;
	
	@Column(name="mot_de_passe")
    private String motDePasse;
	
	@Column(name="photo")
    private String photo;
    
    @Column(name="numero_tel")
    private int numerotel;
    
    @ManyToOne
	@JoinColumn(name="company_id")
    private Company company;
    
    @OneToMany(mappedBy="utilisateur")
    private List<Role> roles;

}

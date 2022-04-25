package com.stockManager.sinda.models;


import javax.persistence.Column;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role")
public class Role extends AbstractEntity {
	
	@ManyToOne
	@JoinColumn(name="utilisatuer_id")
	private Utilisateur utilisateur;
	
	@Column(name="nom")
    private String nom;

}

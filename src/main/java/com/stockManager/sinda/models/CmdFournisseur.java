package com.stockManager.sinda.models;



import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="cmd_fournisseur")
public class CmdFournisseur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="code_cmd_fournisseur")
    private String codeCmdFournisseur;

    @Column(name = "date_cmd_fournisseur")
    private Instant dateCmdFournisseur;
    
    @ManyToOne
    @JoinColumn(name="fournisseur_id")
    private Fournisseur fournisseur;
    
    @OneToMany(mappedBy="cmdFournisseur")
    private List<LigneCmdFournisseur> lignesCmdFournisseurs;

}


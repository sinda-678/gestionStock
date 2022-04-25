package com.stockManager.sinda.models;


import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
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
@Table(name="cmd_client")
public class CmdClient extends AbstractEntity {
	
	@Column(name="code_cmd_client")
    private String codeCmdClient;
	    
	@Column(name="date_commande")
	private Instant dateCommande;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;
	
	@OneToMany(mappedBy = "cmdClient")
	private List<LigneCmdClient> lignesCmdClients;

}

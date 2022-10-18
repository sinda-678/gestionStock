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
@Table(name="cmd_client")
public class CmdClient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
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

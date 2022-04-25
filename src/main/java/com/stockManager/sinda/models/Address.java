package com.stockManager.sinda.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="adresse2")
    private String address2;
	
	@Column(name="ville")
    private String ville;
	
	@Column(name="code_postale")
    private String codePostal;
	
	@Column(name="pays")
    private String pays;

}

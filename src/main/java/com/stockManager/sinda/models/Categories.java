package com.stockManager.sinda.models;





import java.util.List;

import javax.persistence.Column;
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
@Table(name="categories")
public class Categories extends AbstractEntity{
	
	@Column(name="code_category")
	private String codeCategory;
	
	@Column(name="designation")
	private String designation;
	
	@OneToMany(mappedBy ="category")
	private List<Article> articles;


}


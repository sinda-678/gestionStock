package com.stockManager.sinda.dto;

import com.stockManager.sinda.models.Role;

import lombok.Builder;
import lombok.Data;

@Data

@Builder
public class RoleDto {


	private Long id;
	
	private UtilisateurDto utilisateur;
	

    private String nom;

    public RoleDto fromEntity(Role role) {
    	if( role == null) {
    		return null;
    	}
    	return RoleDto.builder()
    			.id(role.getId())
    			.nom(role.getNom())
    			.build();
    }
    public Role toEntity(  RoleDto roleDto) {
    	if(roleDto == null) {
    		return null;
    	}
    	 Role  roles = new  Role();
    	 roles.setId(roleDto.getId());
    	 roles.setNom(roleDto.getNom());
    	 return roles;
    }
	
}

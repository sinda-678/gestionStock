package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

}

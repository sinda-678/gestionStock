package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Fournisseur;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {

}

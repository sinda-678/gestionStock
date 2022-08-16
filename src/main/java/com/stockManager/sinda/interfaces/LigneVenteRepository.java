package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.LigneVente;

public interface LigneVenteRepository extends JpaRepository<LigneVente, Long> {

}

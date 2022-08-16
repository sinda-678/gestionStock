package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long> {

}

package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.CmdFournisseur;

public interface CmdFournisseurRepository extends JpaRepository<CmdFournisseur, Long> {

}

package com.stockManager.sinda.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.CmdFournisseur;
import com.stockManager.sinda.models.Fournisseur;

public interface CmdFournisseurRepository extends JpaRepository<CmdFournisseur, Long> {

	Optional<Fournisseur> findByCodeCmdFournisseur(String codeCmdFournisseur);

}

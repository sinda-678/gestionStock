package com.stockManager.sinda.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.CmdClient;

public interface CmdClientRepository extends JpaRepository<CmdClient, Long> {

	Optional <CmdClient> findByCodeCmdClient(String codeCmdClient);
}

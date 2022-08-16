package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.CmdClient;

public interface CmdClientRepository extends JpaRepository<CmdClient, Long> {

}

package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.MvmtStck;

public interface MvmtStockRepository extends JpaRepository<MvmtStck, Long> {

}

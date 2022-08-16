package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}

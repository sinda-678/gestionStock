package com.stockManager.sinda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockManager.sinda.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

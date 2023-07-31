package com.Tienda.tienda.dao;

import com.Tienda.tienda.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository<Rol, Long> {
    
}

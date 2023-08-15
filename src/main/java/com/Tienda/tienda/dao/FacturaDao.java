package com.Tienda.tienda.dao;

import com.Tienda.tienda.domain.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDao extends JpaRepository<Factura, Long>{
    
}

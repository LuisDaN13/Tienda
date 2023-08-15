package com.Tienda.tienda.dao;

import com.Tienda.tienda.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDao extends JpaRepository<Venta, Long>{
    
}

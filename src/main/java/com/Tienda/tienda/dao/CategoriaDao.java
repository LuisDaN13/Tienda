package com.Tienda.tienda.dao;

import com.Tienda.tienda.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    //Más adelante se harán otros métodos
}

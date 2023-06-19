package com.Tienda.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;   // Es para poner la version de Serializacion  
            
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;                           // Se transforma en la BD en id_categoria
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Categoria() {                               // Constructor Normal 
    }

    public Categoria(String descripcion, String rutaImagen, boolean activo) {   //Constructor SobreCargado
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }    
}

package com.Tienda.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable{
    
    private static final long serialVersionUID = 1L;   // Es para poner la version de Serializacion  
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;
    private String descripcion; 
    private String detalle; 
    private double precio;
    private int existencias;
    private String rutaImagen; 
    private boolean activo;
    
    @ManyToOne                              //tipo de relacion, en este caso muchos a uno
    @JoinColumn(name = "id_Categoria")      //hace una referencia a esa columna, la cual es la llave foranea
    private Categoria categoria;            //para hacer la llava foranea

    public Producto() {
    }

    public Producto(String descripcion, String detalle, double precio, int existencias, String rutaImagen, boolean activo, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.categoria = categoria;
    }
}

package com.Tienda.tienda.service;

import com.Tienda.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {

    // Metodo para consultar las productos. El parametro define si se muestran solo las activas o todas
    public List<Producto> getProductos(boolean activos);

    //se obtiene una producto por su ID
    public Producto getProducto(Producto producto);

    //Inserta: se inserta cuando el idProducto esta vacio/ == null
    //Modificar: se modifica cuando el idProducto no esta vacio
    public void save(Producto producto);

    //se elimina un registro por su ID
    public void delete(Producto producto);

    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con SQL Nativo
    public List<Producto> metodoNativo(double precioInf, double precioSup);
}

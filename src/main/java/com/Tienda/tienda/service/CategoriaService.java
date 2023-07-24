package com.Tienda.tienda.service;

import com.Tienda.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    // Metodo para consultar las categorias. El parametro define si se muestran solo las activas o todas
    public List<Categoria> getCategorias(boolean activos);
    
    //se obtiene una categoria por su ID
    public Categoria getCategoria (Categoria categoria);
    
    //Inserta: se inserta cuando el idCategoria esta vacio/ == null
    //Modificar: se modifica cuando el idCategoria no esta vacio
    public void save(Categoria categoria);
    
    //se elimina un registro por su ID
    public void delete(Categoria categoria);
    
    //Para buscar todo segun una descripcion
    //No se tiene que llamar exactamente igual, en este caso se pone "getPorDescripcion"
    public List<Categoria> getPorDescripcion (String descripcion);
}

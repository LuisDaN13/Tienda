package com.Tienda.tienda.dao;

import com.Tienda.tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username);
    
    //Busca un usuario por el nombre de usuario o por el password
    Usuario findByUsernameAndPassword(String username, String Password);

    //Busca un usuario por el nombre de usuario o por el correo
    Usuario findByUsernameOrCorreo(String username, String correo);
    
    //RETORNA UN TRUE O FALSE: En este caso para ver si existe un usuario por nombre de usuario o correo
    boolean existsByUsernameOrCorreo(String username, String correo);
}

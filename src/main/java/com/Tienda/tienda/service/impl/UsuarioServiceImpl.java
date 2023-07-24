package com.Tienda.tienda.service.impl;

import com.Tienda.tienda.dao.UsuarioDao;
import com.Tienda.tienda.domain.Rol;
import com.Tienda.tienda.domain.Usuario;
import com.Tienda.tienda.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Aqui busca el usuario en la base de datos
        Usuario usuario = usuarioDao.findByUsername(username);
        //Si el usuario no existe lanza la excepcion
        if(usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        
        //en caso de ya existir el atributo setiado
        session.removeAttribute("usuarioImagen");
        //luego crea el atributo con su respectivo contenido, en este caso seria la ruta de imagen del usuario
        session.setAttribute("usuarioImagen", usuario.getRutaImagen());
        
        /* FORMA DE USARLO DE OTRA MANERA
        List<Rol> roles = usuario.getRoles();*/
        
        //FORMA DEL PROFESOR
        var roles = new ArrayList<GrantedAuthority>();
        
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        //necesitamos retornar un objeto de tipo "User" con los datos que necesitamos
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}

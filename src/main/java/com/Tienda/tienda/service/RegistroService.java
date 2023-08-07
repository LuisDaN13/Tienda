package com.Tienda.tienda.service;

import com.Tienda.tienda.domain.Usuario;
import jakarta.mail.MessagingException;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

public interface RegistroService {
    
    // un modelo para activar todo un usuario
    public Model activar(Model model, String usuario, String clave);
    
    // recibe todo el usuario 
    public Model crearUsuario(Model model, Usuario usuario) throws MessagingException;
    
    // similar al primero, pero con una imagen
    public void activar(Usuario usuario, MultipartFile imagenFile);
    
    // todo un usuario para recordar
    public Model recordarUsuario(Model model, Usuario usuario) throws MessagingException;
}

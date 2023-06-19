package com.Tienda.tienda.controller;

import com.Tienda.tienda.domain.Categoria;
import com.Tienda.tienda.service.CategoriaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categoria")
@Slf4j
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")                             //Solo mediante peticiones GET
    public String page(Model model) {
        log.info("Consumo del Recurso /categoria/listado");
        List<Categoria> categorias = categoriaService.getCategorias(false);
        model.addAttribute("Lista Categorias", categorias);
        model.addAttribute("Total Categorias", categorias.size());
        return "/categoria/listado";
    }
}

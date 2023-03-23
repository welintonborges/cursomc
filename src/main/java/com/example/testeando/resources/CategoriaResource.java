package com.example.testeando.resources;

import com.example.testeando.domain.Categoria;
import com.example.testeando.exceptions.ObjectNotFoundException;
import com.example.testeando.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;
    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Categoria obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }
}

package com.example.testeando.resources;

import com.example.testeando.domain.Pessoa;
import com.example.testeando.services.Pessoaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResouce {

    @Autowired
    private Pessoaservice pessoaservice;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable Integer id){
        Pessoa obj = pessoaservice.buscar(id);
        return ResponseEntity.ok().body(obj);
    }


}

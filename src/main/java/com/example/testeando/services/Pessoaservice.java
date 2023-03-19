package com.example.testeando.services;

import com.example.testeando.domain.Pessoa;
import com.example.testeando.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Pessoaservice {

    @Autowired
    private PessoaRepository repository;

    public Pessoa buscar(Integer id){
        Optional<Pessoa> obj = repository.findById(id);
        return obj.orElse(null);
    }
}

package com.example.testeando.services;

import com.example.testeando.domain.Cliente;
import com.example.testeando.exceptions.ObjectNotFoundException;
import com.example.testeando.repositories.CategoriaRepository;
import com.example.testeando.repositories.ClienteRepository;
import com.example.testeando.resources.ClienteResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

}
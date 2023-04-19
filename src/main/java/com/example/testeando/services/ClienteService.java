package com.example.testeando.services;

import com.example.testeando.domain.Cliente;
import com.example.testeando.dto.ClienteDTO;
import com.example.testeando.exceptions.DataIntegrityException;
import com.example.testeando.exceptions.ObjectNotFoundException;
import com.example.testeando.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente fromDto(ClienteDTO objDto) {
        return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null,null);
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Cliente update(Cliente obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public void delete(Integer id) {
        try {
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException("Não é possivel exluir uma cliente  vinculo");
        }
    }

    public List<Cliente> findAll() {
        return  repo.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }
}

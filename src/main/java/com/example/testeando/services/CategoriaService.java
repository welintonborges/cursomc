package com.example.testeando.services;

import com.example.testeando.domain.Categoria;
import com.example.testeando.exceptions.DataIntegrityException;
import com.example.testeando.exceptions.ObjectNotFoundException;
import com.example.testeando.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);
        return repo.save(obj);
    }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {

        try {
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw  new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }

    }
    public List<Categoria> findAll() {
        return repo.findAll();
    }
}

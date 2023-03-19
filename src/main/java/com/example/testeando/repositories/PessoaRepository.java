package com.example.testeando.repositories;

import com.example.testeando.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    Optional<Pessoa> findById(Integer id);
}

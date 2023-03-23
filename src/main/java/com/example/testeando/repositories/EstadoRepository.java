package com.example.testeando.repositories;

import com.example.testeando.domain.Categoria;
import com.example.testeando.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {


}

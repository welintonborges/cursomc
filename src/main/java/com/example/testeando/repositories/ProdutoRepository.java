package com.example.testeando.repositories;


import com.example.testeando.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Optional<Produto> findById(Integer id);

}

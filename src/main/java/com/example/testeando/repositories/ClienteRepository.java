package com.example.testeando.repositories;

import com.example.testeando.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


    Optional<Cliente> findById(Integer id);

    @Transactional(readOnly = true)
    Cliente findByEmail(String email);
}

package com.example.testeando.repositories;

import com.example.testeando.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    Optional<Pagamento> findById(Integer id);

}

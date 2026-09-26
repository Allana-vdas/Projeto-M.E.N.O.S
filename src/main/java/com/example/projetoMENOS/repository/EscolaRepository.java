package com.example.projetoMENOS.repository;
import com.example.projetoMENOS.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

    Optional<Escola> findByEmail(String email);
}

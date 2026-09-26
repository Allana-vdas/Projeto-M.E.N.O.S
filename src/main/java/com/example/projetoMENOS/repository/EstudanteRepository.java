package com.example.projetoMENOS.repository;
import com.example.projetoMENOS.model.Escola;
import com.example.projetoMENOS.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    Optional<Estudante> findByEmail(String email);
}
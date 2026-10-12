package com.example.M.E.N.O.S.repository;

import com.example.M.E.N.O.S.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    Optional<Estudante> findByEmail(String email);
}
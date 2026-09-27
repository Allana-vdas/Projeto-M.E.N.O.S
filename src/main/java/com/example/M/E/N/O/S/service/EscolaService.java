package com.example.M.E.N.O.S.service;

import com.example.M.E.N.O.S.model.Escola;
import com.example.M.E.N.O.S.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    private final EscolaRepository escolaRepository;

    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public List<Escola> listarTodos() {
        return escolaRepository.findAll();
    }

    public Escola buscarPorId(Long id) {
        return escolaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escola não encontrada"));
    }

    public Escola salvar(Escola escola) {
        return escolaRepository.save(escola);
    }

    public Escola atualizar(Long id, Escola escola) {
        Escola escolaExistente = buscarPorId(id);

        escolaExistente.setNome(escola.getNome());

        return escolaRepository.save(escolaExistente);
    }

    public void deletar(Long id) {
        Escola escola = buscarPorId(id);
        escolaRepository.delete(escola);
    }
}
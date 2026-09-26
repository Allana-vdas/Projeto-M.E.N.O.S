package com.example.projetoMENOS.service;

import com.example.projetoMENOS.model.Escola;
import com.example.projetoMENOS.repository.EscolaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    private final EscolaRepository escolaRepository;
    // Injeção de dependência via construtor (forma recomendada no Spring)
    public EscolaService(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public List<Escola> listarTodos() {
        return escolaRepository.findAll();
    }

    public Escola buscarPorId(Long id) {
        return escolaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Escola não encontrada com id: " + id));
    }

    public Escola salvar(Escola escola) {
        // Exemplo de regra de negócio: não permitir dois usuários com o mesmo email
        escolaRepository.findByEmail(escola.getEmail()).ifPresent(u -> {
            throw new RuntimeException("Já existe uma escola com este email");
        });
        return escolaRepository.save(escola);
    }

    public Escola atualizar(Long id, Escola dadosAtualizados) {
        Escola escola = buscarPorId(id);
        escola.setNome(dadosAtualizados.getNome());
        escola.setEmail(dadosAtualizados.getEmail());
        return escolaRepository.save(escola);
    }

    public void deletar(Long id) {
        escolaRepository.deleteById(id);
    }
}

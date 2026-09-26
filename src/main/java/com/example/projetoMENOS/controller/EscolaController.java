package com.example.projetoMENOS.controller;

import com.example.projetoMENOS.model.Escola;
import com.example.projetoMENOS.service.EscolaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller REST de Usuario.
 *
 * @RestController = @Controller + @ResponseBody
 *   -> os métodos retornam dados (JSON) diretamente na resposta HTTP,
 *      em vez de retornar o nome de uma página HTML.
 *
 * @RequestMapping("/usuarios") define o prefixo de URL para todos os métodos desta classe.
 *
 * Endpoints disponíveis:
 *   GET    /usuarios        -> lista todos os usuários
 *   GET    /usuarios/{id}   -> busca um usuário pelo id
 *   POST   /usuarios        -> cria um novo usuário
 *   PUT    /usuarios/{id}   -> atualiza um usuário existente
 *   DELETE /usuarios/{id}   -> remove um usuário
 */

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    private final EscolaService escolaService;

    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @GetMapping
    public List<Escola> listar() {
        return escolaService.listarTodos();
    }

    @GetMapping("/{id}")
    public Escola buscarPorId(@PathVariable Long id) {
        return escolaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Escola criar(@Valid @RequestBody Escola escola) {
        return escolaService.salvar(escola);
    }

    @PutMapping("/{id}")
    public Escola atualizar(@PathVariable Long id, @Valid @RequestBody Escola escola) {
        return escolaService.atualizar(id, escola);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        escolaService.deletar(id);
    }
}
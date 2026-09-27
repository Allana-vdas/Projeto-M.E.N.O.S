package com.example.M.E.N.O.S.controller;

import com.example.M.E.N.O.S.model.Escola;
import com.example.M.E.N.O.S.service.EscolaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Escola criar(@RequestBody Escola escola) {
        return escolaService.salvar(escola);
    }

    @PutMapping("/{id}")
    public Escola atualizar(
            @PathVariable Long id,
            @RequestBody Escola escola) {

        return escolaService.atualizar(id, escola);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        escolaService.deletar(id);
    }
}
package com.aulas.sistemasdistribuidos.restdemo.controllers;

import com.aulas.sistemasdistribuidos.produto.Produto;
import com.aulas.sistemasdistribuidos.restdemo.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/{codigo}")
    public Optional<Produto> buscarPorId(@PathVariable Long codigo) {
        return produtoService.buscarPorId(codigo);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        return produtoService.salvar(produto);
    }

    @DeleteMapping("/{codigo}")
    public void deletar(@PathVariable Long codigo) {
        produtoService.deletar(codigo);
    }
}

package com.aulas.sistemasdistribuidos.restdemo.services;

import com.aulas.sistemasdistribuidos.produto.Produto;
import com.aulas.sistemasdistribuidos.restdemo.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long codigo) {
        return produtoRepository.findById(codigo);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletar(Long codigo) {
        produtoRepository.deleteById(codigo);
    }
}
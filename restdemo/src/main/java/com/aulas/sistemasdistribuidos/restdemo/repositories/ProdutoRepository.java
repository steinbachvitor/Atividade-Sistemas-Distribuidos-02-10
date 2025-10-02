package com.aulas.sistemasdistribuidos.restdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aulas.sistemasdistribuidos.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
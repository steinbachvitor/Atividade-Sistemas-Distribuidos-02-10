package com.aulas.sistemasdistribuidos.restdemo.services;

import com.aulas.sistemasdistribuidos.restdemo.domain.Cliente;
import com.aulas.sistemasdistribuidos.restdemo.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public Cliente get(String cpf) {
        return repository.findById(cpf).orElse(null);
    }

    @Transactional
    public void create(Cliente cliente) {
        if (this.get(cliente.getCpf()) != null) {
            throw new IllegalArgumentException("Cliente já existe!");
        }
        repository.save(cliente);
    }

    @Transactional
    public void update(Cliente cliente) {
        if (this.get(cliente.getCpf()) == null) {
            throw new IllegalArgumentException("Cliente não existe!");
        }
        repository.save(cliente);
    }

    @Transactional
    public void remove(String cpf) {
        repository.deleteById(cpf);
    }
}

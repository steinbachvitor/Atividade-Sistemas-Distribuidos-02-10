package com.aulas.sistemasdistribuidos.restdemo.controllers;

import com.aulas.sistemasdistribuidos.restdemo.domain.Cliente;
import com.aulas.sistemasdistribuidos.restdemo.repositories.ClienteRepository;
import com.aulas.sistemasdistribuidos.restdemo.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping()
    public Cliente get(@RequestParam(name = "cpf") String cpf) {
        Cliente cliente = service.get(cpf);
        return cliente;
    }

    @PostMapping
    public void create(@RequestBody Cliente cliente) {
        service.create(cliente);
    }

    @PutMapping
    public void update(@RequestParam(name = "cpf") String cpf,
                       @RequestBody Cliente cliente) {
        cliente.setCpf(cpf);
        service.update(cliente);
    }

    @DeleteMapping
    public void remove(@RequestParam(name = "cpf") String cpf) {
        service.remove(cpf);
    }
}

package com.infotrapichao.projeto_spring_jwt.src.application.contracts.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;

import java.util.List;

public interface IClienteApplication {
    Cliente findById(Integer id);
    Cliente findByCpf(String cpf);
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    List<Cliente> findAll();
}

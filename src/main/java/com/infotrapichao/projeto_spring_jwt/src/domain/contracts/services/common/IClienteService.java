package com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;

import java.util.List;

public interface IClienteService {
    Cliente findById(Integer id);
    Cliente findByCpf(String cpf);
    Cliente create(Cliente cliente);
    Cliente update(Cliente cliente);
    List<Cliente> findAll();
}

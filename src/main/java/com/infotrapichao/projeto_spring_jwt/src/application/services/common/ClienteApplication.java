package com.infotrapichao.projeto_spring_jwt.src.application.services.common;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.common.IClienteApplication;
import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common.IClienteService;
import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.security.IUserService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteApplication implements IClienteApplication {

    private final IClienteService _clienteService;

    public ClienteApplication(IClienteService clienteService){
        this._clienteService = clienteService;
    }
    @Override
    public Cliente findById(Integer id) {
        return _clienteService.findById(id);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return _clienteService.findByCpf(cpf);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return _clienteService.create(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        return _clienteService.update(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return _clienteService.findAll();
    }
}

package com.infotrapichao.projeto_spring_jwt.src.domain.services.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common.IClienteService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClienteService implements IClienteService {

    private final ClienteRepository _clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this._clienteRepository = clienteRepository;
    }
    @Override
    public Cliente findById(Integer id) {
        return _clienteRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return _clienteRepository.findByCpf(cpf);
    }

    @Override
    public Cliente create(Cliente cliente) {
        if(cliente.getId() != null && _clienteRepository.existsById(cliente.getId())){
            throw new IllegalArgumentException("Cliente já cadastrado!!!");
        }else {
            return _clienteRepository.save(cliente);
        }
    }

    @Override
    public Cliente update(Cliente cliente) {
        if(!_clienteRepository.existsById(cliente.getId())){
            throw new IllegalArgumentException("Cliente não cadastrado!!!");
        }else{
            return _clienteRepository.save(cliente);
        }    }

    @Override
    public List<Cliente> findAll() {
        return _clienteRepository.findAll();
    }
}

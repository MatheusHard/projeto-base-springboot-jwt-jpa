package com.infotrapichao.projeto_spring_jwt.src.domain.services.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.contracts.services.common.IClienteService;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Agendamento;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import com.infotrapichao.projeto_spring_jwt.src.infrastruture.repositories.common.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
    @Transactional
    public Cliente update(Cliente cliente) {
        Cliente clienteExistente = _clienteRepository.findById(cliente.getId()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Atualiza os dados simples
        clienteExistente.setName(cliente.getName());
        clienteExistente.setCpf(cliente.getCpf());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelephone(cliente.getTelephone());
        clienteExistente.setUpdatedAt(LocalDateTime.now());

        // ATUALIZA A LISTA DE AGENDAMENTOS sem quebrar a referência:
        clienteExistente.getAgendamentos().clear();
        if (cliente.getAgendamentos() != null) {
            for (Agendamento ag : cliente.getAgendamentos()) {
                ag.setCliente(clienteExistente); // importante manter a referência
            }
            clienteExistente.getAgendamentos().addAll(cliente.getAgendamentos());
        }
        return _clienteRepository.save(cliente);

    }

    @Override
    public List<Cliente> findAll() {
        return _clienteRepository.findAll();
    }
}

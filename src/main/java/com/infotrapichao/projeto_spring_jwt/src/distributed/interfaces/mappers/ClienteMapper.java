package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.mappers;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.ClienteDTO;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;

import java.util.List;

public class ClienteMapper {
    public static ClienteDTO toClienteDTO(Cliente cliente) {
        return new ClienteDTO(cliente.getId(), cliente.getCreatedAt(), cliente.getUpdatedAt(), cliente.getName(), cliente.getCpf(), cliente.getEmail(), cliente.getTelephone(), cliente.getUser());
    }

    public static Cliente toCliente(ClienteDTO clienteDTO) {
        return new Cliente(clienteDTO.getId(), clienteDTO.getCreatedAt(), clienteDTO.getUpdatedAt(), clienteDTO.getName(), clienteDTO.getCpf(), clienteDTO.getEmail(), clienteDTO.getTelephone(), clienteDTO.getUser());
    }

    public static List<ClienteDTO> toClienteDTOList(List<Cliente> clientes) {
        return clientes.stream().map(c -> {
            ClienteDTO dto =  ClienteMapper.toClienteDTO(c);
            //Aqui pode mudar campo do objeto, caso queira
            dto.getUser().setClientes(null);
            dto.getUser().setPassword(null);
            return dto;
        }).toList();
    }

    public static List<Cliente> toUserList(List<ClienteDTO> clientesDtos) {
        return clientesDtos.stream().map(ClienteMapper::toCliente).toList();
    }
}

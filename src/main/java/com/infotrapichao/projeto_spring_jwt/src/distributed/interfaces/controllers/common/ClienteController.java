package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.controllers.common;

import com.infotrapichao.projeto_spring_jwt.src.application.contracts.common.IClienteApplication;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common.ClienteDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.security.UserDTO;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.mappers.ClienteMapper;
import com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.mappers.UserMapper;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController  {

    IClienteApplication _clienteApplication;

    public ClienteController(IClienteApplication clienteApplication){
        this._clienteApplication = clienteApplication;
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@Validated @RequestBody ClienteDTO clienteDTO){

        Cliente cliente = ClienteMapper.toCliente(clienteDTO);
        var clienteCreated = _clienteApplication.create(cliente);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(clienteCreated);
    }

   /* @PutMapping()
    public void put(@RequestBody User usuario){
        userRepository.save(usuario);
    }*/

    @GetMapping()
    public ResponseEntity<List<ClienteDTO>> findAll(){
        var lista = ClienteMapper.toClienteDTOList(_clienteApplication.findAll());
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable("id") Integer id){
        var cliente = _clienteApplication.findById(id);
        return ResponseEntity.ok(cliente);
    }
}

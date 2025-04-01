package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoDTO {
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean finalizado = false;
    private User user;
    private Cliente cliente;
    private String observacao;
    private boolean deletado = false;
}

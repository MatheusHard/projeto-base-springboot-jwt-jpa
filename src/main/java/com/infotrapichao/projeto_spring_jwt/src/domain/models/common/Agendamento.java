package com.infotrapichao.projeto_spring_jwt.src.domain.models.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime updatedAt;

    @Column
    private boolean finalizado = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-agendamentos")
    private User user;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference(value = "cliente-agendamentos")
    private Cliente cliente;

    @Column(length = 200, nullable = false)
    private String observacao;

    @Column(columnDefinition = "bit(1) default 0")
    private boolean deletado = false;

}

package com.infotrapichao.projeto_spring_jwt.src.domain.models.common;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
public class Agendamento {

    public Agendamento(){}
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime updatedAt;

    @Column(columnDefinition = "bit(1) default 0")
    private Boolean finalizado;

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
    private Boolean deletado;

    @Column(name = "data_atendimento", columnDefinition = "DATETIME(6) DEFAULT CURRENT_TIMESTAMP(6)")
    private LocalDateTime dataAtendimento;

    public Agendamento(
            Integer id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Boolean finalizado,
            User user,
            Cliente cliente,
            String observacao,
            Boolean deletado,
            LocalDateTime dataAtendimento) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.finalizado = finalizado;
        this.user = user;
        this.cliente = cliente;
        this.observacao = observacao;
        this.deletado = deletado;
        this.dataAtendimento = dataAtendimento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Boolean getDeletado() {
        return deletado;
    }

    public void setDeletado(Boolean deletado) {
        this.deletado = deletado;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
}

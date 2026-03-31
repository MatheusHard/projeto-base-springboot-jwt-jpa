package com.infotrapichao.projeto_spring_jwt.src.distributed.interfaces.dtos.common;

import com.infotrapichao.projeto_spring_jwt.src.domain.models.common.Cliente;
import com.infotrapichao.projeto_spring_jwt.src.domain.models.security.User;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class AgendamentoDTO {
    
    public AgendamentoDTO(){}
    
    private Integer id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean finalizado;
    private User user;
    private Cliente cliente;
    private String observacao;
    private Boolean deletado = false;

    ///Filters
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private LocalDateTime dataAtendimento;

    public AgendamentoDTO(
            Integer id,
            LocalDateTime createdAt,
            LocalDateTime updatedAt,
            Boolean finalizado,
            User user,
            Cliente cliente,
            String observacao,
            Boolean deletado,
            Object o,
            Object o1,
            LocalDateTime dataAtendimento) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.finalizado = finalizado;
        this.user = user;
        this.cliente = cliente;
        this.observacao = observacao;
        this.deletado = deletado;
        //this.o = o;
        //this.o1 = o1;
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

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDate dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
}

package com.infotrapichao.projeto_spring_jwt.junit;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.chrono.Chronology;
import java.time.temporal.ChronoUnit;
import static org.junit.jupiter.api.Assertions.*;


public class PessoaTest {

    @Test
    void calcIdadeCorreta(){
        Pessoa p = new Pessoa("Borumungu", LocalDateTime.of(2000, 1,1,15,0,0));
        assertEquals(27, p.getIdade());
    }

    @Test
    void ehMaiorDeIdade(){
    Pessoa p = new Pessoa("Irineu", LocalDateTime.of(2000, 1,1,15,0,0));
        assertTrue(p.getEhMaiorDeIdade());
    }
}


class Pessoa {

private String nome;
private LocalDateTime dataDeNascimento;

    public Pessoa(String nome, LocalDateTime dataDeNascimento){
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdade() {
        return (int) ChronoUnit.YEARS.between(dataDeNascimento, LocalDateTime.now());
    }

    public LocalDateTime getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDateTime dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
    public boolean getEhMaiorDeIdade(){
        return this.getIdade() >= 18;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}










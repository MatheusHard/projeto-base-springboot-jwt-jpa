package com.infotrapichao.projeto_spring_jwt.src.security;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JWTObject {

    private String subject; // nome usuario
    private Date issueAt; // data criacao token
    private Date expiration; // data expiração
    private List<String> roles; //perfis de acesso

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getIssueAt() {
        return issueAt;
    }

    public void setIssueAt(Date issueAt) {
        this.issueAt = issueAt;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setRoles(String... roles){
        this.roles = Arrays.asList(roles);
    }
}

package com.fiap.food.application.core.domain;

import lombok.Data;

public class Customer {

    public Customer() {
        this.validCpf = false;
    }

    public Customer(Long id, String name, String cpf, String email, String password, Boolean validCpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.password = password;
        this.validCpf = validCpf;
    }

    private Long id;
    private String name;
    private String cpf;
    private String email;
    private String password;
    private Boolean validCpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getValidCpf() {
        return validCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        this.validCpf = validCpf;
    }
}

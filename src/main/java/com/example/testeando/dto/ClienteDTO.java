package com.example.testeando.dto;

import com.example.testeando.domain.Cliente;

public class ClienteDTO {

    private Integer id;
    private String nome;

    private String email;
    public ClienteDTO() {
    }

    public ClienteDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = getNome();
        email = getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

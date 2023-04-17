package com.example.testeando.dto;

import com.example.testeando.domain.Categoria;
import com.sun.istack.NotNull;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private  Integer id;

    @NotEmpty(message ="Preenchimento obrigatório")
    @Length(min=5, max=80, message ="O Tamnho deve ser enrtre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria obj){
        id = obj.getId();
        nome = obj.getNome();
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
}

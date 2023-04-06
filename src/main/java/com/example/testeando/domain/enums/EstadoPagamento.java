package com.example.testeando.domain.enums;

public enum EstadoPagamento {
    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private  Integer cod;
    private String descricao;

    private EstadoPagamento(Integer cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EstadoPagamento toEnum(Integer id){
        if (id == null)
            return null;

        for (EstadoPagamento x: EstadoPagamento.values()) {
            if (id.equals(x.getCod()))
                return x;
        }
        throw new IllegalArgumentException("Id inválido" + id);
    }
}

package org.example.CalConversao;

public class Moeda {
    private String nome;
    private String codigo;
    private String simbolo;

    public Moeda(String nome, String codigo, String simbolo) {
        this.nome = nome;
        this.codigo = codigo;
        this.simbolo = simbolo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    @Override
    public String toString() {
        return nome;
    }
}

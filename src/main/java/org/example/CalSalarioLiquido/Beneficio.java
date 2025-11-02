package org.example.CalSalarioLiquido;

public class Beneficio {
    private String nome;
    private double valor;

    public Beneficio(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public String getNome() {
        return nome;
    }
}

package org.example.CalSalarioLiquido;

public class Desconto {
    private String nome;
    private double valor;

    public Desconto(String nome, double valor) {
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

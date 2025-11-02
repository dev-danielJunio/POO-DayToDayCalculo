package org.example.CalConversao;

import org.example.Calculo;

public class Conversao extends Calculo {
    private double valorOriginal;
    private double cotacao;
    private Moeda origem;
    private Moeda destino;

    public Conversao(double valorOriginal, double cotacao, Moeda origem, Moeda destino) {
        super("Conversão de Moeda");
        this.valorOriginal = valorOriginal;
        this.cotacao = cotacao;
        this.origem = origem;
        this.destino = destino;
    }

    public double converter() {
        return valorOriginal * cotacao;
    }

    @Override
    public double executar() {
        return converter();
    }

    @Override
    public void exibirResultado() {
        System.out.printf("%s: %.2f %s = %.2f %s%n",
                nomeCal, valorOriginal, origem.getSimbolo(), executar(), destino.getSimbolo());
    }
}

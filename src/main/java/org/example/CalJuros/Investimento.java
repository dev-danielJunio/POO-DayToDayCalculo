package org.example.CalJuros;

import org.example.Calculo;

public abstract class Investimento extends Calculo {
    protected double capital;
    protected double taxa;
    protected int tempo;

    public Investimento(String nome, double capital, double taxa, int tempo) {
        super(nome);
        this.capital = capital;
        this.taxa = taxa;
        this.tempo = tempo;
    }

    public abstract double calcularMontante();
}

package org.example;

public abstract class Calculo implements Exibivel{
    protected String nomeCal;

    public Calculo(String nomeCal) {
        this.nomeCal = nomeCal;
    }

    public abstract double executar();
}

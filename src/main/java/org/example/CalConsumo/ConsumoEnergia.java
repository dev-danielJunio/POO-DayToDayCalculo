package org.example.CalConsumo;

import org.example.Calculo;

public class ConsumoEnergia extends Calculo {
    private double consumoKw;
    private double valorKw;

    public ConsumoEnergia(double consumoKw, double valorKw) {
        super("Consumo de Energia");
        this.consumoKw = consumoKw;
        this.valorKw = valorKw;
    }

    public double calcularCusto() {
        return consumoKw * valorKw;
    }

    @Override
    public double executar() {
        return calcularCusto();
    }

    @Override
    public void exibirResultado() {
        System.out.printf("%s: R$ %.2f%n", nomeCal, executar());
    }
}
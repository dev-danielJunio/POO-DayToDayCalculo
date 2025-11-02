package org.example.CalIMC;

import org.example.Calculo;

public class CalculoIMC extends Calculo {
    private double peso;
    private double altura;

    public CalculoIMC(double peso, double altura) {
        super("Cálculo de IMC");
        this.peso = peso;
        this.altura = altura;
    }

    public String classificar(double imc) {
        if (imc < 18.5) return "Abaixo do peso";
        else if (imc < 25) return "Peso normal";
        else if (imc < 30) return "Sobrepeso";
        else return "Obesidade";
    }

    @Override
    public double executar() {
        return peso / (altura * altura);
    }

    @Override
    public void exibirResultado() {
        double imc = executar();
        System.out.printf("%s: %.2f (%s)%n", nomeCal, imc, classificar(imc));
    }
}

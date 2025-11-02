package org.example.CalJuros;

public class JurosSimples extends Investimento {
    public JurosSimples(double capital, double taxa, int tempo) {
        super("Juros Simples", capital, taxa, tempo);
    }

    @Override
    public double calcularMontante() {
        return capital * (1 + taxa * tempo);
    }

    @Override
    public double executar() {
        return calcularMontante();
    }

    @Override
    public void exibirResultado() {
        System.out.printf("%s: R$ %.2f%n", nomeCal, executar());
    }
}


package org.example.CalJuros;

public class JurosCompostos extends Investimento {
    public JurosCompostos(double capital, double taxa, int tempo) {
        super("Juros Compostos", capital, taxa, tempo);
    }

    @Override
    public double calcularMontante() {
        return capital * Math.pow(1 + taxa, tempo);
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

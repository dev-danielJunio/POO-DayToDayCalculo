package org.example.CalSalarioLiquido;

import org.example.Calculo;

import java.util.ArrayList;
import java.util.List;

public class CalculoSalario extends Calculo {
    private double salarioBruto;
    private List<Desconto> descontos;
    private List<Beneficio> beneficios;

    public CalculoSalario(double salarioBruto) {
        super("Cálculo de Salário Líquido");
        this.salarioBruto = salarioBruto;
        this.descontos = new ArrayList<>();
        this.beneficios = new ArrayList<>();
    }

    public void addDesconto(Desconto d) {
        this.descontos.add(d);
    }

    public void addBeneficio(Beneficio b) {
        this.beneficios.add(b);
    }

    private double calSalarioLiquido() {
        double totalDescontos = 0;
        double totalBeneficios = 0;
        for (Desconto d : descontos) {
            totalDescontos += d.getValor();
        }
        for (Beneficio b : beneficios) {
            totalBeneficios += b.getValor();
        }
        return salarioBruto - totalDescontos + totalBeneficios;
    }

    @Override
    public double executar() {
        return calSalarioLiquido();
    }

    @Override
    public void exibirResultado() {
        System.out.printf("%s: R$ %.2f%n", nomeCal, executar());
    }
}

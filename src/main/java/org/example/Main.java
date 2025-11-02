package org.example;

import org.example.CalConsumo.ConsumoEnergia;
import org.example.CalConversao.Conversao;
import org.example.CalConversao.Moeda;
import org.example.CalIMC.CalculoIMC;
import org.example.CalJuros.JurosCompostos;
import org.example.CalJuros.JurosSimples;
import org.example.CalSalarioLiquido.Beneficio;
import org.example.CalSalarioLiquido.CalculoSalario;
import org.example.CalSalarioLiquido.Desconto;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Calculo> calculos = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n=== SISTEMA DE CÁLCULOS DO DIA A DIA ===");
            System.out.println("1 - Calcular Salário Líquido");
            System.out.println("2 - Calcular IMC");
            System.out.println("3 - Conversão de Moedas");
            System.out.println("4 - Juros Simples");
            System.out.println("5 - Juros Compostos");
            System.out.println("6 - Consumo de Energia");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o salário bruto: ");
                    double salario = sc.nextDouble();

                    CalculoSalario calcSal = new CalculoSalario(salario);

                    System.out.print("Quantos descontos deseja adicionar? ");
                    int qtdDesc = sc.nextInt();
                    for (int i = 0; i < qtdDesc; i++) {
                        sc.nextLine();
                        System.out.print("Nome do desconto: ");
                        String nome = sc.nextLine();
                        System.out.print("Valor do desconto: ");
                        double valor = sc.nextDouble();
                        calcSal.addDesconto(new Desconto(nome, valor));
                    }

                    System.out.print("Quantos benefícios deseja adicionar? ");
                    int qtdBene = sc.nextInt();
                    for (int i = 0; i < qtdBene; i++) {
                        sc.nextLine();
                        System.out.print("Nome do benefício: ");
                        String nome = sc.nextLine();
                        System.out.print("Valor do benefício: ");
                        double valor = sc.nextDouble();
                        calcSal.addBeneficio(new Beneficio(nome, valor));
                    }

                    calculos.add(calcSal);
                }

                case 2 -> {
                    System.out.print("Digite o peso (kg): ");
                    double peso = sc.nextDouble();
                    System.out.print("Digite a altura (m): ");
                    double altura = sc.nextDouble();
                    calculos.add(new CalculoIMC(peso, altura));
                }

                case 3 -> {
                    System.out.print("Digite o nome da moeda de origem: ");
                    String nomeOrigem = sc.nextLine();
                    System.out.print("Símbolo da moeda de origem: ");
                    String simboloOrigem = sc.nextLine();
                    Moeda origem = new Moeda(nomeOrigem, nomeOrigem.substring(0, 3).toUpperCase(), simboloOrigem);

                    System.out.print("Digite o nome da moeda de destino: ");
                    String nomeDestino = sc.nextLine();
                    System.out.print("Símbolo da moeda de destino: ");
                    String simboloDestino = sc.nextLine();
                    Moeda destino = new Moeda(nomeDestino, nomeDestino.substring(0, 3).toUpperCase(), simboloDestino);

                    System.out.print("Valor a converter: ");
                    double valorOriginal = sc.nextDouble();
                    System.out.print("Cotação atual: ");
                    double cotacao = sc.nextDouble();

                    calculos.add(new Conversao(valorOriginal, cotacao, origem, destino));
                }

                case 4 -> {
                    System.out.print("Capital inicial: ");
                    double capital = sc.nextDouble();
                    System.out.print("Taxa (em decimal, ex: 0.05 = 5%): ");
                    double taxa = sc.nextDouble();
                    System.out.print("Tempo (meses): ");
                    int tempo = sc.nextInt();

                    calculos.add(new JurosSimples(capital, taxa, tempo));
                }

                case 5 -> {
                    System.out.print("Capital inicial: ");
                    double capital = sc.nextDouble();
                    System.out.print("Taxa (em decimal, ex: 0.05 = 5%): ");
                    double taxa = sc.nextDouble();
                    System.out.print("Tempo (meses): ");
                    int tempo = sc.nextInt();

                    calculos.add(new JurosCompostos(capital, taxa, tempo));
                }

                case 6 -> {
                    System.out.print("Consumo em kWh: ");
                    double consumo = sc.nextDouble();
                    System.out.print("Valor do kWh (R$): ");
                    double valor = sc.nextDouble();

                    calculos.add(new ConsumoEnergia(consumo, valor));
                }

                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

            if (opcao != 0) {
                System.out.println("\n=== RESULTADOS ===");
                for (Calculo c : calculos) {
                    c.exibirResultado();
                }
                calculos.clear(); // limpa lista para nova rodada
            }

        } while (opcao != 0);

        sc.close();
    }
}

package Main;
import Model.Conta;
import Model.ContaCorrente;
import Model.ContaPopanca;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();
        boolean finalizar = true, achouConta;
        String indiceConta;
        while (finalizar) {
            System.out.println("[ 1 ] - Cadastrar Conta");
            System.out.println("[ 2 ] - Sacar");
            System.out.println("[ 3 ] - Depositar");
            System.out.println("[ 4 ] - Extrato");
            System.out.println("[ 5 ] - Rendimento");
            System.out.println("[ 6 ] - Listagem");
            System.out.println("[ 7 ] - Sair");
            System.out.print("Selecione uma opcao: ");
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Qual e o tipo de conta? ");
                    System.out.println("[ 1 ] - Conta Poupanca");
                    System.out.println("[ 2 ] - Conta Corrente");
                    System.out.print("Selecione uma Opcao: ");
                    int user = input.nextInt();
                    input.nextLine();
                    switch (user) {
                        case 1:
                            System.out.print("Digite o nome da conta: ");
                            String nome1 = input.nextLine();
                            boolean contaUnica = true;
                            String numConta1;
                            do {
                                System.out.print("Digite o numero da conta: ");
                                numConta1 = input.nextLine();
                                for (Conta contaAtual : contas)
                                    if (numConta1.equals(contaAtual.getNumeroConta())) {
                                        contaUnica = false;
                                        break;
                                    }
                            } while (!contaUnica);
                            System.out.print("Digite o saldo: ");
                            double saldo1 = input.nextDouble();
                            System.out.print("Digite sua taxa de rendimento: ");
                            double taxa = input.nextDouble();
                            try {
                                contas.add(new ContaPopanca(nome1, numConta1, saldo1, taxa));
                                System.out.println("Conta cadastrada com sucesso.");
                            } catch (IllegalArgumentException error) {
                                System.out.println(error.getMessage());
                            }
                            break;
                        case 2:
                            System.out.print("Digite o nome da conta: ");
                            String nome2 = input.nextLine();
                            System.out.print("Digite o numero da conta: ");
                            String numConta2 = input.nextLine();
                            System.out.print("Digite o saldo: ");
                            double saldo2 = input.nextDouble();
                            System.out.print("Digite o valor cobrado por movimento: ");
                            double valorMovimento = input.nextDouble();
                            try {
                                contas.add(new ContaCorrente(nome2, numConta2, saldo2, valorMovimento));
                                System.out.println("Conta cadastrada com sucesso.");
                            } catch (IllegalArgumentException error) {
                                System.out.println(error.getMessage());
                            }
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Digite o numero da conta para sacar: ");
                    indiceConta = input.nextLine();
                    achouConta = false;
                    for (Conta contaAtual : contas)
                        if (indiceConta.equals(contaAtual.getNumeroConta())) {
                            achouConta = true;
                            System.out.print("Digite o valor para sacar: ");
                            try {
                                double saque = input.nextDouble();
                                if (contaAtual instanceof ContaPopanca) {
                                    contaAtual.sacar(saque);
                                } else
                                    contaAtual.sacar(saque);
                                System.out.print("Saque feito com sucesso.");
                            } catch (IllegalArgumentException error) {
                                System.out.println(error.getMessage());
                            }

                            break;
                        }
                    if (!achouConta)
                        System.out.print("Numero da conta Invalido.");
                    break;
                case 3:
                    System.out.print("Digite o numero da conta para depositar: ");
                    indiceConta = input.nextLine(); //usar o numero da conta aqui
                    achouConta = false;
                    for (Conta contaAtual : contas)
                        if (indiceConta.equals(contaAtual.getNumeroConta())) {
                            achouConta = true;
                            System.out.println("Digite o valor para depositar: ");
                            double deposito = input.nextDouble();
                            try {
                                if (contaAtual instanceof ContaPopanca) {
                                    contaAtual.depositar(deposito);
                                } else
                                    contaAtual.depositar(deposito);
                                System.out.println("Deposito feito com sucesso!");
                            } catch (IllegalArgumentException error) {
                                System.out.println(error.getMessage());
                            }
                        }
                    if (!achouConta)
                        System.out.print("Numero da conta Invalido.");
                    break;
                case 4:
                    System.out.print("Digite o numero da conta para ver o extrato: ");
                    indiceConta = input.nextLine();
                    achouConta = false;
                    for (Conta contaAtual : contas)
                        if (indiceConta.equals(contaAtual.getNumeroConta())) {
                            achouConta = true;
                            System.out.println(contaAtual);
                        }
                    if (!achouConta)
                        System.out.print("Numero da conta Invalido.");
                    break;
                case 5:
                    System.out.print("Digite o indice da conta para atualizar a Taxa de rendimento: ");
                    indiceConta = input.nextLine();
                    achouConta = false;
                    for (Conta contaAtual : contas)
                        if (indiceConta.equals(contaAtual.getNumeroConta())) {
                            achouConta = true;
                            if (contaAtual instanceof ContaPopanca) {
                                System.out.println("Digite a taxa de rendimento: ");
                                double rend = input.nextDouble();
                                try {
                                    ((ContaPopanca) contaAtual).atualizaSaldoRendimento(rend);
                                    System.out.println("Taxa de rendimento atualizada com sucesso.");
                                } catch (IllegalArgumentException error) {
                                    System.out.println(error.getMessage());
                                }
                            } else
                                System.out.println("Conta Corrente nao possui a Taxa de Rendimento.");
                        }
                    if (!achouConta)
                        System.out.println("Numero da conta Invalido.");
                    break;
                case 6:
                    for (int i = 0; i < contas.size(); i++) {
                        System.out.println("Conta " + i + ": \n" + contas.get(i).toString());
                        System.out.println("\n");
                    }
                    break;
                case 7:
                    System.out.println("Saindo do programa...");
                    finalizar = false;
                    break;
                default:
                    System.out.println("Opcao Invalida.");
            }
        }
        input.close();
    }
}
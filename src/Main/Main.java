package Main;

import Model.Conta;
import Model.ContaCorrente;
import Model.ContaPopanca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            ArrayList<Conta> contas = new ArrayList<>();
            boolean finalizar = true, achouConta;
            String indiceConta;
            while (finalizar) {
                System.out.println();
                System.out.println("========= MENU =========");
                System.out.println("[ 1 ] - Cadastrar Conta");
                System.out.println("[ 2 ] - Sacar");
                System.out.println("[ 3 ] - Depositar");
                System.out.println("[ 4 ] - Extrato");
                System.out.println("[ 5 ] - Rendimento");
                System.out.println("[ 6 ] - Listagem");
                System.out.println("[ 7 ] - Sair");
                System.out.println("========================");
                System.out.print("Selecione uma opcao: ");
                int option = input.nextInt();
                input.nextLine();
                switch (option) {
                    case 1 -> {
                        String user = "";
                        while (!user.equals("1") && !user.equals("2")) {
                            System.out.println();
                            System.out.println("Qual e o tipo de conta? ");
                            System.out.println("[ 1 ] - Conta Poupanca");
                            System.out.println("[ 2 ] - Conta Corrente");
                            System.out.println();
                            System.out.print("Selecione uma Opcao: ");

                            user = input.nextLine();
                            if ((!user.equals("1")) && (!user.equals("2"))) {
                                System.out.println("Dado invalido.");
                            }
                        }
                        switch (user) {
                            case "1" -> {
                                System.out.print("Informe o titular da conta: ");
                                String nome1 = input.nextLine();
                                boolean contaUnica = true;
                                String numConta1;
                                do {
                                    System.out.print("Digite o numero da conta: ");
                                    numConta1 = input.nextLine();
                                    while (numConta1.equals("")) {
                                        System.out.println("Valor invalido. Informe o numero da conta.");
                                        System.out.print("Digite o numero da conta: ");
                                        numConta1 = input.nextLine();
                                    }
                                    for (Conta contaAtual : contas) {
                                        if (numConta1.equals(contaAtual.getNumeroConta())) {
                                            contaUnica = false;
                                            break;
                                        }
                                    }
                                } while (!contaUnica);
                                System.out.print("Digite o saldo: ");
                                double saldo1 = input.nextDouble();
                                System.out.print("Digite sua taxa de rendimento( % ): ");
                                double taxa = input.nextDouble();
                                try {
                                    contas.add(new ContaPopanca(nome1, numConta1, saldo1, taxa));
                                    System.out.println("Conta cadastrada com sucesso.");
                                } catch (IllegalArgumentException error) {
                                    System.out.println(error.getMessage());
                                }
                            }
                            case "2" -> {
                                System.out.print("Informe o titular da conta: ");
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
                            }
                        }
                    }
                    case 2 -> {
                        System.out.print("Digite o numero da conta para sacar: ");
                        indiceConta = input.nextLine();
                        achouConta = false;
                        for (Conta contaAtual : contas) {
                            if (indiceConta.equals(contaAtual.getNumeroConta())) {
                                achouConta = true;
                                System.out.print("Digite o valor para sacar: ");
                                try {
                                    double saque = input.nextDouble();
                                    if (contaAtual instanceof ContaPopanca) {
                                        contaAtual.sacar(saque);
                                    } else {
                                        contaAtual.debitoConta(saque);
                                    }
                                } catch (IllegalArgumentException error) {
                                    System.out.println(error.getMessage());

                                }
                                break;
                            }
                        }
                        if (!achouConta) {
                            System.out.print("Numero da conta Invalido.");
                        }
                    }
                    case 3 -> {
                        System.out.print("Digite o numero da conta para depositar: ");
                        indiceConta = input.nextLine(); //usar o numero da conta aqui
                        achouConta = false;
                        for (Conta contaAtual : contas) {
                            if (indiceConta.equals(contaAtual.getNumeroConta())) {
                                achouConta = true;
                                System.out.println("Digite o valor para depositar: ");
                                double deposito = input.nextDouble();
                                try {
                                    if (contaAtual instanceof ContaPopanca) {
                                        contaAtual.depositar(deposito);
                                    } else {
                                        contaAtual.creditoConta(deposito);
                                    }
                                } catch (IllegalArgumentException error) {
                                    System.out.println(error.getMessage());
                                }
                            }
                        }
                        if (!achouConta) {
                            System.out.print("Numero da conta Invalido.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Digite o numero da conta para ver o extrato: ");
                        indiceConta = input.nextLine();
                        achouConta = false;
                        for (Conta contaAtual : contas) {
                            if (indiceConta.equals(contaAtual.getNumeroConta())) {
                                achouConta = true;
                                System.out.println(contaAtual);
                            }
                        }
                        if (!achouConta) {
                            System.out.print("Numero da conta Invalido.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Digite o numero da conta para atualizar a Taxa de rendimento ( % ): ");
                        indiceConta = input.nextLine();
                        achouConta = false;
                        for (Conta contaAtual : contas) {
                            if (indiceConta.equals(contaAtual.getNumeroConta())) {
                                achouConta = true;
                                if (contaAtual instanceof ContaPopanca contaPopanca) {
                                    System.out.println("Digite a nova taxa de rendimento ( % ): ");
                                    double rend = input.nextDouble();
                                    try {
                                        contaPopanca.atualizaSaldoRendimento(rend);
                                    } catch (IllegalArgumentException error) {
                                        System.out.println(error.getMessage());
                                    }
                                } else {
                                    System.out.println("Conta Corrente nao possui a Taxa de Rendimento.");
                                }
                            }
                        }
                        if (!achouConta) {
                            System.out.println("Numero da conta Invalido.");
                        }
                    }
                    case 6 -> {
                        for (int i = 0; i < contas.size(); i++) {
                            System.out.println("Conta " + i + ":\n\n" + contas.get(i).toString());
                        }
                    }
                    case 7 -> {
                        System.out.println("Saindo do programa...");
                        finalizar = false;
                    }
                    default -> System.out.println("Opcao Invalida.");
                }
            }
            input.close();
        }
    }
}
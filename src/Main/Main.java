package Main;
import Model.Conta;
import Model.ContaCorrente;
import Model.ContaPopanca;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        System.out.println("Qual e o tipo de conta? ");
        System.out.println("[ 1 ] - Conta Poupanca");
        System.out.println("[ 2 ] - Conta Corrente");
        System.out.println("Selecione uma Opcao: ");
        int u = input.nextInt();
        input.nextLine();
        switch (u) {
            case 1:
                while (true) {
                    System.out.println("[ 1 ] - Cadastrar Conta");
                    System.out.println("[ 2 ] - Sacar");
                    System.out.println("[ 3 ] - Depositar");
                    System.out.println("[ 4 ] - Extrato");
                    System.out.println("[ 5 ] - Rendimento");
                    System.out.println("[ 6 ] - Listagem");
                    System.out.println("[ 7 ] - Sair");
                    System.out.println("Selecione uma opcao: ");
                    int user = input.nextInt();
                    input.nextLine();
                    switch (user) {
                        case 1:
                            System.out.println("Digite o nome da conta: ");
                            String nome1 = input.nextLine();
                            boolean contaUnica=true;
                            String numConta1;
                            do {
                                System.out.print("Digite o numero da conta: ");
                                numConta1 =  input.nextLine();
                                for(Conta contaAtual: contas )
                                    if (numConta1.equals(contaAtual.getNumeroConta())){
                                        contaUnica = false;
                                    break;
                                    }
                            }while(!contaUnica);
                            System.out.print("Digite o saldo: ");
                            double saldo1 = input.nextDouble();
                            double taxa;
                            do {
                                System.out.print("Digite sua taxa de rendimento: ");
                                taxa = input.nextDouble();
                            }while (taxa >1.0 || taxa <0.0);

                            contas.add(new ContaPopanca(nome1, numConta1, saldo1, taxa));
                            System.out.println("Conta cadastrada com sucesso.");
                            break;
                        case 2:
                            System.out.print("Digite o indice da conta para sacar: ");
                            int indiceConta1 = input.nextInt(); //usar o numero da conta aqui

                            if (indiceConta1 >= 0 && indiceConta1 < contas.size()) {
                                System.out.print("Digite o valor para sacar: ");
                                double sacar = input.nextDouble();
                                contas.get(indiceConta1).sacar(sacar);
                                System.out.print("Saque feito com sucesso.");
                            } else {
                                System.out.print("Indice da conta Invalido.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite o indice da conta para depositar: ");
                            int indiceConta2 = input.nextInt();

                            if (indiceConta2 >= 0 && indiceConta2 < contas.size()) {
                                System.out.println("Digite o valor para depositar: ");
                                double depositar = input.nextDouble();
                                contas.get(indiceConta2).depositar(depositar);
                                System.out.println("deposito feito com sucesso.");
                            } else {
                                System.out.println("Indice da conta Invalido.");
                            }
                            break;
                        case 4:
                            System.out.println("Digite o indice da conta para ver o extrato: ");
                            int indiceConta3 = input.nextInt();
                            if (indiceConta3 >= 0 && indiceConta3 < contas.size()) {
                                System.out.println(contas.get(indiceConta3).toString());
                            } else {
                                System.out.println("Indice da conta Invalido.");
                            }
                            break;
                        case 5:
                            System.out.println("Digite o indice da conta para atualizar a Taxa de rendimento: ");
                            int indiceConta4 = input.nextInt();

                            if (indiceConta4 >= 0 && indiceConta4 < contas.size()) {
                                ContaPopanca contaPoupanca = new ContaPopanca();
                                System.out.println("Digite a taxa de rendimento: ");
                                double rend = input.nextDouble();
                                contaPoupanca.atualizaSaldoRendimento(rend);
                                System.out.println("Taxa de rendimento atualizada com sucesso.");
                            } else {
                                System.out.println("Indice da conta Invalido.");
                            }
                            break;
                        case 6:
                            for (int i = 0; i < contas.size(); i++) {
                                System.out.println("Conta " + i + ": \n" + contas.get(i).toString());
                                System.out.println("\n");
                            }
                            break;
                        case 7:
                            System.out.println("Saindo do programa...");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opcao Invalida.");
                            break;
                    }
                }
            case 2:
                while (true) {
                    System.out.println("[ 1 ] - Cadastrar Conta");
                    System.out.println("[ 2 ] - Sacar");
                    System.out.println("[ 3 ] - Depositar");
                    System.out.println("[ 4 ] - Extrato");
                    System.out.println("[ 5 ] - Rendimento");
                    System.out.println("[ 6 ] - Listagem");
                    System.out.println("[ 7 ] - Sair");
                    System.out.println("Selecione uma opcao: ");
                    int user = input.nextInt();
                    input.nextLine();
                    switch (user) {
                        case 1:
                            System.out.println("Digite o nome da conta: ");
                            String nome2 = input.nextLine();
                            System.out.println("Digite o numero da conta: ");
                            String numConta2 = input.nextLine();
                            System.out.println("Digite o saldo: ");
                            double saldo2 = input.nextDouble();
                            System.out.println("Digite o valor do movimento: ");
                            double valorMovimento = input.nextDouble();
                            contas.add(new ContaCorrente(nome2, numConta2, saldo2, valorMovimento));
                            System.out.println("Conta cadastrada com sucesso.");
                            break;
                        case 2:
                            System.out.println("Digite o indice da conta para sacar: ");
                            int indiceContaCorrente1 = input.nextInt();

                            if (indiceContaCorrente1 >= 0 && indiceContaCorrente1 < contas.size()) {
                                System.out.println("Digite o valor para sacar: ");
                                double sacar = input.nextDouble();
                                contas.get(indiceContaCorrente1).sacar(sacar);
                                System.out.println("Saque feito com sucesso.");
                            } else {
                                System.out.println("Indice da conta Invalido.");
                            }
                            break;
                        case 3:
                            System.out.println("Digite o indice da conta para depositar: ");
                            int indiceContaCorrente2 = input.nextInt();

                            if (indiceContaCorrente2 >= 0 && indiceContaCorrente2 < contas.size()) {
                                System.out.println("Digite o valor para depositar: ");
                                double depositar = input.nextDouble();
                                contas.get(indiceContaCorrente2).depositar(depositar);
                                System.out.println("deposito feito com sucesso.");
                            } else {
                                System.out.println("Indice da conta Invalido.");
                            }
                            break;
                        case 4:
                            System.out.println("Digite o indice da conta para ver o extrato: ");
                            int indiceContaCorrente3 = input.nextInt();
                            if (indiceContaCorrente3 >= 0 && indiceContaCorrente3 < contas.size()) {
                                System.out.println(contas.get(indiceContaCorrente3).toString());
                            } else {
                                System.out.println("Indice da conta Invalido.");
                            }
                            break;
                        case 5:
                            System.out.println("Conta Corrente nao possui a Taxa de Rendimento.");
                            break;
                        case 6:
                            System.out.println("Lista de Contas: ");
                            for (int i = 0; i < contas.size(); i++) {
                                System.out.println("Conta " + i + ": " + contas.get(i).toString());
                                System.out.println("\n");
                            }
                            break;
                        case 7:
                            System.out.println("Saindo do programa...");
                            break;
                        default:
                            System.out.println("Opcao Invalida.");
                            break;
                    }
                }
        }
        input.close();
    }
}

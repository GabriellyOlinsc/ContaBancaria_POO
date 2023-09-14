package Model;

import com.sun.source.tree.ReturnTree;

import java.util.ArrayList;

public abstract class Conta{

    private String titularConta;
    private String numeroConta;
    private double saldo;
    private ArrayList<Double> historicoBancario;

    public Conta(){
        
    }
    public Conta(String titularConta, String numeroConta, double saldo) {
        this.titularConta = titularConta;
        this.numeroConta = numeroConta;
        if (saldo < 0) {
            throw new IllegalArgumentException("ERRO. Saldo deve ser maior ou igual a 0.");
        }
        this.saldo = saldo;
        this.historicoBancario = new ArrayList<>();
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("ERRO. O valor do saque deve ser MAIOR que zero.");
        }
        if (valor > this.getSaldo()) {
            throw new IllegalArgumentException("ERRO. Saldo insuficiente para o saque.");
        }

        this.setSaldo(this.getSaldo() - valor);
        historicoBancario.add(-valor); // vai adicionar o valor negativo ao histórico
        System.out.println("Saque de R$" + valor + " realizado com sucesso!");
    }
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("ERRO. O valor do saque deve ser MAIOR que zero.");
        }

        this.setSaldo(this.getSaldo() + valor);
        historicoBancario.add(valor); // vai adicionar o valor positivo ao histórico
        System.out.println("Deposito de R$" + valor + " realizado com sucesso!");
    }

    public String getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(String titularConta) {
        this.titularConta = titularConta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Double> getHistoricoBancario() {
        return historicoBancario;
    }

    public void setHistoricoBancario(ArrayList<Double> historicoBancario) {
        this.historicoBancario = historicoBancario;
    }


    public void creditoConta(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do credito deve ser MAIOR que zero.");
        }

        this.setSaldo(this.getSaldo() + valor);
        this.historicoBancario.add(valor);
        System.out.println("Credito de R$" + valor + " relizado com sucesso.");
    }

    public void debitoConta(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do debito deve ser MAIOR que zero.");
        }

        this.setSaldo(this.getSaldo() + valor);
        this.historicoBancario.add(valor);
        System.out.println("Debito de R$" + valor + " relizado com sucesso.");
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: %s%n%s: %.2f%n%s: %s", "Titular da Conta", getTitularConta(),
                "Numero da Conta", getNumeroConta(), "Saldo", getSaldo(), "Historico Bancario",
                getHistoricoBancario());
    }
}

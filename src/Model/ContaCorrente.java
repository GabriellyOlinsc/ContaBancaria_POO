package Model;

public class ContaCorrente extends Conta {

    private double valorMovimento;

    public ContaCorrente(String titularConta, String numeroConta, double saldo) {
        super(titularConta, numeroConta, saldo);
    }
    
    public ContaCorrente(String titularConta, String numeroConta, double saldo, double valorMovimento) {
        super(titularConta, numeroConta, saldo);
        if (valorMovimento < 0.0) {
            throw new IllegalArgumentException("O valor cobrado pela movimentacao deve ser MAIOR ou IGUAL a 0.0. ");
        }
        this.valorMovimento = valorMovimento;
    }

    @Override
    public void creditoConta(double valor) {
        double descont;
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor de credito deve ser MAIOR que zero.");
        }
        descont = valor - this.getValorMovimento();

        if (descont < 0) { // verificando se o saldo vai ser suficiente para colocar o credito na conta.
            throw new IllegalArgumentException("ERRO. Saldo insuficiente. Credito nao realizado.");
        }
        super.creditoConta(descont); // mandando o valor descontado do credito para o super para conseguir usar no histórico.
        System.out.println("Credito de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void debitoConta(double valor) {
        double descont;
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor de debito deve ser MAIOR que zero.");
        }
        descont = valor - this.getValorMovimento();

        if (descont < 0) {
            throw new IllegalArgumentException("ERRO. Saldo insuficiente. Debito nao realizado.");
        }
        super.debitoConta(descont);
        System.out.println("Debito de R$" + valor + " realizado com sucesso.");
    }

    public double getValorMovimento() {
        return valorMovimento;
    }

    public void setValorMovimento(double valorMovimento) {
        if (valorMovimento < 0.0) {
            throw new IllegalArgumentException("ERRO. O valor cobrado pela movimentacao deve ser MAIOR ou IGUAL a 0.0. ");
        }
        this.valorMovimento = valorMovimento;
    }

}
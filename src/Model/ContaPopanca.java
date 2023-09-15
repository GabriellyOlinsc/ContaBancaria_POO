package Model;

public class ContaPopanca extends Conta {

    private double taxaRendimento;

    public ContaPopanca(String titularConta, String numeroConta, double saldo, double taxaRendimento) {
        super(titularConta, numeroConta, saldo);
        if (taxaRendimento < 0.0) {
            throw new IllegalArgumentException("ERRO. Taxa deve ser MAIOR que 0.0.");
        }
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        if (taxaRendimento < 0.0) {
            throw new IllegalArgumentException("ERRO. Taxa deve ser MAIOR que 0.0.");
        }
        this.taxaRendimento = taxaRendimento;
    }

    public void atualizaSaldoRendimento(double taxa) {
        if (taxa < 0){
            throw new IllegalArgumentException("ERRO. A taxa de rendimento nao deve ser negativa.");
        }
        double rend = this.getSaldo() + this.getSaldo() * (taxa/100);
        super.setSaldo(rend);
        System.out.println("Saldo com rendimento de R$" + rend + " atualizado com sucesso.");
    }
    @Override
    public void creditoConta(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor de credito deve ser MAIOR que zero.");
        }
        super.creditoConta(valor);
    }

    @Override
    public void debitoConta(double valor) {
        System.out.println("A Operação de debito não e permitida em uma conta poupança.");
    }

    @Override
    public String toString() {
        return String.format("%s: %n%s%n%s %s", "Conta Popanca", super.toString(), "Taxa Rendimento: ", getTaxaRendimento());
    }
}

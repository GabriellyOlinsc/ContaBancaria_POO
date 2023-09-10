import java.util.ArrayList;

public class ContaPopanca extends Conta{
    private double taxaRendimento;
    public ContaPopanca(String titularConta,String numeroConta, double saldo, ArrayList<String> historicoBancario,double taxaRendimento){
        super(titularConta,numeroConta,saldo,historicoBancario);
        if(taxaRendimento < 0.0 || taxaRendimento > 1.0)
            throw new IllegalArgumentException("Taxa must be > 0.0 ");
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        if(taxaRendimento < 0.0 || taxaRendimento >1.0)
            throw new IllegalArgumentException("Taxa must be > 0.0 ");
        this.taxaRendimento = taxaRendimento;
    }

    //setSaldoRendimento metodo aqui
}

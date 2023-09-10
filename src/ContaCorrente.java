import java.util.ArrayList;

public class ContaCorrente extends Conta{
    private double valorMovimento ;
    public ContaCorrente(String titularConta,String numeroConta, double saldo, ArrayList<String> historicoBancario,double valorMovimento){
        super(titularConta,numeroConta,saldo,historicoBancario);
        if(valorMovimento<0.0)
            throw new IllegalArgumentException("O valor cobrado pela movimentacao deve ser >= 0.0 ");
        this.valorMovimento = valorMovimento;
    }
}

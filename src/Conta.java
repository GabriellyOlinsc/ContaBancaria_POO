import java.util.ArrayList;

public abstract  class Conta {
    private String titularConta;
    private String numeroConta;
    private double saldo;
    private ArrayList<String> historicoBancario;
    public Conta(String titularConta,String numeroConta, double saldo, ArrayList<String> historicoBancario){
        this.titularConta=titularConta;
        this.numeroConta=numeroConta;
        this.saldo = saldo;
        this.historicoBancario = historicoBancario;
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
    public ArrayList<String> getHistoricoBancario() {
        return historicoBancario;
    }
    public void setHistoricoBancario(ArrayList<String> historicoBancario) {
        this.historicoBancario = historicoBancario;
    }
    public void setCredito(){

    }
    @Override
    public String toString() {
        return "Conta{" +
                "titularConta='" + titularConta + '\'' +
                ", numeroConta='" + numeroConta + '\'' +
                ", saldo=" + saldo +
                ", historicoBancario=" + historicoBancario +
                '}';
    }
}

public abstract class Conta {
    private int numero;
    private String cliente;
    private double saldo = 0;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public String getNome() {
        return cliente;
    }

    public void setSaldo(double valor) {
        this.saldo = valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        this.setSaldo(valor);
    }

    public void transferir(double valor, Conta destino) {
        if (this.sacar(valor)) {
            double novoSaldo = valor + destino.getSaldo();
            destino.setSaldo(novoSaldo);
        } else {
            System.out.println("Saldo Insuficiente!");
        }
    }

    public abstract boolean sacar(double valor);
}

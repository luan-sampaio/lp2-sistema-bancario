public abstract class Conta {
    private int numero;
    private String cliente;
    private double saldo;

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

    public abstract void depositar(double valor);
    public abstract void sacar(int numero, double valor);
    public abstract void transferir();
}

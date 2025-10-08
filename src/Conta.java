public abstract class Conta {
    int numero;
    String cliente;
    double saldo;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public abstract void depositar(double valor);
    public abstract void sacar(int numero, double valor);
    public abstract void transferir();
}

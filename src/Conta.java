public abstract class Conta {
    int numero;
    String cliente;
    double saldo;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

    public abstract void depositar();
    public abstract void sacar();
    public abstract void transferir();
}

public class ContaPoupanca extends Conta{
    public ContaPoupanca(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public void depositar(double valor) {
        this.saldo = valor;
    }

    @Override
    public void sacar(int numero, double valor) {

    }

    @Override
    public void transferir() {

    }
}

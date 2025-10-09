public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, String nome) {
        super(numero, nome);
    }
    @Override
    public void depositar(double valor) {
        this.setSaldo(valor);
    }

    @Override
    public void sacar(int numero, double valor) {
        //Conta operacao =
    }

    @Override
    public void transferir() {

    }
}

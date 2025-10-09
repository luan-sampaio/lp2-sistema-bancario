public class ContaPoupanca extends Conta{
    public ContaPoupanca(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public void sacar(double valor) {
        if (valor  > this.getSaldo()) {
            System.out.println("Saldo Insuficiente!");
        } else {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
        }
    }

    @Override
    public void transferir() {

    }
}

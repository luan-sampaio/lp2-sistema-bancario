public class ContaPoupanca extends Conta{
    public ContaPoupanca(int numero, String cliente) {
        super(numero, cliente);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor  > this.getSaldo()) {
            return false;
        } else {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
            return true;
        }
    }

}

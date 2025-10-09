public class ContaCorrente extends Conta{
    public ContaCorrente(int numero, String nome) {
        super(numero, nome);
    }

    @Override
    public void sacar(double valor) {
        valor += valor * 0.05;
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

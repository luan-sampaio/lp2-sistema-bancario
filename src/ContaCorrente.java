public class ContaCorrente extends Conta implements ITributavel {
    public ContaCorrente(int numero, String nome) {
        super(numero, nome);
    }

    @Override
    public boolean sacar(double valor) {
        valor += valor * 0.05;
        if (valor  > this.getSaldo()) {
            return false;
        } else {
            double novoSaldo = this.getSaldo() - valor;
            this.setSaldo(novoSaldo);
            return true;
        }
    }

    @Override
     public double calcularTributos() {
        return this.getSaldo() * 0.01;
    }

}

public class InterfaceBanco {
    public InterfaceBanco () {}

    public void imprimirInicial() {
        System.out.println("===========================================");
        System.out.println("    Bem vindo ao Banco L.V Sampaio");
        System.out.println("===========================================");
    }

    public void imprimirMenu() {
        System.out.println();
        System.out.println("Operações disponíveis:");
        System.out.println("1 - Criar Conta ");
        System.out.println("2 - Realizar Depósito");
        System.out.println("3 - Realizar Saque");
        System.out.println("4 - Realizar Transferência");
        System.out.println("5 - Listar Contas");
        System.out.println("6 - Calcular Total de Tributos");
        System.out.println("7 - Sair");
        System.out.println();
        System.out.print("Digite o numero da operação desejada: ");
    }

    public void imprimirSaida() {
        System.out.println("\n========================================");
        System.out.println("Encerrando o sistema. Obrigado por utilizar o Banco L.V Sampaio!");
        System.out.println("Volte sempre!");
        System.out.println("========================================\n");
    }

    public void imprimirComprovante(String tipoConta, String nome, int id) {
        System.out.println("\n========================================");
        System.out.println("Conta " + tipoConta + " criada com sucesso!");
        System.out.println("Nome: " + nome);
        System.out.println("Número de conta: " + ++id);
        System.out.println("========================================\n");
    }

    public void imprimirCriarConta() {
        System.out.println("\nEscolha a conta ser criada: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Digite o numero da operação desejada: ");
    }

    public void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

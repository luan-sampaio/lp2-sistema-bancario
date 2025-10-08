public class Main {
    public static void main(String[] args) {
        imprimirMenu();
    }

    public static void imprimirMenu() {
        System.out.println("===========================================");
        System.out.println("    Bem vindo ao Banco L.V Sampaio");
        System.out.println("===========================================");
        System.out.println();
        System.out.println("Operações disponíveis:");
        System.out.println("1 - Criar Conta; ");
        System.out.println("2 - Realizar Depósito;");
        System.out.println("3 - Realizar Saque;");
        System.out.println("4 - Realizar Transferência;");
        System.out.println("5 - Listar Contas;");
        System.out.println("6 - Calcular Total de Tributos;");
        System.out.println("7 - Sair;");
        System.out.println();
        System.out.print("Digite o numero da operação desejada: ");
    }
}

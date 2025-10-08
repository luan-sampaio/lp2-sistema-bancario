import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        imprimirInicial();

        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            imprimirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Implementar");
                    break;
                case 2:
                    System.out.println("Implementar");
                    break;
                case 3:
                    System.out.println("Implementar");
                    break;
                case 4:
                    System.out.println("Implementar");
                    break;
                case 5:
                    System.out.println("Implementar");
                    break;
                case 6:
                    System.out.println("Implementar");
                    break;
                case 7:
                    imprimirSaida();
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente.");
            }
        }
        scanner.close();
    }

    public static void imprimirInicial() {
        System.out.println("===========================================");
        System.out.println("    Bem vindo ao Banco L.V Sampaio");
        System.out.println("===========================================");
    }

    public static void imprimirMenu() {
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

    public static void imprimirSaida() {
        System.out.println("\n========================================");
        System.out.println("Operação finalizada!");
        System.out.println("Volte sempre!");
        System.out.println("========================================\n");
    }
}

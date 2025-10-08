import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.ArrayList;

// TODO: Transformar o try e catch em função para reaproveitar

public class Main {
    public static void main(String[] args) {
        ArrayList<Conta> listaDeConta = new ArrayList<Conta>();
        int numeroDeConta = 0;

        imprimirInicial();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            imprimirMenu();

            int opcao = -1;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nOpção inválida! Digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    criarConta(numeroDeConta, listaDeConta);
                    ++numeroDeConta;
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
                    listarContas(listaDeConta);
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

    public static void imprimirSaida() {
        System.out.println("\n========================================");
        System.out.println("Encerrando o sistema. Obrigado por utilizar o Banco L.V Sampaio!");
        System.out.println("Volte sempre!");
        System.out.println("========================================\n");
    }

    public static void criarConta(int numero, ArrayList<Conta> lista) {
        System.out.print("Insira o nome do cliente: ");

        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();

        System.out.println("\nEscolha a conta ser criada: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Digite o numero da operação desejada: ");

        int operacao = scanner.nextInt();

        switch (operacao) {
            case 1:
                ContaCorrente corrente = new ContaCorrente(numero, nome);
                lista.add(corrente);
                break;
            case 2:
                ContaPoupanca poupanca = new ContaPoupanca(numero, nome);
                lista.add(poupanca);
                break;
            default:
                System.out.println("Operação inválida! Opção inexistente.");
                break;
        }
    }

    public static void listarContas(ArrayList<Conta> lista) {
        for (Conta conta : lista) {
            System.out.println(conta.cliente);
        }
    }


}

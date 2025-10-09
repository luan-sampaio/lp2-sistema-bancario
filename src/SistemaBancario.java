// TODO: Transformar o try e catch em função para reaproveitar
// TODO: GERAR RECIBO DAS CONTAS CRIADAS!

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBancario {
    public SistemaBancario () {}

    public void executar() {
        ArrayList<Conta> listaDeConta = new ArrayList<Conta>();
        int numeroDeConta = 0;

        InterfaceBanco interfaceBanco = new InterfaceBanco();
        Scanner scanner = new Scanner(System.in);
        interfaceBanco.imprimirInicial();

        boolean executando = true;
        while (executando) {
            interfaceBanco.imprimirMenu();

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
                    criarConta(numeroDeConta, listaDeConta, scanner);
                    ++numeroDeConta;
                    break;
                case 2:
                    depositar(listaDeConta, scanner);
                    break;
                case 3:
                    System.out.println("Realizar saque!");
                    break;
                case 4:
                    System.out.println("Realizar Transferência");
                    break;
                case 5:
                    listarContas(listaDeConta);
                    break;
                case 6:
                    System.out.println("Calcular Total de Tributos");
                    break;
                case 7:
                    interfaceBanco.imprimirSaida();
                    //imprimirSaida();
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente.");
            }
        }
        scanner.close();
    }

    private void criarConta(int numero, ArrayList<Conta> lista, Scanner scanner) {
        System.out.print("Insira o nome do cliente: ");

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

    private static void imprimirConta() {
        System.out.println("\n========================================");
        System.out.println("Conta ");
        System.out.println("========================================");
        System.out.println("Pedido N°: ");
        System.out.println("Cliente: " );
        System.out.println("----------------------------------------");
        System.out.println("Itens:");

        // O valor total deve ser calculado
        System.out.println("Total: R$ ");
        System.out.println("========================================");
    }

    private void depositar(ArrayList<Conta> lista, Scanner scanner) {
        System.out.print("Insira o número da conta: ");
        int numero = scanner.nextInt();
        //--numero;
        Conta operacao = lista.get(numero);

        System.out.print("Insira o valor a ser depositado: ");
        double valor = scanner.nextDouble();
        operacao.depositar(valor);
    }

    private static void listarContas(ArrayList<Conta> lista) {
        for (Conta conta : lista) {
            System.out.println(conta.cliente);
        }
    }
}


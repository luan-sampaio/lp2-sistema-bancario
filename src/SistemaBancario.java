// TODO: Transformar o try e catch em função para reaproveitar
// TODO: GERAR RECIBO DAS CONTAS CRIADAS!
// TODO: CRIAR UMA FUNÇÃO DE APETAR ESPAÇO PARA avançar 
// todo: um enter para depois de escolher a opção seria válido em, para não ir avulso

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SistemaBancario {
    public SistemaBancario () {}

    public void executar() {
        ArrayList<Conta> listaDeConta = new ArrayList<>();
        int numeroDeConta = 0;

        InterfaceBanco interfaceBanco = new InterfaceBanco();
        Scanner scanner = new Scanner(System.in);

        interfaceBanco.imprimirInicial();

        boolean executando = true;
        while (executando) {
            interfaceBanco.imprimirMenu();

            int opcao = testarInput(scanner);
            switch (opcao) {
                case 1:
                    criarConta(numeroDeConta, listaDeConta, scanner, interfaceBanco);
                    ++numeroDeConta;
                    break;
                case 2:
                    depositar(listaDeConta, scanner, interfaceBanco);
                    break;
                case 3:
                    saque(listaDeConta, scanner, interfaceBanco);
                    break;
                case 4:
                    transferencia(listaDeConta, scanner, interfaceBanco);
                    break;
                case 5:
                    listarContas(listaDeConta);
                    break;
                case 6:
                    calcularTotalDeTributos(listaDeConta);
                    break;
                case 7:
                    interfaceBanco.imprimirSaida();
                    executando = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Escolha novamente.\n");
            }
        }
        scanner.close();
    }

    private int testarInput(Scanner scanner) {
        int opcao = 0;
        try {
            opcao = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
        }

        return opcao;
    }

    private void criarConta(int numero, ArrayList<Conta> lista, Scanner scanner, InterfaceBanco outup) {
        System.out.print("\nInsira o nome do cliente: ");
        String nome = scanner.next();

        outup.imprimirCriarConta();
        int operacao = testarInput(scanner);

        switch (operacao) {
            case 1:
                ContaCorrente corrente = new ContaCorrente(numero, nome);
                lista.add(corrente);
                outup.imprimirComprovante("Corrente", nome, numero);
                break;
            case 2:
                ContaPoupanca poupanca = new ContaPoupanca(numero, nome);
                lista.add(poupanca);
                outup.imprimirComprovante("Poupança", nome, numero);
                break;
            default:
                System.out.println("\nOperação inválida! Reinice o processo!\n");
                break;
        }
    }

    private void depositar(ArrayList<Conta> lista, Scanner scanner, InterfaceBanco outup) {
        System.out.print("\nInsira o número da conta: ");
        int numero = scanner.nextInt();
        --numero;

        Conta operacao = lista.get(numero);

        System.out.print("\nInsira o valor a ser depositado: ");
        double valor = scanner.nextDouble();
        operacao.depositar(valor);
        outup.comprovanteDeposito(valor, ++numero);
    }

    private void listarContas(ArrayList<Conta> lista) {
        for (Conta conta : lista) {
            System.out.println("\n========================================");
            System.out.println("Conta N°: " + (conta.getId() + 1));
            System.out.println("Cliente: " + conta.getNome());
            System.out.println("Saldo: " + conta.getSaldo());
            if (conta instanceof ContaCorrente) {
                System.out.println("Tipo de conta: Corrente");
            } else {
                System.out.println("Tipo de conta: Poupança");
            }
            System.out.println("========================================\n");
        }
    }

    private void saque(ArrayList<Conta> lista, Scanner scanner, InterfaceBanco output) {
        System.out.print("\nInsira o número da conta: ");
        int numero = scanner.nextInt();
        --numero;
        Conta operacao = lista.get(numero);
        System.out.print("Insira o valor a ser sacado: ");
        double valor = scanner.nextDouble();

        boolean realizarSaque = operacao.sacar(valor);
        output.comprovanteSaque(valor, realizarSaque, numero);
    }

    private void transferencia(ArrayList<Conta> lista, Scanner scanner, InterfaceBanco output) {
        System.out.print("\nInsira o número da conta de origem: ");
        int idContaOrigem = scanner.nextInt();
        --idContaOrigem;
        System.out.print("\nInsira o número da conta de destino: ");
        int idContaDestino = scanner.nextInt();
        --idContaDestino;
        System.out.print("\nInsira o valor de transferência: ");
        double valorTransferencia = scanner.nextDouble();


        Conta contaOrigem = lista.get(idContaOrigem);
        Conta contaDestino = lista.get(idContaDestino);

        contaOrigem.transferir(valorTransferencia, contaDestino);
        output.comprovanteTransferencia(idContaOrigem, idContaDestino, valorTransferencia);
    }

    private void calcularTotalDeTributos(ArrayList<Conta> lista) {
        double tributosTotal = 0;
        for (Conta conta : lista) {
            if (conta instanceof ITributavel) {
                ITributavel contaTributavel = (ITributavel) conta;
                tributosTotal += contaTributavel.calcularTributos();
            }
        }

        System.out.println("\n========================================");
        System.out.println("Total de tributos a recolher: R$ " + tributosTotal);
        System.out.println("========================================");

    }
}


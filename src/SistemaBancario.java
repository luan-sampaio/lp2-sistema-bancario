// TODO: Transformar o try e catch em função para reaproveitar
// TODO: GERAR RECIBO DAS CONTAS CRIADAS!

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

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nOpção inválida! Digite um número.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    interfaceBanco.limparTela();
                    criarConta(numeroDeConta, listaDeConta, scanner, interfaceBanco);
                    ++numeroDeConta;
                    break;
                case 2:
                    depositar(listaDeConta, scanner);
                    break;
                case 3:
                    saque(listaDeConta, scanner);
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
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida! Escolha novamente.");
            }
        }
        scanner.close();
    }

    private void criarConta(int numero, ArrayList<Conta> lista, Scanner scanner, InterfaceBanco outup) {
        System.out.print("\nInsira o nome do cliente: ");
        String nome = scanner.next();

        outup.imprimirCriarConta();
        int operacao = scanner.nextInt();

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
                System.out.println("Operação inválida! Opção inexistente.");
                break;
        }
    }

    private void depositar(ArrayList<Conta> lista, Scanner scanner) {
        System.out.print("Insira o número da conta: ");
        // TODO: AQUI NO CASO DE DIGITAR OUTRA COISA QUE NÃO NÚMERO
        int numero = scanner.nextInt();
        --numero;
        // TODO: PRECISO DE UM TRY CATCH AQUI TAMBÉM
        Conta operacao = lista.get(numero);

        System.out.print("Insira o valor a ser depositado: ");
        double valor = scanner.nextDouble();
        operacao.depositar(valor);
        // TODO: FAZER UMA MENSAGEM DE SUCESSO!
        System.out.println("Valor da conta: " + lista.get(numero).getSaldo());
    }

    private void listarContas(ArrayList<Conta> lista) {
        for (Conta conta : lista) {
            System.out.println(conta.getNome());
            System.out.println(conta.getSaldo());
        }
    }

    private void saque(ArrayList<Conta> lista, Scanner scanner) {
        System.out.print("Insira o número da conta: ");
        // TODO: AQUI NO CASO DE DIGITAR OUTRA COISA QUE NÃO NÚMERO
        int numero = scanner.nextInt();
        --numero;
        // TODO: PRECISO DE UM TRY CATCH AQUI TAMBÉM
        Conta operacao = lista.get(numero);
        System.out.print("Insira o valor a ser sacado: ");
        double valor = scanner.nextDouble();
        operacao.sacar(valor);
        // TODO: MENSAGEM DE SAQUE
    }

}


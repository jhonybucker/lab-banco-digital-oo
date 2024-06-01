import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.setNome("Banco Digital");

        Cliente cliente = new Cliente();
        cliente.setNome("Jhony Bucker");
        banco.adicionarCliente(cliente);

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("=== Banco Digital ===");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Imprimir Extrato");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar: ");
                    double valorDeposito = scanner.nextDouble();
                    cc.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.print("Valor para sacar: ");
                    double valorSaque = scanner.nextDouble();
                    cc.sacar(valorSaque);
                    break;
                case 3:
                    System.out.print("Valor para transferir: ");
                    double valorTransferencia = scanner.nextDouble();
                    cc.transferir(valorTransferencia, poupanca);
                    break;
                case 4:
                    cc.imprimirExtrato();
                    poupanca.imprimirExtrato();
                    cc.imprimirHistorico();
                    poupanca.imprimirHistorico();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }
}

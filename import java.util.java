import java.util.Scanner;

class Conta {
    private int numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;

    // Construtor
    public Conta(int numero, String agencia, String nomeCliente, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    // Método para exibir informações da conta
    public void exibirInformacoes() {
        System.out.println("Número da Conta: " + numero);
        System.out.println("Agência: " + agencia);
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Saldo: R$" + saldo);
    }

    // Método para realizar um depósito
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    // Método para realizar um saque
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor de saque inválido.");
        }
    }
}

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao ContaBanco!");

        System.out.print("Número da Conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();  // Limpar a quebra de linha

        System.out.print("Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Saldo: ");
        double saldo = scanner.nextDouble();

        // Criar uma instância de Conta com os dados fornecidos
        Conta conta = new Conta(numero, agencia, nomeCliente, saldo);

        // Exibir informações da conta
        conta.exibirInformacoes();

        // Realizar operações na conta
        System.out.print("Deseja fazer um depósito (S/N)? ");
        char opcao = scanner.next().charAt(0);
        if (opcao == 'S' || opcao == 's') {
            System.out.print("Valor do depósito: ");
            double valorDeposito = scanner.nextDouble();
            conta.depositar(valorDeposito);
        }

        System.out.print("Deseja fazer um saque (S/N)? ");
        opcao = scanner.next().charAt(0);
        if (opcao == 'S' || opcao == 's') {
            System.out.print("Valor do saque: ");
            double valorSaque = scanner.nextDouble();
            conta.sacar(valorSaque);
        }

        // Exibir informações atualizadas da conta
        conta.exibirInformacoes();

        scanner.close();
    }
}

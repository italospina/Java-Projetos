import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContaBanco contabanco = new ContaBanco();

        System.out.println("Digite seu nome:");
        contabanco.nomeCliente = scanner.nextLine();
        
        System.out.println("Digite sua agencia: (formato XXX-X)");
        contabanco.setAgencia(scanner.nextLine());
        

        System.out.println("Digite se numero de conta: ");
        contabanco.numeroConta =  Integer.parseInt(scanner.nextLine());

        // Exibir informações no final
        contabanco.exibirDados();
        
    }
}

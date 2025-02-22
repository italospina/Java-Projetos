package candidaturas;

import java.util.Scanner;

public class ProcessoSeletivoCase1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double salarioBase = 2000;
        double salarioPretendido = 0;

        System.out.println("Processo Seletivo");

        System.out.println("Digite o salario pretendido: ");
        salarioPretendido = scanner.nextDouble();
        analisarCandidato(salarioBase, salarioPretendido);
    }

    static void analisarCandidato(double salarioBase, double salarioPretendido) {
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o funcionário");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar contra proposta");
        } else {
            System.out.println("Aguardando mais candidatos para analise");
        }
    }
    


}

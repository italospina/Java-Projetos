import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista para armazenar os candidatos selecionados durante o processo
        List<String> candidatosSelecionados = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n");
            System.out.println("-------------------------------------");
            System.out.println("---------Processo Seletivo-----------");
            System.out.println("-------------------------------------");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Selecionar candidatos");
            System.out.println("2 - Imprimir candidatos selecionados");
            System.out.println("3 - Entrar em contato com os candidatos");
            System.out.println("4 - Sair");
    
            System.out.print("Digite a opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    limparTela();
                    // Chama o método de seleção e armazena os candidatos selecionados
                    candidatosSelecionados = selecaoCandidato();

                    break;
                case 2:
                    limparTela();
                    imprimirCandidatos(candidatosSelecionados);
                    break;
                case 3:
                    limparTela();
                    for (String candidato : candidatosSelecionados) {
                        System.out.println("-------------------------------------");
                        ligarCandidato(candidato);
                        System.out.println("-------------------------------------");
                    }
                    break;

                case 4:
                    fecharAplicacao();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 3);
         
    }
    
    static List<String> selecaoCandidato() {
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula", "Lucas", "Luana"};

        List<String> selecionados = new ArrayList<>(); // Lista para armazenar os selecionados
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("\n");
            System.out.println("------------------------------------ " );
            System.out.println("Candidato: " + candidato);
            System.out.println("Salario pretendido: " + salarioPretendido);

            if (salarioBase > salarioPretendido) {
                System.out.println("Candidato " + candidato + " foi selecionado");
                selecionados.add(candidato); // Adiciona à lista de selecionados
                System.out.println("Candidato salvo na lista de selecionados");
                candidatosSelecionados++;
            } else if (salarioBase == salarioPretendido) {
                System.out.println("Candidato " + candidato + " precisa de contraproposta");
                candidatosSelecionados++;
            } else {
                System.out.println("Aguardando mais candidatos para analise");
                
            }
            candidatoAtual++;

        }
        return selecionados; // Retorna a lista de selecionados
    }
    static double valorPretendido (){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void imprimirCandidatos(List<String> selecionados) {

        int indice = 1;
        System.out.println("------------------------------------ " );
        System.out.println("\n" +
        "Lista de Candidatos Selecionados:");

        for (String candidato : selecionados) {
            System.out.println("candidato" + indice + ": " + candidato);
            indice++;
        }
        System.out.println("------------------------------------ " );

    }

    static void ligarCandidato(String candidato) {

        int tentativasRealizadas = 1;
        boolean continuarLigando = true;
        boolean atendeu = false;

        do {
            System.out.println("Tentativa de ligação " + tentativasRealizadas + " para o candidato " + candidato);
            atendeu = atender();
            continuarLigando = !atendeu;

            if (continuarLigando) {
                System.out.println("Candidato " + candidato + " não atendeu a ligação, tentando novamente");
                tentativasRealizadas++;
            } else {
                System.out.println("Candidato " + candidato + " atendeu a ligação com sucesso");
            }
        } while (continuarLigando && tentativasRealizadas <= 3);

        if (atendeu) {
            System.out.println("Contato realizado com " + candidato + " na tentativa numero " + tentativasRealizadas);
        } else {
            System.out.println("Candidato " + candidato + " não atendeu a ligação em 3 tentativas");
        }

    }

    static boolean atender(){
        return new Random().nextInt(3)==1;

    }

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void fecharAplicacao() {
        System.out.println("Encerrando o programa...");
        System.exit(0);
    }

}

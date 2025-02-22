package candidaturas;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivoCase2 {
    public static void main(String[] args) {

        System.out.println("Processo Seletivo");

        selecaoCandidato();
    }
    
    static void selecaoCandidato(){
        String [] candidatos = {"João", "Maria", "José", "Ana", "Carlos", "Mariana", "Pedro", "Paula", "Lucas", "Luana"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("------------------------------------ " );
            System.out.println("Candidato: " + candidato);
            System.out.println("Salario pretendido: " + salarioPretendido);

            if (salarioBase > salarioPretendido) {
                System.out.println("Candidato " + candidato + " foi selecionado");
                candidatosSelecionados++;
            } else if (salarioBase == salarioPretendido) {
                System.out.println("Candidato " + candidato + " precisa de contraproposta");
                candidatosSelecionados++;
            } else {
                System.out.println("Aguardando mais candidatos para analise");
                
            }
            candidatoAtual++;

        }
    }
    static double valorPretendido (){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

}

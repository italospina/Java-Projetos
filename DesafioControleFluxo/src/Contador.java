import java.util.Scanner;

public class Contador {

    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ParametrosInvalidosException parametrosInvalidosException = new ParametrosInvalidosException();
        System.out.println("--------------------Contador--------------------");
        System.out.print("Digite o primeiro número: ");
        int primeiroNumero = scanner.nextInt();

        System.out.print("Digite o segundo número: ");
        int segundoNumero = scanner.nextInt();


        try{
            analisarParametros(primeiroNumero, segundoNumero);
        } catch (ParametrosInvalidosException e){
            System.out.println("-------------------------------" + "\n" + e + ": " +
            "\n" + "O segundo parâmetro deve ser maior que o primeiro" + "\n" + "-------------------------------" );
        }
        
    }   
    
    static int analisarParametros(int primeiroNumero, int segundoNumero) throws ParametrosInvalidosException{
        if(primeiroNumero > segundoNumero){
            throw new ParametrosInvalidosException();
        }
        else{
            for (int i = primeiroNumero; i <= segundoNumero; i++){
                System.out.println("Imprimindo o número " + i);
            }
        }
                return segundoNumero;
    }
}

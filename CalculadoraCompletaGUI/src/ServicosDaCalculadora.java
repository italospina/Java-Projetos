/*
 * =============================
 * SERVIÇO DE CÁLCULO
 * =============================
 * 1.1.25 - Realiza operação matemática entre dois números
 */
public class ServicosDaCalculadora {
    public double calcular(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a-b;
            case "*" -> a*b;
            case "/" -> b != 0 ? a / b : 0; // Evita divisão por zero
            case "%" -> a * b / 100;
            default -> 0;
        };
    }
}

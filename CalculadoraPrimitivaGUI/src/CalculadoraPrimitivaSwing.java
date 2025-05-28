import javax.swing.*;
import java.awt.*;

public class CalculadoraPrimitivaSwing extends JFrame{

    private JTextField campo1, campo2, resultado;
    private JButton somar, subtrair, dividir, multiplicar;

    public CalculadoraPrimitivaSwing(){
        setTitle("Calculadora Primitiva");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 2));

        campo1 = new JTextField();
        campo2 = new JTextField();
        resultado = new JTextField();
        resultado.setEditable(false);

        somar = new JButton("+");
        subtrair = new JButton("-");
        dividir = new JButton("/");
        multiplicar = new JButton("*");

        add(new JLabel("Campo 1:"));
        add(campo1);
        add(new JLabel("Campo 2:"));
        add(campo2);

        add(somar);
        add(subtrair);
        add(dividir);
        add(multiplicar);

        add(new JLabel("Resultado:"));
        add(resultado);

        somar.addActionListener(e ->calcular('+'));
        subtrair.addActionListener(e -> calcular('-')); 
        dividir.addActionListener(e -> calcular('/'));
        multiplicar.addActionListener(e -> calcular('*'));
    
        setVisible(true);
    }

    private void calcular(char operacao) {
        try {
            double n1 = Double.parseDouble(campo1.getText());
            double n2 = Double.parseDouble(campo2.getText());
            double res = 0;
            switch (operacao) {
                case '+':
                    res = n1 + n2;
                    break;
                case '-':
                    res = n1 - n2;
                    break;
                case '/':
                    if (n2 == 0) {
                        JOptionPane.showMessageDialog(this, "Divisão por zero não é permitida!", "Erro", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    res = n1 / n2;
                    break;
                case '*':
                    res = n1 * n2;
                    break;
            }
            resultado.setText(String.valueOf(res));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, insira números válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public static void main(String[] args){
        new CalculadoraPrimitivaSwing();
    }
}

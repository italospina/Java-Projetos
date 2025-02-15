import java.security.PublicKey;

public class ContaBanco {
    int numeroConta;
    String agencia;
    String nomeCliente;
    double saldo= 1526.33;

    public void exibirDados(){
        System.out.println("\n--- Dados da Conta ---");
        System.out.println("Olá, "+ nomeCliente + ". Obrigado por criar uma conta em nosso banco.\n" +
        "Sua agencia é: " + agencia + ", conta: " + numeroConta + ".\n"+
        "Seu saldo é: R$"+ String.format("%.2f",saldo));
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    //Valida o formato da agencia
    public void setAgencia(String agencia) {
        if (validarAgencia(agencia)) {
            this.agencia = agencia;
        } else {
            System.out.println("Formato inválido! Certifique-se de inserir no formato XXX-X.");
        }
    }
    //Valida o formato da agencia
    public boolean validarAgencia(String agencia){
        return agencia.matches("\\d{3}-\\d");
    }

    public String getAgencia(){
        return agencia;
    }

    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }

    public int getNumeroConta(){
        return numeroConta;
    }

    public double getSaldo(){
        return saldo;
    }

    




}

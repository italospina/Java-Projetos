public class Usuario {

    public static void main(String[] args) {

        //Fazendo a instanciação de um objeto
        SmartTv smartv = new SmartTv();

        // Aqui nos mostramos os valores definidos na classe Smartv
        System.out.println("TV está: " + smartv.estado);
        System.out.println("Canal atual:" + smartv.canal);
        System.out.println("Volume atual: " + smartv.volume);

        //alterando o estado da tv
        smartv.ligar();
        System.out.println("Agora a TV está: " + smartv.estado);

        //alterando o volume
        smartv.aumentarVolume();
        System.out.println("O volume da tv agora e: " + smartv.volume);

        //alterar o canal
        smartv.mudarCanal(10);
        System.out.println("O Canal atual e: " + smartv.canal);
    }
}

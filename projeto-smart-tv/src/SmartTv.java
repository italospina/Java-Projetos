public class SmartTv {
    
    boolean estado=false;
    int canal = 1;
    int volume = 15;
    
    public void ligar(){
        estado = true;
    }

    public void desligar(){
        estado = false;
    }

    public void aumentarVolume(){
        volume++;
    }

    public void diminuirVolume(){
        volume --;
    }

    public void mudarCanal(int novoCanal){
        canal = novoCanal;
    }

}

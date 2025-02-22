public class Movimiento {
    private Posicion posInicial;
    private Posicion posFinal;
    private boolean a;
    private int salto;

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }
    public boolean esVertical(){
        a=false;
        if (posInicial.getColumna() == posFinal.getColumna()){
            a=true;
        }
        return a;
    }
    public boolean esHorizontal(){
        a=false;
        if (posInicial.getFila() == posFinal.getFila()){
            a=true;
        }
        return a;
    }
    public int saltoHorizontal(){
        salto = Math.abs(posInicial.getColumna()-posFinal.getColumna());
        return salto;
    }
    public int saltoVertical(){
        salto = Math.abs(posInicial.getFila()-posFinal.getFila());
        return salto;
    }

    public boolean esDiagonal(){
        a=false;
        if (Math.abs(saltoHorizontal()) == Math.abs(saltoVertical())){
            a=true;
        }
        return a;
    }

    public Posicion getPosInicial() {
        return posInicial;
    }

    public Posicion getPosFinal() {
        return posFinal;
    }

}

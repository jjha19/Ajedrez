public class Peon extends Pieza{

    public Peon(boolean color){
        super(color);
        if(color == true){
            setNombre("\u265F");
        }else setNombre("\u2659");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        boolean direccionBien = false;
        boolean saltodoble = false;
        if(getColor()){
            if (mov.getPosInicial().getFila()>mov.getPosFinal().getFila()){
                direccionBien = true;
            }
        } else if (mov.getPosInicial().getFila()<mov.getPosFinal().getFila()) {
            direccionBien  = true;
        }
        if(getColor() && mov.getPosInicial().getFila() == 6){
            saltodoble = true;
        } else if (mov.getPosInicial().getFila() == 1){
            saltodoble = true;
        }

        if ((mov.saltoVertical()==1 || ( mov.saltoVertical()==2 && saltodoble) || (mov.esDiagonal() && (mov.saltoHorizontal() == 1 && mov.saltoVertical() == 1))) && direccionBien){
            valido = true;
        }
        return valido;
    }



}

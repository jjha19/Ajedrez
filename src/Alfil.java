public class Alfil extends Pieza {

    public Alfil( boolean color) {
        super(color);
        if(color == true) {
            setNombre("\u265D");
        }else setNombre("\u2657");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if (mov.esDiagonal()) valido = true;
        return valido;
    }


}
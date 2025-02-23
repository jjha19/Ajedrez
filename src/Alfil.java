public class Alfil extends Pieza {

    public Alfil( boolean color) {
        super(color);
        if(color) {
            setNombre("♝");
        }else setNombre("♗");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        return mov.esDiagonal();
    }


}
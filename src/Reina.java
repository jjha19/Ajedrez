public class Reina extends Pieza {

    public Reina(boolean color) {
        super(color);
        if(color) setNombre("♛");
        else setNombre("♕");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if (mov.esHorizontal() || mov.esVertical() || mov.esDiagonal()) {
            valido = true;
        }
        return valido;
    }


}

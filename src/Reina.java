public class Reina extends Pieza {

    public Reina(boolean color) {
        super(color);
        if(color == true) setNombre("\u265B");
        else setNombre("\u2655");
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

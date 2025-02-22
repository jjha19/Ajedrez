public class Rey  extends Pieza{
    public Rey(boolean color) {
        super(color);
        if(color == true) setNombre("\u265A");
        else setNombre("\u2654");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if(mov.saltoVertical() == 1 || mov.saltoHorizontal() == 1){
            valido = true;
        }
        return valido;
    }
}

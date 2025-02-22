public class Torre extends Pieza {

    public Torre(boolean color) {
        super(color);
        if(color==true){
            setNombre("\u265C");
        }
        else setNombre("\u2656");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if (mov.esHorizontal() || mov.esVertical()) {
            valido = true;
        }
        return valido;
    }
}

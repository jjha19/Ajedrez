public class Rey extends Pieza{
    boolean reyMovido = false;

    public Rey(boolean color) {
        super(color);
        if(color) setNombre("♚");
        else setNombre("♔");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if(mov.saltoVertical() == 1 || mov.saltoHorizontal() == 1){
            valido = true;
            reyMovido = true;
        }
        return valido;
    }

    public boolean getReyMovido() {
        return reyMovido;
    }
}

public class Caballo extends Pieza{
    public Caballo(boolean color){
        super(color);
        if(color == true){
           setNombre("\u265E");
        }else setNombre("\u2658");
    }

    @Override
    boolean validoMovimiento(Movimiento mov) {
        boolean valido = false;
        if ((mov.saltoVertical() == 2 && mov.saltoHorizontal() == 1) || (mov.saltoVertical() == 1 && mov.saltoHorizontal() == 2) ) {
            valido = true;
        }
        return valido;
    }


}

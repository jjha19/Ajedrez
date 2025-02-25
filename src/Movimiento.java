public class Movimiento {
    private Posicion posInicial;
    private Posicion posFinal;
    private boolean a;
    private int salto;
    private Tablero tablero;

    public Movimiento(Posicion posInicial, Posicion posFinal) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
    }

    // Necesito una sobrecarga de constructores que incluyan tablero para poder hacer que el peon coma solo si hay una pieza "a tiro"
    public Movimiento(Posicion posInicial, Posicion posFinal, Tablero tablero) {
        this.posInicial = posInicial;
        this.posFinal = posFinal;
        this.tablero = tablero;
    }

    public Movimiento(Posicion posInicial, int fila, int columna, Tablero tablero) {
        this.posInicial = posInicial;
        this.posFinal = new Posicion(fila, columna);
        this.tablero = tablero;
    }

    public Movimiento(int fila, int columna, Posicion posFinal, Tablero tablero) {
        this.posInicial = new Posicion(fila, columna);
        this.posFinal = posFinal;
        this.tablero = tablero;
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

    public Tablero getTablero() {
        return tablero;
    }

    public void setPosInicial(Posicion posInicial) {
        this.posInicial = posInicial;
    }
    public void setPosFinal(Posicion posFinal) {
        this.posFinal = posFinal;
    }
    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

}

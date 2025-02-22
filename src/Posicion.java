public class Posicion {
    private int fila;
    private int columna;
    public Posicion(){
    }
    public Posicion(int fila, int columna){
        this.fila = fila;
        this.columna = columna;
    }
    public void setFila(int fila){
        this.fila = fila;
    }
    public void setColumna(int columna){
        this.columna = columna;
    }
    public int getFila(){
        return this.fila;
    }
    public int getColumna(){
        return this.columna;
    }
    public String toString(){
        return "Posicion: Fila: " + this.fila + ", Columna: " + this.columna;
    }

}

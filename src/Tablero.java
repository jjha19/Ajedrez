public class Tablero {
    Pieza tablero[][] = new Pieza[8][8];

    public Tablero() {
        tablero[0][0] = new Torre(false);
        tablero[0][1] = new Caballo(false);
        tablero[0][2] = new Alfil(false);
        tablero[0][3] = new Reina(false);
        tablero[0][4] = new Rey(false);
        tablero[0][5] = new Alfil(false);
        tablero[0][6] = new Caballo(false);
        tablero[0][7] = new Torre(false);
        for (int i = 0; i < 8; i++) {
            tablero [1][i] = new Peon(false);
        }

        for (int i = 0; i < 8; i++) {
            tablero [6][i] = new Peon(true);
        }
        tablero[7][0] = new Torre(true);
        tablero[7][1] = new Caballo(true);
        tablero[7][2] = new Alfil(true);
        tablero[7][3] = new Rey(true);
        tablero[7][4] = new Reina(true);
        tablero[7][5] = new Alfil(true);
        tablero[7][6] = new Caballo(true);
        tablero[7][7] = new Torre(true);
    }


    public void pintarTablero(){
        int numero = 1;

        for (char letra = 'A'; letra < 73; letra++) {
            System.out.print("  " + letra);
        }
        System.out.println();
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((numero + i) + "  ");
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] != null) {
                    System.out.print(tablero[i][j].toString() + " ");
                } else System.out.print("\u3000 ");
            }
            System.out.print((numero + i));
            System.out.println();
        }
        for (char letra = 'A'; letra < 73; letra++) {
            System.out.print("  " + letra);
        }
        System.out.println();

    }

    public boolean hayPieza(int fila, int columna){
        boolean haypieza = false;
        if (tablero[fila][columna] != null) {
            haypieza = true;
        }
        return haypieza;
    }

    public boolean hayPieza(Posicion posicion){
        boolean haypieza = false;
        if (tablero[posicion.getFila()][posicion.getColumna()] != null) {
            haypieza = true;
        }
        return haypieza;
    }


    public void ponPieza (Pieza pieza, int fila, int columna){
        tablero[fila][columna] = pieza;
    }

    public void ponPieza (Pieza pieza, Posicion posicion){
        tablero[posicion.getFila()][posicion.getColumna()] = pieza;
    }

    public void quitaPieza(int fila, int columna){
        tablero[fila][columna] = null;
    }

    public void quitaPieza(Posicion posicion){
        tablero[posicion.getFila()][posicion.getColumna()] = null;
    }


    public Pieza devuelvePieza(int fila, int columna){
        return tablero[fila][columna];
    }

    public Pieza devuelvePieza(Posicion posicion){
        return tablero[posicion.getFila()][posicion.getColumna()];
    }

    public boolean hayPiezasEntre(Movimiento movimiento){
        boolean siHay = false;
        //chequea si hay piezas en el movimiento vertical
        if (movimiento.esVertical()){
            if ( movimiento.getPosInicial().getFila() < movimiento.getPosFinal().getFila()){
                for (int i = movimiento.getPosInicial().getFila(); i < movimiento.saltoVertical(); i++) {
                    if (tablero[i][movimiento.getPosInicial().getColumna()] != null) {
                        siHay = true;
                    }
                }
            }else {
                for (int i = movimiento.getPosInicial().getFila(); i > movimiento.saltoVertical(); i--) {
                    if (tablero[i][movimiento.getPosInicial().getColumna()] != null) {
                        siHay = true;
                    }
                }
            }
        }

        //lo mismo pero en Horizontal
        if (movimiento.esHorizontal()){
            if (movimiento.getPosInicial().getColumna() < movimiento.getPosFinal().getColumna()){
                for (int i = movimiento.getPosInicial().getColumna(); i < movimiento.saltoHorizontal(); i++) {
                    if (tablero[i][movimiento.getPosInicial().getFila()] != null) {
                        siHay = true;
                    }
                }
            }else {
                for (int i = movimiento.getPosInicial().getColumna(); i > movimiento.saltoHorizontal(); i--) {
                    if (tablero[i][movimiento.getPosInicial().getFila()] != null) {
                        siHay = true;
                    }
                }
            }
        }

        //otro mas pero en diagonal
        if (movimiento.esDiagonal()){
            for (int i = movimiento.getPosInicial().getColumna(); i < movimiento.saltoHorizontal(); i++) {
                for (int j = movimiento.getPosInicial().getFila(); j < movimiento.saltoVertical(); j++) {
                    if (tablero[j][i] != null) {
                        siHay = true;
                    }
                }
            }
        }
        return siHay;
    }

}

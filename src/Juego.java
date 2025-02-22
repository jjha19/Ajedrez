public class Juego {
    private boolean turno;
    private Movimiento mov;

    public boolean getTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public String validarJugada(String entradaUsuario, Tablero tablero) {
        String advertencia = null;
        boolean dentrolimites = false;
        //Formatea la entrada a algo útil
        entradaUsuario = entradaUsuario.toUpperCase().trim();

        // Se fija si la entrada tiene un formato válido
        if (entradaUsuario.length() == 4) {
            char[] jgd = entradaUsuario.toCharArray();
            if (jgd[0] >= 65 && jgd[0] <= 72) {
                if (jgd[1] >= 49 && jgd[1] <= 56) {
                    if (jgd[2] >= 65 && jgd[2] <= 72) {
                        if (jgd[3] >= 49 && jgd[3] <= 56) {
                            dentrolimites = true;
                        }
                    }
                }
            }
            if (dentrolimites) {
                //traducción char a números 0..7 y creacion de movimiento
                int filaInicial = jgd[1] - '1';
                int columnaInicial = jgd[0] - 'A';
                int filaFinal = jgd[3] - '1';
                int columnaFinal = jgd[2] - 'A';
                Posicion posicionInicial = new Posicion(filaInicial, columnaInicial);
                Posicion posicionFinal = new Posicion(filaFinal, columnaFinal);
                Movimiento jugada = new Movimiento(posicionInicial, posicionFinal);

                // Pregunta si hay pieza en el lugar inicial
                if (tablero.hayPieza(filaInicial, columnaInicial)) {

                    //chequea si es el turno del jugador
                    if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() == turno) {

                        //Chequea si se puede mover a traves de esas casillas
                        if ((tablero.hayPiezasEntre(jugada) && tablero.devuelvePieza(filaInicial, columnaInicial).getClass() == Caballo.class) || !tablero.hayPiezasEntre(jugada)) {

                            // Chequea si la pieza se puede mover asi
                            if (tablero.devuelvePieza(filaInicial, columnaInicial).validoMovimiento(jugada)) {
                                // Chequea si hay canibalismo
                                if (tablero.hayPieza(filaFinal, columnaFinal)) {
                                    if (tablero.devuelvePieza(filaFinal, columnaFinal).getColor() == tablero.devuelvePieza(filaInicial, columnaInicial).getColor()) {
                                        advertencia = "No se puede comer una pieza del mismo equipo. Escribe otra jugada";
                                    }
                                }
                            } else advertencia = "Esa pieza no se puede mover asi. Escribe otra jugada";
                        } else advertencia = "Hay gente en el camino. Recuerda que solo el caballo puede saltar piezas";
                    } else advertencia = "Esa pieza no es de tu color. Escribe otra jugada";
                } else advertencia = "No hay pieza que mover. Escribe otra jugada";
            } else advertencia = "La jugada se va de los límites. Escribe otra";
        }else advertencia = "La jugada no tiene la longitud correcta. Introduce otra.";
        return advertencia;
    }

    public Movimiento transformarAJugada(String entrada) {
        entrada = entrada.toUpperCase().trim();
        char[] jgd = entrada.toCharArray();
        int filaInicial = jgd[1] - '1';
        int columnaInicial = jgd[0] - 'A';
        int filaFinal = jgd[3] - '1';
        int columnaFinal = jgd[2] - 'A';
        Posicion posicionInicial = new Posicion(filaInicial, columnaInicial);
        Posicion posicionFinal = new Posicion(filaFinal, columnaFinal);
        Movimiento jugada = new Movimiento(posicionInicial, posicionFinal);
        return jugada;
    }
}

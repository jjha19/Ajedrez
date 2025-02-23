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
                mov = new Movimiento(posicionInicial, posicionFinal, tablero);

                // Pregunta si hay pieza en el lugar inicial
                if (tablero.hayPieza(filaInicial, columnaInicial)) {

                    //chequea si es el turno del jugador
                    if (tablero.devuelvePieza(filaInicial, columnaInicial).getColor() == turno) {

                        //Chequea si se puede mover a traves de esas casillas
                        if ((tablero.hayPiezasEntre(mov) && tablero.devuelvePieza(filaInicial, columnaInicial).getClass() == Caballo.class) || !tablero.hayPiezasEntre(mov)) {

                            // Chequea si la pieza se puede mover asi
                            if (tablero.devuelvePieza(filaInicial, columnaInicial).validoMovimiento(mov)) {
                                // Chequea si hay canibalismo
                                if (tablero.hayPieza(filaFinal, columnaFinal) && (tablero.devuelvePieza(filaFinal, columnaFinal).getColor() == tablero.devuelvePieza(filaInicial, columnaInicial).getColor())) {
                                        advertencia = "No se puede comer una pieza del mismo equipo. Escribe otra jugada";
                                }
                            } else advertencia = "Esa pieza no se puede mover asi. Escribe otra jugada";
                        } else advertencia = "Hay gente en el camino. Recuerda que solo el caballo puede saltar piezas";
                    } else advertencia = "Esa pieza no es de tu color. Escribe otra jugada";
                } else advertencia = "No hay pieza que mover. Escribe otra jugada";
            } else advertencia = "La jugada se va de los límites. Escribe otra";

            //Se fija si la entrada es enroque largo
        }else if(entradaUsuario.equalsIgnoreCase("o-o-o")) {
            //si es turno de las negras
            if(turno){
                //Se cerciora si hay un rey y una torre en sus posiciones
                if(tablero.devuelvePieza(7,3) instanceof Rey && tablero.devuelvePieza(7,7) instanceof Torre){

                    //Guarda las posiciones de cada uno
                    Posicion posReyNegro = new Posicion(7,3);
                    Posicion posTorreLargo  = new Posicion(7,7);
                    Movimiento enroquelargo = new Movimiento(posReyNegro, posTorreLargo, tablero);

                    //se fija que no haya piezas en medio
                    if(!tablero.hayPiezasEntre(enroquelargo)){

                        //Castea estas piezas para poder acceder a sus atributos
                        Torre torre = (Torre) tablero.devuelvePieza(posTorreLargo);
                        Rey reynegro = (Rey) tablero.devuelvePieza(posReyNegro);
                        // se fija si se movieron
                        if (!reynegro.getReyMovido()) {
                            if(!torre.getTorreMovida()){

                                tablero.ponPieza(reynegro, 7, 5);
                                tablero.quitaPieza(7,3);

                                tablero.ponPieza(torre,7,4);
                                tablero.quitaPieza(7,7);
                            }else advertencia = "La torre ya se movio. No se puede enrocar";
                        }else advertencia = "El rey ya se movio. No se puede enrocar";
                    }else advertencia = "Este enroque largo no se puede hacer. Hay gente en medio";
                }else advertencia = "No se puede hacer el enroque. Te faltan las piezas necesarias";
            } else{
                if(tablero.devuelvePieza(0,4) instanceof Rey && tablero.devuelvePieza(0,0) instanceof Torre){

                    Posicion posReyBlanco = new Posicion(0,4);
                    Posicion posTorreLargo  = new Posicion(0,0);
                    Movimiento enroquelargo = new Movimiento(posReyBlanco, posTorreLargo, tablero);
                    if(!tablero.hayPiezasEntre(enroquelargo)){
                        Torre torre = (Torre) tablero.devuelvePieza(posTorreLargo);
                        Rey reyBlanco = (Rey) tablero.devuelvePieza(posReyBlanco);
                        if (!reyBlanco.getReyMovido()) {
                            if(!torre.getTorreMovida()){

                                tablero.ponPieza(reyBlanco, 0, 2);
                                tablero.quitaPieza(0,4);

                                tablero.ponPieza(torre,0,3);
                                tablero.quitaPieza(0,0);
                            }else advertencia = "La torre ya se movio. No se puede enrocar";
                        }else advertencia = "El rey ya se movio. No se puede enrocar";
                    }else advertencia = "Este enroque largo no se puede hacer. Hay gente en medio";
                }else advertencia = "No se puede hacer el enroque. Te faltan las piezas necesarias";
            }
        } else if(entradaUsuario.equalsIgnoreCase("o-o")) {
            if(turno){
                //Se cerciora si hay un rey y una torre en sus posiciones
                if(tablero.devuelvePieza(7,3) instanceof Rey && tablero.devuelvePieza(7,0) instanceof Torre){

                    //Guarda las posiciones de cada uno
                    Posicion posReyNegro = new Posicion(7,3);
                    Posicion posTorreCorto  = new Posicion(7,0);
                    Movimiento enroqueCorto = new Movimiento(posReyNegro, posTorreCorto, tablero);

                    //se fija que no haya piezas en medio
                    if(!tablero.hayPiezasEntre(enroqueCorto)){

                        //Castea estas piezas para poder acceder a sus atributos
                        Torre torre = (Torre) tablero.devuelvePieza(posTorreCorto);
                        Rey reynegro = (Rey) tablero.devuelvePieza(posReyNegro);
                        // se fija si se movieron
                        if (!reynegro.getReyMovido()) {
                            if(!torre.getTorreMovida()){

                                tablero.ponPieza(reynegro, 7, 1);
                                tablero.quitaPieza(7,3);

                                tablero.ponPieza(torre,7,2);
                                tablero.quitaPieza(7,0);
                            }else advertencia = "La torre ya se movio. No se puede enrocar";
                        }else advertencia = "El rey ya se movio. No se puede enrocar";
                    }else advertencia = "Este enroque largo no se puede hacer. Hay gente en medio";
                }else advertencia = "No se puede hacer el enroque. Te faltan las piezas necesarias";
            }else {
                //Se cerciora si hay un rey y una torre en sus posiciones
                if(tablero.devuelvePieza(0,4) instanceof Rey && tablero.devuelvePieza(0,7) instanceof Torre){

                    //Guarda las posiciones de cada uno
                    Posicion posReyBlanco = new Posicion(0,4);
                    Posicion posTorreCorto  = new Posicion(0,7);
                    Movimiento enroqueCorto = new Movimiento(posReyBlanco, posTorreCorto, tablero);

                    //se fija que no haya piezas en medio
                    if(!tablero.hayPiezasEntre(enroqueCorto)){

                        //Castea estas piezas para poder acceder a sus atributos
                        Torre torre = (Torre) tablero.devuelvePieza(posTorreCorto);
                        Rey reyblanco = (Rey) tablero.devuelvePieza(posReyBlanco);
                        // se fija si se movieron
                        if (!reyblanco.getReyMovido()) {
                            if(!torre.getTorreMovida()){

                                tablero.ponPieza(reyblanco, 0, 6);
                                tablero.quitaPieza(0,4);

                                tablero.ponPieza(torre,0,5);
                                tablero.quitaPieza(0,7);
                            }else advertencia = "La torre ya se movio. No se puede enrocar";
                        }else advertencia = "El rey ya se movio. No se puede enrocar";
                    }else advertencia = "Este enroque largo no se puede hacer. Hay gente en medio";
                }else advertencia = "No se puede hacer el enroque. Te faltan las piezas necesarias";
            }


        } else advertencia = "La jugada no tiene la longitud correcta. Introduce otra.";
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
        mov = new Movimiento(posicionInicial, posicionFinal);
        return mov;
    }



}

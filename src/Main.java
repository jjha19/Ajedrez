import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean fin = false;


        Tablero tablero = new Tablero();
        Juego juego = new Juego();
        String quienVa;
        String entrada;
        Movimiento mov;


        do {
            tablero.pintarTablero();
            if (juego.getTurno()) {
                quienVa = "negras";
            } else quienVa = "blancas";
            if (juego.jaque(tablero)) {
                System.out.println("Jaque al rey de las " + quienVa);
            }
            System.out.println("Introduce la jugada de las " + quienVa);
            entrada = (sc.nextLine());


            // Estos ifs miran si hay entradas atípicas

            if (entrada.equals("me rindo")) {
                fin = true;
                juego.setTurno(!juego.getTurno());
                if (juego.getTurno()) {
                    quienVa = "negras";
                } else quienVa = "blancas";
                System.out.println("¡Ganan las " + quienVa + "!");

            } else if (entrada.equalsIgnoreCase("o-o") || entrada.equalsIgnoreCase("o-o-o")) {
                if (juego.validarJugada(entrada, tablero) == null) {
                    juego.validarJugada(entrada, tablero);
                    juego.setTurno(!juego.getTurno());
                } else System.out.println(juego.validarJugada(entrada, tablero));
            } else {
                if (juego.validarJugada(entrada, tablero) == null) {
                    mov = juego.transformarAJugada(entrada);
                    tablero.ponPieza(tablero.devuelvePieza(mov.getPosInicial()), mov.getPosFinal());
                    tablero.quitaPieza(mov.getPosInicial());
                    //Cambiar el turno porque la jugada es válida
                    juego.setTurno(!juego.getTurno());
                } else System.out.println(juego.validarJugada(entrada, tablero));

                if (juego.reyBlancoMuerto(tablero) || juego.reyNegroMuerto(tablero)) {
                    fin = true;
                    System.out.println("¡El rey ha muerto! Se acaba la partida");
                }else{
                    if (juego.buscaPeonPromo(tablero)) {
                        juego.promocionarPeon(tablero);
                    }
                }
            }
        } while (!fin);
    }
}
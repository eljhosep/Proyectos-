package juegocarta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JuegoMedieval {
    private int numJugadores;
    private List<Jugador> jugadores;
    private MazoMedieval mazo;
    private Random random;
    

    JuegoMedieval(int numJugadores) {
        this.numJugadores = numJugadores;
        this.jugadores = new ArrayList<>();
        for (int i = 1; i <= numJugadores; i++) {
            System.out.println("Jugador " + i);
        }
        this.mazo = new MazoMedieval();
        this.random = new Random();
    }

    public void jugar() {
        mazo.barajar(random);

        for (int i = 0; i < 12; i++) {
            List<CartaMedieval> cartasEnJuego = new ArrayList<>();
            for (int j = 0; j < numJugadores; j++) {
                CartaMedieval jugador = jugadores.get(j);
                CartaMedieval carta = mazo.repartirCarta();
                jugador.recibirCarta(carta);
                cartasEnJuego.add(carta);
            }
            System.out.println("Cartas en juego: " + cartasEnJuego);

            CartaMedieval cartaGanadora = null;
            for (CartaMedieval carta : cartasEnJuego) {
                if (cartaGanadora == null || carta.compareTo(cartaGanadora) > 0) {
                    cartaGanadora = carta;
                }
            }
            System.out.println("La carta ganadora es: " + cartaGanadora);
            for (Jugador jugador : jugadores) {
                if (jugador.tieneCarta(cartaGanadora)) {
                    jugador.sumarPunto();
                    System.out.println("El jugador " + jugador.getNombre() + " gana la ronda.");
                }
                jugador.descartarCartas();
            }
        }

        Jugador ganador = null;
        for (Jugador jugador : jugadores) {
            if (ganador == null || jugador.compareTo(ganador) > 0) {
                ganador = jugador;
            }
        }
        System.out.println("El ganador es: " + ganador.Nombre() + " con " + ganador.getPuntos() + " puntos.");
    }
    private juegocarta.List<JugadorMedieval> jugadores;
    private MazoMedieval mazo;
    private Random random;

    public JuegoMedieval(int numJugadores) {
        this.jugadores = new ArrayList<>();
        this.mazo = new MazoMedieval();
        this.random = new Random();

        for (int i = 1; i <= numJugadores; i++) {
            jugadores.add(new JugadorMedieval("Jugador " + i));
        }

        mazo.barajar(random);
        for (int i = 0; i < 5; i++) {
            for (JugadorMedieval jugador : jugadores) {
                jugador.recibirCarta(mazo.repartirCarta());
            }
        }
    }

    public void jugar() {
        while (!mazo.getCartas().isEmpty()) {
            for (JugadorMedieval jugador : jugadores) {
                System.out.println("Turno de " + jugador.getNombre() + ":");
                System.out.println(jugador.getMano());
                int index = obtenerInput(jugador);
                CartaMedieval cartaJugada = jugador.jugarCarta(index);
                System.out.println(jugador.getNombre() + " jugó " + cartaJugada);
                for (JugadorMedieval otroJugador : jugadores) {
                    if (otroJugador != jugador) {
                        System.out.println("Comparando con " + otroJugador.getNombre() + "...");
                        int resultado = cartaJugada.compareTo(otroJugador.getMano().get(0));
                        if (resultado > 0) {
                            System.out.println(jugador.getNombre() + " ganó la ronda.");
                            jugador.recibirCarta(otroJugador.jugarCarta(0));
                            jugador.recibirCarta(cartaJugada);
                            } else if (resultado < 0) {
                        System.out.println(otroJugador.getNombre() + " ganó la ronda.");
                        otroJugador.recibirCarta(jugador.jugarCarta(index));
                        otroJugador.recibirCarta(cartaJugada);
                    } else {
                        System.out.println("Empate.");
                        otroJugador.recibirCarta(jugador.jugarCarta(index));
                        otroJugador.recibirCarta(cartaJugada);
                    }
                }
            }
            System.out.println();
        }
    }
    System.out.println("Se acabaron las cartas. Ganador: " + obtenerGanador().getNombre());
}

    private int obtenerInput(JugadorMedieval jugador) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.print("Elige una carta (1-" + jugador.getMano().size() + "): ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < jugador.getMano().size()) {
            return index;
        } else {
            System.out.println("Índice inválido. Inténtalo de nuevo.");
        }
    }
}

    private CartaMedieval obtenerGanador() {
    CartaMedieval ganador = jugadores.get(0);
    for (int i = 1; i < jugadores.size(); i++) {
        if (ganador.getMano().size() < jugadores.get(i).getMano().size()) {
            ganador = jugadores.get(i);
        }
    }
    return ganador;
}
}

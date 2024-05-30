package juegocarta;

import java.util.Scanner;

public class JuegoCarta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de jugadores: ");
        int numJugadores = scanner.nextInt();
        JuegoMedieval juego = new JuegoMedieval(numJugadores);
        juego.jugar();
    }
    
}

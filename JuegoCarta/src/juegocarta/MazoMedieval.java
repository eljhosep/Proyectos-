package juegocarta;

import java.util.ArrayList;
import java.util.Random;

public class MazoMedieval {
    private List<CartaMedieval> cartas;

    public MazoMedieval() {
        this.cartas = new ArrayList<>();
        String[] nombres = {"Caballero", "Reina", "Rey", "Príncipe", "Princesa", "Sacerdote", "Mago", "Dragón", "Grifo", "Unicornio", "Goblin", "Ogro"};
        String[] descripciones = {"Valiente guerrero", "Sabia gobernante", "Poderoso monarca", "Heredero al trono", "Hija de la nobleza", "Conexión divina", "Domina las artes arcanas", "Criatura temible", "Criatura mágica", "Pequeño y astuto", "Brutal y feroz", "Malvado y astuto"};

        for (int i = 0; i < nombres.length; i++) {
            for (int j = 1; j <= 5; j++) {
                cartas.add(new CartaMedieval(nombres[i], descripciones[i], j));
            }
        }
    }

    public CartaMedieval repartirCarta() {
        if (cartas.isEmpty()) {
            throw new RuntimeException("El mazo está vacío.");
        }
        return cartas.remove(0);
    }

    void barajar(Random random) {
        for (int i = cartas.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            CartaMedieval temp = cartas.get(i);
            cartas.set(i, cartas.get(j));
            cartas.set(j, temp);
    }
  }

    Object getCartas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

package juegocarta;

import java.util.ArrayList;

public class JugadorMedieval {
    private String nombre;
    private List<CartaMedieval> mano;

    public JugadorMedieval(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    public void recibirCarta(CartaMedieval carta) {
        mano.add(carta);
    }

    public CartaMedieval jugarCarta(int index) {
        return mano.remove(index);
    }

    public String getNombre() {
        return nombre;
    }

    public List<CartaMedieval> getMano() {
        return mano;
    }

    @Override
    public String toString() {
        return nombre + " (mano: " + mano + ")";
    }
    
}

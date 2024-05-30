package juegocarta;

public class CartaMedieval implements Comparable<CartaMedieval>  {
    private String nombre;
    private String descripcion;
    private int nivel;

    public CartaMedieval(String nombre, String descripcion, int nivel) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
    }

    CartaMedieval() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public int compareTo(CartaMedieval otraCarta) {
        if (this.nivel > otraCarta.nivel) {
            return 1;
        } else if (this.nivel < otraCarta.nivel) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return nombre + " (" + descripcion + ", Nivel " + nivel + ")";
    }

    Object getMano() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void recibirCarta(CartaMedieval carta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

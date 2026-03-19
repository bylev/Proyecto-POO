package items;

import ExcepcionesPersonalizadas.ObjetoNoPosibleException;
import personajes.Personaje;

public abstract class Item {
    protected String nombre;
    protected int cantidad;

    public Item(String nombre, int cantidad) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El item debe tener un nombre.");
        this.nombre = nombre;
        this.cantidad = (cantidad < 0) ? 0 : cantidad;
    }

    public abstract void usar();

    public abstract void equiparEn(Personaje p) throws ObjetoNoPosibleException;

    /* Getters */
    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    /* Setters */
    public void setCantidad(int cantidad) {
        this.cantidad = (cantidad < 0) ? 0 : cantidad;
    }

    @Override
    public String toString() {
        return "Item: " + nombre + "\nCantidad: " + cantidad;
    }
}

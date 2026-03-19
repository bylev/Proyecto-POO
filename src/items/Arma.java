package items;

import ExcepcionesPersonalizadas.ObjetoNoPosibleException;
import interfaces.Durable;
import personajes.Personaje;

public class Arma extends Item implements Durable {
    private int danio;
    private int durabilidadActual;
    private int durabilidadMaxima;

    public Arma(String nombre, int cantidad, int danio, int durabilidadMaxima) {
        super(nombre, cantidad);
        if (danio <= 0) throw new IllegalArgumentException("El daño debe ser mayor a 0.");
        this.danio = danio;
        this.durabilidadMaxima = durabilidadMaxima;
        this.durabilidadActual = durabilidadMaxima;
    }

    @Override
    public void equiparEn(Personaje p) throws ObjetoNoPosibleException {
        if (estaRota()) {
            throw new ObjetoNoPosibleException(this.durabilidadActual);
        } else {
            // Llama al método de Personaje que ahora maneja la lista
            p.setArma(this); 
        }
    }

    @Override
    public void usar() throws ObjetoNoPosibleException {
        if (estaRota()) throw new ObjetoNoPosibleException(this.durabilidadActual);
        System.out.println("Usando arma: " + nombre);
    }

    @Override
    public void reducirDurabilidad(int cantidad) {
        durabilidadActual = Math.max(0, durabilidadActual - cantidad);
    }

    @Override
    public boolean estaRota() { return durabilidadActual <= 0; }
    public int getDanio() { return danio; }
}

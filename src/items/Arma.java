package items;

import excepciones.ObjetoNoPosibleException;
import interfaces.Durable;
import personajes.Personaje;

public class Arma extends Item implements Durable {
    private int danio;
    private int durabilidadActual;
    private int durabilidadMaxima;

    public Arma(String nombre, int cantidad, int danio, int durabilidadMaxima) {
        super(nombre, cantidad);
        if (danio <= 0)
            throw new IllegalArgumentException("El daño debe ser mayor a 0.");
        this.danio = danio;
        this.durabilidadMaxima = durabilidadMaxima;
        this.durabilidadActual = durabilidadMaxima;
    }

    /* Getters */
    public int getDanio() {
        return danio;
    }

    public int getDurabilidadActual() {
        return durabilidadActual;
    }

    public int getDurabilidadMaxima() {
        return durabilidadMaxima;
    }

    @Override
    public void equiparEn(Personaje p) throws ObjetoNoPosibleException {
        if (estaRota()) {
            throw new ObjetoNoPosibleException("El arma está rota. No se puede equipar.");
        } else {
            p.setArma(this);
        }
    }

    @Override
    public void usar() throws ObjetoNoPosibleException {
        if (estaRota())
            throw new ObjetoNoPosibleException("El arma está rota.");
        System.out.println("Usando arma: " + nombre);
    }

    @Override
    public void reducirDurabilidad(int cantidad) {
        durabilidadActual = Math.max(0, durabilidadActual - cantidad);
    }

    @Override
    public boolean estaRota() {
        return durabilidadActual <= 0;
    }
}

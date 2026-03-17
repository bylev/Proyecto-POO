package items;

import interfaces.Durable;
import personajes.Personaje;

public class Arma extends Item implements Durable {
    private int danio;
    private int durabilidadActual;
    private int durabilidadMaxima;

    public Arma(String nombre, int cantidad, int danio, int durabilidadMaxima) {
        super(nombre, cantidad);
        if (danio <= 0)
            throw new IllegalArgumentException("El daño no puede ser 0 ni menor.");
        if (durabilidadMaxima <= 0)
            throw new IllegalArgumentException("La durabilidad máxima debe ser mayor a 0.");
        this.danio = danio;
        this.durabilidadActual = durabilidadMaxima;
        this.durabilidadMaxima = durabilidadMaxima;
    }

    /* Getters */
    public int getDanio() {
        return estaRota() ? 0 : danio;
    }

    public int getDurabilidadActual() {
        return durabilidadActual;
    }

    public int getDurabilidadMaxima() {
        return durabilidadMaxima;
    }

    /* Métodos */

    @Override
    public void reducirDurabilidad(int cantidad) {
        durabilidadActual -= cantidad;
        if (durabilidadActual < 0)
            durabilidadActual = 0;
    }

    @Override
    public boolean estaRota() {
        return durabilidadActual == 0;
    }

    @Override
    public void usar() {
        if (cantidad <= 0) {
            System.out.println("No cuentas con este item en tu inventario.");
            return;
        }

        if (estaRota()) {
            System.out.println("El arma " + nombre + " está rota y no puede usarse.");
        } else
            System.out.println("Arma: " + nombre + " | Estado: "
                    + (estaRota() ? "ROTA" : durabilidadActual + "/" + durabilidadMaxima));
    }

    @Override
    public void equiparEn(Personaje p) {
        if (estaRota()) {
            System.out.println("No puedes equipar " + nombre + " porque está rota.");
        } else {
            p.setArma(this);
            System.out.println("Arma equipada y lista para usar.");
        }
    }

    @Override
    public String toString() {
        return "Arma: " + getNombre() + " | Estado: "
                + (estaRota() ? "ROTA" : getDurabilidadActual() + "/" + getDurabilidadMaxima());
    }
}

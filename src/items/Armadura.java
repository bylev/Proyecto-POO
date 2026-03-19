package items;

import ExcepcionesPersonalizadas.ObjetoNoPosibleException;
import interfaces.Durable;
import personajes.Personaje;

public class Armadura extends Item implements Durable {
    private int defensa;
    private int durabilidadActual;
    private int durabilidadMaxima;

    public Armadura(String nombre, int cantidad, int defensa, int durabilidadMaxima) {
        super(nombre, cantidad);
        if (defensa <= 0) throw new IllegalArgumentException("La defensa debe ser mayor a 0.");
        this.defensa = defensa;
        this.durabilidadMaxima = durabilidadMaxima;
        this.durabilidadActual = durabilidadMaxima;
    }

    @Override
    public void equiparEn(Personaje p) throws ObjetoNoPosibleException {
        if (estaRota()) {
            throw new ObjetoNoPosibleException(this.durabilidadActual);
        } else {
            p.setArmadura(this);
        }
    }

    @Override
    public void usar() throws ObjetoNoPosibleException {
        System.out.println("Revisando estado de la armadura: " + nombre);
    }

    @Override
    public void reducirDurabilidad(int cantidad) {
        durabilidadActual = Math.max(0, durabilidadActual - cantidad);
    }

    @Override
    public boolean estaRota() { return durabilidadActual <= 0; }
}

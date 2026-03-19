package items;

import interfaces.Durable;
import personajes.Personaje;

public class Armadura extends Item implements Durable {
    private int defensa;
    private int durabilidadActual;
    private int durabilidadMaxima;

    public Armadura(String nombre, int cantidad, int defensa, int durabilidadMaxima) {
        super(nombre, cantidad);
        if (defensa <= 0)
            throw new IllegalArgumentException("La defensa debe ser mayor a 0.");
        if (durabilidadMaxima <= 0)
            throw new IllegalArgumentException("La durabilidad máxima debe ser mayor a 0.");

        this.defensa = defensa;
        this.durabilidadActual = durabilidadMaxima;
        this.durabilidadMaxima = durabilidadMaxima;
    }

    /* Getters */
    public int getDefensa() {
        return defensa;
    }

    public int getDurabilidadActual() {
        return durabilidadActual;
    }

    public int getDurabilidadMaxima() {
        return durabilidadMaxima;
    }

    @Override
    public void reducirDurabilidad(int cantidad) {
        durabilidadActual -= cantidad;
        if (durabilidadActual < 0)
            durabilidadActual = 0;
    }

    @Override
    public boolean estaRota() {
        return durabilidadActual <= 0;
    }

    @Override
    public void usar() {
        if (getCantidad() <= 0) {
            System.out.println("No cuentas con este item en tu inventario.");
            return;
        }

        if (estaRota()) {
            System.out.println("El armadura " + getNombre() + " está rota y no puede usarse.");
        } else
            System.out.println("Armadura: " + getNombre() + " | Estado: "
                    + (estaRota() ? "ROTA" : durabilidadActual + "/" + durabilidadMaxima));
    }

    @Override
    public void equiparEn(Personaje p) {
        if (estaRota()) {
            System.out.println("No puedes equipar " + getNombre() + " porque está rota.");
        } else {
            p.setArmadura(this);
            System.out.println(p.getNombre() + " equipó la armadura " + getNombre());
        }
    }

}

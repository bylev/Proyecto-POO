package enemigos;

import interfaces.Vida;
import personajes.Personaje;

public abstract class Enemigo implements Vida {
    private String nombre;
    private int vida;
    private int nivel;

    private int experienciaOtorgada;

    public Enemigo(String nombre, int nivel, int vida, int experienciaOtorgada) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El nombre del enemigo no puede estar vacío");
        if (nivel <= 0)
            throw new IllegalArgumentException("El nivel debe ser mayor a 0");
        if (vida <= 0)
            throw new IllegalArgumentException("La vida debe ser mayor a 0");
        if (experienciaOtorgada <= 0)
            throw new IllegalArgumentException("La experiencia otorgada debe ser mayor a 0");

        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.experienciaOtorgada = experienciaOtorgada;
    }

    public abstract void atacar(Personaje p);

    // * Interfaz Vida */

    @Override
    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida <= 0)
            vida = 0;
        System.out.println(nombre + " recibe " + cantidad + " puntos de daño. Vida restante: " + vida);
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    /* Getters */

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperienciaOtorgada() {
        return experienciaOtorgada;
    }

    public int getVida() {
        return vida;
    }

    public int getDanio() {
        return nivel * 10;
    }

    /* Setters */

    public void setVida(int vida) {
        if (vida <= 0)
            throw new IllegalArgumentException("La vida debe ser mayor a 0");
        this.vida = vida;
    }

    @Override
    public String toString() {
        return nombre + " (Nivel: " + nivel + ") - Vida: " + vida;
    }

}

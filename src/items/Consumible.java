package items;

import personajes.Personaje;

public class Consumible extends Item {
    private int vidaRestaurada;
    private Personaje p;

    public Consumible(String nombre, int cantidad, int vidaRestaurada, String tipo) {
        super(nombre, cantidad);
        if (vidaRestaurada <= 0)
            throw new IllegalArgumentException("El consumible debe restaurar vida o maná.");
        this.vidaRestaurada = vidaRestaurada;
        this.p = null;

    }

    /* Getters */
    public int getVidaRestaurada() {
        return vidaRestaurada;
    }

    /* Setter */
    public void setPersonaje(Personaje p) {
        this.p = p;
    }

    /* Métodos */
    @Override
    public void usar() {
        if (p == null) {
            System.out.println("No hay personaje para usar el consumible.");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("No quedan consumibles.");
            return;
        }
        System.out.println("Consumible: " + nombre + " (+" + vidaRestaurada + " de vida)");
        equiparEn(p);
        cantidad--;
    }

    @Override
    public void equiparEn(Personaje p) {
        if (p.getVidaActual() == p.getVidaMaxima()) {
            System.out.println("El personaje ya tiene la vida al máximo.");
            return;
        }
        p.setVidaActual(p.getVidaActual() + vidaRestaurada);
        if (p.getVidaActual() > p.getVidaMaxima())
            p.setVidaActual(p.getVidaMaxima());
        System.out.println(nombre + " restaura " + vidaRestaurada + " puntos de vida.");
    }
}

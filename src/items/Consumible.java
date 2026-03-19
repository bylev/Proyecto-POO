package items;

import ExcepcionesPersonalizadas.ObjetoNoPosibleException;
import personajes.Personaje;

public class Consumible extends Item {
    private int vidaRestaurada;
    private Personaje p;

    public Consumible(String nombre, int cantidad, int vidaRestaurada) {
        super(nombre, cantidad);
        if (vidaRestaurada <= 0) throw new IllegalArgumentException("Debe restaurar vida.");
        this.vidaRestaurada = vidaRestaurada;
    }

    public void setPersonaje(Personaje p) { this.p = p; }

    @Override
    public void usar() throws ObjetoNoPosibleException {
        if (p == null) return;
        if (cantidad > 0) {
            p.setVidaActual(p.getVidaActual() + vidaRestaurada);
            cantidad--;
            System.out.println(p.getNombre() + " usó " + nombre + ". Vida restaurada.");
        }
    }

    @Override
    public void equiparEn(Personaje p) {
        
        p.setConsumible(this);
    }
}

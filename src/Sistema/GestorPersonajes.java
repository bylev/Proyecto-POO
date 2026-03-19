package Sistema;

import java.util.ArrayList;
import java.util.List;

import excepciones.ObjetoNoPosibleException;
import items.Arma;
import items.Armadura;
import items.Consumible;
import items.Item;
import personajes.Personaje;

public class GestorPersonajes {

    private List<Personaje> personajes = new ArrayList<>();

    public void registrarPersonaje(Personaje p) {
        if (p == null)
            throw new IllegalArgumentException("El personaje no puede ser nulo.");
        personajes.add(p);
        System.out.println("Personaje registrado: " + p.getNombre());
    }

    public void darArma(Personaje p, Arma a) {
        if (p == null || a == null)
            return;
        p.getInventario().agregarArma(a);
        System.out.println("[GestorPersonajes] " + a.getNombre()
                + " agregada al inventario de " + p.getNombre());
    }

    public void darArmadura(Personaje p, Armadura a) {
        if (p == null || a == null)
            return;
        p.getInventario().agregarArmadura(a);
        System.out.println("[GestorPersonajes] " + a.getNombre()
                + " agregada al inventario de " + p.getNombre());
    }

    public void darConsumible(Personaje p, Consumible c) {
        if (p == null || c == null)
            return;
        p.getInventario().agregarConsumible(c);
        System.out.println("[GestorPersonajes] " + c.getNombre()
                + " agregada al inventario de " + p.getNombre());
    }

    public void equiparItem(Personaje p, Item i) throws ObjetoNoPosibleException {
        if (p == null || i == null)
            return;
        i.equiparEn(p);
    }

    public void usarConsumible(Personaje p) throws ObjetoNoPosibleException {
        if (p == null)
            return;
        if (!p.estaVivo()) {
            System.out.println("No se puede usar consumible porque el personaje no está vivo.");
            return;
        }
        if (p.getConsumible() == null || p.getConsumible().getCantidad() <= 0) {
            System.out.println("No hay consumible para usar.");
            return;
        }
        p.getConsumible().usar();
        System.out.println("Se ha usado el consumible " + p.getConsumible().getNombre() + " de " + p.getNombre() + ".");
        System.out.println("Vida actual de " + p.getNombre() + ": " + p.getVidaActual() + "/" + p.getVidaMaxima());
        // Cuantos consumibles quedan
        System.out.println("Consumibles restantes: " + p.getConsumible().getCantidad());
    }

    public void mostrarInventario(Personaje p) {
        if (p == null)
            return;
        System.out.println("\n=============== INVENTARIO DE " + p.getNombre() + " ===============");
        System.out.println("\nArmas:       " + p.getInventario().getArmas());
        System.out.println("\nArmaduras:   " + p.getInventario().getArmaduras());
        System.out.println("\nConsumibles: " + p.getInventario().getConsumibles());
        System.out.println("\n========================================================");
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }
}

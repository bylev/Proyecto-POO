package Sistema;

import enemigos.Enemigo;
import excepciones.ManaInsuficienteException;
import excepciones.ObjetoNoPosibleException;
import items.Arma;
import items.Armadura;
import items.Consumible;
import items.Item;
import personajes.Personaje;

import java.util.List;

public class SistemaJuego {

    private final String nombre;

    private final GestorPersonajes gestorPersonajes;
    private final GestorEnemigos gestorEnemigos;
    private final GestorBatallas gestorBatallas;

    public SistemaJuego(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre del sistema no puede estar vacío o ser nulo.");
        this.nombre = nombre;
        this.gestorPersonajes = new GestorPersonajes();
        this.gestorEnemigos = new GestorEnemigos();
        this.gestorBatallas = new GestorBatallas();
    }

    public void registrarPersonaje(Personaje p) {
        gestorPersonajes.registrarPersonaje(p);
    }

    public void darArma(Personaje p, Arma a) {
        gestorPersonajes.darArma(p, a);
    }

    public void darArmadura(Personaje p, Armadura a) {
        gestorPersonajes.darArmadura(p, a);
    }

    public void darConsumible(Personaje p, Consumible c) {
        gestorPersonajes.darConsumible(p, c);
    }

    public void equiparItem(Personaje p, Item i) throws ObjetoNoPosibleException {
        gestorPersonajes.equiparItem(p, i);
    }

    public void mostrarInventario(Personaje p) {
        gestorPersonajes.mostrarInventario(p);
    }

    public List<Personaje> getPersonajes() {
        return gestorPersonajes.getPersonajes();
    }

    public void registrarEnemigo(Enemigo e) {
        gestorEnemigos.registrarEnemigo(e);
    }

    public List<Enemigo> getEnemigos() {
        return gestorEnemigos.getEnemigos();
    }

    public void iniciarBatalla(Personaje p, Enemigo e) throws ManaInsuficienteException {
        gestorBatallas.iniciarBatalla(p, e);
    }

    public void usarConsumible(Personaje p) throws ObjetoNoPosibleException {
        gestorBatallas.usarConsumible(p);
    }

    public int getTotalBatallas() {
        return gestorBatallas.getTotalBatallas();
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarEstado() {
        System.out.println("\n=============== ESTADO DEL JUEGO ===============");
        System.out.println("\nSistema: " + nombre);
        System.out.println("Total de batallas: " + getTotalBatallas());

        System.out.println("\nPersonajes: ");
        for (Personaje p : getPersonajes()) {
            System.out.println(p.toString());
        }

        System.out.println("\nEnemigos: ");
        for (Enemigo e : getEnemigos()) {
            System.out.println(e.toString());
        }

        System.out.println("\n========================================================");
    }
}

package modelo;

import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;
import excepciones.*;
import items.*;
import personajes.Personaje;
import modelo.Inventario;

public class SistemaJuego {
    private String nombre;
    private static int totalBatallas = 0;

    // Array de personajes
    private List<Personaje> personajes = new ArrayList<>();
    private List<Enemigo> enemigos = new ArrayList<>();

    // Constructor
    public SistemaJuego(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre del sistema no puede estar vacío o ser nulo.");
        this.nombre = nombre;
    }

    // Registrar personaje, enemigos e items.
    public void registrarPersonaje(Personaje p) {
        if (p == null)
            throw new IllegalArgumentException("El personaje no puede ser nulo.");
        personajes.add(p);
        System.out.println("Personaje registrado: " + p.getNombre());
    }

    public void registrarEnemigo(Enemigo e) {
        if (e == null)
            throw new IllegalArgumentException("Debe haber un enemigo para registrar.");
        enemigos.add(e);
        System.out.println("Enemigo registrado: " + e.getNombre());
    }

    // Dar items
    public void darArma(Personaje p, Arma a) {
        if (p == null || a == null)
            return;
        p.getInventario().agregarArma(a);
        System.out.println("[" + nombre + "]" + a.getNombre() + " agregada al inventario de " + p.getNombre());
    }

    public void darArmadura(Personaje p, Armadura a) {
        if (p == null || a == null)
            return;
        p.getInventario().agregarArmadura(a);
        System.out.println("[" + nombre + "]" + a.getNombre() + " agregada al inventario de " + p.getNombre());
    }

    public void darConsumible(Personaje p, Consumible c) {
        if (p == null || c == null)
            return;
        p.getInventario().agregarConsumible(c);
        System.out.println("[" + nombre + "]" + c.getNombre() + " agregada al inventario de " + p.getNombre());
    }

    /* Equipar */
    public void equiparItem(Personaje p, Item i) throws ObjetoNoPosibleException {
        if (p == null || i == null)
            return;
        i.equiparEn(p);
    }

    // Iniciar batalla
    public void iniciarBatalla(Personaje p, Enemigo e) throws ManaInsuficienteException {
        if (p == null || e == null) {
            System.out.println("No hay personaje o enemigo para iniciar la batalla.");
            return;
        }
        if (!p.estaVivo()) {
            System.out.println("No se puede iniciar la batalla porque el personaje no está vivo.");
            return;
        }
        totalBatallas++;
        System.out.println("\n=============== BATALLA INICIADA ===============");
        System.out.println("\nBatalla #" + totalBatallas + ": " + p.getNombre() + " vs " + e.getNombre());
        System.out.println("\n================================================");
        p.atacar(e);
        if (e.estaVivo()) {
            e.atacar(p);
        } else {
            System.out.println("\n=============== BATALLA TERMINADA ===============");
            System.out.println("\n" + p.getNombre() + " ha ganado la batalla.");
            System.out.println("\nExperiencia otorgada: " + e.getExperienciaOtorgada() + " puntos.");
            System.out.println("\n================================================");
        }

        System.out.println("\n ====================== Resultado ======================");
        System.out.println("\n" + p.toString());
        System.out.println("\n" + e.toString());
        System.out.println("\n========================================================");
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
        System.out.println("\nArmas: " + p.getInventario().getArmas());
        System.out.println("\nArmaduras: " + p.getInventario().getArmaduras());
        System.out.println("\nConsumibles: " + p.getInventario().getConsumibles());
        System.out.println("\n========================================================");
    }

    // Getters
    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public int getTotalBatallas() {
        return totalBatallas;
    }

    public String getNombre() {
        return nombre;
    }

    // Mostrar estado
    public void mostrarEstado() {
        System.out.println("\n=============== ESTADO DEL JUEGO ===============");
        System.out.println("\nTotal de batallas: " + getTotalBatallas());
        System.out.println("\nPersonajes: ");
        for (Personaje p : personajes) {
            System.out.println(p.toString());
        }
        System.out.println("\nEnemigos: ");
        for (Enemigo e : enemigos) {
            System.out.println(e.toString());
        }
        System.out.println("\n========================================================");
    }
}
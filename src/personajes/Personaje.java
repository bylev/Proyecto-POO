package personajes;

import interfaces.Vida;
import excepciones.ManaInsuficienteException;
import enemigos.Enemigo;
import items.Arma;
import items.Armadura;
import items.Consumible;
import items.Item;
import java.util.ArrayList;
import java.util.List;

import Sistema.Inventario;

public abstract class Personaje implements Vida {
    private String nombre;
    private int nivel;
    private int vidaMaxima;
    private int vidaActual;
    private int danio;
    private int defensa;
    private boolean bloqueando;
    private Inventario inventario;

    private List<Item> equipamiento;

    public Personaje(String nombre, int nivel, int vidaMaxima) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException("El personaje debe tener un nombre válido.");
        if (nivel <= 0)
            throw new IllegalArgumentException("El nivel debe ser mayor a 0.");
        if (vidaMaxima <= 0)
            throw new IllegalArgumentException("La vida máxima debe ser mayor a 0.");

        this.nombre = nombre;
        this.nivel = nivel;
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = vidaMaxima;
        this.defensa = nivel;
        this.danio = 10 + (nivel * 2);
        this.equipamiento = new ArrayList<>();
        this.inventario = new Inventario();
        this.bloqueando = false;
    }

    public Arma getArma() {
        for (Item i : equipamiento) {
            if (i instanceof Arma)
                return (Arma) i;
        }
        return null;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Armadura getArmadura() {
        for (Item i : equipamiento) {
            if (i instanceof Armadura)
                return (Armadura) i;
        }
        return null;
    }

    public Consumible getConsumible() {
        for (Item i : equipamiento) {
            if (i instanceof Consumible)
                return (Consumible) i;
        }
        return null;
    }

    public void setArma(Arma a) {
        equipamiento.removeIf(i -> i instanceof Arma);
        if (a != null) {
            equipamiento.add(a);
            System.out.println(nombre + " equipa el arma " + a.getNombre());
        }
    }

    public void setArmadura(Armadura a) {
        equipamiento.removeIf(i -> i instanceof Armadura);
        if (a != null) {
            equipamiento.add(a);
            System.out.println(nombre + " equipa la armadura " + a.getNombre());
        }
    }

    public void setConsumible(Consumible c) {
        equipamiento.removeIf(i -> i instanceof Consumible);
        if (c != null) {
            equipamiento.add(c);
            c.setPersonaje(this);
            System.out.println(nombre + " equipa el consumible " + c.getNombre());
        }
    }

    public void setVidaActual(int vidaActual) {
        if (vidaActual < 0)
            this.vidaActual = 0;
        else if (vidaActual > vidaMaxima)
            this.vidaActual = vidaMaxima;
        else
            this.vidaActual = vidaActual;
    }

    public void setNivel(int nivel) {
        if (nivel <= 0)
            throw new IllegalArgumentException("El nivel debe ser mayor a 0.");
        this.nivel = nivel;
    }

    public abstract void atacar(Enemigo e) throws ManaInsuficienteException;

    public abstract void bloquear();

    @Override
    public boolean estaVivo() {
        return vidaActual > 0;
    }

    @Override
    public void recibirDanio(int cantidad) {
        int danioRecibido = bloqueando ? Math.max(0, cantidad - (defensa * 2)) : Math.max(0, cantidad - defensa);
        setVidaActual(vidaActual - danioRecibido);
        bloqueando = false;
        System.out.println(nombre + " recibe " + danioRecibido + " de daño. Vida: " + vidaActual);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getDanio() {
        return danio;
    }

    public void setBloqueando(boolean b) {
        this.bloqueando = b;
    }
}

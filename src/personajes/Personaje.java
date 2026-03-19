package personajes;

import interfaces.Vida;
import enemigos.Enemigo;
import items.Arma;
import items.Armadura;
import items.Consumible;
import modelo.Inventario;

public abstract class Personaje implements Vida {
    private String nombre;
    private int nivel;
    private int vidaMaxima;
    private int vidaActual;
    private int danio;
    private int defensa;
    private Arma arma;
    private Armadura armadura;
    private Consumible consumible;
    private boolean bloqueando;
    private Inventario inventario;

    public Personaje(String nombre, int nivel, int vidaMaxima) {
        if (nombre == null || nombre.isEmpty())
            throw new IllegalArgumentException(
                    "El personaje debe tener un nombre válido. No puede ser null ni estar vacío.");
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
        this.arma = null;
        this.armadura = null;
        this.bloqueando = false;
        this.inventario = new Inventario();
    }

    public abstract void atacar(Enemigo e);

    public abstract void bloquear();

    public void setBloqueando(boolean bloqueando) {
        this.bloqueando = bloqueando;
    }

    public int calcularDefensaTotal() {
        int defensaTotal = defensa;
        if (armadura != null && !armadura.estaRota()) {
            defensaTotal += armadura.getDefensa();
            armadura.reducirDurabilidad(1);

            System.out
                    .println(nombre + " usa su armadura " + armadura.getNombre() + " . Defensa total: " + defensaTotal);
        }
        if (bloqueando) {
            defensaTotal += defensa * 2;
            bloqueando = false;
            System.out.println(nombre + " bloqueó el ataque. Defensa total: " + defensaTotal);
        }
        return defensaTotal;
    }

    @Override
    public void recibirDanio(int cantidad) {
        if (!estaVivo())
            return;
        int danioRecibido = Math.max(0, cantidad - calcularDefensaTotal());
        vidaActual -= danioRecibido;
        if (vidaActual < 0)
            vidaActual = 0;
        System.out.println(nombre + " recibe " + danioRecibido + " puntos de daño. Vida actual: " + vidaActual);
    }

    @Override
    public boolean estaVivo() {
        return vidaActual > 0;
    }

    /* GETTERS */
    public int getDefensa() {
        return defensa;
    }

    public int getDanio() {
        return danio;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public Arma getArma() {
        return arma;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public Consumible getConsumible() {
        return consumible;
    }

    public Inventario getInventario() {
        return inventario;
    }

    /* SETTERS */

    public void setVidaActual(int vidaActual) {
        this.vidaActual = vidaActual;
    }

    public void setArmadura(Armadura a) {
        if (a == null) {
            System.out.println("No hay armadura para equipar.");
            return;
        }
        this.armadura = a;
        System.out.println(nombre + " equipa la armadura " + a.getNombre());
    }

    public void setArma(Arma a) {
        if (a == null) {
            System.out.println("No hay arma para equipar.");
            return;
        }
        this.arma = a;
        System.out.println(nombre + " equipa el arma " + a.getNombre());
    }

    public void setConsumible(Consumible c) {
        if (c == null) {
            System.out.println("No hay consumible para equipar.");
            return;
        }
        this.consumible = c;
        c.setPersonaje(this);
        System.out.println(nombre + " equipa el consumible " + c.getNombre());
    }

    @Override
    public String toString() {
        return "=============== Personaje ===============\n" +
                "Nombre: " + nombre + "\n" +
                "Nivel: " + nivel + "\n" +
                "Vida: " + vidaActual + "/" + vidaMaxima + "\n" +
                "Daño: " + danio + "\n" +
                "Defensa: " + defensa + "\n" +
                "Arma: " + (arma != null ? arma.getNombre() : "Ninguna") + "\n" +
                "Armadura: " + (armadura != null ? armadura.getNombre() : "Ninguna") + "\n" +
                "Consumible: " + (consumible != null ? consumible.getNombre() : "Ninguno") + "\n" +
                "=========================================";
    }

}

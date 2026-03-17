package personajes;

import enemigos.Enemigo;

public class Mago extends Personaje {
    private int mana;
    private int total_mana;

    public Mago(String nombre, int nivel, int vidaMaxima, int total_mana) {
        super(nombre, nivel, vidaMaxima);
        if (total_mana <= 0)
            throw new IllegalArgumentException("El mana debe ser mayor a 0.");
        this.total_mana = total_mana;
        this.mana = total_mana;
    }

    /* Getters */
    public int getMana() {
        return mana;
    }

    public int getTotal_mana() {
        return total_mana;
    }

    /* Métodos */

    @Override
    public void atacar(Enemigo e) {
        if (mana < 10) {
            System.out.println(nombre + " no tiene suficiente mana para atacar.");
            return;
        }
        int danioMagico = 20 + (this.nivel * 2);
        mana -= 10;
        System.out.println(
                nombre + " ataca a " + e.getNombre() + " con su magia infligiendo " + danioMagico + " puntos de daño.");
        e.recibirDanio(danioMagico);
    }

    @Override
    public void bloquear() {
        this.bloqueando = true;
        System.out.println(nombre + " bloquea el ataque.");
    }

    @Override
    public String toString() {
        return "=============== Mago ===============\n" +
                "Nombre: " + nombre + "\n" +
                "Nivel: " + nivel + "\n" +
                "Vida: " + vidaActual + "/" + vidaMaxima + "\n" +
                "Daño: " + danio + "\n" +
                "Defensa: " + defensa + "\n" +
                "Armadura: " + (armadura != null ? armadura.getNombre() : "Ninguna") + "\n" +
                "Consumible: " + (consumible != null ? consumible.getNombre() : "Ninguno") + "\n" +
                "=========================================";
    }
}

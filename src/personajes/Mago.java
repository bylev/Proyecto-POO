package personajes;

import ExcepcionesPersonalizadas.ManaInsuficienteException;
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
    public void atacar(Enemigo e) throws ManaInsuficienteException {

        if (this.mana < 10) {
            throw new ManaInsuficienteException("No tienes sufciente mana para atacar y tu mana es " + mana);
        }
        int danioMagico = 20 + (getNivel() * 2);
        mana -= 10;
        System.out.println(
                nombre + " ataca a " + e.getNombre() + " con su magia infligiendo " + danioMagico + " puntos de daño.");
        e.recibirDanio(danioMagico);
    }

    @Override
    public void bloquear() {
        setBloqueando(true);
        System.out.println(nombre + " bloquea el ataque.");
    }

    @Override
    public String toString() {
        return "=============== Mago ===============\n" +
                "Nombre: " + getNombre() + "\n" +
                "Nivel: " + getNivel() + "\n" +
                "Vida: " + getVidaActual() + "/" + getVidaMaxima() + "\n" +
                "Daño: " + getDanio() + "\n" +
                "Defensa: " + getDefensa() + "\n" +
                "Armadura: " + (getArmadura() != null ? getArmadura().getNombre() : "Ninguna") + "\n" +
                "Consumible: " + (getConsumible() != null ? getConsumible().getNombre() : "Ninguno") + "\n" +
                "=========================================";
    }
}

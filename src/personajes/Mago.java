package personajes;

import ExcepcionesPersonalizadas.ManaInsuficienteException;
import enemigos.Enemigo;
import items.Arma;

public class Mago extends Personaje {
    private int mana;
    private int total_mana;

    public Mago(String nombre, int nivel, int vidaMaxima, int total_mana) {
        super(nombre, nivel, vidaMaxima);
        if (total_mana <= 0) throw new IllegalArgumentException("El mana debe ser mayor a 0.");
        this.total_mana = total_mana;
        this.mana = total_mana;
    }

    @Override
    public void atacar(Enemigo e) throws ManaInsuficienteException {
        if (this.mana < 10) throw new ManaInsuficienteException(mana);
        int danioMagico = 20 + (getNivel() * 2);
        mana -= 10;
        System.out.println(nombre + " lanza un hechizo a " + e.getNombre() + " infligiendo " + danioMagico);
        e.recibirDanio(danioMagico);
    }

    @Override
    public void bloquear() {
        setBloqueando(true);
        System.out.println(nombre + " crea un escudo mágico.");
    }

    @Override
    public String toString() {
        Arma a = getArma();
        return "=============== Mago ===============\n" +
                "Nombre: " + nombre + "\n" +
                "Mana: " + mana + "/" + total_mana + "\n" +
                "Arma: " + (a != null ? a.getNombre() : "Ninguna") + "\n" +
                "====================================";
    }
}

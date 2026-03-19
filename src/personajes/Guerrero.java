package personajes;

import ExcepcionesPersonalizadas.ManaInsuficienteException;
import enemigos.Enemigo;

public class Guerrero extends Personaje {
    private int fuerza;
    private int resistencia;

    public Guerrero(String nombre, int nivel, int vidaMaxima, int fuerza, int resistencia) {
        super(nombre, nivel, vidaMaxima);
        if (fuerza <= 0)
            throw new IllegalArgumentException("La fuerza debe ser mayor a 0.");
        if (resistencia <= 0)
            throw new IllegalArgumentException("La resistencia debe ser mayor a 0.");
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    /* Getters */
    public int getFuerza() {
        return fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void atacar(Enemigo e) {
        if (getArma() != null && !getArma().estaRota()) {
            int danioFinal = fuerza + getArma().getDanio();
            System.out.println(nombre + " ataca a " + e.getNombre() + " con su arma " + getArma().getNombre()
                    + " infligiendo " + danioFinal + " puntos de daño.");
            e.recibirDanio(danioFinal);
            getArma().reducirDurabilidad(1);
        } else {
            System.out.println(
                    nombre + " ataca a " + e.getNombre() + " con sus manos infligiendo " + fuerza + " puntos de daño.");
            e.recibirDanio(fuerza);
        }
    }

    @Override
    public void bloquear() {
        setBloqueando(true);
        int defensaTotal = this.defensa + this.resistencia;
        System.out.println(nombre + " bloquea el ataque. Defensa total: " + defensaTotal);
    }

    @Override
    public String toString() {
        return "=============== Guerrero ===============\n" +
                "Nombre: " + nombre + "\n" +
                "Nivel: " + nivel + "\n" +
                "Vida: " + vidaActual + "/" + vidaMaxima + "\n" +
                "Daño: " + danio + "\n" +
                "Defensa: " + defensa + "\n" +
                "Arma: " + (getArma() != null ? getArma().getNombre() : "Ninguna") + "\n" +
                "Armadura: " + (getArmadura() != null ? getArmadura().getNombre() : "Ninguna") + "\n" +
                "Consumible: " + (getConsumible() != null ? getConsumible().getNombre() : "Ninguno") + "\n" +
                "=========================================";
    }
}
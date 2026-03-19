package personajes;

import ExcepcionesPersonalizadas.ManaInsuficienteException;
import enemigos.Enemigo;
import items.Arma;

public class Guerrero extends Personaje {
    private int fuerza;
    private int resistencia;

    public Guerrero(String nombre, int nivel, int vidaMaxima, int fuerza, int resistencia) {
        super(nombre, nivel, vidaMaxima);
        if (fuerza <= 0) throw new IllegalArgumentException("La fuerza debe ser mayor a 0.");
        if (resistencia <= 0) throw new IllegalArgumentException("La resistencia debe ser mayor a 0.");
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    @Override
    public void atacar(Enemigo e) throws ManaInsuficienteException {
        Arma armaEquipada = getArma(); 
        if (armaEquipada != null && !armaEquipada.estaRota()) {
            int danioFinal = fuerza + armaEquipada.getDanio();
            System.out.println(nombre + " ataca a " + e.getNombre() + " con " + armaEquipada.getNombre() + " infligiendo " + danioFinal);
            e.recibirDanio(danioFinal);
            armaEquipada.reducirDurabilidad(1);
        } else {
            System.out.println(nombre + " ataca con sus manos infligiendo " + fuerza);
            e.recibirDanio(fuerza);
        }
    }

    @Override
    public void bloquear() {
        setBloqueando(true);
        System.out.println(nombre + " se prepara para resistir el golpe.");
    }

    @Override
    public String toString() {
        Arma a = getArma();
        return "=============== Guerrero ===============\n" +
                "Nombre: " + nombre + "\n" +
                "Vida: " + vidaActual + "/" + vidaMaxima + "\n" +
                "Arma: " + (a != null ? a.getNombre() : "Ninguna") + "\n" +
                "========================================";
    }
}

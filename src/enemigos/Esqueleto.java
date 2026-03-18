package enemigos;

import personajes.Personaje;

public class Esqueleto extends Enemigo {

    public Esqueleto(int nivel) {
        super("Esqueleto", nivel, nivel * 10, 5);
    }

    @Override
    public void atacar(Personaje p) {
        int danio = getDanio();
        System.out.println("El esqueleto ataca a " + p.getNombre());
        p.recibirDanio(danio);
    }

    @Override
    public String toString() {
        return "========= Esqueleto =========\n" +
                "Nivel: " + getNivel() + "\n" +
                "Vida: " + getVida() + "\n" +
                "Daño: " + getDanio() + "\n" +
                "Experiencia Otorgada: " + getExperienciaOtorgada() + "\n" +
                "===============================";
    }
}

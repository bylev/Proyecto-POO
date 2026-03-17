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
        return "Esqueleto: " + getNombre() +
                "\nNivel: " + getNivel() +
                "\nVida: " + getVida() +
                "\nDaño: " + getDanio() +
                "\nExperiencia Otorgada: " + getExperienciaOtorgada();
    }
}

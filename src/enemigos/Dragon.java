package enemigos;

import personajes.Personaje;

public class Dragon extends Enemigo {

    public Dragon(int nivel) {
        super("Dragón", nivel, nivel * 50, 20);
    }

    @Override
    public void atacar(Personaje p) {
        int danio = getDanio();
        System.out.println("El dragón escupe una ráfaga de fuego a " + p.getNombre());
        p.recibirDanio(danio);
    }

    @Override
    public String toString() {
        return "Dragón: " + getNombre() +
                "\nNivel: " + getNivel() +
                "\nVida: " + getVida() +
                "\nDaño: " + getDanio() +
                "\nExperiencia Otorgada: " + getExperienciaOtorgada();
    }
}

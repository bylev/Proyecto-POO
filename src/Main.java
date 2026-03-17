import items.Arma;
import items.Armadura;
import items.Consumible;
import personajes.*;
import enemigos.*;

public class Main {
    public static void main(String[] args) {

        Personaje g = new Guerrero("Aragorn", 5, 100, 10, 10);
        Personaje m = new Mago("Gandalf", 5, 100, 100);

        Arma espada = new Arma("Espada", 1, 15, 100);
        Armadura cota = new Armadura("Cota de Malla", 1, 5, 100);
        Consumible pocionG = new Consumible("Pocion", 1, 30, "Vida");

        Consumible pocionM = new Consumible("Pocion", 3, 30, "Vida");

        Dragon d = new Dragon(8);
        Esqueleto e = new Esqueleto(8);

        g.setArma(espada);
        g.setArmadura(cota);
        g.setConsumible(pocionG);

        m.setConsumible(pocionM);

        System.out.println(g);
        System.out.println(m);

        System.out.println("\n==== PELEA ====");

        g.atacar(d);
        m.atacar(e);

        System.out.println("\n--- Enemigos atacan ---");
        d.atacar(g);
        d.atacar(m);
        e.atacar(g);
        e.atacar(m);

        System.out.println("\n--- Usar pociones ---");
        g.getConsumible().usar();
        m.getConsumible().usar();
        m.getConsumible().usar();
        m.getConsumible().usar();
        m.getConsumible().usar();

        System.out.println("\n==== ESTADO FINAL ====");
        System.out.println("Aragorn vivo: " + g.estaVivo());
        System.out.println("Gandalf vivo: " + m.estaVivo());
        System.out.println(g.toString());
        System.out.println(m.toString());
    }
}
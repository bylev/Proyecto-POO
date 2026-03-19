import items.Arma;
import items.Armadura;
import items.Consumible;
import modelo.SistemaJuego;
import excepciones.*;
import personajes.*;
import enemigos.*;

public class Main {
    public static void main(String[] args) throws ManaInsuficienteException, ObjetoNoPosibleException {

        SistemaJuego juego = new SistemaJuego("Mundo RPG");

        Guerrero aragorn = new Guerrero("Aragorn", 5, 100, 10, 10);
        Mago gandalf = new Mago("Gandalf", 5, 100, 100);
        Dragon dragon = new Dragon(8);
        Esqueleto esqueleto = new Esqueleto(8);

        juego.registrarPersonaje(aragorn);
        juego.registrarPersonaje(gandalf);
        juego.registrarEnemigo(dragon);
        juego.registrarEnemigo(esqueleto);

        Arma espada = new Arma("Espada", 1, 15, 100);
        Armadura cota = new Armadura("Cota de Malla", 1, 5, 100);
        Consumible pocG = new Consumible("Pocion", 1, 30);
        Consumible pocM = new Consumible("Pocion", 3, 30);

        juego.darArma(aragorn, espada);
        juego.darArmadura(aragorn, cota);
        juego.darConsumible(aragorn, pocG);
        juego.darConsumible(gandalf, pocM);

        juego.equiparItem(aragorn, espada);
        juego.equiparItem(aragorn, cota);
        juego.equiparItem(aragorn, pocG);
        juego.equiparItem(gandalf, pocM);

        // mostrar inventario
        juego.mostrarInventario(aragorn);
        juego.mostrarInventario(gandalf);

        juego.mostrarEstado();

        juego.iniciarBatalla(aragorn, dragon);
        juego.iniciarBatalla(gandalf, esqueleto);

        // usar consumible
        juego.usarConsumible(aragorn);
        juego.usarConsumible(gandalf);

        juego.mostrarEstado();
        juego.getTotalBatallas();
    }
}
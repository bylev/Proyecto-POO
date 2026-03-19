import items.Arma;
import items.Armadura;
import items.Consumible;
import Sistema.SistemaJuego;
import excepciones.ManaInsuficienteException;
import excepciones.ObjetoNoPosibleException;
import personajes.Guerrero;
import personajes.Mago;
import enemigos.Dragon;
import enemigos.Esqueleto;

/**
 * Clase principal del juego RPG por consola.
 * 
 * Demuestra el uso de:
 * - Herencia y clases abstractas (Personaje, Enemigo)
 * - Interfaces (Vida, Durable)
 * - Polimorfismo (atacar, bloquear, equiparEn)
 * - Manejo de excepciones personalizadas (ManaInsuficienteException,
 * ObjetoNoPosibleException)
 * - Composición (SistemaJuego -> GestorPersonajes, GestorEnemigos,
 * GestorBatallas)
 * - Inventario por personaje
 */
public class Main {

    public static void main(String[] args) {

        SistemaJuego juego = new SistemaJuego("Mundo RPG");

        Guerrero aragorn = new Guerrero("Aragorn", 5, 100, 10, 10);
        Mago gandalf = new Mago("Gandalf", 5, 100, 100);

        juego.registrarPersonaje(aragorn);
        juego.registrarPersonaje(gandalf);

        Dragon dragon = new Dragon(8);
        Esqueleto esqueleto = new Esqueleto(8);

        juego.registrarEnemigo(dragon);
        juego.registrarEnemigo(esqueleto);

        Arma espada = new Arma("Espada de Hierro", 1, 15, 100);
        Armadura cota = new Armadura("Cota de Malla", 1, 5, 100);
        Consumible pocG = new Consumible("Poción de Vida", 1, 30);
        Consumible pocM = new Consumible("Poción de Mana", 3, 30);

        juego.darArma(aragorn, espada);
        juego.darArmadura(aragorn, cota);
        juego.darConsumible(aragorn, pocG);
        juego.darConsumible(gandalf, pocM);

        try {
            juego.equiparItem(aragorn, espada);
            juego.equiparItem(aragorn, cota);
            juego.equiparItem(aragorn, pocG);
            juego.equiparItem(gandalf, pocM);
        } catch (ObjetoNoPosibleException e) {
            System.out.println("[ERROR al equipar] " + e.getMessage());
        }

        juego.mostrarInventario(aragorn);
        juego.mostrarInventario(gandalf);

        juego.mostrarEstado();
        try {
            juego.iniciarBatalla(aragorn, dragon);
        } catch (ManaInsuficienteException e) {
            System.out.println("[ERROR en batalla] " + e.getMessage());
        }

        try {
            juego.iniciarBatalla(gandalf, esqueleto);
        } catch (ManaInsuficienteException e) {
            System.out.println("[ERROR en batalla] " + e.getMessage());
        }

        try {
            juego.usarConsumible(aragorn);
        } catch (ObjetoNoPosibleException e) {
            System.out.println("[ERROR al usar consumible - Aragorn] " + e.getMessage());
        }

        try {
            juego.usarConsumible(gandalf);
        } catch (ObjetoNoPosibleException e) {
            System.out.println("[ERROR al usar consumible - Gandalf] " + e.getMessage());
        }

        juego.mostrarEstado();

        System.out.println("\n>>> Total de batallas registradas: " + juego.getTotalBatallas());
    }
}
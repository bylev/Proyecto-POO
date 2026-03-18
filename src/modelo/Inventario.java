package modelo;

import java.util.ArrayList;
import items.Arma;
import items.Armadura;
import items.Consumible;

public class Inventario {
    private ArrayList<Arma> armas = new ArrayList<>();
    private ArrayList<Armadura> armaduras = new ArrayList<>();
    private ArrayList<Consumible> consumibles = new ArrayList<>();

    public void agregarArma(Arma a) {
        if (a == null)
            throw new IllegalArgumentException("Debe haber un arma para agregar.");
        armas.add(a);
        System.out.println("Arma agregada: " + a.toString());
    }

    public void agregarArmadura(Armadura a) {
        if (a == null)
            throw new IllegalArgumentException("Debe haber una armadura para agregar.");
        armaduras.add(a);
        System.out.println("Armadura agregada: " + a.toString());
    }

    public void agregarConsumible(Consumible c) {
        if (c == null)
            throw new IllegalArgumentException("Debe haber un consumible para agregar.");
        consumibles.add(c);
        System.out.println("Consumible agregado: " + c.toString());
    }

    // Getters
    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public ArrayList<Armadura> getArmaduras() {
        return armaduras;
    }

    public ArrayList<Consumible> getConsumibles() {
        return consumibles;
    }

    /* Tamaño inventario */
    public int getTamanoArmas() {
        return armas.size();
    }

    public int getTamanoArmaduras() {
        return armaduras.size();
    }

    public int getTamanoConsumibles() {
        return consumibles.size();
    }

}

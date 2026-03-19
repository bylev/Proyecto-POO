package Sistema;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import enemigos.Enemigo;

public class GestorEnemigos {

    private List<Enemigo> enemigos = new ArrayList<>();

    public void registrarEnemigo(Enemigo e) {
        if (e == null)
            throw new IllegalArgumentException("Debe haber un enemigo para registrar.");
        enemigos.add(e);
        System.out.println("Enemigo registrado: " + e.getNombre());
    }

    public void eliminarEnemigo(Enemigo e) {
        if (e == null)
            return;
        boolean eliminado = enemigos.remove(e);
        if (eliminado)
            System.out.println("Enemigo eliminado: " + e.getNombre());
    }

    // ELIMINAR CON ITERATOR:
    // 1- Elimina los enemigos muertos

    public void eliminarEnemigosMuertos() {
        Iterator<Enemigo> it = enemigos.iterator();
        while (it.hasNext()) {
            Enemigo e = it.next();
            if (!e.estaVivo()) {
                System.out.println("Eliminado: " + e.getNombre());
                it.remove();
            }
        }
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }
}

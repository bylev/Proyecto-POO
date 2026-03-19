package Sistema;

import enemigos.Enemigo;
import excepciones.ManaInsuficienteException;
import excepciones.ObjetoNoPosibleException;
import personajes.Personaje;

public class GestorBatallas {

    private static int totalBatallas = 0;

    public void iniciarBatalla(Personaje p, Enemigo e) throws ManaInsuficienteException {
        if (p == null || e == null) {
            throw new IllegalArgumentException("El personaje y el enemigo no pueden ser nulos.");
        }
        if (!p.estaVivo()) {
            throw new IllegalStateException("No se puede iniciar la batalla porque el personaje no está vivo.");
        }

        totalBatallas++;

        System.out.println("\n=============== BATALLA INICIADA ===============");
        System.out.println("\nBatalla #" + totalBatallas + ": " + p.getNombre() + " vs " + e.getNombre());
        System.out.println("\n================================================");

        // Turno del personaje
        try {
            p.atacar(e);
        } catch (ManaInsuficienteException ex) {
            System.out.println("[GestorBatallas] " + ex.getMessage() + " — el personaje pierde su turno.");
        }

        // Turno del enemigo (solo si sigue vivo)
        if (e.estaVivo()) {
            e.atacar(p);
        } else {
            System.out.println("\n=============== BATALLA TERMINADA ===============");
            System.out.println("\n" + p.getNombre() + " ha ganado la batalla.");
            System.out.println("\nExperiencia otorgada: " + e.getExperienciaOtorgada() + " puntos.");
            System.out.println("\n================================================");
        }

        System.out.println("\n ====================== Resultado ======================");
        System.out.println("\n" + p.toString());
        System.out.println("\n" + e.toString());
        System.out.println("\n========================================================");
    }

    public void usarConsumible(Personaje p) throws ObjetoNoPosibleException {
        if (p == null)
            throw new IllegalArgumentException("El personaje no puede ser nulo.");
        if (!p.estaVivo()) {
            throw new IllegalStateException("No se puede usar consumible porque el personaje no está vivo.");
        }
        if (p.getConsumible() == null || p.getConsumible().getCantidad() <= 0) {
            throw new ObjetoNoPosibleException("No hay consumible disponible para usar.");
        }
        p.getConsumible().usar();
        System.out.println("Se ha usado el consumible " + p.getConsumible().getNombre()
                + " de " + p.getNombre() + ".");
        System.out.println("Vida actual de " + p.getNombre() + ": "
                + p.getVidaActual() + "/" + p.getVidaMaxima());
        System.out.println("Consumibles restantes: " + p.getConsumible().getCantidad());
    }

    public int getTotalBatallas() {
        return totalBatallas;
    }
}

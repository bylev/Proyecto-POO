package interfaces;

public interface Durable {
    void reducirDurabilidad(int cantidad);

    boolean estaRota();
}

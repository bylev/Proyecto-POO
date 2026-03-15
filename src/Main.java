import rpg.Juego;

public class Main{
	public static void main(String[] args){
		Juego juego = new Juego();
		juego.crearJugador(3);
		juego.sortearItem();
		juego.iniciarCombate();
		juego.guardarPartida();
	}
}

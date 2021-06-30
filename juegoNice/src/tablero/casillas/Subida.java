package tablero.casillas;

import Visual.visualTablero.VisualTablero;
import jugador.Player;

public class Subida extends Casilla{
    public int xFinal;
    public int yFinal;
    public Subida(int x, int y, int xFinal, int yFinal, int numeroCasilla) {
        super(x, y, numeroCasilla);
        this.xFinal = xFinal;
        this.yFinal = yFinal;
    }

    @Override
    public void accion(Player jugador) {
        jugador.colocarJugador(VisualTablero.casillasVisuales[yFinal][xFinal]);
    }
}
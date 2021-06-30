package tablero.casillas;

import Visual.visualTablero.VisualTablero;
import jugador.Player;

public class CasillaFinal extends Casilla{

    public CasillaFinal(int x, int y, int numeroCasilla) {
        super(x, y, numeroCasilla);
    }

    @Override
    public void accion(Player jugador) {
        VisualTablero.ganador = true;
        jugador.ganador = true;
        jugador.sumarPartidasWin();
        jugador.sumarPartidasJugadas();
    }
}
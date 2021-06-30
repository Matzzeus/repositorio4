package tablero.casillas;

import jugador.Player;

public class PierdeTurno extends Casilla{
    public PierdeTurno(int x, int y, int numeroCasilla) {
        super(x, y, numeroCasilla);
    }

    @Override
    public void accion(Player jugador) {
        jugador.turnoPerdido = 1;
    }
}
package tablero.casillas;

import jugador.Player;

public class CasillaNula extends Casilla{


    public CasillaNula(int x, int y, int numeroCasilla) {
        super(x, y, numeroCasilla);
    }

    @Override
    public void accion(Player jugador) {

    }
}
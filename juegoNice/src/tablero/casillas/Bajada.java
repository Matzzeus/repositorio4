<<<<<<< HEAD
package tablero.casillas;

import Visual.visualTablero.VisualTablero;
import jugador.Player;

public class Bajada extends Casilla{
    public int xFinal;
    public int yFinal;
    public Bajada(int x, int y, int xFinal, int yFinal, int numeroCasilla) {
        super(x, y, numeroCasilla);
        this.xFinal = xFinal;
        this.yFinal = yFinal;
    }

    @Override
    public void accion(Player jugador) {
        jugador.colocarJugador(VisualTablero.casillasVisuales[yFinal][xFinal]);

    }
}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablero.casillas;

/**
 *
 * @author Matzzeus
 */
public class Bajada {
    
}
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

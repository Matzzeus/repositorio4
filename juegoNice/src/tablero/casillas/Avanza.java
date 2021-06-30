<<<<<<< HEAD
package tablero.casillas;

import Visual.visualTablero.VisualCasillas;
import Visual.visualTablero.VisualTablero;
import jugador.Player;
import tablero.Tablero;

public class Avanza extends Casilla{
    public int posicion;
    public Avanza(int x, int y, int posicion, int numeroCasilla) {
        super(x, y, numeroCasilla);
        this.posicion = posicion;
    }

    @Override
    public void accion(Player jugador) {
        boolean encontrado = false;
        Casilla[][] tablero = VisualTablero.tablero.getCasillas();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j].getNumeroCasilla() == jugador.casillaActual.referencia.getNumeroCasilla() + posicion){

                    jugador.colocarJugador(VisualTablero.casillasVisuales[i][j]);
                    encontrado = true;
                    break;
                }
            }
            if(encontrado){
                break;
            }
        }
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
public class Avanza {
    
}
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

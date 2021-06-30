package tablero.casillas;

import Visual.visualTablero.VisualTablero;
import jugador.ArregloPlayer;
import jugador.Player;

import javax.swing.*;

public class TiraDados extends Casilla{
    public TiraDados(int x, int y, int numeroCasilla) {
        super(x, y, numeroCasilla);
    }

    @Override
    public void accion(Player jugador) {
        for (int i = 0; i < ArregloPlayer.cantidadPlayersPartida; i++) {
            if(ArregloPlayer.jugadoresPartida[i].turno = true){
                ArregloPlayer.jugadoresPartida[i].turnoJugador(VisualTablero.informacion);
                if(i-1 < 0){
                    ArregloPlayer.jugadoresPartida[i].turno = false;
                    ArregloPlayer.jugadoresPartida[ArregloPlayer.cantidadPlayersPartida - 1].turno = true;
                }
                else{
                    ArregloPlayer.jugadoresPartida[i].turno = false;
                    ArregloPlayer.jugadoresPartida[i-1].turno = true;
                }
                break;
            }
        }
    }
}
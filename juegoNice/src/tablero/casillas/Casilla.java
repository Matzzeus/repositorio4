<<<<<<< HEAD
package tablero.casillas;

import jugador.Player;

import javax.swing.*;

public abstract class Casilla extends JPanel {
    
    protected int x;
    protected int y;
    protected int numeroCasilla;

    public Casilla(int x, int y, int numeroCasilla){
        this.x = x;
        this.y = y;
        this.numeroCasilla = numeroCasilla;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public abstract void accion(Player jugador);

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
public class Casilla {
    
}
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

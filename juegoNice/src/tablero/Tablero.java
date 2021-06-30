<<<<<<< HEAD
package tablero;

import Visual.visualTablero.VisualTablero;
import tablero.casillas.*;

import javax.swing.*;

public class Tablero implements Runnable{
    public int tiempoActual = 0;
    private int x;
    private int y;
    private Casilla[][] casillas;
    Thread t = new Thread(this);

    public Tablero(int x, int y){
        this.x = x;
        this.y = y;
        casillas = new Casilla[y][x];
        llenarTablero();
    }

    public void llenarTablero(){
        int n = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(i == (y - 1) && j == (x - 1)){
                    casillas[i][j] = new CasillaFinal(j,i,n);
                }
                else{
                    casillas[i][j] = new CasillaNula(j,i,n);
                }
                n++;
            }
        }
    }

    public void casillaAvanzar(int x, int y, int posicion){
        if(x < this.x && y < this.y){
            int n = casillas[y][x].getNumeroCasilla();
            casillas[y][x] = new Avanza(x, y , posicion, n);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes una casilla fuera del tablero :3");
        }

    }

    public void casillaRetroceder(int x, int y, int posicion){
        if(x < this.x && y < this.y){
            int n = casillas[y][x].getNumeroCasilla();
            casillas[y][x] = new Retrocede(x,y, posicion, n);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes una casilla fuera del tablero :3");
        }

    }

    public void casillaPierdeTurno(int x, int y){
        if(x < this.x && y < this.y){
            int n = casillas[y][x].getNumeroCasilla();
            casillas[y][x] = new PierdeTurno(x,y, n);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes una casilla fuera del tablero :3");
        }

    }

    public void casillaTiraDados(int x, int y){
        if(x < this.x && y < this.y){
            int n = casillas[y][x].getNumeroCasilla();
            casillas[y][x] = new TiraDados(x,y, n);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes una casilla fuera del tablero :3");
        }

    }

    public void casillaSubir(int x, int y, int xFinal, int yFinal){
        if(x < this.x && y < this.y){
            int n = casillas[y][x].getNumeroCasilla();
            casillas[y][x] = new Subida(x,y,xFinal,yFinal, n);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes una casilla fuera del tablero :3");
        }

    }

    public void casillaBajar(int x, int y, int xFinal, int yFinal){
        if(x < this.x && y < this.y){
            int n = casillas[y][x].getNumeroCasilla();
            casillas[y][x] = new Bajada(x,y,xFinal,yFinal, n);
        }
        else{
            JOptionPane.showMessageDialog(null, "No puedes una casilla fuera del tablero :3");
        }

    }

    public void correrTiempo(){
        tiempoActual = 0;
        t.interrupt();
        t = new Thread(this);
        t.start();
    }

    public void pararTiempo(){
        tiempoActual = 0;
        t.interrupt();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void run() {
        while (tiempoActual < 100000){
            if(Thread.currentThread().isInterrupted()){
                break;
            }
            tiempoActual++;
            VisualTablero.setHP(tiempoActual);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
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
package tablero;

/**
 *
 * @author Matzzeus
 */
public class Tablero {
    
}
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

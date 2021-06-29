package jugador;

import Visual.Pintar;
import Visual.visualTablero.VisualCasillas;
import Visual.visualTablero.VisualTablero;
import tablero.casillas.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class Player implements Serializable, Pintar, ActionListener {
    private final int ID;
    private final String NOMBRE;
    private final String APELLIDO;
    private int partidasJugadas = 0;
    private int partidasWin = 0;
    private int partidasLose = 0;
    public VisualCasillas casillaActual;
    JButton botonPlayer = new JButton();
    public boolean turno = false;
    public boolean ganador = false;
    public int turnoPerdido = 0;

    public Player(int id, String nombre, String apellido){
        this.ID = id;
        this.NOMBRE = nombre;
        this.APELLIDO = apellido;
        botonPlayer.setPreferredSize(new Dimension(25,25));
        botonPlayer.setText(nombre.substring(0,1));
        pintarBoton(botonPlayer);
        botonPlayer.addActionListener(this);
    }

    public void colocarJugador(VisualCasillas actual){
        casillaActual.panelCentral.remove(botonPlayer);
        casillaActual = actual;
        casillaActual.panelCentral.add(botonPlayer);
        //casillaActual.referencia.accion(this);
    }

    public void turnoJugador(JTextArea informacion){
        if(turnoPerdido == 0){
            tirarDados(informacion);
        }
        else{
            turnoPerdido=0;
        }
    }

    public void tirarDados(JTextArea informacion){
        int numeroDado = generaNumeroR(1,6);
        boolean encontrado = false;
        Casilla[][] tablero = VisualTablero.tablero.getCasillas();
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j].getNumeroCasilla() == casillaActual.referencia.getNumeroCasilla() + numeroDado){
                    colocarJugador(VisualTablero.casillasVisuales[i][j]);
                    String info = informacion.getText();
                    String tipoCasilla = compararCasillas(casillaActual.referencia);
                    informacion.setText(info + "El número del dado es " + numeroDado + "\n" + NOMBRE +" se movio a la casilla: " + casillaActual.referencia.getNumeroCasilla() + "\n" + tipoCasilla);
                    casillaActual.referencia.accion(this);
                    if(!(casillaActual.referencia instanceof CasillaNula) && !(casillaActual.referencia instanceof PierdeTurno) && !(casillaActual.referencia instanceof TiraDados)){
                        info = informacion.getText();
                        tipoCasilla = compararCasillas(casillaActual.referencia);
                        informacion.setText(info + "La anterior casillas movio la ficha a la casillas:  " + casillaActual.referencia.getNumeroCasilla() + "\n" + tipoCasilla);
                    }
                    encontrado = true;
                    break;
                }
            }
            if(encontrado){
                break;
            }
        }
    }

    public String compararCasillas(Casilla casilla){
        String a = "";
        if(casilla instanceof CasillaNula){
            a = "Casilla Normal: no ocurre nada...";
        }
        else if(casilla instanceof Avanza){
            a = "Casilla Avanzar: avanzas " + ((Avanza) casilla).posicion + " casillas";
        }
        else if(casilla instanceof Retrocede){
            a = "Casilla Retroceder: retrocedes " + ((Retrocede) casilla).posicion + " casillas";
        }
        else if(casilla instanceof PierdeTurno){
            a = "Pierde Turno: Perdiste un turno en la siguiente vuelta";
        }
        else if(casilla instanceof TiraDados){
            a = "Tira Dados: puedes volver a tirar los Dados";
        }
        else if(casilla instanceof Subida){
            a = "Casilla Subir: Subiste hacia la casilla " + casilla.getNumeroCasilla();
        }
        else if(casilla instanceof Bajada){
            a = "Casilla Bajar: Bajaste hacia la casilla " + casilla.getNumeroCasilla();
        }
        return a;
    }


    public void setActual(VisualCasillas actual) {
        this.casillaActual = actual;
    }

    public void sumarPartidasJugadas() {
        this.partidasJugadas++;
    }

    public void sumarPartidasWin() {
        this.partidasWin++;
    }

    public void sumarPartidasLose() {
        this.partidasLose++;
    }

    public int getID() {
        return ID;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasWin() {
        return partidasWin;
    }

    public int getPartidasLose() {
        return partidasLose;
    }

    public int generaNumeroR(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;

    }

    @Override
    public void pintarBoton(JButton boton) {
        boton.setBorder(new LineBorder(Color.BLACK));
        if(ID == 1){
            boton.setBackground(Color.RED);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 2){
            boton.setBackground(Color.BLUE);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 3){
            boton.setBackground(Color.YELLOW);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 4){
            boton.setBackground(Color.MAGENTA);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 5){
            boton.setBackground(Color.ORANGE);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 6){
            boton.setBackground(Color.GREEN);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 7){
            boton.setBackground(Color.GRAY);
            boton.setForeground(Color.WHITE);
        }
        else if(ID == 8){
            boton.setBackground(Color.BLACK);
            boton.setForeground(Color.WHITE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonPlayer){
            JOptionPane.showMessageDialog(null, "Jugador id " + ID +"\nNombre " + NOMBRE + "\nApellidos " + APELLIDO + "\nCasilla Actual " + casillaActual.referencia.getNumeroCasilla());
        }
    }
}
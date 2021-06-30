/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Lectura.GuardarObj;
import Lectura.TextLectura;
import Lectura.LeerObj;
import Visual.opcionesMenu.Visual_Jugar;
import Visual.opcionesMenu.VisualReportes;
import jugador.ArregloPlayer;
import jugador.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


     public class VisualMenu extends  javax.swing.JFrame implements ActionListener, Pintar{

    VisualReportes reportes = new VisualReportes();
    Visual_Jugar juego = new Visual_Jugar();
    JPanel panelCentral = new JPanel();
    JPanel panelJugar = new JPanel();
    JPanel panelCrearJugador = new JPanel();
    JPanel panelReportes = new JPanel();
    JPanel panelSalir = new JPanel();
    JButton botonJugar = new JButton();
    JButton botonCrearJugador = new JButton();
    JButton botonReportes = new JButton();
    JButton botonSalir = new JButton();

    JPanel panelRegresar = new JPanel();
    JButton botonRegresar = new JButton();
    JLabel menu = new JLabel("", SwingConstants.CENTER);

    public void marco(){
        this.setSize(675,400);
        this.setLocationRelativeTo(null);
        this.crearElementos();
        this.setTitle("Serpientes y Escaleras");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    private void crearElementos() {
        LeerObj.abrirObj("Jugadores");
        menu.setLayout(new BorderLayout());
       
        menu.setText(".................MENU INICIAL................");
        menu.setForeground(Color.BLACK);
        panelCentral.setLayout(new GridLayout(5,1));

        botonJugar.setPreferredSize(new Dimension(160,35));
        botonCrearJugador.setPreferredSize(new Dimension(160,35));
        botonReportes.setPreferredSize(new Dimension(160,35));
        botonSalir.setPreferredSize(new Dimension(160,35));
        botonRegresar.setPreferredSize(new Dimension(160,30));

        botonJugar.setText("JUGAR");
        botonCrearJugador.setText("Ingresar Jugador");
        botonReportes.setText("Reportes");
        botonSalir.setText("Salir");
        botonRegresar.setText("Regresar");
        botonRegresar.setVisible(false);

        pintarBoton(botonJugar);
        pintarBoton(botonCrearJugador);
        pintarBoton(botonReportes);
        pintarBoton(botonSalir);
        pintarBoton(botonRegresar);

        panelJugar.add(botonJugar);
        panelCrearJugador.add(botonCrearJugador);
        panelReportes.add(botonReportes);
        panelSalir.add(botonSalir);
        panelRegresar.add(botonRegresar);

        panelCentral.add(menu);
        panelCentral.add(panelJugar);
        panelCentral.add(panelCrearJugador);
        panelCentral.add(panelReportes);
        panelCentral.add(panelSalir);

        this.getContentPane().add(panelCentral, BorderLayout.CENTER);
        this.getContentPane().add(panelRegresar, BorderLayout.SOUTH);

        botonJugar.addActionListener(this);
        botonCrearJugador.addActionListener(this);
        botonReportes.addActionListener(this);
        botonSalir.addActionListener(this);
        botonRegresar.addActionListener(this);
    }

    @Override
    public void pintarBoton(JButton boton) {
        boton.setBackground(Color.GREEN);
        boton.setForeground(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonJugar){
            int jugadoresTablero = getIntRango("Ingresar la cantidad de jugadores que jugaran   ", ArregloPlayer.cantidadPlayers);
            for (int i = 0; i < jugadoresTablero; i++) {
                int posicion = getIntRango(ArregloPlayer.mostrarJugadores() + "Ingresa que jugador entrara",ArregloPlayer.cantidadPlayers);
                ArregloPlayer.agregarPlayersPartida(posicion);
            }
            this.getContentPane().remove(panelCentral);
            this.getContentPane().add(juego, BorderLayout.CENTER);
            botonRegresar.setVisible(true);
            SwingUtilities.updateComponentTreeUI(this);
        }
        else if(e.getSource() == botonCrearJugador){
            String nombre = getString("Ingresa el nombre del Jugador");
            String apellido = getString("Ingresa el apellido del Jugador");
            if(nombre != null && apellido != null){
                ArregloPlayer.agregarPlayers(nombre, apellido);
            }
        }
        else if(e.getSource() == botonReportes){
            this.getContentPane().remove(panelCentral);
            this.getContentPane().add(reportes, BorderLayout.CENTER);
            reportes.llenarFilas();
            reportes = new VisualReportes();
            botonRegresar.setVisible(true);
            SwingUtilities.updateComponentTreeUI(this);
        }
        else if(e.getSource() == botonSalir){
            for (int i = 0; i < ArregloPlayer.cantidadPlayers; i++) {
                GuardarObj.GuardarObj(ArregloPlayer.jugadores[i]);
            }
            JOptionPane.showMessageDialog(null,"Adios :3");
            System.exit(0);
        }
        else if(e.getSource() == botonRegresar){
            this.getContentPane().removeAll();
            this.getContentPane().add(panelCentral, BorderLayout.CENTER);
            this.getContentPane().add(panelRegresar, BorderLayout.SOUTH);
            botonRegresar.setVisible(false);
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

    public int getIntRango(String titulo, int rango){
        String n = "";
        while(n.equals("")){
            n = JOptionPane.showInputDialog(titulo);
            if(!n.matches("[1-"+ rango +"]*$")){
                n = "";
            }
        }
        return Integer.parseInt(n);
    }

    public String getString(String titulo){
        String n = "";
        while(n.equals("")){
            n = JOptionPane.showInputDialog(titulo);
            if(!n.matches("[A-Za-z Á-Źá-ź]*$")){
                n = "";
            }
        }
        return n;
    }


}
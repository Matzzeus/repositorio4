<<<<<<< HEAD
package Visual.visualTablero;

import Visual.Pintar;
import jugador.ArregloPlayer;
import tablero.Tablero;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualTablero extends JFrame implements ActionListener, Pintar {
    public static Tablero tablero;
    public static VisualCasillas[][] casillasVisuales;
    public static boolean ganador = false;
    public static Object Tablero;
    int x = 0;
    int y = 0;
    JPanel panelNorte = new JPanel(new GridLayout());
    JPanel panelSur = new JPanel();
    JPanel panelEste = new JPanel();
    JPanel panelOeste = new JPanel();
    JPanel panelTablero = new JPanel();
    static JLabel tiempo = new JLabel("", SwingConstants.RIGHT);
    public static JTextArea informacion = new JTextArea();
    public static JTextArea turno = new JTextArea();
    JScrollPane scrollPane = new JScrollPane();
    JButton tirarDados = new JButton("Tirar Dados");
    JPanel panelTirarDados = new JPanel();
    JPanel panelTurno = new JPanel();
    JPanel panelInformacion = new JPanel();

    public void marco(){
        this.setSize(1000,600);
        this.setLocationRelativeTo(null);
        this.crearElementos();
        this.setTitle("Serpientes y Escaleras");
        this.setVisible(true);
    }

    public void crearElementos() {

        y = tablero.getY() - 1;
        casillasVisuales = new VisualCasillas[tablero.getY()][tablero.getX()];
        scrollPane.setBounds(50, 30, 300, 50);
        panelSur.setLayout(new GridLayout(1,3));
        informacion.setPreferredSize(new Dimension(280, 100));
        turno.setPreferredSize(new Dimension(120, 20));
        tablero.correrTiempo();
        tiempo.setText("Tiempo de Partida: " + tablero.tiempoActual + "    ");
        tiempo.setForeground(Color.WHITE);
        pintarBoton(tirarDados);
        tirarDados.setPreferredSize(new Dimension(150,35));
        scrollPane.setViewportView(panelTablero);
        panelTablero.setLayout(new GridLayout(tablero.getY(),tablero.getX()));
        panelTirarDados.add(tirarDados);
        panelTurno.add(turno);
        panelInformacion.add(informacion);

        for (int i = 0; i < (tablero.getX()*tablero.getY()); i++) {
            ponerCasilla();
        }

        agregarJugadores();
        iniciarTurnos();
        mostrarTurnoActual();

        panelNorte.add(tiempo);
        panelSur.add(panelInformacion);
        panelSur.add(panelTirarDados);
        panelSur.add(panelTurno);
        panelNorte.setBackground(Color.GRAY);
        panelSur.setBackground(Color.GRAY);
        panelEste.setBackground(Color.GRAY);
        panelOeste.setBackground(Color.GRAY);
        panelTablero.setBackground(Color.GRAY);
        panelTirarDados.setBackground(Color.GRAY);
        panelTurno.setBackground(Color.GRAY);
        panelInformacion.setBackground(Color.GRAY);

        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        this.getContentPane().add(panelNorte, BorderLayout.NORTH);
        this.getContentPane().add(panelSur, BorderLayout.SOUTH);
        this.getContentPane().add(panelEste, BorderLayout.EAST);
        this.getContentPane().add(panelOeste, BorderLayout.WEST);

        tirarDados.addActionListener(this);

    }

    public void iniciarTurnos(){
        int random = generaNumeroR(1,ArregloPlayer.cantidadPlayersPartida);
        ArregloPlayer.jugadoresPartida[random - 1].turno=true;
    }

    public void mostrarTurnoActual(){
        for (int i = 0; i < ArregloPlayer.cantidadPlayersPartida; i++) {
            if(ArregloPlayer.jugadoresPartida[i].turno){
                turno.setText("Turno de " + ArregloPlayer.jugadoresPartida[i].getNOMBRE()+"\n");
                break;
            }
        }
    }

    public int generaNumeroR(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;

    }

    private void ponerCasilla(){

        casillasVisuales[y][x] = new VisualCasillas(tablero.getCasillas()[y][x]);
        casillasVisuales[y][x].setBorder(new LineBorder(Color.BLACK));
        panelTablero.add(casillasVisuales[y][x]);
        x++;
        if(x == tablero.getX()){
            x = 0;
            y--;
        }
    }

    private void agregarJugadores(){
        for (int i = 0; i < ArregloPlayer.cantidadPlayersPartida; i++) {
            ArregloPlayer.jugadoresPartida[i].setActual(casillasVisuales[0][0]);
            ArregloPlayer.jugadoresPartida[i].colocarJugador(casillasVisuales[0][0]);
        }

    }

    public void pintarBoton(JButton boton){
        boton.setBackground(Color.BLACK);
        boton.setForeground(Color.WHITE);
    }

    public static void setHP(int tiempoActual){
        tiempo.setText("Tiempo de Partida: " + tiempoActual + "    ");
        SwingUtilities.updateComponentTreeUI(tiempo);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == tirarDados){
            informacion.setText("");

            for (int i = 0; i < ArregloPlayer.cantidadPlayersPartida; i++) {
                if(ArregloPlayer.jugadoresPartida[i].turno){
                    ArregloPlayer.jugadoresPartida[i].turnoJugador(informacion);
                    if(i+1 == ArregloPlayer.cantidadPlayersPartida){
                        ArregloPlayer.jugadoresPartida[i].turno = false;
                        ArregloPlayer.jugadoresPartida[0].turno = true;
                    }
                    else{
                        ArregloPlayer.jugadoresPartida[i].turno = false;
                        ArregloPlayer.jugadoresPartida[i+1].turno = true;
                    }
                    break;
                }
            }

            if(ganador){
                tablero.pararTiempo();
                for (int i = 0; i < ArregloPlayer.cantidadPlayersPartida; i++) {
                    if(ArregloPlayer.jugadoresPartida[i].ganador){
                        JOptionPane.showMessageDialog(null, "Ganaste : " + ArregloPlayer.jugadoresPartida[i].getNOMBRE());
                        break;
                    }
                }
                for (int i = 0; i < ArregloPlayer.cantidadPlayersPartida; i++) {
                    if(!ArregloPlayer.jugadoresPartida[i].ganador){
                        ArregloPlayer.jugadoresPartida[i].sumarPartidasLose();
                        ArregloPlayer.jugadoresPartida[i].sumarPartidasJugadas();
                    }
                }
                ArregloPlayer.cantidadPlayersPartida = 0;
                this.setVisible(false);
            }
            mostrarTurnoActual();
            SwingUtilities.updateComponentTreeUI(this);
        }
    }

}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual.visualtablero;

/**
 *
 * @author Matzzeus
 */
public class VisualTablero {
    
}
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

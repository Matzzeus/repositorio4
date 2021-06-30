<<<<<<< HEAD
package Visual.visualTablero;

import tablero.casillas.*;
import javax.swing.*;
import java.awt.*;

public class VisualCasillas extends JPanel {
    public Casilla referencia;
    JPanel panelNorte = new JPanel();
    public JPanel panelCentral = new JPanel();
    JLabel nombreCasilla = new JLabel("", SwingConstants.CENTER);
    JLabel numeroCasilla = new JLabel("", SwingConstants.LEFT);

    public VisualCasillas(Casilla referencia){
        this.referencia = referencia;

        setLayout(new BorderLayout());
        panelNorte.setLayout(new BorderLayout());
        panelNorte.add(nombreCasilla, BorderLayout.CENTER);
        panelNorte.add(numeroCasilla, BorderLayout.WEST);
        nombreCasilla.setForeground(Color.BLACK);
        numeroCasilla.setForeground(Color.BLACK);
        if(referencia instanceof CasillaNula){
            panelNorte.setBackground(Color.CYAN);
            panelCentral.setBackground(Color.CYAN);
            nombreCasilla.setText("Casilla Normal");
        }
        else if(referencia instanceof Avanza){
            panelNorte.setBackground(Color.BLUE);
            panelCentral.setBackground(Color.BLUE);
            nombreCasilla.setText("Casilla Avanzar");
        }
        else if(referencia instanceof Retrocede){
            panelNorte.setBackground(Color.ORANGE);
            panelCentral.setBackground(Color.ORANGE);
            nombreCasilla.setText("Casilla Retroceder");
        }
        else if(referencia instanceof PierdeTurno){
            panelNorte.setBackground(Color.RED);
            panelCentral.setBackground(Color.RED);
            nombreCasilla.setText("Pierde Turno");
        }
        else if(referencia instanceof TiraDados){
            panelNorte.setBackground(Color.PINK);
            panelCentral.setBackground(Color.PINK);
            nombreCasilla.setText("Tira Dados");
        }
        else if(referencia instanceof Subida){
            panelNorte.setBackground(Color.GREEN);
            panelCentral.setBackground(Color.GREEN);
            nombreCasilla.setText("Casilla Subir");
        }
        else if(referencia instanceof Bajada){
            panelNorte.setBackground(Color.WHITE);
            panelCentral.setBackground(Color.WHITE);
            nombreCasilla.setText("Casilla Bajar");
        }
        else if(referencia instanceof CasillaFinal){
            panelNorte.setBackground(Color.BLACK);
            panelCentral.setBackground(Color.BLACK);
            nombreCasilla.setText(" FINAL ");
            nombreCasilla.setForeground(Color.WHITE);
            numeroCasilla.setForeground(Color.WHITE);
        }

        numeroCasilla.setText(" " + referencia.getNumeroCasilla());

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentral, BorderLayout.CENTER);
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
public class VisualCasillas {
    
}
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

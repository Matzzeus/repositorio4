package Visual.opcionesMenu;

import Lectura.TextLectura;
import Visual.Pintar;
import Visual.visualTablero.VisualTablero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class  Visual_Jugar extends javax.swing.JFrame implements ActionListener, Pintar{
    
    VisualTablero tablero;
    JPanel panelCargarTexto = new JPanel();
    JButton botonCargarTexto = new JButton();
    JLabel jugar = new JLabel("", SwingConstants.CENTER);

    public Visual_Jugar(){
        setLayout(new GridLayout(3,1));
        jugar.setLayout(new BorderLayout());
        jugar.setFont(new Font("Open Sans", 3, 25));
        jugar.setText("<html><br/><br/><br/>JUGAR<br/><br/><br/><br/></html>");
        jugar.setForeground(Color.BLACK);
        botonCargarTexto.setText("Cargar el tablero");
        panelCargarTexto.add(botonCargarTexto);
        botonCargarTexto.setPreferredSize(new Dimension(160,35));
        pintarBoton(botonCargarTexto);

        add(jugar);
        add(panelCargarTexto);

        botonCargarTexto.addActionListener(this);
    }

    @Override
    public void pintarBoton(JButton boton) {
        boton.setBackground(Color.black);
        boton.setForeground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonCargarTexto){
            TextLectura.LeerArchivos();
            tablero = new VisualTablero();
            if(VisualTablero.Tablero != null){
                tablero.marco();
            }

        }
    }
}
package Lectura;


import jugador.ArregloPlayer;
import jugador.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class LeerObj {
    static Player jugador;

<<<<<<< HEAD
    public static void abrirObj(String carpeta){
=======
    public static void abrirObjeto(String carpeta){
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

        String directorio = GuardarObj.directorio + "/"+carpeta;
        File archivoo = new File(directorio); //Abrir con dirección directa
        String[] archivos = archivoo.list();

        try{
            ObjectInputStream lector;

            for (int i = 0; i < archivos.length; i++) {
                String archivo = archivos[i];
                lector = new ObjectInputStream(new FileInputStream(archivoo.getPath()+"/"+archivo));
                if(carpeta.equals("Jugadores")){
                    jugador = (Player) lector.readObject();
                    ArregloPlayer.agregarPlayersLectura(jugador.getID(), jugador.getNOMBRE(), jugador.getAPELLIDO());
                }
                lector.close();

            }

        }
        catch (Exception ex){
            //JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            //System.out.println(ex);
        }
    }

<<<<<<< HEAD
    
=======
    public static void abrirObj(String jugadores) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
>>>>>>> de2baaf46e69b4e3e7e5d05c73996af73e551351

}
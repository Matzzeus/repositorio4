package Lectura;

import jugador.Player;
import javax.swing.*;
import java.io.*;

public class GuardarObj {

    public static String directorio = System.getProperty("user.dir");

    public static void GuardarObj (Object objeto){

        File archivo = new File(directorio + "/Jugadores");
        archivo.mkdir();

        try{
            ObjectOutputStream fichero;

            if(objeto instanceof Player){
                fichero = new ObjectOutputStream(new FileOutputStream(archivo.getPath()+ "/"+ ((Player) objeto).getNOMBRE() +"." + "jugador"));
            }
            else{
                fichero = null;
            }

            fichero.writeObject(objeto);
            fichero.close();

        }catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar, ponga nombre al archivo");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar en la salida");
            System.out.println(ex);
        }
    }
}
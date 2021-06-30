package Lectura;


import Visual.visualTablero.VisualTablero;
import tablero.Tablero;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;


public class TextLectura {

    static String[][] tablero = new String[100][];
    static int cantidadTableros = 0;
    static String[][] casillasAvanzar = new String[100][];
    static int cantidadCasillasAvanzar = 0;
    static String[][] casillasRetroceder = new String[100][];
    static int cantidadCasillasRetroceder = 0;
    static String[][] casillasPierdeTurno = new String[100][];
    static int cantidadCasillasPierdeTurno = 0;
    static String[][] casillasTiraDados = new String[100][];
    static int cantidadCasillasTiraDados = 0;
    static String[][] casillasSubida = new String[100][];
    static int cantidadCasillasSubida = 0;
    static String[][] casillasBajada = new String[100][];
    static int cantidadCasillasBajada = 0;

    public static void main(String[] args){
        LeerArchivos();
    }
    public static void LeerArchivos(){

        JFileChooser cargar = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Carga de datos","txt");
        cargar.setFileFilter(filtro);
        cargar.showOpenDialog(null);
        cargar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        File archivo = cargar.getSelectedFile();

        int contador = 0;
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            while(lectura != null)  {
                contador++;
                String cont = " " + contador;
                String datos[] = probar(lectura, cont);
                switch (datos[0]){
                    case "TABLERO":
                        tablero[cantidadTableros] = datos;
                        cantidadTableros++;
                        break;
                    case "PIERDETURNO":
                        casillasPierdeTurno[cantidadCasillasPierdeTurno] = datos;
                        cantidadCasillasPierdeTurno++;
                        break;
                    case "TIRARDADOS":
                        casillasTiraDados[cantidadCasillasTiraDados] = datos;
                        cantidadCasillasTiraDados++;
                        break;
                    case "AVANZA":
                        casillasAvanzar[cantidadCasillasAvanzar] = datos;
                        cantidadCasillasAvanzar++;
                        break;
                    case "RETROCEDE":
                        casillasRetroceder[cantidadCasillasRetroceder] = datos;
                        cantidadCasillasRetroceder++;
                        break;
                    case "SUBIDA":
                        casillasSubida[cantidadCasillasSubida] = datos;
                        cantidadCasillasSubida++;
                        break;
                    case "BAJADA":
                        casillasBajada[cantidadCasillasBajada] = datos;
                        cantidadCasillasBajada++;
                        break;
                }
                lectura = entrada.readLine();
            }
            entrada.close();
        }
        catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Error al cargar el archivo");
            System.out.println(ex);
        }

        //validar valores para el tablero
        for (int i = 0; i < cantidadTableros; i++) {
            int t = tablero[i].length - 2;
            if(t != 2){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + tablero[i][t+1]);
            }
            else if(!esNumeroInt(tablero[i][1]) || !esNumeroInt(tablero[i][2])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + tablero[i][t+1]);
            }
            else{
                VisualTablero.tablero = new Tablero(Integer.parseInt(tablero[i][1]), Integer.parseInt(tablero[i][2]));
            }

        }

        //Validar Casillas Avanzar
        for (int i = 0; i < cantidadCasillasAvanzar; i++) {
            int t = casillasAvanzar[i].length - 2;
            if(t != 3){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + casillasAvanzar[i][t+1]);
            }
            else if(!esNumeroInt(casillasAvanzar[i][1]) || !esNumeroInt(casillasAvanzar[i][2]) || !esNumeroInt(casillasAvanzar[i][3])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + casillasAvanzar[i][t+1]);
            }
            else{
                VisualTablero.tablero.casillaAvanzar(Integer.parseInt(casillasAvanzar[i][1]), Integer.parseInt(casillasAvanzar[i][2]), Integer.parseInt(casillasAvanzar[i][3]));
            }

        }

        //Validar Casillas Retroceder
        for (int i = 0; i < cantidadCasillasRetroceder; i++) {
            int t = casillasRetroceder[i].length - 2;
            if(t != 3){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + casillasRetroceder[i][t+1]);
            }
            else if(!esNumeroInt(casillasRetroceder[i][1]) || !esNumeroInt(casillasRetroceder[i][2]) || !esNumeroInt(casillasRetroceder[i][3])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + casillasRetroceder[i][t+1]);
            }
            else{
                VisualTablero.tablero.casillaRetroceder(Integer.parseInt(casillasRetroceder[i][1]), Integer.parseInt(casillasRetroceder[i][2]), Integer.parseInt(casillasAvanzar[i][3]));
            }

        }

        //Validar Casillas Tira Dados
        for (int i = 0; i < cantidadCasillasTiraDados; i++) {
            int t = casillasTiraDados[i].length - 2;
            if(t != 2){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + casillasTiraDados[i][t+1]);
            }
            else if(!esNumeroInt(casillasTiraDados[i][1]) || !esNumeroInt(casillasTiraDados[i][2])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + casillasTiraDados[i][t+1]);
            }
            else{
                VisualTablero.tablero.casillaTiraDados(Integer.parseInt(casillasTiraDados[i][1]), Integer.parseInt(casillasTiraDados[i][2]));
            }

        }

        //Validar Casillas PierdeTurno
        for (int i = 0; i < cantidadCasillasPierdeTurno; i++) {
            int t = casillasPierdeTurno[i].length - 2;
            if(t != 2){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + casillasPierdeTurno[i][t+1]);
            }
            else if(!esNumeroInt(casillasPierdeTurno[i][1]) || !esNumeroInt(casillasPierdeTurno[i][2])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + casillasPierdeTurno[i][t+1]);
            }
            else{
                VisualTablero.tablero.casillaPierdeTurno(Integer.parseInt(casillasPierdeTurno[i][1]), Integer.parseInt(casillasPierdeTurno[i][2]));
            }

        }

        //Validar Casillas Subida
        for (int i = 0; i < cantidadCasillasSubida; i++) {
            int t = casillasSubida[i].length - 2;
            if(t != 4){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + casillasSubida[i][t+1]);
            }
            else if(!esNumeroInt(casillasSubida[i][1]) || !esNumeroInt(casillasSubida[i][2]) || !esNumeroInt(casillasSubida[i][3]) || !esNumeroInt(casillasSubida[i][4])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + casillasSubida[i][t+1]);
            }
            else{
                VisualTablero.tablero.casillaSubir(Integer.parseInt(casillasSubida[i][1]), Integer.parseInt(casillasSubida[i][2]), Integer.parseInt(casillasSubida[i][3]), Integer.parseInt(casillasSubida[i][4]));
            }

        }

        //Validar Casillas Bajada
        for (int i = 0; i < cantidadCasillasBajada; i++) {
            int t = casillasBajada[i].length - 2;
            if(t != 4){
                JOptionPane.showMessageDialog(null, "Error cantidad elementos línea: " + casillasBajada[i][t+1]);
            }
            else if(!esNumeroInt(casillasBajada[i][1]) || !esNumeroInt(casillasBajada[i][2]) || !esNumeroInt(casillasBajada[i][3]) || !esNumeroInt(casillasBajada[i][4])){
                JOptionPane.showMessageDialog(null, "Error número requerido línea: " + casillasBajada[i][t+1]);
            }
            else{
                VisualTablero.tablero.casillaBajar(Integer.parseInt(casillasBajada[i][1]), Integer.parseInt(casillasBajada[i][2]), Integer.parseInt(casillasBajada[i][3]), Integer.parseInt(casillasBajada[i][4]));
            }
        }

        cantidadTableros = 0;
        cantidadCasillasAvanzar = 0;
        cantidadCasillasRetroceder = 0;
        cantidadCasillasSubida = 0;
        cantidadCasillasBajada = 0;
        cantidadCasillasTiraDados = 0;
        cantidadCasillasPierdeTurno = 0;
    }

    public static String[] probar(String a, String linea){
        a = a+linea;
        a = a.replaceAll("\\(", ",");
        a = a.replaceAll("\\)", ",");
        String b[] = a.split(",");
        for (int i = 0; i <b.length ; i++) {
            b[i] = b[i].trim().toUpperCase();
        }
        return b;
    }

    static boolean esNumeroInt(String valor){
        try{
            var n =Integer.parseInt(valor);
            return true;
        }
        catch(Exception ex){
            return false;
        }
    }
}
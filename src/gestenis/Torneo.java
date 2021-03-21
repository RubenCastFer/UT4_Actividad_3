package gestenis;

import java.io.*;
import java.util.ArrayList;


public class Torneo  {
    
    private String nombreTorneo;
    private int puntuacion;
    
    Torneo (String nombreTorneo,int puntuacion){
        this.nombreTorneo=nombreTorneo;
        this.puntuacion=puntuacion;
    }

    /**
     * Devuelve el nombre del torneo
     * @return
     */
    public String getNombreTorneo() {
        return nombreTorneo;
    }

    /**
     * Asignamos un nombre de torneo
     * @param nombreTorneo del torneo
     */
    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    /**
     * Devuelve la puntuacionuación asignada al torneo
     * @return
     */
    
    public int getPuntuacion() {
        return puntuacion;
    }

    /**
     * Introducimos la puntuacionuación asignada para el torneo
     * @param
     */
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    /**
     * Carga los datos del fichero en el ArrayList lista
     * y devuelve true si todo ha ido bien o false si ha fallado algo
     * @param fichero
     * @return
     */
    public static ArrayList<Torneo> cargar(File fichero){
        ArrayList<Torneo> lista = null;
        try{
        	lista = new ArrayList<Torneo>();
            ObjectInputStream ficheroEntrada = null;
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return lista;
        }catch(ClassNotFoundException cnfe){
            return null;
        }catch(FileNotFoundException fnfe){
            return null;
        }catch (IOException ioe){
            return null;
        }
    }
    /**
     * Guarda los datos del ArrayList lista en el fichero fichero
     * Si todo ha ido bien devuelve true y en caso contrario false 
     * @param lista
     * @param fichero
     * @return
     */
    public static boolean guardar(ArrayList<Torneo> lista,File fichero){
        try{
        	//Fichero de salida
            ObjectOutputStream sal = null; 
            sal = new ObjectOutputStream(new FileOutputStream (fichero));
            sal.writeObject(lista);
            sal.flush();
            sal.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
    
    /**
     * método cargarYGuardar  eliminado, es un copia pega de los métodos cargar 
     * y guardar en caso de que no se quiera eliminar este método realizar las 
     * llamadas a los anteriores mencionados.
     */
}
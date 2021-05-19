/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete3;

// Uso de la clase Formatter para escribir datos en un archivo de texto.
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import paquete1.Calificacion;
import paquete1.Profesor;

public class ArchivoEscritura {

    private String nombreArchivo;
    private String rutaArchivo;
    private Calificacion registro;
    private Formatter salidaArchivo;

    public ArchivoEscritura(String n) {
        nombreArchivo = n;
        rutaArchivo = String.format("data/%s",
                obtenerNombreArchivo());
        
        // sacar la información del archivo, previo a volver 
        // a trabajar con el mimso.
        establecerInformacionAnterior();
        
        
    }

    public void establecerInformacionAnterior() {
        
        
        ArchivoLectura lectura = new ArchivoLectura(nombreArchivo);
        lectura.establecerLista();
        ArrayList<Calificacion> lista = lectura.obtenerLista();
        
        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {
                
                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {
                
                        establecerRegistro(lista.get(i));
                        establecerSalida();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);

        } // fin de catch
    }
    
    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRutaArchivo() {
        rutaArchivo = String.format("data/%s.txt",
                obtenerNombreArchivo());;
    }

    public void establecerRegistro(Calificacion n) {
        registro = n;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerRutaArchivo() {
        return rutaArchivo;
    }

    public Calificacion obtenerRegistro() {
        return registro;
    }

    // agrega registros al archivo
    public void establecerSalida() {
        try {
            Calificacion p = obtenerRegistro();
            String cadenaRegistro = String.format("%s;%.2f;%s|%s",
                    p.obtenerNombreMateria(),
                    p.obtenerNota(),
                    p.obtenerProfesor().obtenerNombre(),
                    p.obtenerProfesor().obtenerTipo()
                    );
            salidaArchivo.format("%s\n", cadenaRegistro);

        } catch (Exception e) {
            System.err.println("Error al crear el archivo.");
            System.err.println(e);

        }

    }

    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } // cierra el archivo

    }

}

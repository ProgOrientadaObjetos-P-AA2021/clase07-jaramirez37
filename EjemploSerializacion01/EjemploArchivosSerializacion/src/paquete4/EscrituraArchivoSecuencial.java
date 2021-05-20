package paquete4;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author josep
 */
public class EscrituraArchivoSecuencial {
    
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Hospital registro;
    private ArrayList<Hospital> lista;

    public EscrituraArchivoSecuencial(String nombreArc) {
        nombreArchivo = nombreArc;
        setLista(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        // System.out.println(obtenerListaProfesores().size());
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (getLista().size() > 0) {
                for (int i = 0; i < getLista().size(); i++) {
                    setRegistro(getLista().get(i));
                    setSalida();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    
    public void setNombreArchivo(String n){
        nombreArchivo = n;
    }
    // agrega registros al archivo
    public void setRegistro(Hospital p) {
        registro = p;
    }

    public void setSalida() {
        try {
            salida.writeObject(registro); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // en el atributo listaProfesores obtenemos los registros 
    // del archivo
    public void setLista() {
        
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(getNombreArchivo());
        l.setListaHospitales();
        lista = l.getListaHospitales();
    }

    public String getNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Hospital> getLista() {
        return lista;
    }

    public ObjectOutputStream getSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } // fin de catch
    } 

}

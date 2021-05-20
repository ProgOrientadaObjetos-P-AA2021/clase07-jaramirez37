package paquete6;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
/**
 *
 * @author josep
 */
public class ArchiveWrite {
    
    private String nomArchivo;
    private String rutaArchivo;
    private Hospital registro;
    private Formatter salidaArchivo;

    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public Hospital getRegistro() {
        return registro;
    }

    public void setRegistro(Hospital registro) {
        this.registro = registro;
    }

    public Formatter getSalidaArchivo() {
        return salidaArchivo;
    }

    public void setSalidaArchivo(Formatter salidaArchivo) {
        this.salidaArchivo = salidaArchivo;
    }
    
    public ArchiveWrite(String n) {
        nomArchivo = n;
        rutaArchivo = String.format("data/%s",
                getNomArchivo());

        getInfoAnterior();

    }

    public void getInfoAnterior() {

        ArchiveRead lectura = new ArchiveRead(nomArchivo);
        lectura.setLista();
        ArrayList<Hospital> lista = lectura.getLista();

        try {
            salidaArchivo = new Formatter(rutaArchivo);
            if (lista != null) {

                if (lista.size() > 0) {
                    for (int i = 0; i < lista.size(); i++) {

                        setRegistro(lista.get(i));
                        setSalida();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e);

        } 
    }

    public void setSalida() {
        try {
            Hospital p = getRegistro();
            String cadenaRegistro = String.format("%s;%d;%.2f",
                    p.getNombre(),
                    p.getNumCamas(),
                    p.getPresupuesto());
            salidaArchivo.format("%s\n", cadenaRegistro);

        } catch (Exception e) {
            System.err.println("Error al crear el archivo.");
            System.err.println(e);

        }

    }

    public void cerrarArchivo() {
        if (salidaArchivo != null) {
            salidaArchivo.close();
        } 

    }
}

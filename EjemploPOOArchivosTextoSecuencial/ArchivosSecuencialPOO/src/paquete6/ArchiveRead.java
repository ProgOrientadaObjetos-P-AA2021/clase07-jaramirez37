package paquete6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author josep
 */
public class ArchiveRead {
    
    private Scanner entrada;
    private String nomArchivo;
    private String rutaArchivo;
    private ArrayList<Hospital> lista;

    public ArchiveRead(String n) {
        nomArchivo = n;

        rutaArchivo = String.format("data/%s",
                getNomArchivo());
        File f = new File(rutaArchivo);
        if (f.exists()) {
            try {
                entrada = new Scanner(new File(rutaArchivo));
            } // fin de try
            catch (FileNotFoundException e) {
                System.err.println("Error al leer del archivo: " + e);

            } // fin de catch
        }
    }

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

    public void setLista() {
        lista = new ArrayList<>();
        File f = new File(rutaArchivo);

        if (f.exists()) {

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();
                
                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split(";")));
                
                String nom = linea_partes.get(0);
                int numCamas = Integer.parseInt(linea_partes.get(1));
                double presupuesto = Double.parseDouble(linea_partes.get(2).replace(",", "."));

                Hospital hosp = new Hospital(nom, numCamas, presupuesto);

                lista.add(hosp);

            } 
        }
    }

    public ArrayList<Hospital> getLista() {

        return lista;
    }

    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close();
        } 

    }

    @Override
    public String toString() {
        String cadena = "\tHOSPITALES\n";

        for (int i = 0; i < getLista().size(); i++) {
            cadena = String.format("%sNombre: %s\nNumero de Camas: %d\n Presupuesto: " + "%.2f\n", cadena,
                    getLista().get(i).getNombre(),
                    getLista().get(i).getNumCamas(),
                    getLista().get(i).getPresupuesto());

        }

        return cadena;
    }
}

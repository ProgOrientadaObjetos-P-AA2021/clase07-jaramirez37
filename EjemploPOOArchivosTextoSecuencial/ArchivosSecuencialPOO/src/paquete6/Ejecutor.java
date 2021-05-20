package paquete6;

/**
 *
 * @author josep
 */
public class Ejecutor {
    
    public static void main(String[] args) {
        
        Hospital h = new Hospital("Hospital Julios Docner", 500, 2000.000);
        Hospital h1 = new Hospital("Hospital Hause", 400, 60000.000);
        Hospital h2 = new Hospital("Hospital Makelele", 300, 80000.000);

        String nomArchivo = "hospital.txt";

        Hospital[] lista = {h, h1, h};

        ArchiveWrite archivo = new ArchiveWrite(nomArchivo);

        for (int i = 0; i < lista.length; i++) {
            
            archivo.setRegistro(lista[i]);
            archivo.setSalida();
        }

        archivo.cerrarArchivo();
        
        ArchiveRead lectura = new ArchiveRead(nomArchivo);
        lectura.setLista();
        System.out.println(lectura);
    }
    
}

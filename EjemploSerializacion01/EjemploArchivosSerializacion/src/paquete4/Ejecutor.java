package paquete4;

public class Ejecutor {

    public static void main(String[] args) {

       String fileName = "hospital.txt";
        
        Hospital hospital1 = new Hospital("Julios Docner", 45, 500.00);
        Hospital hospital2 = new Hospital("Torre Judicial", 100, 2000.00);
        Hospital hospital3 = new Hospital("Presbyterian", 10, 500.00);

        Hospital[] listaHospitales = {hospital1, hospital2, hospital3};

        EscrituraArchivoSecuencial archivo = new EscrituraArchivoSecuencial(fileName);

        for (int i = 0; i < listaHospitales.length; i++) {      
            archivo.setRegistro(listaHospitales[i]);       
            archivo.setSalida();
        }
        archivo.cerrarArchivo();
        
    

        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(fileName);
        lectura.setListaHospitales();
        System.out.println(lectura);
    }
}

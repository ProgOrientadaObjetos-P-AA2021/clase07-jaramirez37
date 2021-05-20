package paquete6;

/**
 *
 * @author josep
 */
public class Hospital {

    private String nom;
    private int numCamas;
    private double presupuesto;
    
    public Hospital(String nombre, int numCamas, double presupuesto) {
        this.nom = nombre;
        this.numCamas = numCamas;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nom;
    }

    public void setNombre(String nombre) {
        this.nom = nombre;
    }

    public int getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(int numCamas) {
        this.numCamas = numCamas;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
    
}

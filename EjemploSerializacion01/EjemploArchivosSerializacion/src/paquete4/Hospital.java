package paquete4;
import java.io.Serializable;

/**
 *
 * @author josep
 */
public class Hospital implements Serializable{
    
    private String nombre;
    private int numeroCamas;
    private double presupuesto;

    public Hospital(String nombre, int numeroCamas, double presupuesto) {
        this.nombre = nombre;
        this.numeroCamas = numeroCamas;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }
}

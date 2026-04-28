/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaveterinaria;

/**
 *
 * @author meryw
 */
public class ServicioVeterinario {
    private String nombre;
    private double costo;

    public ServicioVeterinario(String nombre, double costo) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre del servicio no puede estar vacio.");
        }
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo del servicio debe ser mayor a 0.");
        }
        this.nombre = nombre;
        this.costo = costo;
    }

    public String getNombre() { return nombre; }
    public double getCosto() { return costo; }

    public void setCosto(double nuevoCosto) {
        if (nuevoCosto <= 0) {
            throw new IllegalArgumentException("El costo del servicio debe ser mayor a 0.");
        }
        this.costo = nuevoCosto;
    }
}

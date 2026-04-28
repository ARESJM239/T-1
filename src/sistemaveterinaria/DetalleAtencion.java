/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaveterinaria;

/**
 *
 * @author meryw
 */
public class DetalleAtencion {
    private ServicioVeterinario servicio;

    public DetalleAtencion(ServicioVeterinario servicio) {
        this.servicio = servicio;
    }

    public double calcularCosto() { 
        return servicio.getCosto(); 
    }
    
    public ServicioVeterinario getServicio() { 
        return servicio; 
    }
}

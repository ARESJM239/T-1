/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaveterinaria;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author meryw
 */
public class Atencion {
    private static int contadorId = 1; 
    private int id;
    private String cliente;
    private String mascota;
    private List<DetalleAtencion> detalles;

    public Atencion(String cliente, String mascota) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.mascota = mascota;
        this.detalles = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getCliente() { return cliente; }
    public String getMascota() { return mascota; }

    public void agregarDetalle(DetalleAtencion detalle) { detalles.add(detalle); }

    public void eliminarDetalle(String nombreServicio) {
        boolean eliminado = detalles.removeIf(d -> d.getServicio().getNombre().equalsIgnoreCase(nombreServicio));
        if (!eliminado) System.out.println("Servicio no encontrado para eliminar.");
    }

    public double calcularTotal() {
        if (detalles.isEmpty()) throw new IllegalStateException("No se puede calcular el total de una atencion vacia.");
        double total = 0;
        for (DetalleAtencion d : detalles) total += d.calcularCosto();
        return total;
    }

    public void actualizarCostoServicio(String nombreServicio, double nuevoCosto) {
        boolean encontrado = false;
        for (DetalleAtencion d : detalles) {
            if (d.getServicio().getNombre().equalsIgnoreCase(nombreServicio)) {
                d.getServicio().setCosto(nuevoCosto);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("Servicio no encontrado.");
    }

    public int cantidadServicios() { return detalles.size(); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
          .append(", Cliente: ").append(cliente)
          .append(", Mascota: ").append(mascota);
        sb.append("Servicios:\n");
        for (DetalleAtencion d : detalles) {
            sb.append(" - ").append(d.getServicio().getNombre())
              .append(": ").append(d.getServicio().getCosto()).append("\n");
        }
        try { sb.append("Total: ").append(calcularTotal()).append("\n"); }
        catch (IllegalStateException e) { sb.append("Total: Atencion vacia\n"); }
        return sb.toString();
    }
}

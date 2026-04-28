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
public class GestorAtenciones {
    private List<Atencion> listaAtenciones;

    public GestorAtenciones() { 
        listaAtenciones = new ArrayList<>(); 
    }

    public void registrarAtencion(Atencion atencion) { 
        listaAtenciones.add(atencion); 
    }

    public List<Atencion> getListaAtenciones() {
        return listaAtenciones; 
    }

    public void listarAtenciones() {
        if (listaAtenciones.isEmpty()) {
            System.out.println("No hay atenciones registradas.");
            return;
        }
        for (Atencion a : listaAtenciones) System.out.println(a);
    }

    public void mostrarAtencionesMenoresATresServicios() {
        System.out.println("Atenciones con menos de 3 servicios:");
        for (Atencion a : listaAtenciones) {
            if (a.cantidadServicios() < 3) System.out.println(a);
        }
    }
}

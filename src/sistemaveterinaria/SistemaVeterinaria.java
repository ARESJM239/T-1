/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemaveterinaria;

import java.util.Scanner;

/**
 *
 * @author meryw
 */
public class SistemaVeterinaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        GestorAtenciones gestor = new GestorAtenciones();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Sistema Veterinaria ---");
            System.out.println("1. Crear atencion");
            System.out.println("2. Agregar servicio a atencion");
            System.out.println("3. Listar atenciones");
            System.out.println("4. Actualizar costo de un servicio");
            System.out.println("5. Eliminar un servicio de una atencion");
            System.out.println("6. Mostrar atenciones con menos de 3 servicios");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
            int opcion = sc.nextInt(); sc.nextLine();

            switch(opcion) {
                case 1: { // Crear atención
                    System.out.print("Nombre del cliente: ");
                    String cliente = sc.nextLine();
                    System.out.print("Nombre de la mascota: ");
                    String mascota = sc.nextLine();
                    Atencion atencion = new Atencion(cliente, mascota);
                    gestor.registrarAtencion(atencion);
                    System.out.println("Atencion creada exitosamente. ID de la atención: " + atencion.getId());
                }

                case 2: { // Agregar servicio
                    if (gestor.getListaAtenciones().isEmpty()) {
                        System.out.println("No hay atenciones registradas.");
                        break;
                    }

                    System.out.println("Atenciones disponibles:");
                    for (Atencion a : gestor.getListaAtenciones()) {
                        System.out.println("ID: " + a.getId() + ", Cliente: " + a.getCliente() + ", Mascota: " + a.getMascota());
                    }

                    System.out.print("Ingrese el ID de la atencion a la que desea agregar un servicio: ");
                    int id = sc.nextInt(); sc.nextLine();

                    Atencion atencion = null;
                    for (Atencion a : gestor.getListaAtenciones()) {
                        if (a.getId() == id) {
                            atencion = a;
                            break;
                        }
                    }

                    if (atencion != null) {
                        System.out.print("Nombre del servicio: ");
                        String nombreServicio = sc.nextLine();
                        System.out.print("Costo del servicio: ");
                        double costo = sc.nextDouble(); sc.nextLine();
                        try {
                            ServicioVeterinario servicio = new ServicioVeterinario(nombreServicio, costo);
                            atencion.agregarDetalle(new DetalleAtencion(servicio));
                            System.out.println("Servicio agregado a la atencion ID " + id);
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Atencion no encontrada.");
                    }
                }

                case 3: gestor.listarAtenciones();

                case 4: { // Actualizar costo
                    if (gestor.getListaAtenciones().isEmpty()) {
                        System.out.println("No hay atenciones registradas.");
                        break;
                    }

                    System.out.println("Atenciones disponibles:");
                    for (Atencion a : gestor.getListaAtenciones()) {
                        System.out.println("ID: " + a.getId() + ", Cliente: " + a.getCliente() + ", Mascota: " + a.getMascota());
                    }

                    System.out.print("Ingrese el ID de la atencion que desea actualizar: ");
                    int id = sc.nextInt(); sc.nextLine();

                    Atencion atencion = null;
                    for (Atencion a : gestor.getListaAtenciones()) {
                        if (a.getId() == id) {
                            atencion = a;
                            break;
                        }
                    }

                    if (atencion != null) {
                        System.out.print("Nombre del servicio a actualizar: ");
                        String nombreServicio = sc.nextLine();
                        System.out.print("Nuevo costo: ");
                        double nuevoCosto = sc.nextDouble(); sc.nextLine();
                        atencion.actualizarCostoServicio(nombreServicio, nuevoCosto);
                        System.out.println("Costo actualizado para la atención ID " + id);
                    } else {
                        System.out.println("Atencion no encontrada.");
                    }
                }

                case 5: { // Eliminar servicio
                    if (gestor.getListaAtenciones().isEmpty()) {
                        System.out.println("No hay atenciones registradas.");
                        break;
                    }

                    System.out.println("Atenciones disponibles:");
                    for (Atencion a : gestor.getListaAtenciones()) {
                        System.out.println("ID: " + a.getId() + ", Cliente: " + a.getCliente() + ", Mascota: " + a.getMascota());
                    }

                    System.out.print("Ingrese el ID de la atención de la que desea eliminar un servicio: ");
                    int id = sc.nextInt(); sc.nextLine();

                    Atencion atencion = null;
                    for (Atencion a : gestor.getListaAtenciones()) {
                        if (a.getId() == id) {
                            atencion = a;
                            break;
                        }
                    }

                    if (atencion != null) {
                        System.out.print("Nombre del servicio a eliminar: ");
                        String nombreServicio = sc.nextLine();
                        atencion.eliminarDetalle(nombreServicio);
                        System.out.println("Servicio eliminado de la atencion ID " + id);
                    } else {
                        System.out.println("Atencion no encontrada.");
                    }
                }

                case 6: gestor.mostrarAtencionesMenoresATresServicios();

                case 7: salir = true;

                default: System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
}
        

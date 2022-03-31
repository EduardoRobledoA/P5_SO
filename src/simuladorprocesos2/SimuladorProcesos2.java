/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorprocesos2;

import java.util.*;

/**
 *
 * @author Eduardo Robledo Aguirre
 * @author Roberto Toledo Sanchez
 */
public class SimuladorProcesos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Memoria RAM = new Memoria(2048);
        RAM.llenarMem();
        ColaProcesos QUEUE = new ColaProcesos();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario
 
        while (!salir) {
 
            System.out.println("------------------------- SIMULADOR DE PROCESOS Y MEMORIA -------------------------");
            System.out.println("1. Crear Proceso nuevo");
            System.out.println("2. Ver estado actual del sistema");
            System.out.println("3. Imprimir cola de procesos");
            System.out.println("4. Ver proceso actual");
            System.out.println("5. Ejecutar proceso actual");
            System.out.println("6. Pasar al proceso siguiente");
            System.out.println("7. Matar proceso actual");
            System.out.println("8. Salir del programa");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        System.out.println("\nHas seleccionado la opcion 1");
                        CrearProceso NewProces = new CrearProceso();
                        Proceso proc = NewProces.Crear(RAM);
                        if(proc != null)
                            QUEUE.insertar_Proceso(proc);
                        break;

                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        QUEUE.estado_actual_sistema(RAM);
                        break;

                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        QUEUE.imprimir_cola_procesos();
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        QUEUE.ver_proceso_actual();
                        break;

                    case 5:
                        System.out.println("Has seleccionado la opcion 5");
                        QUEUE.ejecutar_proceso_actual(RAM);
                        break;

                    case 6:
                        System.out.println("Has seleccionado la opcion 6");
                        QUEUE.pasar_proceso_siguiente();
                        break;

                    case 7:
                        System.out.println("Has seleccionado la opcion 7");
                        QUEUE.matar_proceso_actual(RAM);
                        break;

                    case 8:
                        salir = true;
                        break;
                        
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorprocesos2;

import java.util.*;
import simuladorprocesos2.Memoria;
/**
 *
 * @author Eduardo Robledo Aguirre
 * @author Roberto Toledo Sanchez
 */
public class ColaProcesos {

    LinkedList<Proceso> NuevaColaProcesos = new LinkedList();
    LinkedList<Proceso> ColaProcesosFinalizados = new LinkedList();
    LinkedList<Proceso> ColaProcesosEliminados = new LinkedList();

    /**
     *
     * @param p
     */
    public void insertar_Proceso(Proceso p) {
        NuevaColaProcesos.add(p);
    }

    /**
     *
     * @param memoria
     */
    public void estado_de_los_procesos(Memoria memoria) {
        System.out.println("\n >>>>Memoria Disponible:"+memoria.getCapacidad());
        System.out.println("\n >>>> Número de procesos listos:"+ NuevaColaProcesos.size());

        int i=1;
        if (ColaProcesosFinalizados.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos finalizados \n");
        } else {
            System.out.println("\n >>>> Lista de Procesos Finalizados Exitosamente: \n");
            for (Proceso temporal : ColaProcesosFinalizados) {
                
                if (i==1) {
                    System.out.println(i+"->\tNombre: "+temporal.getNombre()+"\n\tID unico: "+temporal.getId_Proc()
                    +"\n\tInstrucciones pendientes: "+temporal.getNo_Instrucciones()
                    +"\n\tInstrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n");
                    i++;
                } else {
                    System.out.println(i+"->\tNombre: "+temporal.getNombre()+"\n\tID unico: "+temporal.getId_Proc()
                    +"\n\tInstrucciones pendientes: "+temporal.getNo_Instrucciones()
                    +"\n\tInstrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n");
                    i++;
                }

            }
            System.out.println();
            
        }

        i=1;
        if (ColaProcesosEliminados.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos eliminados \n");
        } else {
            System.out.println("\n >>>> Lista de Procesos Eliminados: \n");
            for (Proceso temporal : ColaProcesosEliminados) {
                
                if (i==1) {
                    System.out.println(i+"->\tNombre: "+temporal.getNombre()+"\n\tID unico: "+temporal.getId_Proc()
                    +"\n\tInstrucciones pendientes: "+temporal.getNo_Instrucciones()
                    +"\n\tInstrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n");
                    i++;
                } else {
                    System.out.println(i+"->\tNombre: "+temporal.getNombre()+"\n\tID unico: "+temporal.getId_Proc()
                    +"\n\tInstrucciones pendientes: "+temporal.getNo_Instrucciones()
                    +"\n\tInstrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n");
                    i++;
                }

            }
            System.out.println();
        
        }

    }

    /**
     *
     */
    public void imprimir_cola_procesos() {

        int i=1;
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {
            System.out.println("\n >>>> Lista de Procesos Preparados: \n");
            for (Proceso temporal : NuevaColaProcesos) {
                
                if (i==1) {
                    System.out.println(i+"->\tNombre: "+temporal.getNombre()+"(Proceso Activo)\n\tID unico: "+temporal.getId_Proc()
                    +"\n\tInstrucciones pendientes: "+temporal.getNo_Instrucciones()
                    +"\n\tInstrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n");
                    i++;
                } else {
                    System.out.println(i+"->\tNombre: "+temporal.getNombre()+"\n\tID unico: "+temporal.getId_Proc()
                    +"\n\tInstrucciones pendientes: "+temporal.getNo_Instrucciones()
                    +"\n\tInstrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n");
                    i++;
                }

            }
            System.out.println();
        }

    }

    /**
     *
     */
    public void ver_proceso_actual(){
        
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {
            Proceso temporal = NuevaColaProcesos.getFirst();
            System.out.println("\n >>>> Proceso actual: \n");
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: "+temporal.getDirBase()+"-"+temporal.getDirLimite()+"\n");
        }

    }

    /**
     *
     * @param memoria
     */
    public void ejecutar_proceso_actual(Memoria memoria){

        int i;
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {

            System.out.println("\n >>>>>>> Proceso activo actual: \n");
            Proceso temporal = NuevaColaProcesos.removeFirst();
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: "+temporal.getDirBase()+"-"+temporal.getDirLimite()+"\n");

            System.out.println("\n >>>> Ejecutando proceso actual\n");
            for(i=0;i<3;i++){
                System.out.println("..." );
                try {
                    Thread.sleep(550);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if (temporal.getNo_Instrucciones() <= 5) { //Proceso termina su ejecucion
                
                int totalInstrucciones = temporal.getNo_Instrucciones()+temporal.getNo_InstruccionesEjecutadas();
                temporal.setNo_InstruccionesEjecutadas(totalInstrucciones);
                temporal.setNo_Instrucciones(0);         
                
                int memLib = temporal.getMemoria();
                memoria.setCapacidad(memLib + memoria.getCapacidad());
                
                int base = temporal.getDirBase();
                int limite = temporal.getDirLimite();   
                for(i=base;i<limite;i++)
                    memoria.localidades[i]=null;
                
                ColaProcesosFinalizados.add(temporal);
                System.out.println("\n >>>> El proceso ha concluido su ejecución\n");


            } else { //Proceso vuelve a la cola

                int memoActual = temporal.getNo_Instrucciones();
                temporal.setNo_Instrucciones(memoActual-5);
                
                memoActual = temporal.getNo_InstruccionesEjecutadas();
                temporal.setNo_InstruccionesEjecutadas(memoActual+5);
                
                NuevaColaProcesos.add(temporal);
                System.out.println("\n >>>>>>> Proceso despues de ejecucion: \n");
                System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
                +"  Instrucciones restantes: "+temporal.getNo_Instrucciones()+"\n"
                +"  Instrucciones que se ejecutaron: 5\n"
                +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
                +"  Direcciones de memoria asignadas: "+temporal.getDirBase()+"-"+temporal.getDirLimite()+"\n");

            }

        }

    }

    /**
     *
     */
    public void pasar_proceso_siguiente(){
        
        int i;
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {

            System.out.println("\n >>>>>>> Proceso activo actual: \n");
            Proceso temporal = NuevaColaProcesos.removeFirst();
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: "+temporal.getDirBase()+"-"+temporal.getDirLimite()+"\n");

            System.out.println("\n >>>> Pasando al siguiente proceso\n");
            for(i=0;i<3;i++){
                System.out.println("..." );
                try {
                    Thread.sleep(550);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            NuevaColaProcesos.add(temporal);
            temporal = NuevaColaProcesos.getFirst();
            System.out.println("\n >>>>>>> Proceso activo actual: \n");
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: "+temporal.getDirBase()+"-"+temporal.getDirLimite()+"\n");

        }
    }
    
    /**
     *
     * @param memoria
     */
    public void matar_proceso_actual(Memoria memoria){

        int i;
        if (NuevaColaProcesos.size()==0) {
                System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {

            System.out.println("\n >>>> Matando proceso actual \n");
            for(i=0;i<3;i++){
                System.out.println("..." );
                try {
                    Thread.sleep(550);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println("\n >>>>>>> Se elimino el proceso: \n");
            Proceso temporal = NuevaColaProcesos.removeFirst();        
            int memLib = temporal.getMemoria();
            memoria.setCapacidad(memLib + memoria.getCapacidad());
            
            int base = temporal.getDirBase();
            int limite = temporal.getDirLimite();   
            for(i=base;i<limite;i++)
                memoria.localidades[i]=null;
            
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"
            +"  Direcciones de memoria asignadas: "+temporal.getDirBase()+"-"+temporal.getDirLimite()+"\n");
            ColaProcesosEliminados.add(temporal);

        }

    }

}

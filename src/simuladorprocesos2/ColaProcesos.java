/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorprocesos2;

import java.util.*;
//import simuladorprocesos2.Memoria;
/**
 *
 * @author Eduardo Robledo Aguirre
 * @author Roberto Toledo Sanchez
 */
public class ColaProcesos {

   
    LinkedList<Proceso> NuevaColaProcesos = new LinkedList<>();
    LinkedList<Proceso> ColaProcesosFinalizados = new LinkedList<>();
    LinkedList<Proceso> ColaProcesosEliminados = new LinkedList<>();
    int[][] frames_pages = {
        {0,15},
        {16,31},
        {32,47},
        {48,63},
        {64,79},
        {80,95},
        {96,111},
        {112,127},
        {128,143},
        {144,159},
        {160,175},
        {176,191},
        {192,207},
        {208,223},
        {224,239},
        {240,255},
        {256,271},
        {272,287},
        {288,303},
        {304,319},
        {320,335},
        {336,351},
        {352,367},
        {368,383},
        {384,399},
        {400,415},
        {416,431},
        {432,447},
        {448,463},
        {464,479},
        {480,495},
        {496,511},
        {512,527},
        {528,543},
        {544,559},
        {560,575},
        {576,591},
        {592,607},
        {608,623},
        {624,639},
        {640,655},
        {656,671},
        {672,687},
        {688,703},
        {704,719},
        {720,735},
        {736,751},
        {752,767},
        {768,783},
        {784,799},
        {800,815},
        {816,831},
        {832,847},
        {848,863},
        {864,879},
        {880,895},
        {896,911},
        {912,927},
        {928,943},
        {944,959},
        {960,975},
        {976,991},
        {992,1007},
        {1008,1023} };

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
            
        System.out.println("\n ----------------------- Estado de la Memoria -----------------------");
        System.out.println("Marco           Pagina");
        for(i=0;i<64;i++)
            System.out.println(i+"                     "+memoria.marcos[i]);

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
        int i,aux;
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {
            Proceso temporal = NuevaColaProcesos.getFirst();
            System.out.println("\n >>>> Proceso actual: \n");
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: \n"
            +"  PAGE    FRAME   {BASE - LIMIT}");
            for (i = 0; i < temporal.getNoPaginas(); i++) {
                aux = temporal.tabla_paginas[i];
                System.out.println("  "+i+"       "+aux+"        "+frames_pages[aux][0]+" - "+frames_pages[aux][1]);
            }
        }

    }

    /**
     *
     * @param memoria
     */
    public void ejecutar_proceso_actual(Memoria memoria){

        int i,aux;
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {

            System.out.println("\n >>>>>>> Proceso activo actual: \n");
            Proceso temporal = NuevaColaProcesos.removeFirst();
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: \n"
            +"  PAGE    FRAME   {BASE - LIMIT}");
            for (i = 0; i < temporal.getNoPaginas(); i++) {
                aux = temporal.tabla_paginas[i];
                System.out.println("  "+i+"       "+aux+"        "+frames_pages[aux][0]+" - "+frames_pages[aux][1]);
            }            

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
                
                /*
                int base = temporal.getDirBase();
                int limite = temporal.getDirLimite();   
                for(i=base;i<limite;i++)
                    memoria.localidades[i]=null;
                */
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
                +"  Direcciones de memoria asignadas: \n"
                +"  PAGE    FRAME   {BASE - LIMIT}");
                for (i = 0; i < temporal.getNoPaginas(); i++) {
                    aux = temporal.tabla_paginas[i];
                    System.out.println("  "+i+"       "+aux+"        "+frames_pages[aux][0]+" - "+frames_pages[aux][1]);
                }                
            }

        }

    }

    /**
     *
     */
    public void pasar_proceso_siguiente(){
        
        int i,aux;
        if (NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos preparados \n");
        } else {

            System.out.println("\n >>>>>>> Proceso activo actual: \n");
            Proceso temporal = NuevaColaProcesos.removeFirst();
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"        
            +"  Direcciones de memoria asignadas: \n"
            +"  PAGE    FRAME   {BASE - LIMIT}");
            for (i = 0; i < temporal.getNoPaginas(); i++) {
                aux = temporal.tabla_paginas[i];
                System.out.println("  "+i+"       "+aux+"        "+frames_pages[aux][0]+" - "+frames_pages[aux][1]);
            }            

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
            +"  Direcciones de memoria asignadas: \n"
            +"  PAGE    FRAME   {BASE - LIMIT}");
            for (i = 0; i < temporal.getNoPaginas(); i++) {
                aux = temporal.tabla_paginas[i];
                System.out.println("  "+i+"       "+aux+"        "+frames_pages[aux][0]+" - "+frames_pages[aux][1]);
            }

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
            
            for(int marco : temporal.tabla_paginas){
                memoria.marcos[marco] = null;
            }
                
            /*
            for(i=0;i<temporal.noPaginas;i++){
                System.out.println("");
                aux = temporal.tabla_paginas[i];
                for(j=aux*16;j<(aux*16)+16;j++)
                    memoria.localidades[j]=null;
            }
            */
            temporal.tabla_paginas=null;
            
            /*
            int base = temporal.getDirBase();
            int limite = temporal.getDirLimite();   
            for(i=base;i<limite;i++)
                memoria.localidades[i]=null;
            */
            System.out.println("  Nombre: "+temporal.getNombre()+"\n"+"  ID unico: "+temporal.getId_Proc()+"\n"
            +"  Instrucciones totales: "+temporal.getNo_Instrucciones()+"\n"
            +"  Instrucciones ejecutadas: "+temporal.getNo_InstruccionesEjecutadas()+"\n"
            +"  Espacio ocupado: "+temporal.getMemoria()+"\n"
            +"  Direcciones de memoria asignadas: \n"
            +"  PAGE    FRAME   {BASE - LIMIT}\n"
            +"  null    null     null - null");    
                        
            ColaProcesosEliminados.add(temporal);

        }

    }

}

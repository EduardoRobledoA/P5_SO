/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorprocesos2;
/**
 *
 * @author Eduardo Robledo Aguirre
 * @author Roberto Toledo Sanchez
 */
public class Memoria {
    //public String[] localidades = new String[1024];
    public String[] marcos = new String[64];
    public int capacidad ;

    public Memoria() {
    }

    public Memoria(int capacidad) {
        this.capacidad = capacidad;
    }
    /*
    public String[] getLocalidades() {
        return localidades;
    }

    public void setLocalidades(String[] localidades) {
        this.localidades = localidades;
    }
   */
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    /*
    public void llenarMem(){
        for(int i=0;i<1024;i++)
            this.localidades[i]=null;          
    }
    */
    public void llenarMarcos(){
        for(int i=0;i<64;i++)
            this.marcos[i]=null;          
    }
    
  
   
    /*
     * Nueva funcion. Lista ligada de procesos y huecos
     * 
     */
    public void estado_de_la_memoria(){
        System.out.println("\n ----------------------- LISTA LIGADA DE PROCESOS Y HUECOS -----------------------\n");
        System.out.println("| PROCESO/HUECO | DIRECCION BASE DE LA PAGINA | LONGITUD |---|---> \n");
        int j = 0;
        for(int i=0;i<64;i++){

            switch (i) {
                case 0:
                    System.out.println("    | "+marcos[i]+" |"+"| 0 | 16 |---|---");
                    j = j+16;
                    break;

                case 63:
                    System.out.println("--->| "+marcos[i]+" |"+"| "+j+"| 16 | X |");
                    break;
            
                default:
                    System.out.println("--->| "+marcos[i]+" |"+"| "+j+" | 16 |---|---");
                    j = j+16;
                    break;
            }
            
        }       
    }
    
   
    /*
     * Nueva funcion. Desfragmentacion y muestra de la lista ligada de procesos y huecos.
     * 
    */ 
    public void desfragmentar_memoria(ColaProcesos mainqueue) {
        int j=0;
        int i;
        int frame_null;

        System.out.println("\n >>>> Desfragmentando memoria\n");
        for(int z=0;z<3;z++){
            System.out.println("..." );
            try {
                Thread.sleep(550);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        if (mainqueue.NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos en memoria \n");
        } else {
            
            for(i=0;i<64;i++){

                if (marcos[i]==null) {
                    frame_null = i;
                    for (int k = (i+1); k < 64; k++) {
                        if (marcos[k]!=null) {
                            System.out.println(marcos[k]);
                            String string = marcos[k];
                            String[] parts = string.split(" - ");
                            // String[] parts = marcos[k].split(" - ");
                            String nombre_proceso = parts[0]; // 123
                            
                            String pagina = parts[1]; // 654321
                            String[] parts2 = pagina.split("Page ");
                            String numero_pagina = parts2[1];
                            int num = Integer.parseInt(numero_pagina);
                            
                            for (Proceso temporal : mainqueue.NuevaColaProcesos) {
                
                                if (nombre_proceso==temporal.getNombre()) {
                                    temporal.tabla_paginas[num]=frame_null;
                                    marcos[frame_null]=temporal.getNombre()+" - Page "+num;
                                    marcos[k]=null;
                                    break;
                                }
                
                            }
                            break;
                        }
                        
                    }
                }                  
            } 
       
            System.out.println("\n ----------------------- NUEVA LISTA LIGADA DE PROCESOS Y HUECOS -----------------------\n");
            System.out.println("| PROCESO/HUECO | DIRECCION BASE DE LA PAGINA | LONGITUD |---|---> \n");
            j = 0;
            for(i=0;i<64;i++){

                switch (i) {
                    case 0:
                        System.out.println("    | "+marcos[i]+" |"+"| 0 | 16 |---|---");
                        j = j+16;
                        break;

                    case 63:
                        System.out.println("--->| "+marcos[i]+" |"+"| "+j+"| 16 | X |");
                        break;
            
                    default:
                        System.out.println("--->| "+marcos[i]+" |"+"| "+j+" | 16 |---|---");
                        j = j+16;
                        break;
                }      
            
            }   

        }

    }
} 


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
                    if (marcos[i]==null)
                         System.out.println("    | "+"H"+" |"+"| 0 | 16 |---|---");
                    else
                        System.out.println("    | "+marcos[i]+" |"+"| 0 | 16 |---|---");
                    j = j+16;
                 
                        
                    break;

                case 63:
                    if (marcos[i]==null)
                          System.out.println("--->| "+"H"+" |"+"| "+j+"| 16 | X |");
                    else
                        System.out.println("--->| "+marcos[i]+" |"+"| "+j+"| 16 | X |");
                    break;
            
                default:
                    if (marcos[i]==null)
                        System.out.println("--->| "+"H"+" |"+"| "+j+" | 16 |---|---");
                    else
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
    public void desfragmentar_memoria(ColaProcesos Q) {
        
        int j=0;
        int i;
        int k;
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
        
        if (Q.NuevaColaProcesos.size()==0) {
            System.out.println("\n >>>>>>> No hay procesos en memoria \n");
        } else {
            
            for(i=0;i<64;i++){

                if (this.marcos[i]==null) {
                    frame_null = i;
                    for (k = (i+1); k < this.marcos.length; k++) {
                        if (this.marcos[k]!=null) {

                            this.marcos[frame_null]=this.marcos[k];
                            this.marcos[k]=null;

                            String string = this.marcos[frame_null];
                            String[] parts = string.split(" - ");
                            
                            String nombre_proceso = parts[0];
                            
                            
                            String pagina = parts[1]; 
                            String[] parts2 = pagina.split("Page ");
                            String numero_pagina = parts2[1];
                            int num = Integer.parseInt(numero_pagina);
                            
                            
                            for (Proceso temporal : Q.NuevaColaProcesos) {

                                if (nombre_proceso.equals(temporal.getId_Proc())) {
                                    temporal.tabla_paginas[num]=frame_null;
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
            this.estado_de_la_memoria();

        }
                            

    }

    
   
} 


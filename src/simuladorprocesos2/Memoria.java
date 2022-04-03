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
    public String[] localidades = new String[1024];
    public int capacidad ;

    public Memoria() {
    }

    public Memoria(int capacidad) {
        this.capacidad = capacidad;
    }

    public String[] getLocalidades() {
        return localidades;
    }

    public void setLocalidades(String[] localidades) {
        this.localidades = localidades;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void llenarMem(){
        for(int i=0;i<1024;i++)
            this.localidades[i]=null;          
    }
    /*
     * Nueva funcion. Lista ligada de procesos y huecos
     * 
     */
    public void estado_de_la_memoria(){
        
    }
    
    /*
     * Nueva funcion. Desfragmentacion y muestra de la lista ligada de procesos y huecos.
     * 
     */
    public void desfragmentar_memoria(){

        int j=0;
        int registro_base_null;

        for (int i = 0; i < 1024; i++) {

            //if (i==0) {
            //    if (localidades[i] == null) {
            //        registro_base_null = 0;
            //    }
            //}

            j++;
            if (j==16) {
                j=0;
                System.out.println(i);
                System.out.println();
                System.out.println(i+1);
            }
        }
    
    }

} 

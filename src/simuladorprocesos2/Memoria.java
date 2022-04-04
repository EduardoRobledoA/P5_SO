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
    
    public void estado_de_la_memoria(){
    
   }
    
   public void desfragmentar_memoria(){
       
   }

} 

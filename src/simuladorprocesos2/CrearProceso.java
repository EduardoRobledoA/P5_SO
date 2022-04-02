/*+
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorprocesos2;
//import static java.lang.Thread.sleep;
// java.util.logging.Level;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.logging.Logger;
/**
 *
 * @author Eduardo Robledo Aguirre
 * @author Roberto Toledo Sanchez
 */
public class CrearProceso {

    /**
     *
     */
    public CrearProceso() {
    }
    
    /**
     *
     * @param memoria
     * @return proceso, se retorna un objeto proceso
     */
    public Proceso Crear(Memoria memoria){
        String nombre;
        int i;
        Scanner teclado = new Scanner(System.in);
        Proceso proceso = new Proceso();
        
        System.out.println("Ingrese el nombre del proceso: ");
        nombre = teclado.nextLine();
        proceso.setNombre(nombre);
       
        System.out.println("\n");
        for(i=0;i<3;i++){
            System.out.println("Creando " + proceso.getNombre()+"..." );
            try {
                Thread.sleep(550);
            } catch (InterruptedException ex) {
                Logger.getLogger(CrearProceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.asignacion_Id(proceso);
        this.asignacion_Instrucciones(proceso);  
        this.asignacion_Memoria(proceso);     
        if(this.validacionMemoria(memoria, proceso)){
            this.insercionProceso(memoria, proceso);
            System.out.println("Proceso "+nombre+" ha sido creado");
            System.out.println("\nid: "+proceso.getId_Proc());
            System.out.println("# instrucciones: "+proceso.getNo_Instrucciones()); 
            System.out.println("Memoria ocupada: "+proceso.getMemoria());
            System.out.println("Memoria disponible actualizada: "+memoria.getCapacidad()+"\n");
            return proceso;
        }
        return null;
    }
    
    /**
     *
     * @param proceso
     */
    public void asignacion_Id(Proceso proceso){
        String id;
        Random id_num = new Random();
        id = (id_num.nextInt(1000))+"_"+proceso.getNombre();
        proceso.setId_Proc(id); 
    }
    
    /**
     *
     * @param proceso
     */
    public void asignacion_Instrucciones(Proceso proceso){
        int instrucciones = 31;
        Random no_ins = new Random();
        
        while(instrucciones>30)
            instrucciones = (no_ins.nextInt(30)+10);
        proceso.setNo_Instrucciones(instrucciones);  
    }
    
    /**
     *
     * @param proceso
     */
    public void asignacion_Memoria(Proceso proceso){
        int inst = proceso.getNo_Instrucciones();
        
        if(inst<=15)
            proceso.setMemoria(64);
        else if(inst>15 && inst<=20)
            proceso.setMemoria(128);
        else if(inst>20 && inst<=25)
            proceso.setMemoria(256);
        else if(inst>25)
            proceso.setMemoria(512);   
    }

    /*
     * Modificacion funcion
     * 
     */

    public void insercionProceso(Memoria memoria, Proceso proceso){
        int i=0;
        int j;
        while(memoria.localidades[i] !=null)
            i++;
        int base = i;
        int limite =base+proceso.getMemoria()-1;
        proceso.setDirBase(base);
        proceso.setDirLimite(limite);
        for(j=base;j<=limite;j++)
            memoria.localidades[j]=proceso.getNombre();
    }
    
    public boolean validacionMemoria(Memoria memoria, Proceso proceso){
        int mem_Ocupada = proceso.getMemoria();
        int mem_Disponible = memoria.getCapacidad();
   
        if(mem_Disponible>=mem_Ocupada){
            memoria.setCapacidad(mem_Disponible-mem_Ocupada);         
            return true;
        }else{
            System.out.println("\nNo hay memoria disponible");
            System.out.println("Memoria ocupada por el proceso: "+proceso.getMemoria());
            System.out.println("Memoria disponible : "+memoria.getCapacidad());
            System.out.println("¡Para crear nuevo proceso es necesario ejecutar o matar otros procesos!\n");
            return false;
        }    
    }
}
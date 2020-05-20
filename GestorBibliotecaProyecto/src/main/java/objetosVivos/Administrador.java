/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosVivos;

/**
 *Administrador mediante esta clase se podrá manipular y gestionar todo el gestor de la biblioteca es como
 * un jefe y puede añadir y quitar gestores o usuarios
 * 
 * @author nicoc
 */
public class Administrador extends Persona {
     private Gestor[] trabajadores;//Array de gestores que tiene el administrador
    public Administrador(String n, String a, byte e, String d) {
        super(n, a, e, d);
        
   this.trabajadores=new Gestor[3];
    }
    
    /**
     * Getter de trabajadores
     * @return los trabajadores
     */
     public Gestor[] getTrabajadores() {
        return trabajadores;
    }
     
     /**
      * Setter de trabajadores
      * @param trabajadores a modificar
      */
    public void setTrabajadores(Gestor[] trabajadores) {
        this.trabajadores = trabajadores;
    }
    
    
  
    
    
    
    
}

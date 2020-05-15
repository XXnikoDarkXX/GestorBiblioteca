/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosVivos;

/**
 *
 * @author nicoc
 */
public class Usuario extends Persona {
    private boolean estado;//Si esta dado de alta o esta de baja 
    
    /**
     * Constructor de Usuario con los parametros de Persona
     * @param n nombre del usuario
     * @param a apellido del usuario
     * @param e edad del usuario
     * @param d dni del usuario
     */
    public Usuario(String n, String a, byte e, String d) {
        super(n, a, e,d);
        
    }

    
    /**
     * Getter de estado
     * @return el estado true si esta dado de alta y false si esta dado de baja
     */
    public boolean isEstado() {
        return estado;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosLectura;

/**
 *Excepcion de Lectura en caso de que un usuario elija un codigo de libro ya elegido nos saltara este error
 * @author nicoc
 */
public class LecturaExcepcion  extends Exception{
       public LecturaExcepcion() {
       
           super();
    }
       public LecturaExcepcion(String message) {
        super(message);
    }
}

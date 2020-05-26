/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosLectura;

/**
 *
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosVivos;

/**
 *Cuando elijamos un gestor por el nif en caso de que este mal escrito nos dara el error de que el nif elegido no existe
 * @author nicoc
 */
public class GestorExcepcion extends Exception{
 public GestorExcepcion() {
        super();
    }
       public GestorExcepcion(String message) {
        super(message);
    }   
}

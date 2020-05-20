/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nicoc
 * Interface por la cual podremos gestionar si un usuario puede pedir un libro, revista o periodico si esta disponible o no
 */
public interface Prestamo {
    /**
     * Interfaz por el cual comparamos el codigo de la lectura y si su prestamo es usado no se podrá usar
     * @param Codigo codigo de lectura puede ser libro,revista,o periodico
     */
    public String gestionLecturaUsuario(byte codigo);
      
    
        
    
}

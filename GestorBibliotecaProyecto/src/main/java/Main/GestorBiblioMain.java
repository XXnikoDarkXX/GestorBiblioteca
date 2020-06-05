/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import graficos.GraficoVentana;
import objetosLectura.Lectura;
import objetosLectura.LecturaExcepcion;
import objetosLectura.Libro;
import objetosLectura.Periodico;
import objetosLectura.Revista;
import objetosVivos.Administrador;
import objetosVivos.Gestor;
import objetosVivos.GestorExcepcion;
import objetosVivos.Usuario;

/**
 *
 * @author nicoc
 */
public class GestorBiblioMain {

    /**Main principal para el programa de Biblioteca
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, LecturaExcepcion, GestorExcepcion {
       
       Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
            GraficoVentana ventana=new GraficoVentana();
            ventana.setVisible(true);
            
      
        
     
        
 
        

     
       
    }
    
}

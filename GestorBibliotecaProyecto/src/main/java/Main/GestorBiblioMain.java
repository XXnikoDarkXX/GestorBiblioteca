/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import objetosLectura.Lectura;
import objetosLectura.Libro;
import objetosLectura.Periodico;
import objetosLectura.Revista;
import objetosVivos.Gestor;
import objetosVivos.Usuario;

/**
 *
 * @author nicoc
 */
public class GestorBiblioMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       
         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
            
        Usuario prueba=new Usuario("pepe","garcia",(byte)22,"64332");
        
        Gestor nicolas=new Gestor("Nicolas","sanchez",(byte)18,"54373141");
        
        Revista lectu=new Revista((byte)5,"La morte","conduccion","Soto");
        
        nicolas.agregarLectura(lectu);
    }
    
}

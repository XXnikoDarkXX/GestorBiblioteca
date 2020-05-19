/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosVivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import objetosLectura.Libro;

/**
 *
 * @author nicoc
 */
public class Usuario extends Persona {
    private ArrayList <Libro>libros=new ArrayList();
    private boolean estado;//Si esta dado de alta o esta de baja 
    
            
    
    
    
    /**
     * Constructor de Usuario con los parametros de Persona
     * @param n nombre del usuario
     * @param a apellido del usuario
     * @param e edad del usuario
     * @param d dni del usuario
     */
    public Usuario(String n, String a, byte e, String d)  {
        super(n, a, e,d);
        
    }

    
    /**
     * Getter de estado
     * @return el estado true si esta dado de alta y false si esta dado de baja
     */
    public boolean isEstado() {
        return estado;
    }
    
    /**
     * Getter de los libros del  usuario
     * @return 
     */
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    
    //Setter de los libros del usuario
    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }
    //Setter para dar de alta o baja a un usuario
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
    /**
     * Metodo para Consultar cuales libros hay disponibles
     * @return 
     */
    public String consultarLibros() throws SQLException{
      
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from LIBROS");
         String libros="";   
            while (rs.next()) {
           libros+=rs.getInt("CODIGO")+ " : " + rs.getString("NOMBRE") + " : " + rs.getString("CATEGORIA")+ " : " + rs.getString("PRESTAMO");
        }
           
        
       rs.close();
        return libros;
    }
    
    /**
     * Metodo por el cual un usuario puede elegir un libro
     * @param nombreLibro nombre del libro por el cual va a ser usado
     */
    public void elegirLibro(String nombrelibro) throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from LIBROS");
        
         int nfilas = smt.executeUpdate("update libros set PRESTAMO='EN USO' where NOMBRE="+nombrelibro);
          
        
        rs.close();
    }
    
    
}

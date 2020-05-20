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
import objetosLectura.Lectura;
import objetosLectura.Libro;
import objetosLectura.Periodico;
import objetosLectura.Revista;

/**
 *Trabajador de la biblioteca solo tiene el poder de gestionar los libros es decir, añadirlos y consultarlos
 * EXPLICAR PARA QUE SIRVE
 * @author nicoc
 */
public class Gestor extends Persona {
   
    public Gestor(String n, String a, byte e, String d) {
        super(n, a, e, d);
        
   
    }
    
    /**
     * Damos de alta al usuario
     * @param user usuario al cual le damos de alta
     */
     public void darAltaUsuario(Usuario user){
        user.setEstado(true);
    }
    
    /**
     * Damos de baja al usuario
     * @param user ususuario que damos de baja
     */
    public void darBajaUsuario(Usuario user){

    }
    /**
     * Agregamos libro a la base 
     * antes buscamos que tipo es el objeto le y en caso
     * de ser periodico, libro o revista se insertara en su respectiva tabla de la bbdd
     * @param le 
     */
    public void agregarLectura(Lectura le) throws SQLException{
                  Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        
        if (le.getClass().getName()=="objetosLectura.Libro") {//mediante estos metodo podremos saber que tipo va a a ser
            //el objeto le en caso de que sea libro ...
            ResultSet rs = smt.executeQuery("select * from LIBROS");//Mediante este metodo selecionamos la tabla
            //Y lo insertamos
      int nfilas = smt.executeUpdate("insert into LIBROS values (" + (byte)le.getCodigo() + ",'" + le.getNombre() 
    + "', '" +((Libro)le).getCategoria()+"', '" + le.getEstadoPrestamo() + "','"+ ((Libro)le).getEditorial()+ "') ");
                   
               rs.close();
        }else if(le.getClass().getName()=="objetosLectura.Periodico"){
              ResultSet rs = smt.executeQuery("select * from periodico");//Mediante este metodo selecionamos la tabla
             int nfilas = smt.executeUpdate("insert into PERIODICO values (" + (byte)le.getCodigo() + ",'" + le.getNombre() 
    + "', '" +((Periodico)le).getEditorial()+"', '" + le.getEstadoPrestamo() + "','"+ ((Periodico)le).getTipoDeNoticias()+ "') ");
      rs.close();
        }else if(le.getClass().getName()=="objetosLectura.Revista"){
             ResultSet rs = smt.executeQuery("select * from revista");
          int nfilas = smt.executeUpdate("insert into revista values (" + (byte)le.getCodigo() + ",'" + le.getNombre() 
    + "', '" +((Revista)le).getTipoRevista()+"', '" +((Revista)le).getAutor() + "','"+ le.getEstadoPrestamo()+ "') ");
         
            
            
        }
         
        
     
        smt.close();
        con.close();
        
        
    }
    
    
    
    
}

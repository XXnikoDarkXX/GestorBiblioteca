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
import objetosLectura.Lectura;
import objetosLectura.Libro;

/**
 *
 * @author nicoc
 */
public class Usuario extends Persona {

    private ArrayList<Libro> libros = new ArrayList();
    private boolean estado;//Si esta dado de alta o esta de baja 

    /**
     * Constructor de Usuario con los parametros de Persona
     *
     * @param n nombre del usuario
     * @param a apellido del usuario
     * @param e edad del usuario
     * @param d dni del usuario
     */
    public Usuario(String n, String a, byte e, String d) {
        super(n, a, e, d);

    }

    /**
     * Getter de estado
     *
     * @return el estado true si esta dado de alta y false si esta dado de baja
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Getter de los libros del usuario
     *
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
     * Metodo para Consultar cuales libros hay disponibles Nos conectamos a la
     * bbdd y cargamos al String la informacion
     *
     * @return un String con todos los libros que no estan en uso
     */
    public String consultarLibros() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from LIBROS");
        String libros = "CODIGO   |  NOMBRE  |  CATEGORIA |  PRESTAMO \n";
        int i = 0;//contador
        while (rs.next()) {
            if (rs.getString("PRESTAMO").equalsIgnoreCase("NO EN USO")) {
                libros += rs.getInt("CODIGO") + " :      " + rs.getString("NOMBRE") + " :     " + rs.getString("CATEGORIA") + " :     " + rs.getString("PRESTAMO");

            }
        }

        rs.close();
        smt.close();
        con.close();
        return libros;
    }

    /**
     * Metodo para consultar cuales revistas estan disponible
     *
     * @return String con toda la informacion
     * @throws SQLException lanzara un error de bbdd sql
     */
    public String consultarRevistas() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from revista");
        String revista = "CODIGO         |       NOMBRE       |      TIPODEREVISTA    |      AUTOR     |    PRESTAMO \n";
        int i = 0;//contador
        while (rs.next()) {
            if (rs.getString("PRESTAMO").equalsIgnoreCase("NO EN USO")) { 
                revista += rs.getInt("CODIGO") + " :\t\t" + rs.getString("NOMBRE") + " :  \t\t" + rs.getString("TIPOREVISTA") + " :\t\t " + rs.getString("AUTOR") + " : \t\t" + rs.getString("PRESTAMO");

            }
        }

        rs.close();
        smt.close();
        con.close();
        return revista;
    }

    /**
     *Metodo para consultar que periodicos estan disponible
     * @return un String con toda la informacion
     * @throws SQLException En caso de error en la consulta de BBDD  lanzara la excepcion 
     */
    public String consultarPeriodicos() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from PERIODICO");
        String periodico = "CODIGO         |       NOMBRE       |      EDITORIAL    |      PRESTAMO     |    TIPODENOTICIAS \n";
        int i = 0;//contador
        while (rs.next()) {
            if (rs.getString("PRESTAMO").equalsIgnoreCase("NO EN USO")) {
                periodico += rs.getInt("CODIGO") + " :                 " + rs.getString("NOMBRE") + " :          "+rs.getString("EDITORIAL") + " :       " + rs.getString("PRESTAMO") + " :        " + rs.getString("TIPODENOTICIAS");

        }
            }

        rs.close();
        smt.close();
        con.close();
        return periodico;
    }
        /**
         * 
         * @param codigo
         * @throws SQLException 
         */
    public void elegirLibro(byte codigo) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta

        ResultSet rs = smt.executeQuery("select * from LIBROS");
        
        int nfilas = smt.executeUpdate("update libros set PRESTAMO='EN USO' where codigo=" + codigo);//Ponemos 
        //el prestamo en uso

        rs.close();
        smt.close();
        con.close();

    }

    public void elegirRevista(byte codigo) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from revista");

        int nfilas = smt.executeUpdate("update revista set PRESTAMO='EN USO' where NOMBRE=" + codigo);//Ponemos 
        rs.close();

        smt.close();
        con.close();
    }

    public void elegirPeriodico(byte codigo) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta

        ResultSet rs = smt.executeQuery("select * from periodico");//Mediante este metodo selecionamos la tabla
        int nfilas = smt.executeUpdate("update periodico set PRESTAMO='EN USO' where NOMBRE=" + codigo);//Ponemos 

    }

}

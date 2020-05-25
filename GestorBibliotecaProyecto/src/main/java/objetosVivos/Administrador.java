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
import java.util.LinkedList;
import objetosLectura.LecturaExcepcion;

/**
 * Administrador mediante esta clase se podrá manipular y gestionar todo el
 * gestor de la biblioteca es como un jefe y puede añadir y quitar gestores o
 * usuarios
 *
 * @author nicoc
 */
public class Administrador extends Persona {

    public Administrador(String n, String a, byte e, String d) {
        super(n, a, e, d);

    }

    /**
     * Funcion por el cual el administrador puede borrar Gestores por medio del
     * nif
     *
     * @param nif
     * @throws SQLException
     */
    public void borrarGestor(String nif) throws SQLException, GestorExcepcion {
        int contador = 0;//lo usremos para saber si el nif no existe
        LinkedList<String> lista = new LinkedList();//creamos una lista donde tenemos todos los codigos que estan en uso
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from gestor");//Mediante este metodo selecionamos la tabla
        //MEDIANTe este while añadimos a las lista los codigos en uso
        while (rs.next()) {

            lista.add(rs.getString("NIF"));

        }

        for (int i = 0; i < lista.size(); i++) {
            if (nif.equalsIgnoreCase(lista.get(i)) ) {
                contador++;

            }

        }
        if (contador==0) {
            throw new GestorExcepcion("ERROR: has elegido un NIF invalido elije otro");
        }
        int nfilas = smt.executeUpdate("delete from GESTOR WHERE NIF='" + nif +"'");
    }

    /**
     * Mostramos todos los gestores que hay en la tabla de la bbdd
     *
     * @return en un string sus datos
     * @throws SQLException
     */
    public String mostrarGestores() throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from GESTOR");
        String gestor = "NIF         |       NOMBRE       |      APELLIDO    |      EDAD \n";
        int i = 0;//contador
        while (rs.next()) {

            gestor += rs.getString("NIF") + " :           " + rs.getString("NOMBRE") + " :          " + rs.getString("APELLIDO") + " :       " + rs.getInt("EDAD");

        }
        rs.close();
        smt.close();
        con.close();
        return gestor;
    }

}

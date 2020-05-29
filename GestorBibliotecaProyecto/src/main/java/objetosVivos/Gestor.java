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
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import objetosLectura.Lectura;
import objetosLectura.Libro;
import objetosLectura.Periodico;
import objetosLectura.Revista;

/**
 * Trabajador de la biblioteca solo tiene el poder de gestionar los libros es
 * decir, añadirlos y consultarlos EXPLICAR PARA QUE SIRVE
 *
 * @author nicoc
 */
public class Gestor extends Persona {
	
	
	

    public Gestor(String n, String a, byte e, String d)  {
    	
        super(n, a, e, d);
        try {
       
      //  this.insertarGestor(d,n,a,e);
    	}catch(NumberFormatException ex) {
    		ex.printStackTrace();
    		System.out.println("Error te has equivocado y no has introducido un numero");
    	}
    }
    /**
     * Concstructor De Gestor Vacio
     */
    	public Gestor() {
		
	}
    
    /**
     * Damos de alta al usuario
     *
     * @param user usuario al cual le damos de alta
     */
    public void darAltaUsuario(Usuario user) throws SQLException {
        user.setEstado(true);
      
    }
    
    
    public  void insertarGestor  (String dni,String nombre,String apellido,byte edad) throws SQLException{
         Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from gestor");//Mediante este metodo selecionamos la tabla
         
          int nfilas = smt.executeUpdate("insert into gestor values ('" + dni + "','" + nombre+
                  "','" + apellido + "',"+edad+ ") ");
      
        
        
      /*int nfilas = smt.executeUpdate("insert into gestor values ('" + "343ra" + "','" + "pikachy" + "','" + "fernandez" +
              "',"+3+ ") ");*/
       
       rs.close();
       smt.close();
       con.close();
    }
    
    

    /**
     * Damos de baja al usuario
     *
     * @param user ususuario que damos de baja
     */
    public void darBajaUsuario(Usuario user) {
        user.setEstado(false);
    }

    /**
     * Agregamos libro a la base antes buscamos que tipo es el objeto le y en
     * caso de ser periodico, libro o revista se insertara en su respectiva
     * tabla de la bbdd
     *
     * @param le objeto de tipo lectura por el cual usaremos para insertar los
     * libros
     */
    public void agregarLectura(Lectura le) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta

        if (le.getClass().getName() == "objetosLectura.Libro") {//mediante estos metodo podremos saber que tipo va a a ser
            //el objeto le en caso de que sea libro ...
            ResultSet rs = smt.executeQuery("select * from LIBROS");//Mediante este metodo selecionamos la tabla
            //Y lo insertamos
            int nfilas = smt.executeUpdate("insert into LIBROS values (" + (byte) le.getCodigo() + ",'" + le.getNombre()
                    + "', '" + ((Libro) le).getCategoria() + "', '" + le.getEstadoPrestamo() + "','" + ((Libro) le).getEditorial() + "') ");

            rs.close();
        } else if (le.getClass().getName() == "objetosLectura.Periodico") {
            ResultSet rs = smt.executeQuery("select * from periodico");//Mediante este metodo selecionamos la tabla
            int nfilas = smt.executeUpdate("insert into PERIODICO values (" + (byte) le.getCodigo() + ",'" + le.getNombre()
                    + "', '" + ((Periodico) le).getEditorial() + "', '" + le.getEstadoPrestamo() + "','" + ((Periodico) le).getTipoDeNoticias() + "') ");
            rs.close();
        } else if (le.getClass().getName() == "objetosLectura.Revista") {
            ResultSet rs = smt.executeQuery("select * from revista");
            int nfilas = smt.executeUpdate("insert into revista values (" + (byte) le.getCodigo() + ",'" + le.getNombre()
                    + "', '" + ((Revista) le).getTipoRevista() + "', '" + ((Revista) le).getAutor() + "','" + le.getEstadoPrestamo() + "') ");

            rs.close();

        }

        smt.close();
        con.close();

    }

    /**
     * Metodo por el cual usando la id del libro creado podemos borrar un libro
     *
     * @param le
     * @throws SQLException
     *
    public void borrarLectura(Lectura le) throws SQLException {
    	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta

        if (le.getClass().getName() == "objetosLectura.Libro") {//mediante estos metodo podremos saber que tipo va a a ser
            //el objeto le en caso de que sea libro ...
            ResultSet rs = smt.executeQuery("select * from LIBROS");
            int nfilas = smt.executeUpdate("delete from libros where CODIGO= " + (byte) le.getCodigo());//borramos el libro que 
            //tenga la id de le

            rs.close();
        } else if (le.getClass().getName() == "objetosLectura.Periodico") {
            ResultSet rs = smt.executeQuery("select * from periodico");//Mediante este metodo selecionamos la tabla
            int nfilas = smt.executeUpdate("delete from periodico where CODIGO= " + (byte) le.getCodigo());//borramos el libro que 

            rs.close();
        } else if (le.getClass().getName() == "objetosLectura.Revista") {
            ResultSet rs = smt.executeQuery("select * from revista");

            int nfilas = smt.executeUpdate("delete from revista where CODIGO= " + (byte) le.getCodigo());//borramos el libro que 
            rs.close();

        }
        smt.close();
        con.close();
    }
    
    */
    
    /**
     * Metodo para borrar Libro de la bbdd
     * @param codigo que pasamos por parametro para borrar
     * @throws SQLException
     */
    public void borrarLibro(byte codigo) throws SQLException {
   
        	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
            Statement smt = con.createStatement();//Crear la consulta

           
                ResultSet rs = smt.executeQuery("select * from LIBROS");
               int nfilas = smt.executeUpdate("delete from libros where CODIGO= "+ (byte)codigo);//borramos el libro que 
                //tenga la id 

                rs.close();
                smt.close();
                con.close();
    }
    /**
     * Metodo para borrar una revista de la bbdd
     * @param codigo que pasamos por parametros para borrar la revista
     * @throws SQLException en caso de error con la peticion de la bbdd nos lanzara este error
     */
    public void borrarRevista(byte codigo) throws SQLException {
    	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
    	
    	 ResultSet rs = smt.executeQuery("select * from revista");

         int nfilas = smt.executeUpdate("delete from revista where CODIGO= " + (byte)codigo);//borramos el libro que 
         rs.close();
    }
    
    
    
    public void borrarPeriodico(byte codigo) throws SQLException {
    	Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
    	
    	
    	ResultSet rs = smt.executeQuery("select * from revista");

        int nfilas = smt.executeUpdate("delete from revista where CODIGO= " + (byte)codigo);//borramos el libro que 
        rs.close();
    }
    
    
    
    /**
     * Metodo para insertarUsuario
     * @param user usuario que creamos
     * @throws SQLException en caso de error lanzara esta excepcion de la bbdd
     */
    public void insertarUsuario(Usuario user) throws SQLException {
    	try {
    	 Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
         Statement smt = con.createStatement();//Crear la consulta
         ResultSet rs = smt.executeQuery("select * from USUARIO");//Mediante este metodo selecionamos la tabla
          
        //   int nfilas = smt.executeUpdate("insert into USUARIO values ('" + "PREUBA" + "','" + "FERNANDEZ"+
          //         "','" + 33 + "','"+"545A"+ "','"+"BAJA"+"') ");
       
       int nfilas = smt.executeUpdate("insert into USUARIO values ('" + user.getNombre() + "','" + user.getApellido()+
          "','" + user.getEdad() + "','"+user.getDni()+ "','"+user.isEstado()+"') ");
       rs.close();
       smt.close();
       con.close();
         
    	}catch(SQLIntegrityConstraintViolationException ex) {
    		ex.printStackTrace();
    		System.out.println("Has puesto un nif ya elegido");
    	}
        
        
    }
    
    
    /**
     * Metodo para Consultar los libros
     *
     * @return un String con todos los libros que no estan en uso
     */
    public String consultarLibros() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from LIBROS");
        String libros = "CODIGO\t   |  NOMBRE\t  |  CATEGORIA\t |  PRESTAMO  \t| EDITORIAL  \n";
       
        while (rs.next()) {
            
                libros += rs.getInt("CODIGO") + " :\t    " + rs.getString("NOMBRE") + " :\t" + rs.getString("CATEGORIA") + " :\t" + rs.getString("PRESTAMO") + " :\t       " + rs.getString("EDITORIAL")+"\n";

            
        }

        rs.close();
        smt.close();
        con.close();
        return libros;
    }
    
    
    
    /**
     * Metodo para consultarl las Revistas
     *
     * @return String con toda la informacion
     * @throws SQLException lanzara un error de bbdd sql
     */
    public String consultarRevistas() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from revista");
        String revista = "CODIGO\t|NOMBRE  \t|TIPODEREVISTA |\t   AUTOR     | \t   PRESTAMO \n";
        int i = 0;//contador
        while (rs.next()) {
            
                revista += rs.getInt("CODIGO") + "\t" + rs.getString("NOMBRE") + " :\t" + rs.getString("TIPOREVISTA") + " :\t        " + rs.getString("AUTOR") + " : \t" + rs.getString("PRESTAMO")+"\n";

            
        }

        rs.close();
        smt.close();
        con.close();
        return revista;
    }
    /**
     * Metodo para consultar que periodic
     *
     * @return un String con toda la informacion
     * @throws SQLException En caso de error en la consulta de BBDD lanzara la
     * excepcion
     */
    public String consultarPeriodicos() throws SQLException {

        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/BIBLIOTECA?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "admin");
        Statement smt = con.createStatement();//Crear la consulta
        ResultSet rs = smt.executeQuery("select * from PERIODICO");
        String periodico = "CODIGO         |       NOMBRE       |      EDITORIAL    |      PRESTAMO     |    TIPODENOTICIAS \n";
        int i = 0;//contador
        while (rs.next()) {
          
                periodico += rs.getInt("CODIGO") + " :                 " + rs.getString("NOMBRE") + " :          " + rs.getString("EDITORIAL") + " :       " + rs.getString("PRESTAMO") + " :        " + rs.getString("TIPODENOTICIAS");

            
        }

        rs.close();
        smt.close();
        con.close();
        return periodico;
    }

}

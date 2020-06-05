/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosLectura;


/**
 *SuperClase lectura todo lo relacionado con los libros,revistas, periódicos.... se heredará de aqui
 * @author nicoc
 */
public abstract class Lectura {
    
    private String nombre;//nombre
    private byte codigo;//codigo del libro
    private String estadoPrestamo;//si esta en uso o no
    
    /**
     * Contructor de Lectura
     * @param n nombre de la lectura
     * @param c categoria de la lectura
     * @param es estado del prestamo
     */
    public Lectura(byte codigo,String n){
        this.nombre=n;
        this.codigo=codigo;
        this.estadoPrestamo="NO EN USO";
        
     
    }
    /**
     * Gettter de Nombre
     * @return el nombre de la lectura
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Getter del codigo
     * @return el codigo de la lectura
     */
    public byte getCodigo(){
        return codigo;
    }
    
    
    /* Getter del estadoPrestamo
     * @return estado del préstamo
     */
    public String getEstadoPrestamo() {
        return estadoPrestamo;
    }
    /**
     * Setter de nombre
     * @param nombre a cambiar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    /**
     * Setter del estadoPrestamo
     * @param estadoPrestamo a cambiar
     */
    public void setEstadoPrestamo(String estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }
    /**
     * Setter de codigo
     * @param codigo a cambiar
     */
    public void setCodigo(byte codigo) {
        this.codigo = codigo;
    }

   

  
    /**
     * Funcion que hace que si usas un codigo en uso mostrara un mensaje de usar
     * @param codigo
     * @return
     */
    public  String gestionLecturaUsuario(byte codigo) {
        
        String mensajeUsar="";
        if (codigo==this.codigo) {
            if (this.estadoPrestamo.equalsIgnoreCase("no en uso")) {
                mensajeUsar="si";
            }else{
                mensajeUsar="no";
            }
        }else{
            mensajeUsar="te has equivocado de codigo";
           
        }
        return mensajeUsar;
    
    } 
    
    
    
    
    
}

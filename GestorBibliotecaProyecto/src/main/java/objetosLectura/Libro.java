/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosLectura;

/**
 *Clase libro en el detallaremos todas las funciones importantes así como las interaciones con las personas
 * @author nicoc
 */
public class Libro extends Lectura{
    private String editorial;//editorial del libro
    private String categoria;//categoria del libro 
    
    
    /**
     * Constructor de Libro con todos los campos
     * @param n nombre del libro
     * @param c codigo del libro
     * @param categoria categoria del libro
     * @param ed editorial del  libro
     */
    public Libro(String n, byte c,String categoria,String ed) {
        super(c,n );
        this.categoria=categoria;
        this.editorial=ed;
        
    }
    
    /**
     * Getter de Editorial
     * @return la editorial
     */
    public String getEditorial() {
        return editorial;
    }
    /**
     * Getter de Categoria
     * @return la categoria
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * Setter de Editorial
     * @param editorial a cambiar
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    /**
     * Setter de categoria
     * @param categoria a cambiar
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Libro{" +"codigo: "+super.getCodigo()+ "nombre: "+super.getNombre()+ "editorial=" + editorial 
                + ", categoria=" + categoria + "prestamo: "+super.getEstadoPrestamo()+'}';
    }
    
    
    
    
    
    
    
    
}

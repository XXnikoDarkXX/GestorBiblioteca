/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosLectura;

/**
 *Clase revista 
 * @author nicoc
 */
public class Revista extends Lectura {
    
    private String tipoRevista;//Tipo de revista, negocios, oficio, etc
    private String autor;//nombre del autor de la revista
    
    /**
     * Constructor de Revista
     * @param codigo de la revista
     * @param n nombre de la revista
     * @param tr tipo de revista
     * @param au autor de la revista
     */
    public Revista(String codigo, String n,String tr,String au) {
        super(codigo, n);
        this.tipoRevista=tr;
        this.autor=au;
     
    }

    /**
     * Getter del tipo de Revista
     * @return el tipo de revista
     */
    public String getTipoRevista() {
        return tipoRevista;
    }
    /**
     * Getter de autor
     * @return el autor
     */
    public String getAutor() {
        return autor;
    }
    
    /**
     * Setter de tipoRevista
     * @param tipoRevista  a cambiar
     */
    public void setTipoRevista(String tipoRevista) {
        this.tipoRevista = tipoRevista;
    }

    /**
     * Setter de autor
     * @param autor a cambiar
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Revista{" + "codigo: "+super.getCodigo()+"nombre: "+super.getNombre()+
                "tipoRevista=" + tipoRevista + ", autor=" + autor + "prestamo: "+super.getEstadoPrestamo()+'}';
    }
    
        
    
    
    
    
}

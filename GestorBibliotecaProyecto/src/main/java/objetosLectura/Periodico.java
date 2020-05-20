/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosLectura;

/**
 *Clase periodico
 * @author nicoc
 */
public class Periodico extends Lectura {
    private String editorial;//editorial del periodico el pais, marca, el mundo...
    private String tipoDeNoticias;//Tipo de noticias que da el periodico, deportes, oficio etc
    
    /**
     * Constructor de Periodico
     * @param codigo codigo del periodico
     * @param n nombre del periodico
     * @param ed 
     */
    public Periodico(byte codigo, String n,String ed,String tn) {
        super(codigo, n);
        this.editorial=ed;
        this.tipoDeNoticias=tn;
    }
    
    /**
     * Getter de Editorial
     * @return la editorial
     */
    public String getEditorial() {
        return editorial;
    }
    /**
     * Getter de tipoDeNoticias
     * @return el tipo de noticias
     */
    public String getTipoDeNoticias() {
        return tipoDeNoticias;
    }
    
    /**
     * Setter de editorial
     * @param editorial a cambiar
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    /**
     * Setter de tipo de Noticias
     * @param tipoDeNoticias a cambiar
     */
    public void setTipoDeNoticias(String tipoDeNoticias) {
        this.tipoDeNoticias = tipoDeNoticias;
    }

    @Override
    public String toString() {
        return "Periodico{"+"Codigo: "+super.getCodigo()+"nombre: "+super.getNombre() + "editorial=" + editorial 
                + ", tipoDeNoticias=" + tipoDeNoticias + "prestamo: "+super.getEstadoPrestamo()+'}';
    }
    
    
    
  
    
    
    
    
}

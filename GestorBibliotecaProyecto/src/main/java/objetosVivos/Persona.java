/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosVivos;

import Main.Prestamo;

/**
 *SuperClase Persona contiene todas las variables, funciones... comunes de una persona en nuestro programa
 * @author nicoc
 */
public abstract  class Persona  {
    private String nombre;//nombre de la persona
    private String apellido;//apellido de la persona
    private byte edad;//Edad de la persona
    private String dni;//Dni de la persona
    
    /**
     * Constructor de Persona con todos sus parametros
     * @param n nombre de la persona
     * @param a apellido de la persona
     * @param e edad de la persona
     * @param d dni de la persona
     */
    public Persona(String n,String a, byte e,String d){
        this.nombre=n;
        this.apellido=a;
        this.edad=e;
        this.dni=d;
    }

    /**
     * Getter de nombre
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de apellido
     * @return el Apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Getter de edad
     * @return la edad
     */
    public byte getEdad() {
        return edad;
    }

    /**
     * Setter de nombre
     * @param nombre nombre a modificar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Setter de apellido
     * @param apellido a modificar
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    /**
     * Setter de edad
     * @param edad a modificar
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }
    
    /**
     * Getter del DNI
     * @return el dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * Setter del DNI
     * @param dni a cambiar
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
    

    
}

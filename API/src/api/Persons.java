/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author s115e17
 */
public class Persons {
    
    ////////////////////
    // Atributos ///////
    ////////////////////
    
    /** Identificador unico de la persona (numero de cedula) */
    private Long id;
    
    /** Nombre de la persona (incluye apellidos) */
    private String name;
    
    ////////////////////
    // Metodos
    ////////////////////
    
    /**
     * Constructor predeterminado
     */
    public Persons() {
        
    }
    
    /**
     * Constructor con parametros
     * @param pId Id de la persona a crear
     * @param pName Nombre de la persona a crear
     */
    public Persons(Long pId, String pName) {
        id = pId;
        name = pName;
    }
    
    /**
     * Constructor de copia
     * @param pCopy Objeto que sera clonado para construir la nueva persona
     */
    public Persons(Persons pCopy) {
        id = pCopy.getId();
        name = pCopy.getName();
    }
    
    /**
     * Metodo que devuelve el Person en su
     * representacion de string
     * @return Devuelve la representacion en String
     */
    @Override
    public String toString() {
        return "§" + id + "-" + name + "§";
    }
    
    /**
     * Determina si el parametro es igual 
     * al objeto que llamo al metodo (this)
     * @param o Objeto a verificar
     * @return 
     */
    @Override
    public boolean equals(Object o) {
        if(o instanceof Persons) {
            Persons po = (Persons)o;
            return this.id.equals(po.getId());
        }
        return false;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

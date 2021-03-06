/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author s115e17
 */
public class Personas implements Comparable<Personas> {
    
    ////////////////////
    // Atributos ///////
    ////////////////////
    
    /** Identificador unico de la persona (numero de cedula) */
    private Long id;
    
    /** Nombre de la persona (incluye apellidos) */
    private String name;
    
    private int age;
    
    ////////////////////
    // Metodos
    ////////////////////
    
    /**
     * Constructor predeterminado
     */
    public Personas() {
        
    }
    
    /**
     * Constructor con parametros
     * @param pId Id de la persona a crear
     * @param pName Nombre de la persona a crear
     */
    public Personas(Long pId, String pName,int age) {
        id = pId;
        name = pName;
        this.age = age; 
    }
    
    /**
     * Constructor de copia
     * @param pCopy Objeto que sera clonado para construir la nueva persona
     */
    public Personas(Personas pCopy) {
        id = pCopy.getId();
        name = pCopy.getName();
        this.age = pCopy.getAge();
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
        if(o instanceof Personas) {
            Personas po = (Personas)o;
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
    
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Personas o) {
        if(this.getAge() == o.getAge()) return 0;
        if(age > o.getAge()) return 1;
        return -1;
    }
}

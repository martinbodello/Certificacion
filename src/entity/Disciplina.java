package entity;
// Generated 18/06/2018 11:42:53 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Disciplina generated by hbm2java
 */
public class Disciplina  implements java.io.Serializable {


     private int id;
     private String nombre;
     private Set inscripcions = new HashSet(0);

    public Disciplina() {
    }

	
    public Disciplina(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Disciplina(int id, String nombre, Set inscripcions) {
       this.id = id;
       this.nombre = nombre;
       this.inscripcions = inscripcions;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getInscripcions() {
        return this.inscripcions;
    }
    
    public void setInscripcions(Set inscripcions) {
        this.inscripcions = inscripcions;
    }


    @Override
    public String toString() {
        return nombre;
    }


}



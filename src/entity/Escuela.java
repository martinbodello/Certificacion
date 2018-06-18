package entity;
// Generated 18/06/2018 11:42:53 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Escuela generated by hbm2java
 */
public class Escuela  implements java.io.Serializable {


     private Integer id;
     private String descripcion;
     private Set competidors = new HashSet(0);

    public Escuela() {
    }

	
    public Escuela(String descripcion) {
        this.descripcion = descripcion;
    }
    public Escuela(String descripcion, Set competidors) {
       this.descripcion = descripcion;
       this.competidors = competidors;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getCompetidors() {
        return this.competidors;
    }
    
    public void setCompetidors(Set competidors) {
        this.competidors = competidors;
    }

    @Override
    public String toString() {
        return descripcion;
    }




}


package entity;
// Generated 18/06/2018 11:42:53 by Hibernate Tools 4.3.1



/**
 * Inscripcion generated by hbm2java
 */
public class Inscripcion  implements java.io.Serializable {


     private InscripcionId id;
     private Categoria categoria;
     private Competidor competidor;
     private Disciplina disciplina;
     private Torneo torneo;
     private String aprobada;

    public Inscripcion() {
    }

	
    public Inscripcion(InscripcionId id, Categoria categoria, Competidor competidor, Disciplina disciplina) {
        this.id = id;
        this.categoria = categoria;
        this.competidor = competidor;
        this.disciplina = disciplina;
    }
    public Inscripcion(InscripcionId id, Categoria categoria, Competidor competidor, Disciplina disciplina, Torneo torneo, String aprobada) {
       this.id = id;
       this.categoria = categoria;
       this.competidor = competidor;
       this.disciplina = disciplina;
       this.torneo = torneo;
       this.aprobada = aprobada;
    }
   
    public InscripcionId getId() {
        return this.id;
    }
    
    public void setId(InscripcionId id) {
        this.id = id;
    }
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Competidor getCompetidor() {
        return this.competidor;
    }
    
    public void setCompetidor(Competidor competidor) {
        this.competidor = competidor;
    }
    public Disciplina getDisciplina() {
        return this.disciplina;
    }
    
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    public Torneo getTorneo() {
        return this.torneo;
    }
    
    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
    public String getAprobada() {
        return this.aprobada;
    }
    
    public void setAprobada(String aprobada) {
        this.aprobada = aprobada;
    }




}



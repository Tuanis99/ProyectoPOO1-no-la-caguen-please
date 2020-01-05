/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Xtreme
 */
public class Recurso {
 
    
  private String nombre;
  private int idRecurso;
  
  public Recurso(String nombre) {
    this.nombre = nombre;
  }

    public Recurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Recurso(String nombre, int idRecurso) {
        this.nombre = nombre;
        this.idRecurso = idRecurso;
    }
  
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

    public int getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(int idRecurso) {
        this.idRecurso = idRecurso;
    }
 
   
  
}

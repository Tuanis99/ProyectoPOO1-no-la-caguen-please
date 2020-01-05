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
public class Participante {
  

  private String nombre;
  private String primerApellido;
  private String segundoApellido;
  private String correo;
  private int idParticipante;

  public Participante(String nombre, String primerApellido, String segundoApellido, String correo, int idParticipante) {
    this.nombre = nombre;
    this.primerApellido = primerApellido;
    this.segundoApellido = segundoApellido;
    this.correo = correo;
    this.idParticipante = idParticipante;
  }
  
  
  public Participante(String nombre, String primerApellido, String segundoApellido, String correo) {
    this.nombre = nombre;
    this.primerApellido = primerApellido;
    this.segundoApellido = segundoApellido;
    this.correo = correo;
  }

  
  public String getPrimerApellido() {
    return primerApellido;
  }

  
  public void setPrimerApellido(String primerApellido) {
    this.primerApellido = primerApellido;
  }

  
  public String getSegundoApellido() {
    return segundoApellido;
  }

  
  public void setSegundoApellido(String segundoApellido) {
    this.segundoApellido = segundoApellido;
  }

  
  public String getCorreo() {
    return correo;
  }

  
  public void setCorreo(String correo) {
    this.correo = correo;
  }

  
  public int getIdParticipante() {
    return idParticipante;
  }

  
  public void setIdParticipante(int idParticipante) {
    this.idParticipante = idParticipante;
  }

  


  
  public String getNombre() {
    return nombre;
  }

  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  } 
}

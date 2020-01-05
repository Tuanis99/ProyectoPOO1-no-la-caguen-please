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
public class Sala {

  private int numero;
  private String idSala;
  private String ubicacion;
  private int capacidad;
  private String estado;
  private int califacion;

  public Sala() {
  }

    public Sala(String idSala) {
        this.idSala = idSala;
    }

    public Sala(int numero) {
        this.numero = numero;
    }

    public Sala(String ubicacion, int capacidad) {
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public Sala(String idSala, String ubicacion) {
        this.idSala = idSala;
        this.ubicacion = ubicacion;
    }
    
    
  
  public Sala(String pUbicacion, int pCapacidad, int pNumero) {
    this.ubicacion = pUbicacion;
    this.capacidad = pCapacidad;
    this.numero = pNumero;
  }

  
  public Sala(String pIdSala, String pUbicacion, int pCapacidad, String pEstado) {
    this.idSala = pIdSala;
    this.ubicacion = pUbicacion;
    this.capacidad = pCapacidad;
    this.estado = pEstado;
  }

  
  public String getIdSala() {
    return this.idSala;
  }

  
  public void setIdSala(String pIdSala) {
    this.idSala = pIdSala;
  }

  public int getNumero() {
      return this.numero;
  }

  public void setNumero(int pNumero) {
    this.numero = pNumero;
  }
    
  public String getUbicacion() {
    return this.ubicacion;
  }

  
  public void setUbicacion(String pUbicacion) {
    this.ubicacion = ubicacion;
  }

  
  public int getCapacidad() {
    return this.capacidad;
  }

  
  public void setCapacidad(int pCapacidad) {
    this.capacidad = pCapacidad;
  }

  
  public String getEstado() {
    return this.estado;
  }

  
  public void setEstado(String pEstado) {
    this.estado = pEstado;
  }

  
  public int getCalifacion() {
    return this.califacion;
  }

  
  public void setCalifacion(int pCalifacion) {
    this.califacion = pCalifacion;
  }
  
  public boolean equalsSala(Object o){
    if (this == o){
      return true;
    }
    if (o == null){
      return false;
    }
    if (getClass() != o.getClass()){
      return false;
    }
    Sala sala = (Sala) o;
    return idSala.equals(sala.idSala);
  }
  
}
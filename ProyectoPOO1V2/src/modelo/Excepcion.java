package modelo;

import java.sql.Date;


/**
 *
 * @author Xtreme
 */
public class Excepcion {

 
  private String inicioExcepcion;
  private String finalExcepcion;
    
  
  public Excepcion(String pInicioExcepcion, String pFinalExcepcion) {
    this.inicioExcepcion = pInicioExcepcion;
    this.finalExcepcion =pFinalExcepcion;
  }

    public String getInicioExcepcion() {
        return inicioExcepcion;
    }

    public void setInicioExcepcion(String inicioExcepcion) {
        this.inicioExcepcion = inicioExcepcion;
    }

    public String getFinalExcepcion() {
        return finalExcepcion;
    }

    public void setFinalExcepcion(String finalExcepcion) {
        this.finalExcepcion = finalExcepcion;
    }
}

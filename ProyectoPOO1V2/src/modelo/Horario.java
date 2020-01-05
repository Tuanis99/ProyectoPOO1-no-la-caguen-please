package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Xtreme
 */
public class Horario {

  private int idHorario;
  private String dia;
  private Time horaApertura;
  private Time horaCierre;

  public Horario(int idHorario) {
    this.idHorario = idHorario;
  }

    
  
  public Horario(String dia, Time horaApertura, Time horaCierre) {
    this.dia = dia;
    this.horaApertura = horaApertura;
    this.horaCierre = horaCierre;
  }

  public Horario(int idHorario, String dia, Time horaApertura, Time horaCierre) {
    this.idHorario = idHorario;
    this.dia = dia;
    this.horaApertura = horaApertura;
    this.horaCierre = horaCierre;
  }

  public int getIdHorario() {
    return this.idHorario;
  }

  public void setIdHorario(int idHorario) {
    this.idHorario = idHorario;
  }


    
  public String getDia() {
    return this.dia;
  }

  
  public void setDia(String dia) {
    this.dia = dia;
  }

  
  public Time getHoraApertura() {
    return this.horaApertura;
  }

  
  public void setHoraApertura(Time horaApertura) {
    this.horaApertura = horaApertura;
  }

    
  public Time getHoraCierre() {
    return this.horaCierre;
  }

  
  public void setHoraCierre(Time horaCierre) {
    this.horaCierre = horaCierre;
  }
}
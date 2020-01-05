package modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Xtreme
 */
public class Excepcion {

  
  private Date fecha;
  private Time horaInicio;
  private Time horaFinal;
  private String motivo;

  
  public Excepcion(Date fecha, Time horaInicio, Time horaFinal, String motivo) {
    this.fecha = fecha;
    this.horaInicio = horaInicio;
    this.horaFinal = horaFinal;
    this.motivo = motivo;
  }

  public Date getFecha() {
    return fecha;
  }

  
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }

  
  public Time getHoraInicio() {
    return horaInicio;
  }

  
  public void setHoraInicio(Time horaInicio) {
    this.horaInicio = horaInicio;
  }

  
  public Time getHoraFinal() {
    return horaFinal;
  }

  
  public void setHoraFinal(Time horaFinal) {
    this.horaFinal = horaFinal;
  }

  
  public String getMotivo() {
    return motivo;
  }

  
  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }
  
  
  
  
  
}

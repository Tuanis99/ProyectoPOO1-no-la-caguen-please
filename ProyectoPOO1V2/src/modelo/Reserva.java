package modelo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import modelo.Incidente;

/**
 *
 * @author Xtreme
 */
public class Reserva {

  private Estudiante organizador;
  private String asunto;
  private String estado;
  private Date fechaSolicitud;
  private Date fechaUso;
  private Time horaInicio;
  private Time horaFin;
  private ArrayList<Incidente> incidentesReserva = new ArrayList<Incidente>();
  private boolean isExitosa;
  private int id;  
  private int idEstado;
  private String idSala;

 
  public Reserva() {
  }
   
  
  public Reserva(int pId, String pAsunto, Date pFechaSolicitud, Date pFechaUso, Time pHoraInicio,
      Time pHoraFin, String pIdSala, String pEstado, boolean pIsExitosa){
    this.id = pId;
    this.asunto = pAsunto;
    this.fechaSolicitud = pFechaSolicitud;
    this.fechaUso = pFechaUso;
    this.horaInicio = pHoraInicio;
    this.horaFin = pHoraFin;
    this.idSala = pIdSala;
    this.estado = pEstado;
    this.isExitosa = pIsExitosa;
  }

    public Reserva(Estudiante organizador, String asunto, Date fechaUso, Time horaInicio, Time horaFin, String idSala) {
        this.organizador = organizador;
        this.asunto = asunto;
        this.fechaUso = fechaUso;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idSala = idSala;
    }
  
  

  
  public Reserva(int pId, String pAsunto, Date pFechaSolicitud, Date pFechaUso, Time pHoraInicio,
      Time pHoraFin, String pIdSala, String pEstado, boolean pIsExitosa, 
      ArrayList<Incidente> pInicdentesReserva){
    this.id = pId;
    this.asunto = pAsunto;
    this.fechaSolicitud = pFechaSolicitud;
    this.fechaUso = pFechaUso;
    this.horaInicio = pHoraInicio;
    this.horaFin = pHoraFin;
    this.idSala = pIdSala;
    this.estado = pEstado;
    this.isExitosa = pIsExitosa;
    this.incidentesReserva =  pInicdentesReserva; 
  }

  
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaUso() {
        return fechaUso;
    }

    public void setFechaUso(Date fechaUso) {
        this.fechaUso = fechaUso;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public ArrayList<Incidente> getIncidentesReserva() {
        return incidentesReserva;
    }

    public void setIncidentesReserva(ArrayList<Incidente> incidentesReserva) {
        this.incidentesReserva = incidentesReserva;
    }

    public boolean isIsExitosa() {
        return isExitosa;
    }

    public void setIsExitosa(boolean isExitosa) {
        this.isExitosa = isExitosa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }
    
    
  public boolean getIsExitosa() {
    return isExitosa;
  }

    public Estudiante getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Estudiante organizador) {
        this.organizador = organizador;
    }


    
    
  public ArrayList<Incidente> agregarIncidente(Incidente incidente){
    incidentesReserva.add(incidente);
    return incidentesReserva;
  }
}

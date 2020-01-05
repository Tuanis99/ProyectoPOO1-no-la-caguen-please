package modelo;

//NO OLVIDAR METODOS ACCESORES NI EQULAS NI CONSTRUCTOR SOBRECARGADO NI VACIO
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import modelo.Horario;
import modelo.Reserva;
import modelo.Incidente;

/**
 *
 * @author Xtreme
 */
public class Estudiante {   
  private String nombre; 
  private String primerApellido; 
  private String segundoApellido; 
  private String correo;
  private String carrera;
  private ArrayList<Reserva> reservasEstudiante = new ArrayList<Reserva>();
  private int carnet;
  private int calificacion; 
  private int idCarrera;
  private int telefono; 
  
  
  public Estudiante(){
  }
  
  
  public Estudiante(int pCarnet, String pNombre, String pPrimerApellido, String pSegundoApellido, 
        String pCorreo, int pIdCarrera, int pTelefono) {
    this.carnet = pCarnet;
    this.nombre = pNombre;
    this.primerApellido = pPrimerApellido;
    this.segundoApellido = pSegundoApellido;
    this.correo = pCorreo;
    this.calificacion = 100;
    this.idCarrera = pIdCarrera;
    this.telefono = pTelefono;
  }
  

  public Estudiante(int pCarnet, String pNombre, String pPrimerApellido, String pSegundoApellido, 
        String pCorreo,int pTelefono, int pCalificacion, String pCarrera) {
    this.carnet = pCarnet;
    this.nombre = pNombre;
    this.primerApellido = pPrimerApellido;
    this.segundoApellido = pSegundoApellido;
    this.correo = pCorreo;
    this.calificacion = pCalificacion;
    this.telefono = pTelefono;
    this.carrera = pCarrera;
  }

  
  public Estudiante(int pCarnet, String pNombre, String pPrimerApellido, String pSegundoApellido, 
        String pCorreo, String pCarrera, int pTelefono, ArrayList<Reserva> pReservasEstudiante) {
    this.carnet = pCarnet;
    this.nombre = pNombre;
    this.primerApellido = pPrimerApellido;
    this.segundoApellido = pSegundoApellido;
    this.correo = pCorreo;
    this.calificacion = 100;
    this.carrera = pCarrera;
    this.telefono = pTelefono;
    this.reservasEstudiante = pReservasEstudiante;
  }
  
  
  public int getCarnet() {
    return this.carnet;
  }

  
  public void setCarnet(int pCarnet) {
    this.carnet = pCarnet;
  }

  
  public String getNombre() {
    return this.nombre;
  }

  
  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  
  public String getPrimerApellido() {
    return this.primerApellido;
  }

  
  public void setPrimerApellido(String pPrimerApellido) {
    this.primerApellido = pPrimerApellido;
  }
  
  
  public String getSegundoApellido() {
    return this.segundoApellido;
  }

  
  public void setSegundoApellido(String pSegundoApellido) {
    this.primerApellido = pSegundoApellido;
  }

  
  public String getCorreo() {
    return this.correo;
  }

  
  public void setCorreo(String pCorreo) {
    this.correo = pCorreo;
  }

  
  public int getIdCarrera() {
    return this.idCarrera;
  }

  
  public void setCarrera(int pIdCarrera) {
    this.idCarrera = pIdCarrera;
  }

  
  public int getCalificacion() {
    return this.calificacion;
  }

  
  public void setCalificacion(int pCalificacion) {
    this.calificacion = pCalificacion;
  }

  
  public int getTelefono() {
    return this.telefono;
  }

  
  public void setTelefono(int pTelefono) {
    this.telefono = pTelefono;
  }
  
  public String getCarrera() {
    return this.carrera;
  }
  
  
  public ArrayList<Reserva> getReservasEstudiante(){
    return reservasEstudiante;
  }
  
  
  public ArrayList<Reserva> agregarReserva(int id, String asunto, Date fechaSolicitud,
      Date fechaUso, Time horaInicio, Time horaFin, String idSala, String estado,
      boolean isExitosa, ArrayList<Incidente> incidentes){
    reservasEstudiante.add(new Reserva(id, asunto, fechaSolicitud, fechaUso, horaInicio, horaFin,
        idSala, estado, isExitosa, incidentes));
    return reservasEstudiante;
  }

}
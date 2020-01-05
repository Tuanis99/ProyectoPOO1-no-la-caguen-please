package dao;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Participante;
import modelo.Reserva;
import modelo.Sala;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ReservaDAO {
  private static ResultSet resultadoConsulta;
  
  
  public ArrayList<Reserva> consultarReservasEstudiante(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec consultarOrganizadorReserva "+carnet+";");
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    while (resultadoConsulta.next()) {
      Reserva reservaEncontrada = new Reserva(resultadoConsulta.getInt(1),
        resultadoConsulta.getString(2), resultadoConsulta.getDate(3),
        resultadoConsulta.getDate(4), resultadoConsulta.getTime(5),
        resultadoConsulta.getTime(6), resultadoConsulta.getString(7), 
        resultadoConsulta.getString(8), resultadoConsulta.getBoolean(9));
      reservas.add(reservaEncontrada);
    }
    return reservas;
  }
  
  
 public boolean agregarReserva(Reserva reserva) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entrada = ConexionSQL.getConexionSQL().prepareCall("{call "
          + "registrarReserva (?,?,?,?,?,?)}");
      entrada.setString(1, reserva.getIdSala());
      entrada.setString(2, reserva.getAsunto());
      entrada.setDate(3, reserva.getFechaUso());
      entrada.setTime(4, reserva.getHoraInicio());
      entrada.setTime(5, reserva.getHoraFin());
      entrada.setInt(6, reserva.getOrganizador().getCarnet());
      entrada.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }


  public int validarUsuario(int carnet) throws SQLException,
          ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec validarEstudiante "
        +carnet+";");
      int bandera = 0;
      while (resultadoConsulta.next()){
          bandera = resultadoConsulta.getInt(1);        
      }    
      return bandera;
  } 
  
  
  public ArrayList<Sala> consultarSalasMasUtilizadas()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec salasDisp "+";");
    ArrayList<Sala> salas = new ArrayList<Sala>();
    while (resultadoConsulta.next()) {
       
      String idSala = resultadoConsulta.getString(1);
      String ubicacion = resultadoConsulta.getString(2);
      int capacidad = resultadoConsulta.getInt(3);
      String estado = resultadoConsulta.getString(4);
      Sala sala = new Sala(idSala, ubicacion, capacidad, estado);
      salas.add(sala);
    }
    return salas;
  }
  
  
  public ArrayList<String> cargarComboRecursos()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec recursos "+";");
    ArrayList<String> recursos = new ArrayList<String>();
    while (resultadoConsulta.next()) {
       
      String recurso = resultadoConsulta.getString(2);
      recursos.add(recurso);
    }
    return recursos;
  }
  
  
  public ArrayList<String> cargarComboSalasReservas()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec salasDisp "+";");
    ArrayList<String> salas = new ArrayList<String>();
    while (resultadoConsulta.next()) {
       
      String idSala = resultadoConsulta.getString(1);
      salas.add(idSala);
    }
    return salas;
  }
  
  
 public void agregarParticipante(Participante participante) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entrada = ConexionSQL.getConexionSQL().prepareCall("{call "
          + "registrarParticipante (?,?,?,?)}");
      entrada.setString(1, participante.getNombre());
      entrada.setString(2, participante.getPrimerApellido());
      entrada.setString(3, participante.getSegundoApellido());
      entrada.setString(4, participante.getCorreo());
      entrada.execute();
    }
    catch(ClassNotFoundException | SQLException e) {     
    }   
  }
 
 
  public ArrayList<Participante> consultarParticipantes()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec consularParticipantes "+";");
    ArrayList<Participante> participantes = new ArrayList<Participante>();
    while (resultadoConsulta.next()) {  
      int id = resultadoConsulta.getInt(1);
      String nombre = resultadoConsulta.getString(2);
      String primerApellido = resultadoConsulta.getString(3);
      String segundoApellido = resultadoConsulta.getString(4);
      String correo = resultadoConsulta.getString(5);
      Participante participante = new Participante(nombre,primerApellido,segundoApellido,correo,id);
      participantes.add(participante);
    }
    return participantes;
  }
  
  
  public ArrayList<Integer> cargarComboReservasParticipante(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec reservasDispOrganizador "
        +carnet+";");
    ArrayList<Integer> ids = new ArrayList<>();
    while (resultadoConsulta.next()) {
       
      int id = resultadoConsulta.getInt(1);
      ids.add(id);
    }
    return ids;
  }
  
  
 public void agregarParticipanteReserva(int idReserva, int idParticipante) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entrada = ConexionSQL.getConexionSQL().prepareCall("{call "
          + "insertarReservaParticipante (?,?)}");
      entrada.setInt(1, idParticipante);
      entrada.setInt(2, idReserva);
      entrada.execute();
    }
    catch(ClassNotFoundException | SQLException e) {     
    }   
  }  
}
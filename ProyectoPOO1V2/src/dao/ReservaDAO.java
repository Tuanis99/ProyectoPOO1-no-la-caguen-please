package dao;


import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Reserva;


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
  
  
  public ArrayList<Reserva> consultarReservasCancelables(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec "
        + "consultarOrganizadorReservasCancelables   "+carnet+";");
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    while (resultadoConsulta.next()) {
      Reserva reservaEncontrada = new Reserva(resultadoConsulta.getInt(1),
        resultadoConsulta.getDate(2), resultadoConsulta.getTime(3),
        resultadoConsulta.getTime(4), resultadoConsulta.getString(5));
      reservas.add(reservaEncontrada);
    }
    return reservas;
  }
  
  
  public ArrayList<Reserva> cargarComboBoxId(int carnet)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec cargarComboBox "+carnet+";");
    ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    while (resultadoConsulta.next()) {
      Reserva reservaEncontrada = new Reserva(resultadoConsulta.getInt(1));
      reservas.add(reservaEncontrada);
    }
    return reservas;
  }
  
  
  public boolean validarEstadoReserva(int idReserva)throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec validarEstadoReserva  "+idReserva+";");
    boolean bandera = false;
    while (resultadoConsulta.next()) {
      int resultado =resultadoConsulta.getInt(1);
      if (resultado == 1){
        bandera = true;
      }
    }
    return bandera;
  }
  
  
  public boolean cancelarReserva(int idReserva)throws SQLException,
      ClassNotFoundException{
      boolean bandera;
      try{
      resultadoConsulta = ConexionSQL.createConsult("exec cancelarReserva "+idReserva+";");
      bandera = true;
      return bandera;
     }
     catch(ClassNotFoundException e){
       bandera = false;
       return bandera;
     }
  }
}
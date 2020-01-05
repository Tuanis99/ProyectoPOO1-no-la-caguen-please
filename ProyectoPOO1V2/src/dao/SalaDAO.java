/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import modelo.Estado;
import modelo.Horario;
import modelo.Recurso;
import modelo.Sala;

/**
 *
 * @author luisg
 */
public class SalaDAO {
  private static ResultSet resultadoConsulta;
  
    /**
     *
     * @param sala
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean agregarSala(Sala sala) throws SQLException,
      ClassNotFoundException {
    try {
      CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call agregarSala"
          + "(?,?)}");
      entry.setString(1, sala.getUbicacion());
      entry.setInt(2, sala.getCapacidad()); 
      //entry.setInt(3, sala.getNumero());
      entry.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<String> cargarComboEstado()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec estados "+";");
    ArrayList<String> estados = new ArrayList<String>();
    while (resultadoConsulta.next()) {
       
      String estado = resultadoConsulta.getString(2);
      estados.add(estado);
    }
    return estados;
  }
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Horario> consultarHorariosDisponibles() throws SQLException,
          ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec tablaHorarios;");
      ArrayList<Horario> horarios = new ArrayList<Horario>();
      while (resultadoConsulta.next()){
          int idHorario = resultadoConsulta.getInt(1);
          String dia = resultadoConsulta.getString(2);
          Time horaApertura = resultadoConsulta.getTime(3);
          Time horaCierre = resultadoConsulta.getTime(4);
          
          Horario horario = new Horario (idHorario,dia,horaApertura,horaCierre);
          horarios.add(horario);
      }
      return horarios;
  }
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<String> cargarComboHorarios() throws SQLException, ClassNotFoundException{
    resultadoConsulta =  ConexionSQL.createConsult("exec consultarHorarios;");
    ArrayList<String> horarios = new ArrayList<String>();
    while (resultadoConsulta.next()) {
      String horarioEncontrado = resultadoConsulta.getString(1);
      horarios.add(horarioEncontrado);
    }
    return horarios;
  }
  
    /**
     *
     * @param sala
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public Sala verificarSala(Sala sala) throws SQLException, ClassNotFoundException{
      ArrayList <Sala> salas = cargarSalasVerificacion();
      int cantidad = salas.size();   
      for (int i = 0; i<cantidad; i++){
        if(sala.equalsSala(salas.get(i))){
            return sala;
        }
      }
      return null;
  }
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<Sala> cargarSalasVerificacion() throws SQLException, ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec cargarSalas;");
      ArrayList <Sala> salas = new ArrayList<Sala>();
      while (resultadoConsulta.next()){
          Sala salaEncontrada = new Sala(resultadoConsulta.getString(1));
          salas.add(salaEncontrada);
      }
      return salas;
  }
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ArrayList<String> cargarSalas() throws SQLException, ClassNotFoundException{
      resultadoConsulta = ConexionSQL.createConsult("exec cargarSalas;");
      ArrayList <String> salas = new ArrayList<String>();
      while (resultadoConsulta.next()){
          String salaEncontrada = resultadoConsulta.getString(1);
          salas.add(salaEncontrada);
      }
      return salas;
  }
  
    /**
     *
     * @param sala
     * @param horario
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean agregarHorario(Sala sala, Horario horario) throws SQLException, ClassNotFoundException{
      try{
        CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call agregarHorarioSala"
          + "(?,?)}");
        entry.setInt(1, horario.getIdHorario());
        entry.setString(2, sala.getIdSala()); 
        entry.execute();
    }
    catch(ClassNotFoundException | SQLException e) {
      return false;
    }
    return true;    
  }
  
    /**
     *
     * @param sala
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean idModificar(Sala sala) throws SQLException, ClassNotFoundException{
      try{
          CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call guardarID"
          + "(?)}");
          entry.setString(1, sala.getIdSala());
          entry.execute();
      }
      catch(ClassNotFoundException | SQLException e){
          return false;
      }
      return true;
  }
  
    /**
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean idEliminar() throws SQLException, ClassNotFoundException{
      try{
          CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call elimiID}");
          entry.execute();
      }
      catch(ClassNotFoundException | SQLException e){
          System.out.print(e);
          return false;
      }
      return true;
  }

    /**
     *
     * @param sala
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean modificarSalaUbicacion(Sala sala) throws SQLException, ClassNotFoundException{
      try{
          CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call modificarSalaUbicacion"
          + "(?)}");
          entry.setString(1, sala.getIdSala());
          entry.execute();
      }
      catch(ClassNotFoundException | SQLException e){
          System.out.println(e);
          return false;
      }
      return true;
  }
  
    /**
     *
     * @param recurso
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean modificarSalaRecurso(Recurso recurso) throws SQLException, ClassNotFoundException{
      try{
          CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call modificarSalaRecurso"
          + "(?)}");
          entry.setInt(1, recurso.getIdRecurso());
          entry.execute();
      }
      catch(ClassNotFoundException | SQLException e){
          return false;
      }
      return true;
  }

    /**
     *
     * @param estado
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean modificarSalaEstado(Estado estado) throws SQLException, ClassNotFoundException{
      try{
          CallableStatement entry = ConexionSQL.getConexionSQL().prepareCall("{call modificarSalaEstado"
          + "(?)}");
          entry.setInt(1, estado.getIdEstado());
          entry.execute();
      }
      catch(ClassNotFoundException | SQLException e){
          return false;
      }
      return true;
  }
}

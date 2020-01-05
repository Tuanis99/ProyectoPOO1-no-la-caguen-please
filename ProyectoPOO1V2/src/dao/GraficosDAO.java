/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mata
 */
public class GraficosDAO {
  private static ResultSet resultadoConsulta; 
  
  
public ArrayList<String> consultarSalasMasUtilizadas()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5SalasUtilizadas "+";");
    ArrayList<String> salas = new ArrayList<String>();
    while (resultadoConsulta.next()) {
       
      String sala = resultadoConsulta.getString(1);
      int cantidadSala = resultadoConsulta.getInt(2);
      salas.add(sala);
    }
    return salas;
  }


public ArrayList<Integer> consultarSalasMasUtilizadasCantidades()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5SalasUtilizadas "+";");
    ArrayList<Integer> cantidades = new ArrayList<Integer>();
    while (resultadoConsulta.next()) {
      int cantidadSala = resultadoConsulta.getInt(2);
      cantidades.add(cantidadSala);
    }
    return cantidades;
  }


public ArrayList<String> consultarTopHorarios()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5HorariosUtilizados "+";");
    ArrayList<String> horarios = new ArrayList<String>();
    while (resultadoConsulta.next()) {
      String horario = resultadoConsulta.getString(1);
      horarios.add(horario);
    }
    return horarios;
  }


public ArrayList<Integer> consultarTopHorariosCantidades()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5HorariosUtilizados "+";");
    ArrayList<Integer> cantidades = new ArrayList<Integer>();
    while (resultadoConsulta.next()) {
      int cantidadSala = resultadoConsulta.getInt(2);
      cantidades.add(cantidadSala);
    }
    return cantidades;
  }


public ArrayList<String> consultarTopCarreras()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5CarrerasSalas "+";");
    ArrayList<String> carreras = new ArrayList<String>();
    while (resultadoConsulta.next()) {
      String carrera = resultadoConsulta.getString(1);
      carreras.add(carrera);
    }
    return carreras;
  }


public ArrayList<Integer> consultarTopCarrerasCantidades()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5CarrerasSalas "+";");
    ArrayList<Integer> cantidades = new ArrayList<Integer>();
    while (resultadoConsulta.next()) {
      int cantidadSala = resultadoConsulta.getInt(2);
      cantidades.add(cantidadSala);
    }
    return cantidades;
  }


public ArrayList<String> consultarSalasPuntuacion()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5CalificacionSalas "+";");
    ArrayList<String> salas = new ArrayList<String>();
    while (resultadoConsulta.next()) {
       
      String sala = resultadoConsulta.getString(1);
      int cantidadSala = resultadoConsulta.getInt(2);
      salas.add(sala);
    }
    return salas;
  }


public ArrayList<Integer> consultarSalasPuntuacionCantidades()throws SQLException,
      ClassNotFoundException{
    resultadoConsulta = ConexionSQL.createConsult("exec top5CalificacionSalas "+";");
    ArrayList<Integer> cantidades = new ArrayList<Integer>();
    while (resultadoConsulta.next()) {
      int cantidadSala = resultadoConsulta.getInt(2);
      cantidades.add(cantidadSala);
    }
    return cantidades;
  }
}

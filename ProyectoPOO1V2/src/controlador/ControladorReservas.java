/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ReservaDAO;
import dao.SalaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Sala;
import vista.AgregarParticipantes;
import vista.CrearReserva;
import vista.Menu;
import vista.Reporte;

/**
 *
 * @author Mata
 */
public class ControladorReservas implements ActionListener{
  public ReservaDAO dao;
  public CrearReserva vista;  
  public Reserva modelo;

  public ControladorReservas(CrearReserva pVista) {
    this.vista = pVista;
    dao = new ReservaDAO();
    this.vista.btnBuscar.addActionListener(this);
    this.vista.btnReservar.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }

  
  public void actionPerformed(ActionEvent e) {    
    try{
      switch(e.getActionCommand()) {
          case "Buscar":
              llenarTabla();
              break;
          case "Reservar":
              registrarReserva();
              break;              
          case "Volver":
              cerrarVentanaAgregarSala();
              break;
          default:
              break;
      }
    }catch(Exception x){
      JOptionPane.showMessageDialog(null, "Error con el ingreso de datos");
   }
  }  
   
  public void cargarCombo(){
    try {
        ArrayList<String> recursos = dao.cargarComboRecursos();
        for (int i = 0; i < recursos.size(); i++) {
            String recurso = recursos.get(i);
            vista.comboRecursos.addItem(recurso);         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }

  
  public void cargarComboSalas(){
    try {
        ArrayList<String> salas = dao.cargarComboSalasReservas();
        for (int i = 0; i < salas.size(); i++) {
            String sala = salas.get(i);
            vista.comboSalas.addItem(sala);         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }

  
  public void llenarTabla(){
    try {
        ArrayList<Sala> salas = dao.consultarSalasMasUtilizadas();
        DefaultTableModel tm=(DefaultTableModel)vista.tableSalas.getModel();
        tm.setRowCount(0);
        for (int i = 0; i < salas.size(); i++) {
           Object o[]= {salas.get(i).getIdSala(),salas.get(i).getUbicacion(),salas.get(i).getCapacidad()
           ,salas.get(i).getEstado()};
           tm.addRow(o);           
        }               
        } catch (Exception e) {
            System.out.println(e);
        }
  }  

  
  public void cerrarVentanaAgregarSala() {
  Menu menuVista = new Menu();
  ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
  controladorMenu.vista.setVisible(true);
  this.vista.setVisible(false);
  controladorMenu.vista.setLocationRelativeTo(null); 
  }

  private void registrarReserva() {
    try {
        if (dao.validarUsuario(Integer.parseInt(vista.txtCarnet.getText())) == 1) {
            System.out.println(dao.validarUsuario(Integer.parseInt(vista.txtCarnet.getText())));
           Estudiante estudiante = new Estudiante(Integer.parseInt(vista.txtCarnet.getText()));
           String asunto = vista.txtAsunto.getText();
           Date fechaUso=Date.valueOf(vista.txtFecha.getText());  
           String horaInicioCombo = vista.comboHoraInicio.getSelectedItem().toString();
           String minInicio = vista.comboMinutosInicio.getSelectedItem().toString();
           Time horaInicio = new Time(Integer.parseInt(horaInicioCombo), Integer.parseInt(minInicio), 0);
           String horaFinCombo = vista.comboHoraFin.getSelectedItem().toString();
           String minFin = vista.comboMinFin.getSelectedItem().toString();
           Time horaFin = new Time(Integer.parseInt(horaFinCombo), Integer.parseInt(minFin), 0);
            System.out.println(horaInicio+"c"+horaFin);
           String idSala = vista.comboSalas.getSelectedItem().toString();
           System.out.println(idSala);
           modelo = new Reserva(estudiante, asunto, fechaUso, horaInicio,horaFin, idSala);
           dao.agregarReserva(modelo);
           AgregarParticipantes vistaParticipantes = new AgregarParticipantes(estudiante.getCarnet());
           ControladorParticipantes controlador = new ControladorParticipantes(vistaParticipantes);
           controlador.cargarComboReservaParticipante(estudiante.getCarnet());
           controlador.vista.setVisible(true);
           vista.setVisible(false);
           controlador.vista.setLocationRelativeTo(null);           
        }else{
           JOptionPane.showMessageDialog(null, "Usuario no registrado");
        }
        } catch (ClassNotFoundException| SQLException e) {
         JOptionPane.showMessageDialog(null, e);
        }
  }
}

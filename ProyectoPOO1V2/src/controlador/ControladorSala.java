/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SalaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Horario;
import modelo.Sala;
import vista.AgregarSalaForm;
import vista.Menu;
import vista.SeleccionarHorario;


/**
 *
 * @author ayanc
 */
public class ControladorSala implements ActionListener{
  public AgregarSalaForm vista;
  public SalaDAO dao;
  public Sala modelo;
  public ControladorSeleccionarHorario controlador;
  
  
  public ControladorSala(AgregarSalaForm pVista){
    vista = pVista;
    dao= new SalaDAO();
    this.vista.btnAgregarSala.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Agregar Sala":
          agregarSala();
          abrirSeleccionHorario();
          break;
        case "Volver":
          cerrarVentanaAgregarSala();
          break;
        default:
          break;
      }
    }
    catch (SQLException ex) {
      Logger.getLogger(ControladorSala.class.getName()).log(Level.SEVERE, null, ex);
    } 
    catch (ClassNotFoundException ex) {
      Logger.getLogger(ControladorSala.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  
  public void agregarSala() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe completar todos los campos mostrados");
    }
//    if(vista.validarDatosEnteros()== false) {
//      JOptionPane.showMessageDialog(vista, "El numero de sala y la capacidad deben ser números enteros");
//    }
    String ubicacion = vista.txtUbicacion.getText();
    String capacidadString = vista.txtCapacidad.getText();
    int capacidad = Integer.parseInt(capacidadString);
    //String numeroString = vista.txtNumero.getText();
    //int numero = Integer.parseInt(numeroString);
    
    modelo = new Sala(ubicacion,capacidad);
    boolean salaActual = dao.agregarSala(modelo);
    if (salaActual){
      JOptionPane.showMessageDialog(vista, "La sala ha sido ingresada correctamente");
    }
    else{
      JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
    }
  }
  
  public void abrirSeleccionHorario(){
    SeleccionarHorario horarioVista = new SeleccionarHorario();
    ControladorSeleccionarHorario controladorSeleccion = new ControladorSeleccionarHorario(horarioVista);
    controladorSeleccion.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorSeleccion.vista.setLocationRelativeTo(null);
    controladorSeleccion.cargarHorarios();
    controladorSeleccion.llenarTablaHorarios();
    controladorSeleccion.cargarSalas();
  }
  
  
    
 public void cerrarVentanaAgregarSala() {
  Menu menuVista = new Menu();
  ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
  controladorMenu.vista.setVisible(true);
  this.vista.setVisible(false);
  controladorMenu.vista.setLocationRelativeTo(null); 
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ReservaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Participante;
import modelo.Sala;
import vista.AgregarParticipantes;
import vista.Menu;

/**
 *
 * @author Mata
 */
public class ControladorParticipantes implements ActionListener{
  public AgregarParticipantes vista;
  public ReservaDAO dao;
  public Participante modelo;
  
  
  public ControladorParticipantes(AgregarParticipantes pVista) {
    this.vista = pVista;
    dao = new ReservaDAO();
    this.vista.btnRegistrarParticipante.addActionListener(this);
    this.vista.btnAgregar.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }


  public void actionPerformed(ActionEvent e) {    
    try{
      switch(e.getActionCommand()) {
          case "Registrar Participante":
              registrarParticipante();
              break;            
          case "Volver":
              cerrarVentanaAgregarSala();
              break;
           case "Agregar":
              agregarParticipanteReserva();
              break;
          default:
              break;
      } 
    }catch(Exception x){
      JOptionPane.showMessageDialog(null, "Error con el ingreso de datos");   
    }
  }


  public void registrarParticipante(){
    try{
      String nombre = vista.txtNombre.getText();
      String primerApellido = vista.txtPrimerApellido.getText();
      String segundoApellido = vista.txtSegundoApellido.getText();
      String correo = vista.txtCorreo.getText();
      Participante participante = new Participante(nombre, primerApellido, segundoApellido, correo);
      dao.agregarParticipante(participante); 
      llenarTabla();
      JOptionPane.showMessageDialog(null, "Exito");
    }catch(Exception e){
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
  
  
  public void llenarTabla(){
    try {
        ArrayList<Participante> participantes = dao.consultarParticipantes();
        DefaultTableModel tm=(DefaultTableModel)vista.tableParticipantes.getModel();
        tm.setRowCount(0);
        for (int i = 0; i < participantes.size(); i++) {
           Object o[]= {participantes.get(i).getIdParticipante(), participantes.get(i).getNombre(),participantes.get(i).getPrimerApellido(),participantes.get(i).getSegundoApellido()
           ,participantes.get(i).getCorreo()};
           tm.addRow(o);           
        }               
        } catch (Exception e) {
            System.out.println(e);
        }
  }
  
  
  public void cargarComboReservaParticipante(int carnet){
    try {
        ArrayList<Integer> ids = dao.cargarComboReservasParticipante(carnet);
        for (int i = 0; i < ids.size(); i++) {
            Integer id = ids.get(i);
            vista.comboReservasParticipante.addItem(id.toString());         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }  

  private void agregarParticipanteReserva() {
    try{
       int idReserva = Integer.parseInt(vista.comboReservasParticipante.getSelectedItem().toString()) ;
       int idParticipante = Integer.parseInt(vista.txtIdParticipante.getText());
       dao.agregarParticipanteReserva(idReserva, idParticipante);  
        JOptionPane.showMessageDialog(null, "Exito");
    }catch(Exception e){
        System.out.println(e);
    }

  }
}

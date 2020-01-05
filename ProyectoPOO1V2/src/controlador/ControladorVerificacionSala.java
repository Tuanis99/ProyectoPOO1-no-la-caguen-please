/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Sala;
import vista.Menu;
import vista.ModificarSala;
import vista.SeleccionModificar;

/**
 *
 * @author luisg
 */
public class ControladorVerificacionSala implements ActionListener{
  public ModificarSala vista;
  public SalaDAO dao;
  public Sala modelo;
  public ControladorModificacionSala controlador;
  
  
  public ControladorVerificacionSala(ModificarSala pVista){
    vista = pVista;
    dao= new SalaDAO();
    this.vista.btnAceptar.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Aceptar":
          verificarDatos();
          break;
        case "Volver":
          cerrarVentanaValidarDatosSala();
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
  
  public void verificarDatos() throws SQLException, ClassNotFoundException{
      //if(vista.validarDatosCompletos()){
          String idSala = vista.cbxSalas.getSelectedItem().toString();
          modelo = new Sala(idSala);
          Sala salaActual = dao.verificarSala(modelo);
          boolean salaActualV = dao.idModificar(modelo);
          if(salaActualV){
            if(salaActual != null){
              vista.setVisible(false);
              desplegarModificacion();
            }else{
           JOptionPane.showMessageDialog(vista, "Los datos son incorrectos");   
           }       
          }else{
             JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
          }
  }  
      public void cargarSalas(){
        try{
            ArrayList<String> salas = dao.cargarSalas();
            for(int i = 0; i < salas.size(); i++){
                String sala = salas.get(i);
                vista.cbxSalas.addItem(sala);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
  
  public void cerrarVentanaValidarDatosSala(){
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
  
  public void desplegarModificacion(){
      SeleccionModificar modificar = new SeleccionModificar ();
      ControladorModificacionSala modificarSala = new ControladorModificacionSala (modificar);
      modificarSala.vista.setVisible(true);
      vista.setVisible(false);
      modificarSala.vista.setLocationRelativeTo(null);
      modificarSala.cargarCombo();
      modificarSala.cargarComboEstado();
  }
}
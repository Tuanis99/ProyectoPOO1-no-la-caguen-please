/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionListener;
import dao.SalaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Estado;
import modelo.Recurso;
import vista.SeleccionModificar;
import vista.Menu;
import modelo.Sala;
import vista.ModificarSala;

/**
 *
 * @author luisg
 */
public class ControladorModificacionSala implements ActionListener{

    public SeleccionModificar vista;
    public SalaDAO dao;
    public Sala modelo;
    public Recurso modelo2;
    public Estado modelo3;
    public ModificarSala vista2;
    
    /**
     *
     * @param pVista
     */
    public ControladorModificacionSala (SeleccionModificar pVista){
        vista = pVista;
        dao = new SalaDAO();
        this.vista.btnModificarUbicacion.addActionListener(this);
        this.vista.btnModificarRecursos.addActionListener(this);
        this.vista.btnModificarEstado.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
    
    /**
     *
     * @param e
     */
    public void actionPerformed (ActionEvent e){
        try{
            switch(e.getActionCommand()){
                case "Modificar Ubicacion":
                    modificarUbicacion();
                    break;
                case "Modificar Recursos":    
                    modificarRecursos();
                    break;
                case "Modificar Estado":
                    modificarEstado();
                    break;
                case "Volver":
                    cerrarVentanaSeleccionModificar();
                    break;
                default:
                    break;
            }
        }
      catch (SQLException | ClassNotFoundException ex) {
          Logger.getLogger(ControladorSala.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
        
    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void modificarUbicacion() throws SQLException, ClassNotFoundException{
      String ubicacion = vista.txtUbicacion.getText();
      modelo = new Sala(ubicacion);
      boolean salaActual = dao.modificarSalaUbicacion(modelo);
      if(salaActual){
          JOptionPane.showMessageDialog(vista, "La sala ha sido modificada exitosamente");
      }else{
         JOptionPane.showMessageDialog(vista, "Ha ocuriido un error de conexion");
      }
  }

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void modificarRecursos() throws SQLException, ClassNotFoundException{
      int recurso = vista.cbxRecursos.getSelectedIndex();
      modelo2 = new Recurso(recurso);
      boolean recursoActual = dao.modificarSalaRecurso(modelo2);
      if(recursoActual){
          JOptionPane.showMessageDialog(vista, "La sala ha sido modificada exitosamente");
      }else{
          JOptionPane.showMessageDialog(vista, "Ha ocuriido un error de conexion");
      }
  }

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void modificarEstado() throws SQLException, ClassNotFoundException{
      int estado = vista.cbxEstado.getSelectedIndex();
      modelo3 = new Estado(estado);
      boolean estadoActual = dao.modificarSalaEstado(modelo3);
      if(estadoActual){
          JOptionPane.showMessageDialog(vista, "La sala ha sido modificada exitosamente");
      }else{
          JOptionPane.showMessageDialog(vista, "Ha ocuriido un error de conexion");
      }
  }
  
    /**
     *
     */
    public void cargarCombo(){
    try {
        ArrayList<String> recursos = dao.cargarComboRecursos();
        for (int i = 0; i < recursos.size(); i++) {
            String recurso = recursos.get(i);
            vista.cbxRecursos.addItem(recurso);         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }
  
    /**
     *
     */
    public void cargarComboEstado(){
    try {
        ArrayList<String> estados = dao.cargarComboEstado();
        for (int i = 0; i < estados.size(); i++) {
            String estado = estados.get(i);
            vista.cbxEstado.addItem(estado);         
        }
        
        } catch (Exception e) {
            System.out.println(e);
        }
  }

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void eliminarTemp() throws SQLException, ClassNotFoundException{
        dao.idEliminar();
  }

    /**
     *
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void cerrarVentanaSeleccionModificar() throws SQLException, ClassNotFoundException{
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null);
  }
}

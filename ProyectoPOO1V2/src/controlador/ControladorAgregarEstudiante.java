package controlador;

import dao.EstudianteDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Estudiante;
import vista.AgregarEstudianteForm;
import vista.Menu;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorAgregarEstudiante implements ActionListener {
  public AgregarEstudianteForm vista;
  public EstudianteDAO dao;
  public Estudiante modelo;
  
  
  public ControladorAgregarEstudiante(AgregarEstudianteForm pVista){
    vista = pVista;
    dao= new EstudianteDAO();
    this.vista.btRegistrarEstudiante.addActionListener(this);
    this.vista.btVolver.addActionListener(this);
  }
  
  
  @Override
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Registrar":
          agregarEstudiante();
          break;
        case "Volver":
          cerrarVentanaRegistroEstudiantes();
          break;
        default:
          break;
      }
    }
    catch (SQLException | ClassNotFoundException ex) {
      Logger.getLogger(ControladorAgregarEstudiante.class.getName()).log(Level.SEVERE, null, 
          ex);
    }
  }
  
  
  public void agregarEstudiante() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCorreo() == true) {
      JOptionPane.showMessageDialog(vista, "Debe ingresar una dirección de correo");
    } 
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe completar todos los campos mostrados");
    }
//    if(vista.validarDatosEnteros()== true) {
//      JOptionPane.showMessageDialog(vista, "El carnet y el télefono deben ser números enteros");
//    }
    else{
      String carnetString = vista.txtCarnet.getText();
      int carnet = Integer.parseInt(carnetString);
      String correo = vista.txtCorreo.getText();
      String nombre = vista.txtNombre.getText();
      String telefonoString = vista.txtTelefono.getText();
      int telefono = Integer.parseInt(telefonoString);
      String primerApellido = vista.txtPrimerApellido.getText();
      String segundoApellido = vista.txtSegundoApellido.getText();
      int idCarrera = vista.cbCarrera.getSelectedIndex() + 1;
      modelo = new Estudiante(carnet, nombre, primerApellido, segundoApellido, correo, idCarrera, 
          telefono);
      boolean estudianteActual = dao.agregarOrganizador(modelo);
      if (estudianteActual){
        JOptionPane.showMessageDialog(vista, "El estudiante ha sido ingresado correctamente");
      }
      else{
        JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
      }
    }
  }
  
  
  public void cargarCarreras(){
    try {
      ArrayList<String> recursos = dao.cargarListaCarreras();
      for (int i = 0; i < recursos.size(); i++) {
        String recurso = recursos.get(i);
        vista.cbCarrera.addItem(recurso);         
      }    
    } 
    catch (Exception e) {
      System.out.println(e);
    }
  }
  
  
  public void cerrarVentanaRegistroEstudiantes() {
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
}

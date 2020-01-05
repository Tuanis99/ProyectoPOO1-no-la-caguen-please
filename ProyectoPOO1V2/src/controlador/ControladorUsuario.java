package controlador;

import java.awt.event.ActionListener;
import modelo.Usuario;
import dao.UsuarioDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.LogInForm;
import vista.Menu;


public class ControladorUsuario implements ActionListener {
  
  public LogInForm vista;
  public UsuarioDAO dao;
  public Usuario modelo;
  
  
  public ControladorUsuario(LogInForm pVista){
    vista = pVista;
    dao= new UsuarioDAO();
    this.vista.btIngresar.addActionListener(this);
    this.vista.btSalir.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e) {    
    try{
      switch(e.getActionCommand()) {
        case "Ingresar":
          logIn();
          break;
        case "Salir":
          salir();
          break;
        default:
          break;
      }
    }
    catch (SQLException ex) {
      Logger.getLogger(ControladorAgregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
    } 
    catch (ClassNotFoundException ex) {
      Logger.getLogger(ControladorAgregarEstudiante.class.getName()).log(Level.SEVERE, null, ex);
    }
  }


  public void logIn() throws SQLException, ClassNotFoundException {
    if (vista.validarDatosCompletos()){
      String idUsuario = vista.txtUsuario.getText();
      String contrasena = vista.txtContrasena.getText();
      modelo = new Usuario(idUsuario, contrasena);
      Usuario usuarioActual = dao.iniciarSesion(modelo); 
      if (usuarioActual != null) {   
        vista.setVisible(false);
        JOptionPane.showMessageDialog(vista, "Bienvenido: " +modelo.getIdUsuario());
        desplegarMenu();
      }
      else {
        JOptionPane.showMessageDialog(vista, "Los datos son incorrectos");
      }
    }
    else{
      JOptionPane.showMessageDialog(vista, "Todos lo datos son requeridos");
    }
  }
 
  
  public void salir(){
    vista.finalizarPrograma();
  }
  
  
  public void desplegarMenu(){
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    controladorMenu.vista.setLocationRelativeTo(null);    
  }


}


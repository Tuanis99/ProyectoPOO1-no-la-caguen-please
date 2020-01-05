package controlador;


import dao.ReservaDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Estudiante;
import modelo.Reserva;
import modelo.Incidente;
import vista.ConsultaEstudiantesForm;
import vista.ConsultaReservasEstudianteForm;
import vista.Menu;
/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorConsultaReservasEstudiante implements ActionListener {
  public ConsultaReservasEstudianteForm vista;
  public ReservaDAO dao;
  public Reserva modelo;
  
  
  public ControladorConsultaReservasEstudiante(ConsultaReservasEstudianteForm pVista){
    vista = pVista;
    dao= new ReservaDAO();
    this.vista.btBuscar.addActionListener(this);
    this.vista.btVolver.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Buscar":
          mostrarReservaEstudiantes();
          break;
        case "Volver":
          cerrarVentanaConsultaReservasEstudiantes();
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
  

  public void cerrarVentanaConsultaReservasEstudiantes() {
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
   
  
  
  public void mostrarReservaEstudiantes() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe digitar el carnet del estudiante");
    }
 //   if(vista.validarDatosEnteros()== false) {
 //     JOptionPane.showMessageDialog(vista, "El carnet debe ser un número entero");
 //   }
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    ArrayList<Reserva> reservasEstudiante = dao.consultarReservasEstudiante(carnet);
    DefaultTableModel modeloTabla = (DefaultTableModel) vista.tbInfoReservas.getModel();
    modeloTabla.setRowCount(0);
    for (int j=0;j<reservasEstudiante.size();j++){
      Vector reservasEncontradas = new Vector();
      reservasEncontradas.add(reservasEstudiante.get(j).getId());
      reservasEncontradas.add(reservasEstudiante.get(j).getAsunto());
      reservasEncontradas.add(reservasEstudiante.get(j).getFechaSolicitud());  
      reservasEncontradas.add(reservasEstudiante.get(j).getFechaUso());
      reservasEncontradas.add(reservasEstudiante.get(j).getHoraInicio());
      reservasEncontradas.add(reservasEstudiante.get(j).getHoraFin());
      reservasEncontradas.add(reservasEstudiante.get(j).getIdSala());
      reservasEncontradas.add(reservasEstudiante.get(j).getEstado());
      String estadoExito = "No";
      if (reservasEstudiante.get(j).getIsExitosa()){
        estadoExito = "Sí";
      }
      reservasEncontradas.add(estadoExito);
      modeloTabla.addRow(reservasEncontradas);
      vista.tbInfoReservas.setModel(modeloTabla);
    }
  }  
}

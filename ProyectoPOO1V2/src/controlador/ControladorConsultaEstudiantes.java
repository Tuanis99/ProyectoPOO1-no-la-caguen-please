package controlador;


import dao.EstudianteDAO;
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
import vista.Menu;



/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorConsultaEstudiantes implements ActionListener {
  public ConsultaEstudiantesForm vista;
  public EstudianteDAO dao;
  public Estudiante modelo;
  
  
  public ControladorConsultaEstudiantes(ConsultaEstudiantesForm pVista){
    vista = pVista;
    dao= new EstudianteDAO();
    this.vista.btBuscar.addActionListener(this);
    this.vista.btVolver.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
    try{
      switch(e.getActionCommand()) {
        case "Buscar":
          mostrarEstudiantes();
          mostrarReservaEstudiantes();
          mostrarIncidenteReservaEstudiantes();
          break;
        case "Volver":
          cerrarVentanaConsultaEstudiantes();
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
  

  public void cerrarVentanaConsultaEstudiantes() {
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
  
  private ArrayList<Incidente> instanciarIncidente() throws SQLException, ClassNotFoundException{
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    ArrayList<Incidente> incidentes = dao.consultarReservasIncidentesEstudiante(carnet);
    return incidentes;
  }
  
  
  private ArrayList<Reserva> instanciarReserva() throws SQLException, ClassNotFoundException{
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    ArrayList<Incidente> incidentes = instanciarIncidente();
    ArrayList<Reserva> reservas = dao.consultarReservasEstudiante(carnet);
    for (int j = 0; j < reservas.size(); j++){
      for (int k = 0; k < incidentes.size(); k++){
        if(reservas.get(j).getId() == incidentes.get(k).getIdReserva()){
          reservas.get(j).agregarIncidente(incidentes.get(k));
        }
      } 
    }
    return reservas;
  }
  
  
  private Estudiante instanciarEstudiante() throws SQLException, 
      ClassNotFoundException {
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    ArrayList<Reserva> reservas = instanciarReserva();
    ArrayList<Estudiante> estudiantes = dao.consultarEstudiantes(carnet); 
    Estudiante estudiante = estudiantes.get(0);
    for (int j = 0; j < reservas.size(); j++){
      Reserva reserva = reservas.get(j);
      estudiante.agregarReserva(reserva.getId(), reserva.getAsunto(), reserva.getFechaSolicitud(),
          reserva.getFechaUso(), reserva.getHoraInicio(), reserva.getHoraFin(), reserva.getIdSala(),
          reserva.getEstado(), reserva.getIsExitosa(), reserva.getIncidentesReserva());
    }
    return estudiante;
  }
  
  public void mostrarEstudiantes() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe digitar el carnet del estudiante");
    }
 //   if(vista.validarDatosEnteros()== false) {
 //     JOptionPane.showMessageDialog(vista, "El carnet debe ser un número entero");
 //   }
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    Estudiante estudiante = instanciarEstudiante(); 
      DefaultTableModel modeloTabla = (DefaultTableModel) vista.tbInfoEstudiante.getModel();
      modeloTabla.setRowCount(0);
      Vector estudiantesConsultado = new Vector();
      estudiantesConsultado.add(estudiante.getCarnet());
      estudiantesConsultado.add(estudiante.getNombre());
      estudiantesConsultado.add(estudiante.getPrimerApellido());
      estudiantesConsultado.add(estudiante.getSegundoApellido());
      estudiantesConsultado.add(estudiante.getCorreo());
      estudiantesConsultado.add(estudiante.getCalificacion());
      estudiantesConsultado.add(estudiante.getTelefono());
      estudiantesConsultado.add(estudiante.getCarrera());
      modeloTabla.addRow(estudiantesConsultado);
      vista.tbInfoEstudiante.setModel(modeloTabla);
    
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
    Estudiante estudiante = instanciarEstudiante();
    ArrayList<Reserva> reservasEstudiante = estudiante.getReservasEstudiante();
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
  
  
  public void mostrarIncidenteReservaEstudiantes() throws SQLException, ClassNotFoundException{
    if(vista.validarDatosCompletos() == false) {
      JOptionPane.showMessageDialog(vista, "Debe digitar el carnet del estudiante");
    }
 //   if(vista.validarDatosEnteros()== false) {
 //     JOptionPane.showMessageDialog(vista, "El carnet debe ser un número entero");
 //   }
    String carnetString = vista.txtCarnet.getText();
    int carnet = Integer.parseInt(carnetString);
    Estudiante estudiante = instanciarEstudiante();
    ArrayList<Reserva> reservasEstudiante = estudiante.getReservasEstudiante();
    DefaultTableModel modeloTabla = (DefaultTableModel) vista.tbInfoIncidentes.getModel();
    modeloTabla.setRowCount(0);
    for (int j=0;j<reservasEstudiante.size();j++){
      ArrayList<Incidente> incidentesReserva = reservasEstudiante.get(j).getIncidentesReserva();
      for (int k=0; k<incidentesReserva.size(); k++ ){
        Vector incidentesEncontrados = new Vector();
        incidentesEncontrados.add(incidentesReserva.get(k).getIdReserva());
        incidentesEncontrados.add(incidentesReserva.get(k).getDetalle());
        incidentesEncontrados.add(incidentesReserva.get(k).getRebajoPuntos());
        modeloTabla.addRow(incidentesEncontrados);
        vista.tbInfoIncidentes.setModel(modeloTabla);
      } 
    }  
  }
}


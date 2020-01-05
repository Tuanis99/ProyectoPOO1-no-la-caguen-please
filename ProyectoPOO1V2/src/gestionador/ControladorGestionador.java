package gestionador;


import controlador.ControladorAgregarEstudiante;
import controlador.ControladorConsultaEstudiantes;
import controlador.ControladorSala;
import controlador.ControladorVerificacionSala;
import controlador.ControladorConsultaReservasEstudiante;
import controlador.ControladorGraficos;
import controlador.ControladorReservas;
import dao.EstudianteDAO;
import dao.UsuarioDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Estudiante;
import modelo.Usuario;
import modelo.Reserva;
import vista.AgregarEstudianteForm;
import vista.AgregarSalaForm;
import vista.ConsultaEstudiantesForm;
import vista.Menu;
import vista.ModificarSala;
import vista.ConsultaReservasEstudianteForm;
import vista.CrearReserva;
import vista.Reporte;


/**
 *
 * @author Andrés Pérez Bonilla
 */
public class ControladorGestionador implements ActionListener {
  public Menu vista;
  public EstudianteDAO dao;
  public Estudiante modelo;
  
  
  public ControladorGestionador(Menu pVista){
    vista = pVista;
    this.vista.btAgregarEstudiante.addActionListener(this);
    this.vista.btAgregarSala.addActionListener(this);
    this.vista.btAnalisisDatos.addActionListener(this);
    this.vista.btConsultarEstudiante.addActionListener(this);
    this.vista.btConsultarSala.addActionListener(this);
    this.vista.btCrearReserva.addActionListener(this);
    this.vista.btModificarDatosSala.addActionListener(this);
    this.vista.btReservasEstudiante.addActionListener(this);
    this.vista.btCerrarSesion.addActionListener(this);
    this.vista.btCalificarSala.addActionListener(this);
  }
    
    
    @Override
  public void actionPerformed(ActionEvent e){    
      switch(e.getActionCommand()) {
          case "Agregar Estudiante":
              AgregarEstudianteForm estudianteVista = new AgregarEstudianteForm();
              ControladorAgregarEstudiante controladorEstudiante = new 
                  ControladorAgregarEstudiante(estudianteVista);
              controladorEstudiante.vista.setVisible(true);
              vista.setVisible(false);
              controladorEstudiante.vista.setLocationRelativeTo(null);
              controladorEstudiante.cargarCarreras();
              break;
          case "Consultar Estudiante":
              ConsultaEstudiantesForm estudiantesConsultadosVista = new
                  ConsultaEstudiantesForm();
              ControladorConsultaEstudiantes controladorEstudiantesConsultados = new 
                  ControladorConsultaEstudiantes(estudiantesConsultadosVista);   
              controladorEstudiantesConsultados.vista.setVisible(true);
              vista.setVisible(false);
              controladorEstudiantesConsultados.vista.setLocationRelativeTo(null);
              break;
          case "Agregar Sala":
              AgregarSalaForm salaVista = new AgregarSalaForm();
              ControladorSala controladorSala = new 
              ControladorSala(salaVista);
              controladorSala.vista.setVisible(true);
              vista.setVisible(false);
              controladorSala.vista.setLocationRelativeTo(null);
              break;                           
          case "Modificar Datos de Salas":
              ModificarSala modificarVista = new ModificarSala();
              ControladorVerificacionSala controladorModificar = new 
              ControladorVerificacionSala(modificarVista);
              controladorModificar.vista.setVisible(true);
              vista.setVisible(false);
              controladorModificar.vista.setLocationRelativeTo(null);
              controladorModificar.cargarSalas();
              break;

          case "Reservas de un estudiante":
              ConsultaReservasEstudianteForm estudiantesReservaVista = new 
                  ConsultaReservasEstudianteForm();
              ControladorConsultaReservasEstudiante controladorReservasEstudiante = new 
                  ControladorConsultaReservasEstudiante(estudiantesReservaVista);
              controladorReservasEstudiante.vista.setVisible(true);
              vista.setVisible(false);
              controladorReservasEstudiante.vista.setLocationRelativeTo(null);
              break;

          case "Crear Reserva":
              CrearReserva crearReservaVista = new CrearReserva();
              ControladorReservas controladorReservas = new ControladorReservas(crearReservaVista);
              controladorReservas.cargarCombo();
              controladorReservas.cargarComboSalas();
              controladorReservas.vista.setVisible(true);
              vista.setVisible(false);
              controladorReservas.vista.setLocationRelativeTo(null);
              break; 
              
          case "Análisis de Datos":
              Reporte analisisdDatos = new Reporte();
              ControladorGraficos controlador = new ControladorGraficos(analisisdDatos);
              controlador.vista.setVisible(true);
              vista.setVisible(false);
              controlador.vista.setLocationRelativeTo(null);
              break;
          default:
              break;
      }
  }
}//Análisis de Datos
package controlador;


import dao.GraficosDAO;
import gestionador.ControladorGestionador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import vista.Menu;
import vista.Reporte;
/**
 *
 * @author Mata
 */
public class ControladorGraficos implements ActionListener{
  GraficosDAO dao;
  public Reporte vista;

  public ControladorGraficos(Reporte pVista){
    vista = pVista;
    dao= new GraficosDAO();
    this.vista.btnGraficar.addActionListener(this);
    this.vista.btnVolver.addActionListener(this);
  }
  
  
  public void actionPerformed(ActionEvent e){    
      switch(e.getActionCommand()) {
        case "Graficar":
          graficar();
          break;
        case "Volver":
          cerrarVentana();
          break;
        default:
          break;
      }
  }  
  
  public void graficar(){
    if (this.vista.comboGrafico.getSelectedItem().toString().equals("Salas mas utilizadas")) {
       graficarTopSalasUtilizadas();  
    }
   
    
    if (this.vista.comboGrafico.getSelectedItem().toString().equals("Horarios mas utilizados")) {
       graficarTopHorarios();  
    }  
    
    
    if (this.vista.comboGrafico.getSelectedItem().toString().equals("Carreras con mas uso de salas")) {
       graficarTopCarreras();  
    } 


    if (this.vista.comboGrafico.getSelectedItem().toString().equals("Salas con mejor calificación")) {
       graficarTopSalasCalificacion();  
    }    
  }
  public void graficarTopSalasUtilizadas(){
    try {
        ArrayList<String> salas = dao.consultarSalasMasUtilizadas();  
        ArrayList<Integer> cantidades = dao.consultarSalasMasUtilizadasCantidades(); 
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(cantidades.get(0), salas.get(0), "Salas");
        dataSet.addValue(cantidades.get(1), salas.get(1), "Salas");
        dataSet.addValue(cantidades.get(2), salas.get(2), "Salas");
        dataSet.addValue(cantidades.get(3), salas.get(3), "Salas");
        dataSet.addValue(cantidades.get(4), salas.get(4), "Salas");
        JFreeChart grafica = ChartFactory.createBarChart("Salas mas utilizadas", " x", "Salas", dataSet, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("graficas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }      
  }

    private void graficarTopHorarios() {
    try {
        ArrayList<String> horario = dao.consultarTopHorarios();  
        ArrayList<Integer> cantidades = dao.consultarTopHorariosCantidades(); 
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue(horario.get(0), cantidades.get(0));
        dataSet.setValue(horario.get(1), cantidades.get(1));
        dataSet.setValue(horario.get(2), cantidades.get(2));
        dataSet.setValue(horario.get(3), cantidades.get(3));
        dataSet.setValue(horario.get(4), cantidades.get(4));
        JFreeChart grafica = ChartFactory.createPieChart("Horarios mas utilizados", dataSet, true, true, Locale.ITALY);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("graficas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void graficarTopCarreras() {
    try {
        ArrayList<String> carrera = dao.consultarTopCarreras();  
        ArrayList<Integer> cantidades = dao.consultarTopCarrerasCantidades(); 
        DefaultPieDataset dataSet = new DefaultPieDataset();
        dataSet.setValue(carrera.get(0), cantidades.get(0));
        dataSet.setValue(carrera.get(1), cantidades.get(1));
        dataSet.setValue(carrera.get(2), cantidades.get(2));
        dataSet.setValue(carrera.get(3), cantidades.get(3));
        dataSet.setValue(carrera.get(4), cantidades.get(4));
        JFreeChart grafica = ChartFactory.createPieChart("Carreras con mas reservas", dataSet, true, true, Locale.ITALY);
        ChartPanel contenedor1 = new ChartPanel(grafica);
        JFrame ventana1 = new JFrame("Carreras");
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.add(contenedor1);
        ventana1.setSize(500, 500);
        ventana1.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void graficarTopSalasCalificacion() {
    try {
        ArrayList<String> salas = dao.consultarSalasPuntuacion();  
        ArrayList<Integer> cantidades = dao.consultarSalasPuntuacionCantidades(); 
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(cantidades.get(0), salas.get(0), "Salas");
        dataSet.addValue(cantidades.get(1), salas.get(1), "Salas");
        dataSet.addValue(cantidades.get(2), salas.get(2), "Salas");
        dataSet.addValue(cantidades.get(3), salas.get(3), "Salas");
        dataSet.addValue(cantidades.get(4), salas.get(4), "Salas");
        JFreeChart grafica = ChartFactory.createBarChart("Salas con mejor calificación", " x", "Salas", dataSet, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel contenedor = new ChartPanel(grafica);
        JFrame ventana = new JFrame("graficas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(500, 500);
        ventana.setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        } 
    }
    
    
  public void cerrarVentana() {
    Menu menuVista = new Menu();
    ControladorGestionador controladorMenu = new ControladorGestionador(menuVista);
    controladorMenu.vista.setVisible(true);
    this.vista.setVisible(false);
    controladorMenu.vista.setLocationRelativeTo(null); 
  }
}

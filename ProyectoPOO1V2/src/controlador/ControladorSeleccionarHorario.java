/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SalaDAO;
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
import vista.SeleccionarHorario;

/**
 *
 * @author luisg
 */
public class ControladorSeleccionarHorario implements ActionListener{
    public SeleccionarHorario vista;
    public SalaDAO dao;
    public Sala modelo;
    public Horario modelo2;
    
    public ControladorSeleccionarHorario(SeleccionarHorario pVista){
        vista = pVista;
        dao = new SalaDAO();
        this.vista.btnAceptar.addActionListener(this);
    }
    
    public void actionPerformed (ActionEvent e){
        try{
            switch (e.getActionCommand()){
                case "Aceptar":
                    agregarHorario();
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
    
    public void agregarHorario() throws SQLException, ClassNotFoundException{
        String idSala =  vista.cbxIdSalas.getSelectedItem().toString();
        int horario = vista.cbxHorario.getSelectedIndex() + 1;
        modelo = new Sala(idSala);
        modelo2 = new Horario(horario);
        boolean horarioActual = dao.agregarHorario(modelo, modelo2);
        if (horarioActual){
            JOptionPane.showMessageDialog(vista, "El horario ha sido ingresada correctamente");
        }
        else{
            JOptionPane.showMessageDialog(vista, "Ha ocurrido un error de conexión");
        }
    }
    
    public void cargarHorarios(){
        try {
            ArrayList<String> recursos = dao.cargarComboHorarios();
            for (int i = 0; i < recursos.size(); i++) {
                String recurso = recursos.get(i);
                vista.cbxHorario.addItem(recurso);         
            }    
        } 
        catch (Exception e) {
            System.out.println(e);
        }
  }
    
    public void cargarSalas(){
        try{
            ArrayList<String> salas = dao.cargarSalas();
            for(int i = 0; i < salas.size(); i++){
                String sala = salas.get(i);
                vista.cbxIdSalas.addItem(sala);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
  
    public void llenarTablaHorarios(){
    try {
        ArrayList<Horario> horarios = dao.consultarHorariosDisponibles();
        DefaultTableModel tm=(DefaultTableModel)vista.horariosTable.getModel();
        tm.setRowCount(0);
        for (int i = 0; i < horarios.size(); i++) {
           Object o[]= {horarios.get(i).getIdHorario(),horarios.get(i).getDia(),horarios.get(i).getHoraApertura()
           ,horarios.get(i).getHoraCierre()};
           tm.addRow(o);           
        }               
        } catch (Exception e) {
            System.out.println(e);
        }
  }
}

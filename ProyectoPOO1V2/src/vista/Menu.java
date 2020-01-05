package vista;

/**
 *
 * @author Andrés Pérez Bonilla
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btAgregarEstudiante = new javax.swing.JButton();
        btConsultarEstudiante = new javax.swing.JButton();
        btAgregarSala = new javax.swing.JButton();
        btModificarDatosSala = new javax.swing.JButton();
        btCalificarSala = new javax.swing.JButton();
        btConsultarSala = new javax.swing.JButton();
        btCrearReserva = new javax.swing.JButton();
        btAnalisisDatos = new javax.swing.JButton();
        btReservasEstudiante = new javax.swing.JButton();
        btCerrarSesion = new javax.swing.JButton();
        btCancelarReserva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú");

        btAgregarEstudiante.setText("Agregar Estudiante");
        btAgregarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarEstudianteActionPerformed(evt);
            }
        });

        btConsultarEstudiante.setText("Consultar Estudiante");
        btConsultarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarEstudianteActionPerformed(evt);
            }
        });

        btAgregarSala.setText("Agregar Sala");
        btAgregarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarSalaActionPerformed(evt);
            }
        });

        btModificarDatosSala.setText("Modificar Datos de Salas");
        btModificarDatosSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificarDatosSalaActionPerformed(evt);
            }
        });

        btCalificarSala.setText("Calificar Sala");
        btCalificarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalificarSalaActionPerformed(evt);
            }
        });

        btConsultarSala.setText("Consultar Sala");
        btConsultarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarSalaActionPerformed(evt);
            }
        });

        btCrearReserva.setText("Crear Reserva");

        btAnalisisDatos.setText("Análisis de Datos");
        btAnalisisDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAnalisisDatosActionPerformed(evt);
            }
        });

        btReservasEstudiante.setText("Reservas de un estudiante");

        btCerrarSesion.setText("Cerrar Sesión");

        btCancelarReserva.setText("Cancelar Reserva");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(199, 199, 199)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btAgregarEstudiante)
                            .addComponent(btConsultarEstudiante)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btModificarDatosSala))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btAgregarSala))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btCalificarSala)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAnalisisDatos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btConsultarSala)
                                .addComponent(btCrearReserva)))
                        .addGap(108, 108, 108))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btReservasEstudiante)
                        .addGap(82, 82, 82))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btCerrarSesion)
                            .addComponent(btCancelarReserva)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAgregarEstudiante)
                            .addComponent(btConsultarSala))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btConsultarEstudiante)
                            .addComponent(btCrearReserva))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAgregarSala)
                            .addComponent(btAnalisisDatos))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btModificarDatosSala)
                            .addComponent(btReservasEstudiante)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCalificarSala)
                    .addComponent(btCancelarReserva))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btCerrarSesion)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAnalisisDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAnalisisDatosActionPerformed
  
    }//GEN-LAST:event_btAnalisisDatosActionPerformed

    private void btAgregarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarEstudianteActionPerformed

    }//GEN-LAST:event_btAgregarEstudianteActionPerformed

    private void btConsultarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarEstudianteActionPerformed
        
    }//GEN-LAST:event_btConsultarEstudianteActionPerformed

    private void btAgregarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarSalaActionPerformed
          
    }//GEN-LAST:event_btAgregarSalaActionPerformed

    private void btModificarDatosSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificarDatosSalaActionPerformed

    }//GEN-LAST:event_btModificarDatosSalaActionPerformed

    private void btCalificarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalificarSalaActionPerformed
 
    }//GEN-LAST:event_btCalificarSalaActionPerformed

    private void btConsultarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarSalaActionPerformed

    }//GEN-LAST:event_btConsultarSalaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAgregarEstudiante;
    public javax.swing.JButton btAgregarSala;
    public javax.swing.JButton btAnalisisDatos;
    public javax.swing.JButton btCalificarSala;
    public javax.swing.JButton btCancelarReserva;
    public javax.swing.JButton btCerrarSesion;
    public javax.swing.JButton btConsultarEstudiante;
    public javax.swing.JButton btConsultarSala;
    public javax.swing.JButton btCrearReserva;
    public javax.swing.JButton btModificarDatosSala;
    public javax.swing.JButton btReservasEstudiante;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
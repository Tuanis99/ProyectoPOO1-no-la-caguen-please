/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author luisg
 */
public class SeleccionModificar extends javax.swing.JFrame {

    /**
     * Creates new form SeleccionModificar
     */
    public SeleccionModificar() {
        initComponents();
    }
    
    public boolean validarDatosCompletos (){
        String ubicacion = txtUbicacion.getText();
        if (ubicacion.length() == 0){
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbModificacion = new javax.swing.JLabel();
        lbEstado = new javax.swing.JLabel();
        lbRecursos = new javax.swing.JLabel();
        lbUbicacion = new javax.swing.JLabel();
        txtUbicacion = new javax.swing.JTextField();
        btnModificarUbicacion = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cbxRecursos = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        btnModificarEstado = new javax.swing.JButton();
        btnModificarRecursos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbModificacion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbModificacion.setText("Modificacion de la Sala");

        lbEstado.setText("Estado");

        lbRecursos.setText("Recursos");

        lbUbicacion.setText("Ubicacion");

        txtUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUbicacionActionPerformed(evt);
            }
        });

        btnModificarUbicacion.setText("Modificar Ubicacion");
        btnModificarUbicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUbicacionActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");

        cbxRecursos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });

        btnModificarEstado.setText("Modificar Estado");
        btnModificarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarEstadoActionPerformed(evt);
            }
        });

        btnModificarRecursos.setText("Modificar Recursos");
        btnModificarRecursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarRecursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbUbicacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 38, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbRecursos)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnModificarEstado)
                                        .addGap(143, 143, 143)
                                        .addComponent(btnModificarRecursos)))
                                .addGap(65, 65, 65))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbModificacion)
                        .addGap(302, 302, 302))))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(btnModificarUbicacion)
                .addGap(151, 151, 151)
                .addComponent(lbEstado)
                .addGap(18, 18, 18)
                .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lbModificacion)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUbicacion)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbRecursos)
                    .addComponent(cbxRecursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEstado)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarUbicacion)
                    .addComponent(btnModificarRecursos)
                    .addComponent(btnModificarEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 238, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarUbicacionActionPerformed

    private void txtUbicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUbicacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUbicacionActionPerformed

    private void btnModificarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarEstadoActionPerformed

    private void btnModificarRecursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarRecursosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarRecursosActionPerformed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionModificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnModificarEstado;
    public javax.swing.JButton btnModificarRecursos;
    public javax.swing.JButton btnModificarUbicacion;
    public javax.swing.JButton btnVolver;
    public javax.swing.JComboBox<String> cbxEstado;
    public javax.swing.JComboBox<String> cbxRecursos;
    private javax.swing.JLabel lbEstado;
    private javax.swing.JLabel lbModificacion;
    private javax.swing.JLabel lbRecursos;
    private javax.swing.JLabel lbUbicacion;
    public javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}

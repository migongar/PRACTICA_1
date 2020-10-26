/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author angel
 */
public class InscribirseTorneo extends javax.swing.JFrame {
    private JFrame pganterior;
    private Usuario usuario;
    /**
     * Creates new form IncribirseTorneo
     */
    
    public InscribirseTorneo(Usuario user,JFrame anterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        pganterior = anterior;
        usuario = user;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        JL_Torneos = new javax.swing.JList<>();
        jB_Inscribir = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jT_dni = new javax.swing.JTextField();
        jB_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INCRIBIRSE EN TORNEO");

        jScrollPane1.setViewportView(JL_Torneos);

        jB_Inscribir.setText("Inscribirse");
        jB_Inscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_InscribirActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("DNI");

        jT_dni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_dniActionPerformed(evt);
            }
        });

        jB_buscar.setText("Buscar Torneo");
        jB_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Inscribir)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jT_dni, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jB_buscar)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jB_buscar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Inscribir)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_InscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_InscribirActionPerformed
        if(JL_Torneos.getSelectedValue() != null){            
            if(!usuario.registrarJugadorTorneo(usuario,(Object)JL_Torneos.getSelectedValue())){
                JOptionPane.showMessageDialog(null, "Error al realizar la reserva del cliente habitual", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha realizado con exito", "AVISO",JOptionPane.INFORMATION_MESSAGE);
                pganterior.setVisible(true);
                this.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun torneo", "ERROR",  JOptionPane.ERROR_MESSAGE);
        }
        
        JOptionPane.showMessageDialog(this, "Inscrito en: ");
    }//GEN-LAST:event_jB_InscribirActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:        
        pganterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jT_dniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_dniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_dniActionPerformed

    private void jB_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_buscarActionPerformed
        ArrayList listaTorneos = new ArrayList();
        
        listaTorneos = usuario.buscarTorneos(jT_dni.getText());
        
        JL_Torneos.clearSelection();

        DefaultListModel lista = new DefaultListModel();
        if(!listaTorneos.isEmpty()){
            for(int i = 0; i < listaTorneos.size(); i++){
                lista.addElement(listaTorneos.get(i));                   
            }
        }                
        else{
            JOptionPane.showMessageDialog(null,"No hay torneos disponibles para este jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        JL_Torneos.setModel(lista);  
    }//GEN-LAST:event_jB_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JL_Torneos;
    private javax.swing.JButton jB_Inscribir;
    private javax.swing.JButton jB_buscar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jT_dni;
    // End of variables declaration//GEN-END:variables
}

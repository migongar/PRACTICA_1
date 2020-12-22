/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import Fachada.Fachada;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Administrador;
import modelo.Datos;

/**
 *
 * @author angel
 */
public class RegistroClub extends javax.swing.JFrame {
    private Fachada administrador;
    private JFrame paganterior;
    private Datos datosGerente, datosEntrenador;
    /**
     * Creates new form RegistroClub
     */
    public RegistroClub(Fachada admin, JFrame pagant) {
        initComponents();
        this.setLocationRelativeTo(null);
        administrador = admin;
        paganterior = pagant;
        
        datosGerente = null;
        datosEntrenador = null;
        
        ArrayList lista = new ArrayList();
        lista = administrador.getLiga().getFederaciones();
        for(int i = 0; i<lista.size();i++){
            jC_Fede.addItem(lista.get(i).toString());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jT_nomClub = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jC_Fede = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jT_DNIGerente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jB_BuscarGer = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jT_nomGerente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jB_BuscarEnt = new javax.swing.JButton();
        jT_DNIEntrenador = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jT_nomEntrenador = new javax.swing.JTextField();
        jB_Salir = new javax.swing.JButton();
        jB_Registrar = new javax.swing.JButton();
        jTF_nomSede = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jT_apGerente = new javax.swing.JTextField();
        jT_apEntrenador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("REGISTRO CLUB");

        jLabel2.setText("Nombre del Cub : ");

        jLabel3.setText("Federacion: ");

        jC_Fede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jC_FedeActionPerformed(evt);
            }
        });

        jLabel4.setText("Sede:");

        jLabel5.setText("Datos del Gerente");

        jT_DNIGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_DNIGerenteActionPerformed(evt);
            }
        });

        jLabel6.setText("DNI");

        jB_BuscarGer.setText("Buscar");
        jB_BuscarGer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BuscarGerActionPerformed(evt);
            }
        });

        jLabel7.setText("Nombre: ");

        jLabel8.setText("Datos de Entrenador");

        jB_BuscarEnt.setText("Buscar");
        jB_BuscarEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BuscarEntActionPerformed(evt);
            }
        });

        jT_DNIEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_DNIEntrenadorActionPerformed(evt);
            }
        });

        jLabel9.setText("DNI");

        jLabel10.setText("Nombre: ");

        jT_nomEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_nomEntrenadorActionPerformed(evt);
            }
        });

        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });

        jB_Registrar.setText("Registrar");
        jB_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_RegistrarActionPerformed(evt);
            }
        });

        jLabel11.setText("Apellidos:");

        jLabel12.setText("Apellidos:");

        jT_apEntrenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jT_apEntrenadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jB_Salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jB_Registrar)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jT_DNIGerente)
                            .addComponent(jT_nomGerente)
                            .addComponent(jT_apGerente, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 117, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel10))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jT_apEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jB_BuscarGer)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jT_DNIEntrenador, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                            .addComponent(jT_nomEntrenador))))
                                .addGap(18, 18, 18)
                                .addComponent(jB_BuscarEnt)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jT_nomClub)
                    .addComponent(jC_Fede, 0, 188, Short.MAX_VALUE)
                    .addComponent(jTF_nomSede)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jT_nomClub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jC_Fede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTF_nomSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jT_DNIGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_BuscarGer)
                    .addComponent(jLabel9)
                    .addComponent(jT_DNIEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jB_BuscarEnt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_nomEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_nomGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jT_apGerente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jT_apEntrenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Salir)
                    .addComponent(jB_Registrar))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jC_FedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jC_FedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jC_FedeActionPerformed

    private void jT_DNIGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_DNIGerenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_DNIGerenteActionPerformed

    private void jT_DNIEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_DNIEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_DNIEntrenadorActionPerformed

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        paganterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_RegistrarActionPerformed
        String club, sede, federacion;     
        
        club = jT_nomClub.getText();
        federacion = jC_Fede.getSelectedItem().toString();
        sede = jTF_nomSede.getText();
        
        if(datosGerente != null || datosEntrenador != null){
            if(!administrador.registrarClub(club, federacion, sede, datosGerente.getDNI(), datosEntrenador.getDNI())){
                JOptionPane.showMessageDialog(null, "Error al registrar el jugador", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "Registrado correctamente.\n", "AVISO",JOptionPane.INFORMATION_MESSAGE);
                paganterior.setVisible(true);
                this.dispose();
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Error falta especificar Gerente o Entrenado del club", "ERROR",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jB_RegistrarActionPerformed

    private void jB_BuscarGerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BuscarGerActionPerformed
        String DNIgerente;
        
        DNIgerente = jT_DNIGerente.getText();
        
        datosGerente = administrador.buscarGerente(DNIgerente);
        
        if(datosGerente != null){
            jT_nomGerente.setText(datosGerente.getNombre());
            jT_apGerente.setText(datosGerente.getApellidos());
        }
        else{
            jT_nomGerente.setText("");
            jT_apGerente.setText("");            
            JOptionPane.showMessageDialog(null, "El DNI no corresponde con ningun Gerente registrado", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jB_BuscarGerActionPerformed

    private void jT_nomEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_nomEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_nomEntrenadorActionPerformed

    private void jT_apEntrenadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jT_apEntrenadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jT_apEntrenadorActionPerformed

    private void jB_BuscarEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BuscarEntActionPerformed
        String DNIentrenador;
        
        DNIentrenador = jT_DNIEntrenador.getText();
        
        datosEntrenador = administrador.buscarEntrenador(DNIentrenador);
        
        if(datosEntrenador != null){
            jT_nomEntrenador.setText(datosEntrenador.getNombre());
            jT_apEntrenador.setText(datosEntrenador.getApellidos());
        }
        else{
            jT_nomEntrenador.setText("");
            jT_apEntrenador.setText("");            
            JOptionPane.showMessageDialog(null, "El DNI no corresponde con ningun Entrenador registrado", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }// TODO add your handling code here:
    }//GEN-LAST:event_jB_BuscarEntActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_BuscarEnt;
    private javax.swing.JButton jB_BuscarGer;
    private javax.swing.JButton jB_Registrar;
    private javax.swing.JButton jB_Salir;
    private javax.swing.JComboBox<String> jC_Fede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTF_nomSede;
    private javax.swing.JTextField jT_DNIEntrenador;
    private javax.swing.JTextField jT_DNIGerente;
    private javax.swing.JTextField jT_apEntrenador;
    private javax.swing.JTextField jT_apGerente;
    private javax.swing.JTextField jT_nomClub;
    private javax.swing.JTextField jT_nomEntrenador;
    private javax.swing.JTextField jT_nomGerente;
    // End of variables declaration//GEN-END:variables
}

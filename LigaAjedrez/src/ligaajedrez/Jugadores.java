/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Jugador;

/**
 *
 * @author angel
 */
public class Jugadores extends javax.swing.JFrame {

    /**
     * Creates new form Jugadores
     */
    private AsignarResponsable resp;
    private ReservarSede resSede;
    private IntroducirResultado resultado;
    private InscribirseTorneo inscribir_torneo;
    private JFrame paganterior;
    private Jugador jugador;
    
    public Jugadores(Jugador jug,JFrame pgant) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jugador = jug;
        this.paganterior = pgant;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_ReservarSede = new javax.swing.JButton();
        jB_IntroducirRes = new javax.swing.JButton();
        jB_InscribirseTorneo = new javax.swing.JButton();
        jL_Jugaodr = new javax.swing.JLabel();
        jB_AsignarResponsable = new javax.swing.JButton();
        jL_Nombre = new javax.swing.JLabel();
        jTF_Nombre = new javax.swing.JTextField();
        jL_Club = new javax.swing.JLabel();
        jTF_Club = new javax.swing.JTextField();
        jB_Salir = new javax.swing.JButton();
        jB_Historial = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jB_ReservarSede.setText("Reservar Sede");
        jB_ReservarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ReservarSedeActionPerformed(evt);
            }
        });

        jB_IntroducirRes.setText("Introducir Resultado");
        jB_IntroducirRes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_IntroducirResActionPerformed(evt);
            }
        });

        jB_InscribirseTorneo.setText("Inscribirse Torneo");
        jB_InscribirseTorneo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_InscribirseTorneoActionPerformed(evt);
            }
        });

        jL_Jugaodr.setText("JUGADOR");

        jB_AsignarResponsable.setText("Asignar Responsable a Menor");
        jB_AsignarResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AsignarResponsableActionPerformed(evt);
            }
        });

        jL_Nombre.setText("nombre");

        jL_Club.setText("club");

        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });

        jB_Historial.setText("Historial Jugador");
        jB_Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_HistorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jB_ReservarSede)
                        .addGap(18, 18, 18)
                        .addComponent(jB_IntroducirRes)
                        .addGap(18, 18, 18)
                        .addComponent(jB_InscribirseTorneo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jB_Salir))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(jB_AsignarResponsable)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jB_Historial))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(167, 167, 167)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jL_Club)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jL_Jugaodr, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jL_Nombre)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTF_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addComponent(jTF_Club)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Jugaodr, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Nombre)
                    .addComponent(jTF_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Club)
                    .addComponent(jTF_Club, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Historial)
                    .addComponent(jB_AsignarResponsable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_IntroducirRes)
                    .addComponent(jB_ReservarSede)
                    .addComponent(jB_InscribirseTorneo))
                .addGap(40, 40, 40)
                .addComponent(jB_Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_InscribirseTorneoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_InscribirseTorneoActionPerformed
        this.setVisible(false);
        inscribir_torneo = new InscribirseTorneo(jugador,this);
        inscribir_torneo.setVisible(true);
    }//GEN-LAST:event_jB_InscribirseTorneoActionPerformed

    private void jB_AsignarResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AsignarResponsableActionPerformed
        this.setVisible(false);
        resp = new AsignarResponsable(this);
        resp.setVisible(true);
    }//GEN-LAST:event_jB_AsignarResponsableActionPerformed

    private void jB_ReservarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ReservarSedeActionPerformed
        this.setVisible(false);
        resSede = new ReservarSede(this);
        resSede.setVisible(true);
    }//GEN-LAST:event_jB_ReservarSedeActionPerformed

    private void jB_IntroducirResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_IntroducirResActionPerformed
        this.setVisible(false);
        resultado = new IntroducirResultado(jugador,this);
        resultado.setVisible(true);
    }//GEN-LAST:event_jB_IntroducirResActionPerformed

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        paganterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_HistorialActionPerformed
        ArrayList lista = new ArrayList();
        lista = jugador.getTorneos();
        String torneos = "";
        for(int i = 0;i<lista.size();i++){
            torneos += lista.get(i).toString() + "\n";
        }
        
        JOptionPane.showMessageDialog(this, "Historial Jugador:" + torneos);
    }//GEN-LAST:event_jB_HistorialActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_AsignarResponsable;
    private javax.swing.JButton jB_Historial;
    private javax.swing.JButton jB_InscribirseTorneo;
    private javax.swing.JButton jB_IntroducirRes;
    private javax.swing.JButton jB_ReservarSede;
    private javax.swing.JButton jB_Salir;
    private javax.swing.JLabel jL_Club;
    private javax.swing.JLabel jL_Jugaodr;
    private javax.swing.JLabel jL_Nombre;
    private javax.swing.JTextField jTF_Club;
    private javax.swing.JTextField jTF_Nombre;
    // End of variables declaration//GEN-END:variables
}

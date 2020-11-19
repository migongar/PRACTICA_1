/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import Fachada.Fachada;
import javax.swing.JFrame;
import modelo.Administrador;

/**
 *
 * @author angel
 */
public class Administracion extends javax.swing.JFrame {
    private InscribirseTorneo inscribirseTorneo;
    private AsignarSede asignarSede;
    private AsignarResponsable asignarResponsable;
    private ReservarSede reservarSede;
    private IntroducirResultado resultado;
    private Historial historial;
    private Registrar registrar;
    private Fachada administrador;
    private JFrame paganterior;

    /**
     * Creates new form Administrador
     */
    public Administracion(Fachada admin, JFrame pgant) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.administrador = admin;
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
        jB_Inscribirse = new javax.swing.JButton();
        jB_Historial = new javax.swing.JButton();
        jB_AsignarSede = new javax.swing.JButton();
        jB_AsignarResponsable = new javax.swing.JButton();
        jL_Admin = new javax.swing.JLabel();
        jL_Nombre = new javax.swing.JLabel();
        jTF_nombre = new javax.swing.JTextField();
        jB_Resgistrar = new javax.swing.JButton();
        jB_Salir = new javax.swing.JButton();

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

        jB_Inscribirse.setText("Incribirse Torneo");
        jB_Inscribirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_InscribirseActionPerformed(evt);
            }
        });

        jB_Historial.setText("Historial");
        jB_Historial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_HistorialActionPerformed(evt);
            }
        });

        jB_AsignarSede.setText("Asignar Sede");
        jB_AsignarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AsignarSedeActionPerformed(evt);
            }
        });

        jB_AsignarResponsable.setText("Asignar Responsable a Menor");
        jB_AsignarResponsable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_AsignarResponsableActionPerformed(evt);
            }
        });

        jL_Admin.setText("ADMINISTRADOR");
        jL_Admin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jL_Nombre.setText("nombre");

        jB_Resgistrar.setText("Registrar");
        jB_Resgistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ResgistrarActionPerformed(evt);
            }
        });

        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jB_ReservarSede)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jB_Historial)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jB_IntroducirRes))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jL_Admin)
                            .addComponent(jB_AsignarSede))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jB_Inscribirse)
                        .addContainerGap(70, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_AsignarResponsable)
                        .addGap(33, 33, 33))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jL_Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTF_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jB_Resgistrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jB_Salir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jL_Admin)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Nombre)
                    .addComponent(jTF_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Historial)
                    .addComponent(jB_AsignarSede)
                    .addComponent(jB_AsignarResponsable))
                .addGap(35, 35, 35)
                .addComponent(jB_Resgistrar)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_ReservarSede)
                    .addComponent(jB_IntroducirRes)
                    .addComponent(jB_Inscribirse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jB_Salir)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_ReservarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ReservarSedeActionPerformed
        this.setVisible(false);
        reservarSede = new ReservarSede(administrador,this);
        reservarSede.setVisible(true);
    }//GEN-LAST:event_jB_ReservarSedeActionPerformed

    private void jB_HistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_HistorialActionPerformed
        this.setVisible(false);
        historial = new Historial(this);
        historial.setVisible(true);
    }//GEN-LAST:event_jB_HistorialActionPerformed

    private void jB_InscribirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_InscribirseActionPerformed
        this.setVisible(false);
        inscribirseTorneo = new InscribirseTorneo(administrador, this);
        inscribirseTorneo.setVisible(true);
    }//GEN-LAST:event_jB_InscribirseActionPerformed

    private void jB_IntroducirResActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_IntroducirResActionPerformed
        this.setVisible(false);
        resultado = new IntroducirResultado(administrador,this);
        resultado.setVisible(true);
    }//GEN-LAST:event_jB_IntroducirResActionPerformed

    private void jB_AsignarResponsableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AsignarResponsableActionPerformed
        this.setVisible(false);
        asignarResponsable = new AsignarResponsable(administrador,this);
        asignarResponsable.setVisible(true);
    }//GEN-LAST:event_jB_AsignarResponsableActionPerformed

    private void jB_AsignarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_AsignarSedeActionPerformed
        this.setVisible(false);
        asignarSede = new AsignarSede(administrador, this);
        asignarSede.setVisible(true);
    }//GEN-LAST:event_jB_AsignarSedeActionPerformed

    private void jB_ResgistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ResgistrarActionPerformed
        registrar = new Registrar(administrador,this);
        this.setVisible(false);
        registrar.setVisible(true);
    }//GEN-LAST:event_jB_ResgistrarActionPerformed

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        paganterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_SalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_AsignarResponsable;
    private javax.swing.JButton jB_AsignarSede;
    private javax.swing.JButton jB_Historial;
    private javax.swing.JButton jB_Inscribirse;
    private javax.swing.JButton jB_IntroducirRes;
    private javax.swing.JButton jB_ReservarSede;
    private javax.swing.JButton jB_Resgistrar;
    private javax.swing.JButton jB_Salir;
    private javax.swing.JLabel jL_Admin;
    private javax.swing.JLabel jL_Nombre;
    private javax.swing.JTextField jTF_nombre;
    // End of variables declaration//GEN-END:variables
}

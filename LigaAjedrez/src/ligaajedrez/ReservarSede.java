/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import Fachada.Fachada;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class ReservarSede extends javax.swing.JFrame {
    private Fachada usuario;
    private JFrame pganterior;
    
    /**
     * Creates new form ReservarSede
     */    
    
    public ReservarSede(Fachada user,JFrame anterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.usuario = user;
        this.pganterior = anterior;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jL_Horarios = new javax.swing.JList<>();
        jB_Buscar = new javax.swing.JButton();
        jB_Reservar = new javax.swing.JButton();
        jB_Salir = new javax.swing.JButton();
        jL_ReservarSede = new javax.swing.JLabel();
        jL_Entrenador = new javax.swing.JLabel();
        jTF_DNIJugador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jDC_fecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(jL_Horarios);

        jB_Buscar.setText("Buscar");
        jB_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BuscarActionPerformed(evt);
            }
        });

        jB_Reservar.setText("Reservar");
        jB_Reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ReservarActionPerformed(evt);
            }
        });

        jB_Salir.setText("Salir");
        jB_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_SalirActionPerformed(evt);
            }
        });

        jL_ReservarSede.setText("RESERVAR SEDE");

        jL_Entrenador.setText("DNI jugador");

        jLabel1.setText("Introduce dia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jL_ReservarSede))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jL_Entrenador))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTF_DNIJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jB_Buscar))
                            .addComponent(jDC_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(63, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jB_Salir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jB_Reservar)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_ReservarSede)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDC_fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Buscar)
                    .addComponent(jTF_DNIJugador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Entrenador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Reservar)
                    .addComponent(jB_Salir))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_SalirActionPerformed
        pganterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jB_SalirActionPerformed

    private void jB_ReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ReservarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Sede Reservada:");
    }//GEN-LAST:event_jB_ReservarActionPerformed

    private void jB_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BuscarActionPerformed
        String dni = jTF_DNIJugador.getText();
        
        if(!usuario.comprobarDNI(dni)){
            JOptionPane.showMessageDialog(null, "DNI no valido", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            ArrayList horasDisponibles = usuario.buscarHorasDisponibles(dni,jDC_fecha.getCalendar().getTime());
            
            jL_Horarios.clearSelection();

            DefaultListModel lista = new DefaultListModel();
            if(!horasDisponibles.isEmpty()){
                for(int i = 0; i < horasDisponibles.size(); i++){
                    lista.addElement(horasDisponibles.get(i));                   
                }
            }                
            else{
                JOptionPane.showMessageDialog(null,"No hay horarios disponibles para este jugador", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            
            jL_Horarios.setModel(lista);
        }
            
    }//GEN-LAST:event_jB_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Buscar;
    private javax.swing.JButton jB_Reservar;
    private javax.swing.JButton jB_Salir;
    private com.toedter.calendar.JDateChooser jDC_fecha;
    private javax.swing.JLabel jL_Entrenador;
    private javax.swing.JList<String> jL_Horarios;
    private javax.swing.JLabel jL_ReservarSede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTF_DNIJugador;
    // End of variables declaration//GEN-END:variables
}

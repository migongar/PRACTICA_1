/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import Fachada.Fachada;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class Login extends javax.swing.JFrame {
    private Administracion administracion;
    private Jugadores jugadores;
    private RegistroJugador registrar;
    private Fachada fachada;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        fachada = new Fachada();    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jL_User = new javax.swing.JLabel();
        jL_Password = new javax.swing.JLabel();
        jTF_User = new javax.swing.JTextField();
        jB_Entrar = new javax.swing.JButton();
        jL_Inicio = new javax.swing.JLabel();
        jB_Resgistrar = new javax.swing.JButton();
        jPF_Password = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jL_User.setText("User");

        jL_Password.setText("Password");

        jTF_User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_UserActionPerformed(evt);
            }
        });

        jB_Entrar.setText("Entrar");
        jB_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_EntrarActionPerformed(evt);
            }
        });

        jL_Inicio.setText("INICIO");

        jB_Resgistrar.setText("Registrar");
        jB_Resgistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_ResgistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jB_Resgistrar)
                        .addGap(82, 82, 82)
                        .addComponent(jB_Entrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jL_User)
                            .addComponent(jL_Password))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jL_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTF_User, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jPF_Password))))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jL_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_User)
                    .addComponent(jTF_User, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Password)
                    .addComponent(jPF_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_Resgistrar)
                    .addComponent(jB_Entrar))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_UserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_UserActionPerformed

    private void jB_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_EntrarActionPerformed
        fachada.setUsuario(fachada.buscarUsuario(jTF_User.getText()));
        
        if(fachada.getUsuario() != null){
            String contrasenya = new String(jPF_Password.getPassword());
            if(contrasenya.equals(fachada.getUsuario().getPassword())){     
                switch (fachada.getUsuario().getTipo()) {
                    case 1:
                        this.setVisible(false);
                        fachada.setAdministrador(fachada.getUsuario());
                        administracion = new Administracion(fachada, this);
                        administracion.setVisible(true);
                        break;
                    case 0:
                        this.setVisible(false);
                        jugadores = new Jugadores(fachada, this);
                        jugadores.setVisible(true);
                        break;
                }
            }
            else
                JOptionPane.showMessageDialog(null, "El password no es correcto", "AVISO",JOptionPane.WARNING_MESSAGE);
            }
        else
            JOptionPane.showMessageDialog(null, "El usuario no existe", "AVISO",JOptionPane.WARNING_MESSAGE);   
    }//GEN-LAST:event_jB_EntrarActionPerformed

    private void jB_ResgistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_ResgistrarActionPerformed
        //usuario = new Usuario();
        registrar = new RegistroJugador(fachada, this);        
        this.setVisible(false);
        registrar.setVisible(true);
    }//GEN-LAST:event_jB_ResgistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Entrar;
    private javax.swing.JButton jB_Resgistrar;
    private javax.swing.JLabel jL_Inicio;
    private javax.swing.JLabel jL_Password;
    private javax.swing.JLabel jL_User;
    private javax.swing.JPasswordField jPF_Password;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTF_User;
    // End of variables declaration//GEN-END:variables
}

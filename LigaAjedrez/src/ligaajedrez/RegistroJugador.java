/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligaajedrez;

import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Usuario;

/**
 *
 * @author angel
 */
public class RegistroJugador extends javax.swing.JFrame {
    private JFrame login;
    private Usuario usuario;
    /**
     * Creates new form RegistroJugador
     * @param user
     */
    public RegistroJugador(Usuario user, JFrame login) {
        initComponents();        
        this.setLocationRelativeTo(null);
        this.usuario = user;
        this.login = login;
        ArrayList lista = new ArrayList();
        lista = usuario.getFederaciones();
        for(int i = 0; i<lista.size();i++){
            jCB_federacion.addItem(lista.get(i).toString());
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

        jL_Nombre = new javax.swing.JLabel();
        jTF_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jL_club = new javax.swing.JLabel();
        jCB_federacion = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jL_Registro = new javax.swing.JLabel();
        jL_Cuota = new javax.swing.JLabel();
        jTF_Dinero = new javax.swing.JTextField();
        jL_Mes = new javax.swing.JLabel();
        jL_Dni = new javax.swing.JLabel();
        jTF_DNI = new javax.swing.JTextField();
        jL_Apellidos = new javax.swing.JLabel();
        jTF_Apellidos = new javax.swing.JTextField();
        jDC_fnac = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jL_Club = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jB_Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jL_Nombre.setText("Nombre");

        jLabel2.setText("fecha nacimiento");

        jL_club.setText("Club");

        jCB_federacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCB_federacionActionPerformed(evt);
            }
        });

        jButton1.setText("registrarse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("salir");

        jL_Registro.setText("REGISTRO");

        jL_Cuota.setText("Cuota a pagar:");

        jL_Mes.setText("/ mes");

        jL_Dni.setText("DNI");

        jL_Apellidos.setText("Apellidos");

        jScrollPane1.setViewportView(jL_Club);

        jLabel1.setText("Fedederacion:");

        jB_Buscar.setText("Buscar club");
        jB_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jL_Nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTF_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jL_Apellidos)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTF_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jL_Cuota)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTF_Dinero, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jL_Mes))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jL_Dni)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTF_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDC_fnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jL_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCB_federacion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jB_Buscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jL_club)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_Registro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jL_Nombre)
                    .addComponent(jTF_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jL_Apellidos)
                    .addComponent(jTF_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jL_Dni)
                        .addComponent(jTF_DNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDC_fnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jB_Buscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jL_club))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTF_Dinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jL_Mes)
                            .addComponent(jL_Cuota))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCB_federacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dni, nom, ape, club;
        int edad;
        Calendar hoy = Calendar.getInstance();

        int diff_year = hoy.get(Calendar.YEAR) -  jDC_fnac.getCalendar().get(Calendar.YEAR);
        int diff_month = hoy.get(Calendar.MONTH) - jDC_fnac.getCalendar().get(Calendar.MONTH);
        int diff_day = hoy.get(Calendar.DAY_OF_MONTH) - jDC_fnac.getCalendar().get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if (diff_month < 0 || (diff_month == 0 && diff_day < 0)) {
            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
        }
        
        edad = diff_year;           
        
        dni = jTF_DNI.getText();     
        nom = jTF_Nombre.getText();
        ape = jTF_Apellidos.getText();
        club = jCB_federacion.getSelectedItem().toString();
        
        if(!usuario.registrarJugador(nom, ape, dni, club, edad)){
            JOptionPane.showMessageDialog(null, "Error al registrar el jugador", "ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Registrado correctamente.\nNombre de Usuario: " + usuario.getLogin() + "\nContaraseña: " + usuario.getPassword(), "AVISO",JOptionPane.INFORMATION_MESSAGE);
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCB_federacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCB_federacionActionPerformed
                    
    }//GEN-LAST:event_jCB_federacionActionPerformed

    private void jB_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_BuscarActionPerformed
        ArrayList listaClubes = new ArrayList();
        
        listaClubes = usuario.buscarClubes(jCB_federacion.getSelectedItem().toString());
        
        jL_Club.clearSelection();

        DefaultListModel lista = new DefaultListModel();
        if(!listaClubes.isEmpty()){
            for(int i = 0; i < listaClubes.size(); i++){
                lista.addElement(listaClubes.get(i));                   
            }
        }                
        else{
            JOptionPane.showMessageDialog(null,"No hay clubes disponibles para esta federacion", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        jL_Club.setModel(lista);
    }//GEN-LAST:event_jB_BuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_Buscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jCB_federacion;
    private com.toedter.calendar.JDateChooser jDC_fnac;
    private javax.swing.JLabel jL_Apellidos;
    private javax.swing.JList<String> jL_Club;
    private javax.swing.JLabel jL_Cuota;
    private javax.swing.JLabel jL_Dni;
    private javax.swing.JLabel jL_Mes;
    private javax.swing.JLabel jL_Nombre;
    private javax.swing.JLabel jL_Registro;
    private javax.swing.JLabel jL_club;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTF_Apellidos;
    private javax.swing.JTextField jTF_DNI;
    private javax.swing.JTextField jTF_Dinero;
    private javax.swing.JTextField jTF_Nombre;
    // End of variables declaration//GEN-END:variables
}

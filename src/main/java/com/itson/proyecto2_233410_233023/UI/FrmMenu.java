/**
 * Clase FrmMenu.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.UI;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.implementaciones.ConexionBD;
import com.itson.proyecto2_233410_233023.implementaciones.PersonasDAO;
import com.itson.proyecto2_233410_233023.interfaces.IConexionBD;
import com.itson.proyecto2_233410_233023.interfaces.IPersonasDAO;
import com.itson.proyecto2_233410_233023.interfaces.IVehiculosDAO;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel x Kim
 */
public class FrmMenu extends javax.swing.JFrame {
    /**
     * Este atributo representa la DAO de Personas.
     */
    IPersonasDAO personasDAO;
    IVehiculosDAO vehiculosDAO;

    /**
     * Método constructor que inicializa sus atributos al valor de los parámetros enviados.
     */
    public FrmMenu(IPersonasDAO personasDAO,IVehiculosDAO vehiculosDAO) {
        this.personasDAO=personasDAO;
        this.vehiculosDAO=vehiculosDAO;
        initComponents();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondoMenu = new javax.swing.JPanel();
        jToolBarMenu = new javax.swing.JToolBar();
        btnTramitarLicencia = new javax.swing.JButton();
        btnTramitarPlaca = new javax.swing.JButton();
        btnInsercion = new javax.swing.JButton();
        btnHistorial1 = new javax.swing.JButton();
        jPanelBarra = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lblAutoPapeleo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autopapeleo Menú ");
        setBackground(new java.awt.Color(233, 219, 253));
        setName("frmMenu"); // NOI18N
        setResizable(false);

        jPanelFondoMenu.setBackground(new java.awt.Color(233, 219, 253));
        jPanelFondoMenu.setForeground(new java.awt.Color(233, 219, 253));
        jPanelFondoMenu.setPreferredSize(new java.awt.Dimension(600, 400));

        jToolBarMenu.setBackground(new java.awt.Color(233, 219, 253));
        jToolBarMenu.setBorder(null);
        jToolBarMenu.setForeground(new java.awt.Color(233, 219, 253));
        jToolBarMenu.setRollover(true);

        btnTramitarLicencia.setBackground(new java.awt.Color(233, 219, 253));
        btnTramitarLicencia.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnTramitarLicencia.setForeground(new java.awt.Color(129, 0, 127));
        btnTramitarLicencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursosImagenes/tramiteLicenciaIcon.png"))); // NOI18N
        btnTramitarLicencia.setText("Tramitar Licencia");
        btnTramitarLicencia.setBorder(null);
        btnTramitarLicencia.setFocusable(false);
        btnTramitarLicencia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTramitarLicencia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTramitarLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTramitarLicenciaActionPerformed(evt);
            }
        });

        btnTramitarPlaca.setBackground(new java.awt.Color(233, 219, 253));
        btnTramitarPlaca.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnTramitarPlaca.setForeground(new java.awt.Color(129, 0, 127));
        btnTramitarPlaca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursosImagenes/tramitePlacasIcon.png"))); // NOI18N
        btnTramitarPlaca.setText("Tramitar Placas");
        btnTramitarPlaca.setBorder(null);
        btnTramitarPlaca.setFocusable(false);
        btnTramitarPlaca.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTramitarPlaca.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTramitarPlaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTramitarPlacaActionPerformed(evt);
            }
        });

        btnInsercion.setBackground(new java.awt.Color(233, 219, 253));
        btnInsercion.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnInsercion.setForeground(new java.awt.Color(129, 0, 127));
        btnInsercion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursosImagenes/insercionMasivaIcon.png"))); // NOI18N
        btnInsercion.setBorder(null);
        btnInsercion.setBorderPainted(false);
        btnInsercion.setContentAreaFilled(false);
        btnInsercion.setFocusable(false);
        btnInsercion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInsercion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInsercion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsercionActionPerformed(evt);
            }
        });

        btnHistorial1.setBackground(new java.awt.Color(233, 219, 253));
        btnHistorial1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnHistorial1.setForeground(new java.awt.Color(129, 0, 127));
        btnHistorial1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursosImagenes/historialIcon.png"))); // NOI18N
        btnHistorial1.setText("Historial");
        btnHistorial1.setBorder(null);
        btnHistorial1.setBorderPainted(false);
        btnHistorial1.setFocusable(false);
        btnHistorial1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHistorial1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHistorial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorial1ActionPerformed(evt);
            }
        });

        jPanelBarra.setBackground(new java.awt.Color(129, 0, 127));
        jPanelBarra.setForeground(new java.awt.Color(129, 0, 127));
        jPanelBarra.setToolTipText("");

        btnSalir.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(124, 63, 163));
        btnSalir.setText("Salir");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblAutoPapeleo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblAutoPapeleo.setForeground(new java.awt.Color(255, 255, 255));
        lblAutoPapeleo.setText("AutoPapeleo");

        javax.swing.GroupLayout jPanelBarraLayout = new javax.swing.GroupLayout(jPanelBarra);
        jPanelBarra.setLayout(jPanelBarraLayout);
        jPanelBarraLayout.setHorizontalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAutoPapeleo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(lblAutoPapeleo))
        );

        javax.swing.GroupLayout jPanelFondoMenuLayout = new javax.swing.GroupLayout(jPanelFondoMenu);
        jPanelFondoMenu.setLayout(jPanelFondoMenuLayout);
        jPanelFondoMenuLayout.setHorizontalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnInsercion))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHistorial1)
                        .addGap(239, 239, 239))
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addComponent(btnTramitarPlaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(btnTramitarLicencia)
                        .addGap(68, 68, 68))))
        );
        jPanelFondoMenuLayout.setVerticalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTramitarPlaca)
                    .addComponent(btnTramitarLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(btnHistorial1)
                .addGap(18, 18, 18)
                .addComponent(btnInsercion)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método que genera un mensaje de confirmación a través de un JOptionPane.
     * @param mensaje Mensaje a enviar.
     * @param titulo Titulo del mensaje.
     */
    private void mensajeConfirmacion(String mensaje, String titulo) {
        new JOptionPane().showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void btnTramitarLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitarLicenciaActionPerformed
       FrmSeleccionarPersona frmsp = new FrmSeleccionarPersona(personasDAO,vehiculosDAO,true);
       this.setVisible(false);
       frmsp.setVisible(true);

    }//GEN-LAST:event_btnTramitarLicenciaActionPerformed

    private void btnTramitarPlacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTramitarPlacaActionPerformed
     FrmSeleccionarPersona frmsp = new FrmSeleccionarPersona(personasDAO,vehiculosDAO,false);
       this.setVisible(false);
       frmsp.setVisible(true);
    }//GEN-LAST:event_btnTramitarPlacaActionPerformed

    private void btnInsercionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsercionActionPerformed
        if(personasDAO.insercionMasivaPersonas()){
             mensajeConfirmacion("Registro de personas realizado correctamente", "Confirmación");
        }
    }//GEN-LAST:event_btnInsercionActionPerformed

    private void btnHistorial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorial1ActionPerformed
        FrmHistorial frmh = new FrmHistorial();
        this.setVisible(false);
        frmh.setVisible(true);
    }//GEN-LAST:event_btnHistorial1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHistorial1;
    private javax.swing.JButton btnInsercion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTramitarLicencia;
    private javax.swing.JButton btnTramitarPlaca;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelFondoMenu;
    private javax.swing.JToolBar jToolBarMenu;
    private javax.swing.JLabel lblAutoPapeleo;
    // End of variables declaration//GEN-END:variables
}

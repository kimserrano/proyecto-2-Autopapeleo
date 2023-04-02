/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.itson.proyecto2_233410_233023.UI;

/**
 *
 * @author kim
 */
public class FrmSeleccionarPersona extends javax.swing.JFrame {

    /**
     * Creates new form FrmSeleccionarPersona
     */
    public FrmSeleccionarPersona() {
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

        jPanelFondo = new javax.swing.JPanel();
        jPanelBarra = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        lblAutoPapeleo = new javax.swing.JLabel();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jRadioBtnNombre = new javax.swing.JRadioButton();
        jRadioBtnRFC = new javax.swing.JRadioButton();
        jRadioBtnID = new javax.swing.JRadioButton();
        jScrollPaneTabla = new javax.swing.JScrollPane();
        jTablePersonas = new javax.swing.JTable();
        jLblIndicacion = new javax.swing.JLabel();
        jLblId = new javax.swing.JLabel();
        jTextFieldBuscarId = new javax.swing.JTextField();
        btnSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccionar persona");
        setPreferredSize(new java.awt.Dimension(659, 604));

        jPanelFondo.setBackground(new java.awt.Color(233, 219, 253));
        jPanelFondo.setForeground(new java.awt.Color(233, 219, 253));

        jPanelBarra.setBackground(new java.awt.Color(129, 0, 127));
        jPanelBarra.setForeground(new java.awt.Color(129, 0, 127));
        jPanelBarra.setToolTipText("");

        btnSalir.setBackground(new java.awt.Color(255, 255, 255));
        btnSalir.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(124, 63, 163));
        btnSalir.setText("Volver");
        btnSalir.setBorder(null);
        btnSalir.setBorderPainted(false);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblAutoPapeleo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblAutoPapeleo.setForeground(new java.awt.Color(255, 255, 255));
        lblAutoPapeleo.setText("Selecciona Persona");

        javax.swing.GroupLayout jPanelBarraLayout = new javax.swing.GroupLayout(jPanelBarra);
        jPanelBarra.setLayout(jPanelBarraLayout);
        jPanelBarraLayout.setHorizontalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraLayout.createSequentialGroup()
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAutoPapeleo)
                .addGap(0, 530, Short.MAX_VALUE))
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(lblAutoPapeleo))
        );

        jTextFieldBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldBusqueda.setFont(new java.awt.Font("Microsoft JhengHei", 2, 12)); // NOI18N
        jTextFieldBusqueda.setForeground(new java.awt.Color(124, 63, 163));
        jTextFieldBusqueda.setText("     Ingresa persona...");
        jTextFieldBusqueda.setToolTipText("");
        jTextFieldBusqueda.setBorder(null);
        jTextFieldBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBusquedaActionPerformed(evt);
            }
        });

        jRadioBtnNombre.setBackground(new java.awt.Color(233, 219, 253));
        jRadioBtnNombre.setForeground(new java.awt.Color(124, 63, 163));
        jRadioBtnNombre.setText("Nombre");
        jRadioBtnNombre.setBorder(null);

        jRadioBtnRFC.setBackground(new java.awt.Color(233, 219, 253));
        jRadioBtnRFC.setForeground(new java.awt.Color(124, 63, 163));
        jRadioBtnRFC.setText("RFC");
        jRadioBtnRFC.setBorder(null);

        jRadioBtnID.setBackground(new java.awt.Color(233, 219, 253));
        jRadioBtnID.setForeground(new java.awt.Color(124, 63, 163));
        jRadioBtnID.setText("ID");
        jRadioBtnID.setBorder(null);

        jTablePersonas.setBackground(new java.awt.Color(255, 255, 255));
        jTablePersonas.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jTablePersonas.setForeground(new java.awt.Color(129, 0, 127));
        jTablePersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "RFC", "Fecha de Nacimiento", "Discapacitado", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTablePersonas.setGridColor(new java.awt.Color(129, 0, 127));
        jTablePersonas.setSelectionBackground(new java.awt.Color(233, 219, 253));
        jTablePersonas.setSelectionForeground(new java.awt.Color(129, 0, 127));
        jScrollPaneTabla.setViewportView(jTablePersonas);

        jLblIndicacion.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jLblIndicacion.setForeground(new java.awt.Color(129, 0, 127));
        jLblIndicacion.setText("(Id de la persona a la cual se quiere seleccionar)");

        jLblId.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLblId.setForeground(new java.awt.Color(129, 0, 127));
        jLblId.setText("ID:");

        jTextFieldBuscarId.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldBuscarId.setFont(new java.awt.Font("Microsoft JhengHei", 2, 12)); // NOI18N
        jTextFieldBuscarId.setForeground(new java.awt.Color(124, 63, 163));
        jTextFieldBuscarId.setToolTipText("");
        jTextFieldBuscarId.setBorder(null);
        jTextFieldBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarIdActionPerformed(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(255, 255, 255));
        btnSeleccionar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(129, 0, 127));
        btnSeleccionar.setText("Seleccionar persona");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFondoLayout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLblIndicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelFondoLayout.createSequentialGroup()
                                    .addComponent(jLblId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(38, 38, 38)))))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jRadioBtnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioBtnRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jRadioBtnID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioBtnRFC)
                            .addComponent(jRadioBtnNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBtnID))
                    .addComponent(jTextFieldBusqueda))
                .addGap(28, 28, 28)
                .addComponent(jScrollPaneTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(jLblIndicacion)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblId)
                    .addComponent(jTextFieldBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void jTextFieldBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBusquedaActionPerformed

    private void jTextFieldBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarIdActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JLabel jLblId;
    private javax.swing.JLabel jLblIndicacion;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JRadioButton jRadioBtnID;
    private javax.swing.JRadioButton jRadioBtnNombre;
    private javax.swing.JRadioButton jRadioBtnRFC;
    private javax.swing.JScrollPane jScrollPaneTabla;
    private javax.swing.JTable jTablePersonas;
    private javax.swing.JTextField jTextFieldBuscarId;
    private javax.swing.JTextField jTextFieldBusqueda;
    private javax.swing.JLabel lblAutoPapeleo;
    // End of variables declaration//GEN-END:variables
}

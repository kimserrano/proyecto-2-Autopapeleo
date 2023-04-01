/*
FrmMenu.java creada el 31/03/2023.
*/
package com.itosn.proyecto2_233410_233023.UI;

/**
 *
 * @author Gabriel x Kim
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public FrmMenu() {
        initComponents();
        this.setSize(this.getWidth(), this.getHeight());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnFondo = new javax.swing.JPanel();
        jpnFondo2 = new javax.swing.JPanel();
        jpnFondo3 = new javax.swing.JPanel();
        lblSalir = new javax.swing.JLabel();
        lblTitulo1 = new javax.swing.JLabel();
        jpnFondo4 = new javax.swing.JPanel();
        lblInsercion = new javax.swing.JLabel();
        lblInsercion1 = new javax.swing.JLabel();
        lblTramitePlaca = new javax.swing.JLabel();
        lblTramiteLicencia = new javax.swing.JLabel();
        lblHistorial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnFondo.setBackground(new java.awt.Color(233, 219, 253));
        jpnFondo.setMaximumSize(new java.awt.Dimension(400, 260));
        jpnFondo.setPreferredSize(new java.awt.Dimension(400, 260));
        jpnFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpnFondo2.setBackground(new java.awt.Color(129, 0, 127));

        jpnFondo3.setBackground(new java.awt.Color(255, 255, 255));

        lblSalir.setBackground(new java.awt.Color(204, 102, 255));
        lblSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSalir.setForeground(new java.awt.Color(124, 63, 163));
        lblSalir.setText("< Salir");

        javax.swing.GroupLayout jpnFondo3Layout = new javax.swing.GroupLayout(jpnFondo3);
        jpnFondo3.setLayout(jpnFondo3Layout);
        jpnFondo3Layout.setHorizontalGroup(
            jpnFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFondo3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblSalir)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jpnFondo3Layout.setVerticalGroup(
            jpnFondo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFondo3Layout.createSequentialGroup()
                .addComponent(lblSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lblTitulo1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTitulo1.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo1.setText("AutoPapeleo");

        javax.swing.GroupLayout jpnFondo2Layout = new javax.swing.GroupLayout(jpnFondo2);
        jpnFondo2.setLayout(jpnFondo2Layout);
        jpnFondo2Layout.setHorizontalGroup(
            jpnFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFondo2Layout.createSequentialGroup()
                .addComponent(jpnFondo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitulo1)
                .addGap(0, 238, Short.MAX_VALUE))
        );
        jpnFondo2Layout.setVerticalGroup(
            jpnFondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnFondo2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo1)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jpnFondo.add(jpnFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 30));

        jpnFondo4.setBackground(new java.awt.Color(255, 255, 255));

        lblInsercion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblInsercion.setForeground(new java.awt.Color(124, 63, 163));
        lblInsercion.setText("Inserción");

        lblInsercion1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblInsercion1.setForeground(new java.awt.Color(124, 63, 163));
        lblInsercion1.setText("Masiva");

        javax.swing.GroupLayout jpnFondo4Layout = new javax.swing.GroupLayout(jpnFondo4);
        jpnFondo4.setLayout(jpnFondo4Layout);
        jpnFondo4Layout.setHorizontalGroup(
            jpnFondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFondo4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnFondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnFondo4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblInsercion1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblInsercion, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnFondo4Layout.setVerticalGroup(
            jpnFondo4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnFondo4Layout.createSequentialGroup()
                .addComponent(lblInsercion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInsercion1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpnFondo.add(jpnFondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 100, 40));

        lblTramitePlaca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTramitePlaca.setForeground(new java.awt.Color(124, 63, 163));
        lblTramitePlaca.setText("Tramitar placas");
        jpnFondo.add(lblTramitePlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        lblTramiteLicencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTramiteLicencia.setForeground(new java.awt.Color(124, 63, 163));
        lblTramiteLicencia.setText("Tramitar licencia");
        jpnFondo.add(lblTramiteLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, -1, -1));

        lblHistorial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblHistorial.setForeground(new java.awt.Color(124, 63, 163));
        lblHistorial.setText("Historial");
        jpnFondo.add(lblHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 349, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jpnFondo;
    private javax.swing.JPanel jpnFondo2;
    private javax.swing.JPanel jpnFondo3;
    private javax.swing.JPanel jpnFondo4;
    private javax.swing.JLabel lblHistorial;
    private javax.swing.JLabel lblInsercion;
    private javax.swing.JLabel lblInsercion1;
    private javax.swing.JLabel lblSalir;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTramiteLicencia;
    private javax.swing.JLabel lblTramitePlaca;
    // End of variables declaration//GEN-END:variables
}

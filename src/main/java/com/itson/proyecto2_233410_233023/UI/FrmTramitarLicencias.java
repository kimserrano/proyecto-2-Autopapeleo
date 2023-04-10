/**
 * Clase FrmTramitarLicencias.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.UI;

import com.itson.proyecto2_233410_233023.dominio.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel x Kim
 */
public class FrmTramitarLicencias extends javax.swing.JFrame {

    DefaultComboBoxModel<Anios> modeloComboBox = new DefaultComboBoxModel<>(Anios.values());
    IPersonasDAO personasDAO;
    IVehiculosDAO vehiculosDAO;
    Persona personaSeleccionada;
    ITramitesDAO tramitesDAO;
    IHistorialDAO historialDAO;
    Licencia licencia;
    Tramite verificacion;

    /**
     * Creates new form FrmTramitarLicencias
     */
    public FrmTramitarLicencias(IPersonasDAO personasDAO, IVehiculosDAO vehiculosDAO, Persona persona, ITramitesDAO tramitesDAO, IHistorialDAO historialDAO) {
        initComponents();
        cbxVigencia.setModel(modeloComboBox);
        this.personasDAO = personasDAO;
        this.historialDAO = historialDAO;
        this.vehiculosDAO = vehiculosDAO;
        this.tramitesDAO = tramitesDAO;
        this.personaSeleccionada = persona;
        lblNombrePersona.setText(persona.getNombre() + " " + persona.getApellidoPaterno());
        calculoVigencia();
    }

    public Licencia obtenerDatosLicencia() {
        Calendar fechaActual = Calendar.getInstance();
        int anio = fechaActual.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
        Calendar fechaExpedicion = new GregorianCalendar(anio, mes, dia);
        Anios vigencia = (Anios) cbxVigencia.getSelectedItem();
        float monto = Float.parseFloat(txtMonto.getText());
        Licencia licencia = new Licencia(monto, fechaExpedicion, vigencia, Estado.ACTIVA);
        return licencia;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondoMenu = new javax.swing.JPanel();
        jToolBarMenu = new javax.swing.JToolBar();
        jPanelBarra = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        lblTramitarLicencia = new javax.swing.JLabel();
        lblNombrePersona = new javax.swing.JLabel();
        cbxVigencia = new javax.swing.JComboBox<>();
        lblVigencia = new javax.swing.JLabel();
        lblMonto = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        btnRealizarTramite = new javax.swing.JButton();

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

        jPanelBarra.setBackground(new java.awt.Color(129, 0, 127));
        jPanelBarra.setForeground(new java.awt.Color(129, 0, 127));
        jPanelBarra.setToolTipText("");

        btnVolver.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(124, 63, 163));
        btnVolver.setText("Volver");
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        lblTramitarLicencia.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblTramitarLicencia.setForeground(new java.awt.Color(255, 255, 255));
        lblTramitarLicencia.setText("Tramitar licencia");

        lblNombrePersona.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNombrePersona.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePersona.setText("Persona");

        javax.swing.GroupLayout jPanelBarraLayout = new javax.swing.GroupLayout(jPanelBarra);
        jPanelBarra.setLayout(jPanelBarraLayout);
        jPanelBarraLayout.setHorizontalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraLayout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTramitarLicencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(lblTramitarLicencia)
                .addComponent(lblNombrePersona))
        );

        cbxVigencia.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        cbxVigencia.setForeground(new java.awt.Color(124, 63, 163));
        cbxVigencia.setModel(modeloComboBox);
        cbxVigencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVigenciaActionPerformed(evt);
            }
        });

        lblVigencia.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblVigencia.setForeground(new java.awt.Color(124, 63, 163));
        lblVigencia.setText("Vigencia");

        lblMonto.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblMonto.setForeground(new java.awt.Color(124, 63, 163));
        lblMonto.setText("Monto a pagar");

        txtMonto.setEditable(false);
        txtMonto.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        btnRealizarTramite.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnRealizarTramite.setText("Realizar trámite");
        btnRealizarTramite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnRealizarTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarTramiteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoMenuLayout = new javax.swing.GroupLayout(jPanelFondoMenu);
        jPanelFondoMenu.setLayout(jPanelFondoMenuLayout);
        jPanelFondoMenuLayout.setHorizontalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoMenuLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblVigencia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMonto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoMenuLayout.createSequentialGroup()
                    .addContainerGap(346, Short.MAX_VALUE)
                    .addComponent(btnRealizarTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)))
        );
        jPanelFondoMenuLayout.setVerticalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxVigencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVigencia)
                    .addComponent(lblMonto)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(212, 212, 212))
            .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                    .addGap(115, 115, 115)
                    .addComponent(btnRealizarTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(139, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmMenu frmm = new FrmMenu(personasDAO, vehiculosDAO, tramitesDAO, historialDAO);
        this.setVisible(false);
        frmm.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    public TramiteLicencia revisarRegistro() {
        for (int i = 0; i < tramitesDAO.consultarTramitesLicencia().size(); i++) {
            if (tramitesDAO.consultarTramitesLicencia().get(i).getPersona().equals(personaSeleccionada)
                    && tramitesDAO.consultarTramitesLicencia().get(i).getLicencia().getEstado().equals(Estado.ACTIVA)) {
                TramiteLicencia tramiteLicencia = tramitesDAO.consultarTramitesLicencia().get(i);
                return tramiteLicencia;
            }
        }
        return null;
    }

    public void calculoVigencia() {
        if (revisarRegistro() != null) {
            Calendar fechaInicio = revisarRegistro().getFechaExpedicion();
            Anios anios = revisarRegistro().getLicencia().getAniosVigencia();
            int anioVigencia;
            if (anios == Anios.UNO) {
                fechaInicio.add(Calendar.YEAR, 1);
            } else if (anios == Anios.DOS) {
                fechaInicio.add(Calendar.YEAR, 2);
            } else {
                fechaInicio.add(Calendar.YEAR, 3);
            }
            Calendar fechaFin = Calendar.getInstance();
            if (tramitesDAO.consultarDiasTransurridosSP(fechaInicio, fechaFin) < 0) {
                mostrarMensaje(" Tu licencia actual vence en: "
                        + tramitesDAO.consultarDiasTransurridosSP(fechaInicio, fechaFin) * -1 + " días");

            }

        }
    }

    public void actualizacion() {
        if (licencia != null && revisarRegistro() != null) {
            try {
                tramitesDAO.actualizarLicencia(revisarRegistro().getLicencia(), revisarRegistro());
            } catch (Exception ex) {
                mostrarMensaje(ex.getMessage());
            }
        }
    }

    public Licencia registrarLicencia() {
        licencia = obtenerDatosLicencia();
        try {
            tramitesDAO.registrarLicencia(licencia);
            mostrarMensaje("Licencia registrada");
            return licencia;

        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
        return null;
    }

    public void costos() {
        if (cbxVigencia.getSelectedItem().equals(Anios.UNO)) {
            txtMonto.setText("600.00");
        } else if (cbxVigencia.getSelectedItem().equals(Anios.DOS)) {
            txtMonto.setText("900.00");
        } else if (cbxVigencia.getSelectedItem().equals(Anios.TRES)) {
            txtMonto.setText("1100.00");
        }
    }

    public void costosDiscapacidos() {
        if (cbxVigencia.getSelectedItem().equals(Anios.UNO)) {
            txtMonto.setText("200.00");
        } else if (cbxVigencia.getSelectedItem().equals(Anios.DOS)) {
            txtMonto.setText("500.00");
        } else if (cbxVigencia.getSelectedItem().equals(Anios.TRES)) {
            txtMonto.setText("700.00");
        }
    }

    public TramiteLicencia obtenerDatosTramite() {
        //Licencia licencia, Float costo, Calendar fechaExpedicion, Persona persona
        TramiteLicencia tramiteLicencia = new TramiteLicencia(licencia,
                licencia.getMonto(), licencia.getFechaExpedicion(),
                personaSeleccionada);
        return tramiteLicencia;
    }

    public TramiteLicencia registrarTramite() {
        TramiteLicencia tramiteLicencia = obtenerDatosTramite();
        try {
            tramitesDAO.tramitarLicencia(tramiteLicencia);
            return tramiteLicencia;
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
        return null;

    }

    private void cbxVigenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVigenciaActionPerformed
        if (personaSeleccionada.getDiscapacitado().equals(Discapacitado.SI)) {
            costosDiscapacidos();
        } else {
            costos();
        }
    }//GEN-LAST:event_cbxVigenciaActionPerformed

    private void btnRealizarTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarTramiteActionPerformed
        // TODO add your handling code here:
        registrarLicencia();
        actualizacion();
        registrarTramite();
        this.dispose();
        new FrmMenu(personasDAO, vehiculosDAO, tramitesDAO, historialDAO).setVisible(true);
    }//GEN-LAST:event_btnRealizarTramiteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRealizarTramite;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<Anios> cbxVigencia;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelFondoMenu;
    private javax.swing.JToolBar jToolBarMenu;
    private javax.swing.JLabel lblMonto;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblTramitarLicencia;
    private javax.swing.JLabel lblVigencia;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}

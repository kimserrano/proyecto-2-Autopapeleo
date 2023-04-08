/**
 * Clase FrmTramitarPlacas.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.UI;

import com.itson.proyecto2_233410_233023.dominio.*;
import com.itson.proyecto2_233410_233023.implementaciones.Validador;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel x Kim
 */
public class FrmTramitarPlacas extends javax.swing.JFrame {

    IPersonasDAO personasDAO;
    IVehiculosDAO vehiculosDAO;
    ITramitesDAO tramitesDAO;
    IHistorialDAO historialDAO;
    Persona personaSeleccionada;
    String vehiculo = "Nuevo";
    Validador validador = new Validador();

    /**
     * Creates new form FrmTramitarPlacas
     */
    public FrmTramitarPlacas(IPersonasDAO personasDAO, IVehiculosDAO vehiculosDAO, ITramitesDAO tramitesDAO, Persona persona, String numSerie, IHistorialDAO historialDAO) {
        initComponents();
        this.historialDAO = historialDAO;
        this.personasDAO = personasDAO;
        this.vehiculosDAO = vehiculosDAO;
        this.tramitesDAO = tramitesDAO;
        this.personaSeleccionada = persona;
        btnBuscar.setVisible(false);
        txtNumeroSerie.setText(numSerie);
        txtNumeroSerie.setEditable(false);
        btnBuscarRegistrado.setVisible(false);
        txtCosto.setText("1500.00");
        lblPlacasAnteriores.setVisible(false);
        txtPlacasAnteriores.setVisible(false);
        lblNombrePersona.setText(persona.getNombre() + " " + persona.getApellidoPaterno());
    }

    public void mostrarOpciones() {
        if (cbxVehiculo.getSelectedItem().toString().equals("Nuevo")) {

            btnRegistrar.setVisible(true);
            btnBuscar.setVisible(false);
            txtNumeroSerie.setEditable(false);
            btnBuscarRegistrado.setVisible(false);
            lblPlacasAnteriores.setVisible(false);
            txtPlacasAnteriores.setVisible(false);
            txtCosto.setText("1500.00");
        } else if (cbxVehiculo.getSelectedItem().toString().equals("Registrado sin historial")) {
            txtNumeroSerie.setEditable(true);
            btnRegistrar.setVisible(false);
            btnBuscarRegistrado.setVisible(true);
            lblPlacasAnteriores.setVisible(false);
            txtPlacasAnteriores.setVisible(false);
            txtCosto.setText("1500.00");
        } else {
            txtNumeroSerie.setEditable(false);
            btnBuscarRegistrado.setVisible(false);
            btnRegistrar.setVisible(false);
            btnBuscar.setVisible(true);
            txtPlacasAnteriores.setVisible(true);
            lblPlacasAnteriores.setVisible(true);
            txtCosto.setText("1000.00");
        }
    }

    public Placa obtenerDatos() {
        Calendar fechaActual = Calendar.getInstance();
        int anio = fechaActual.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DAY_OF_MONTH);
        Calendar fechaExpedicion = new GregorianCalendar(anio, mes, dia);
        String numeroAlfanumerico = txtNuevaPlaca.getText();
        Float costo = Float.parseFloat(txtCosto.getText());
        //Placa(String numeroAlfanumerico, Float costo, Estado estado, Calendar fechaEmisio
        Placa placa = new Placa(numeroAlfanumerico, costo, Estado.ACTIVA, fechaExpedicion);
        return placa;
    }

    public Placa validarDatos(Placa placa) {
        Vehiculo vehiculo;
        String numSerie = txtNumeroSerie.getText();
        try {
            validador.validaPlacas(placa.getNumeroAlfanumerico());
            validador.validaNumeroSerie(numSerie);
            if (txtNumeroSerie.isEditable()) {
                mostrarMensaje("Asegurese de buscar el auto.");
                return null;
            }
            vehiculo = vehiculosDAO.obtenerVehiculo(numSerie);
            placa.setVehiculo(vehiculo);
            return placa;
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
            return null;
        }
    }

    public void buscarVehiculoUsado() {
        String placas = txtPlacasAnteriores.getText();
        Vehiculo vehiculo;
        try {
            validador.validaPlacas(placas);
            vehiculo = vehiculosDAO.obtenerVehiculoUsado(placas);
            if (vehiculo != null) {
                txtNumeroSerie.setText(vehiculo.getNumeroSerie());
                mostrarMensaje("Vehiculo encontrado.");
            } else {
                mostrarMensaje("Vehiculo no encontrado");
            }
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    public void buscarVehiculoSinHistorial() {
        String numSerie = txtNumeroSerie.getText();
        Vehiculo vehiculo;
        try {
            if (validador.validaNumeroSerie(numSerie)) {
                vehiculo = vehiculosDAO.obtenerVehiculoSinHistorial(numSerie);
                if (vehiculo != null) {
                    mostrarMensaje("Vehiculo encontrado.");
                    txtNumeroSerie.setEditable(false);
                } else {
                    mostrarMensaje("Vehiculo no encontrado.");
                }
            }
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
    }

    public boolean realizarTramite() {
        Placa placa = obtenerDatos();
        if (validarDatos(placa) != null) {
            try {
                TramitePlaca tramite = new TramitePlaca(placa, placa.getCosto(), placa.getFechaEmision(), personaSeleccionada);
                tramitesDAO.tramitarPlaca(tramite);
                mostrarMensaje("Trámite realizado con éxito.");
                return true;
            } catch (Exception ex) {
                mostrarMensaje(ex.getMessage());
            }
        }
        return false;
    }

    public void regresarMenu() {
        FrmMenu frmm = new FrmMenu(personasDAO, vehiculosDAO, tramitesDAO, historialDAO);
        this.setVisible(false);
        frmm.setVisible(true);
    }

    public void formatoPlacaSerie(KeyEvent evt, JTextField txt) {
        String texto = txt.getText();
        char c = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(c) || c == '-') || texto.length() >= 7) {
            evt.consume();
        } else if (texto.length() == 3 && c != '-') {
            evt.consume();
        } else if (texto.length() == 4 && !Character.isDigit(c)) {
            evt.consume();
        } else if (texto.length() == 5 && !Character.isDigit(c)) {
            evt.consume();
        } else if (texto.length() == 6 && !Character.isDigit(c)) {
            evt.consume();
        }
    }

    /**
     * Método para mostrar un mensaje en un JOptionPane.
     *
     * @param msj Mensaje a mostrar.
     */
    private void mostrarMensaje(String msj) {
        JOptionPane.showMessageDialog(null, msj, "Info", JOptionPane.INFORMATION_MESSAGE);
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
        jpnBarra = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        lblTramitarPlacas = new javax.swing.JLabel();
        lblNombrePersona = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        cbxVehiculo = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        lblVehiculo1 = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblPlacasAnteriores = new javax.swing.JLabel();
        txtPlacasAnteriores = new javax.swing.JTextField();
        lblNuevaPlaca = new javax.swing.JLabel();
        txtNuevaPlaca = new javax.swing.JTextField();
        lblCosto = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jpnBotonTramite = new javax.swing.JPanel();
        btnRealizarTramite = new javax.swing.JButton();
        btnBuscarRegistrado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autopapeleo Menú ");
        setBackground(new java.awt.Color(233, 219, 253));
        setName("frmMenu"); // NOI18N
        setResizable(false);

        jPanelFondoMenu.setBackground(new java.awt.Color(233, 219, 253));
        jPanelFondoMenu.setForeground(new java.awt.Color(233, 219, 253));
        jPanelFondoMenu.setMaximumSize(new java.awt.Dimension(501, 326));
        jPanelFondoMenu.setMinimumSize(new java.awt.Dimension(501, 326));
        jPanelFondoMenu.setPreferredSize(new java.awt.Dimension(501, 326));

        jToolBarMenu.setBackground(new java.awt.Color(233, 219, 253));
        jToolBarMenu.setBorder(null);
        jToolBarMenu.setForeground(new java.awt.Color(233, 219, 253));
        jToolBarMenu.setRollover(true);

        jpnBarra.setBackground(new java.awt.Color(129, 0, 127));
        jpnBarra.setForeground(new java.awt.Color(129, 0, 127));
        jpnBarra.setToolTipText("");

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

        lblTramitarPlacas.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblTramitarPlacas.setForeground(new java.awt.Color(255, 255, 255));
        lblTramitarPlacas.setText("Tramitar placas");

        lblNombrePersona.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNombrePersona.setForeground(new java.awt.Color(255, 255, 255));
        lblNombrePersona.setText("Persona");

        javax.swing.GroupLayout jpnBarraLayout = new javax.swing.GroupLayout(jpnBarra);
        jpnBarra.setLayout(jpnBarraLayout);
        jpnBarraLayout.setHorizontalGroup(
            jpnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnBarraLayout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTramitarPlacas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNombrePersona, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnBarraLayout.setVerticalGroup(
            jpnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(lblTramitarPlacas)
                .addComponent(lblNombrePersona))
        );

        lblNumeroSerie.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(124, 63, 163));
        lblNumeroSerie.setText("Número de serie");

        cbxVehiculo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        cbxVehiculo.setForeground(new java.awt.Color(124, 63, 163));
        cbxVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nuevo", "Usado", "Registrado sin historial" }));
        cbxVehiculo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxVehiculoItemStateChanged(evt);
            }
        });
        cbxVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxVehiculoActionPerformed(evt);
            }
        });

        btnRegistrar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblVehiculo1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblVehiculo1.setForeground(new java.awt.Color(124, 63, 163));
        lblVehiculo1.setText("Vehiculo");

        txtNumeroSerie.setEditable(false);
        txtNumeroSerie.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtNumeroSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroSerieKeyTyped(evt);
            }
        });

        btnBuscar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblPlacasAnteriores.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblPlacasAnteriores.setForeground(new java.awt.Color(124, 63, 163));
        lblPlacasAnteriores.setText("Placas anteriores");

        txtPlacasAnteriores.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtPlacasAnteriores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlacasAnterioresKeyTyped(evt);
            }
        });

        lblNuevaPlaca.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNuevaPlaca.setForeground(new java.awt.Color(124, 63, 163));
        lblNuevaPlaca.setText("Nueva placa");

        txtNuevaPlaca.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtNuevaPlaca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevaPlacaKeyTyped(evt);
            }
        });

        lblCosto.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblCosto.setForeground(new java.awt.Color(124, 63, 163));
        lblCosto.setText("Costo");

        txtCosto.setEditable(false);
        txtCosto.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(129, 0, 127));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jpnBotonTramite.setBackground(new java.awt.Color(233, 219, 253));

        btnRealizarTramite.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnRealizarTramite.setText("Realizar trámite");
        btnRealizarTramite.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnRealizarTramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarTramiteActionPerformed(evt);
            }
        });

        btnBuscarRegistrado.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnBuscarRegistrado.setText("Buscar");
        btnBuscarRegistrado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnBuscarRegistrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRegistradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnBotonTramiteLayout = new javax.swing.GroupLayout(jpnBotonTramite);
        jpnBotonTramite.setLayout(jpnBotonTramiteLayout);
        jpnBotonTramiteLayout.setHorizontalGroup(
            jpnBotonTramiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotonTramiteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRealizarTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jpnBotonTramiteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnBuscarRegistrado, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnBotonTramiteLayout.setVerticalGroup(
            jpnBotonTramiteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBotonTramiteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBuscarRegistrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(34, 34, 34)
                .addComponent(btnRealizarTramite, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jPanelFondoMenuLayout = new javax.swing.GroupLayout(jPanelFondoMenu);
        jPanelFondoMenu.setLayout(jPanelFondoMenuLayout);
        jPanelFondoMenuLayout.setHorizontalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addComponent(lblPlacasAnteriores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPlacasAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCosto)
                    .addComponent(lblNuevaPlaca)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addComponent(lblNumeroSerie)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNuevaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpnBotonTramite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lblVehiculo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelFondoMenuLayout.setVerticalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addComponent(jpnBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVehiculo1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPlacasAnteriores)
                    .addComponent(txtPlacasAnteriores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNumeroSerie)
                            .addComponent(txtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNuevaPlaca)
                            .addComponent(txtNuevaPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCosto)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jpnBotonTramite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        regresarMenu();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRealizarTramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarTramiteActionPerformed
        if (realizarTramite()) {
            regresarMenu();
        }
    }//GEN-LAST:event_btnRealizarTramiteActionPerformed

    private void cbxVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxVehiculoActionPerformed
        mostrarOpciones();
    }//GEN-LAST:event_cbxVehiculoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        FrmRegistrarVehiculo frmrv = new FrmRegistrarVehiculo(personasDAO, vehiculosDAO, personaSeleccionada, tramitesDAO, historialDAO);
        this.setVisible(false);
        frmrv.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void txtPlacasAnterioresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlacasAnterioresKeyTyped
        formatoPlacaSerie(evt, txtPlacasAnteriores);
    }//GEN-LAST:event_txtPlacasAnterioresKeyTyped

    private void txtNuevaPlacaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaPlacaKeyTyped
        formatoPlacaSerie(evt, txtNuevaPlaca);
    }//GEN-LAST:event_txtNuevaPlacaKeyTyped

    private void cbxVehiculoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxVehiculoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.vehiculo = (String) this.cbxVehiculo.getSelectedItem();
        }
    }//GEN-LAST:event_cbxVehiculoItemStateChanged

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarVehiculoUsado();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarRegistradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRegistradoActionPerformed
        buscarVehiculoSinHistorial();
    }//GEN-LAST:event_btnBuscarRegistradoActionPerformed

    private void txtNumeroSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroSerieKeyTyped
        formatoPlacaSerie(evt, txtNumeroSerie);
    }//GEN-LAST:event_txtNumeroSerieKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarRegistrado;
    private javax.swing.JButton btnRealizarTramite;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxVehiculo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFondoMenu;
    private javax.swing.JToolBar jToolBarMenu;
    private javax.swing.JPanel jpnBarra;
    private javax.swing.JPanel jpnBotonTramite;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblNuevaPlaca;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblPlacasAnteriores;
    private javax.swing.JLabel lblTramitarPlacas;
    private javax.swing.JLabel lblVehiculo1;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNuevaPlaca;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JTextField txtPlacasAnteriores;
    // End of variables declaration//GEN-END:variables
}

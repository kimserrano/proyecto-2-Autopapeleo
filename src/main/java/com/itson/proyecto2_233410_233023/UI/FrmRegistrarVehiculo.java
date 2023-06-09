/**
 * Clase RegistrarVehiculo.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.UI;

import com.itson.proyecto2_233410_233023.dominio.*;
import com.itson.proyecto2_233410_233023.implementaciones.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.awt.event.ItemEvent;

import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel x Kim
 */
public class FrmRegistrarVehiculo extends javax.swing.JFrame {

    /**
     * Atributo que representa la DAO de personas.
     */
    IPersonasDAO personasDAO;
    /**
     * Atributo que representa la DAO de vehículos.
     */
    IVehiculosDAO vehiculosDAO;
    /**
     * Atributo que representa la DAO de trámites.
     */
    ITramitesDAO tramitesDAO;
    /**
     * Atributo que representa a la persona seleccionada.
     */
    Persona personaSeleccionada;
    /**
     * Atributo que represente al validador.
     */
    Validador validador = new Validador();
    /**
     * Atributo que representa el tipo del automovil.
     */
    String tipo = "Automovil";
    /**
     * Atributo que representa el número de serie.
     */
    String numSerie = "";

    /**
     * Constructor por defecto que inicializa sus atributos al valor de los
     * parámetros enviados.
     *
     * @param personasDAO Atributo que ayuda a utilizar aquellos métodos para la
     * búsqueda de personas.
     * @param vehiculosDAO Atributo que ayuda a utilizar aquellos métodos para
     * la búsqueda de vehículos.
     * @param persona Persona seleccionada anteriormente.
     * @param tramitesDAO Atributo que ayuda a utilizar aquellos métodos para
     * consultar los trámites realizados por una persona.
     */
    public FrmRegistrarVehiculo(IPersonasDAO personasDAO, IVehiculosDAO vehiculosDAO, Persona persona, ITramitesDAO tramitesDAO) {
        initComponents();
        this.personasDAO = personasDAO;
        this.vehiculosDAO = vehiculosDAO;
        this.tramitesDAO = tramitesDAO;
        this.personaSeleccionada = persona;
        lblNombrePersona.setText(personaSeleccionada.getNombre() + " " + personaSeleccionada.getApellidoPaterno());

    }

    /**
     * Método para validar un vehiculo.
     *
     * @param vehiculo Vehiculo a validar.
     * @return Valor booleano.
     */
    public Boolean validarDatos(Vehiculo vehiculo) {
        try {
            validador.validaNumeroSerie(vehiculo.getNumeroSerie());
            validador.validaTexto(vehiculo.getMarca(), "Marca");
            validador.validaTexto(vehiculo.getLinea(), "Linea");
            validador.validaTexto(vehiculo.getColor(), "Color");
            validador.validaModelo(vehiculo.getModelo());
            return true;
        } catch (PersistenciaException ex) {
            mostrarMensaje(ex.getMessage());
            return false;
        }
    }

    /**
     * Método para obtener los datos de los textField del frame.
     *
     * @return Vehiculo con los datos obtenidos.
     */
    public Vehiculo obtenerDatos() {
        Vehiculo vehiculo = null;
        String numeroSerie = txtNumeroSerie.getText();
        String marca = txtMarca.getText();
        String linea = txtLinea.getText();
        String color = txtColor.getText();
        String modelo = txtModelo.getText();
        if (tipo.equals("Automovil")) {
            vehiculo = new Automovil(numeroSerie, marca, linea, color, modelo, personaSeleccionada);
        }
        return vehiculo;

    }

    /**
     * Método para validar un número de serie y saber si hay algún vehiculo con
     * el mismo número de serie.
     *
     * @param vehiculo Vehiculo a validar.
     * @return Valor booleano.
     */
    public boolean validarNumSerieDuplicado(Vehiculo vehiculo) {
        try {
            Vehiculo vehiculoObtenido = vehiculosDAO.obtenerVehiculo(vehiculo.getNumeroSerie());
            if (vehiculoObtenido != null) {
                if (vehiculo.getNumeroSerie().equalsIgnoreCase(vehiculoObtenido.getNumeroSerie())) {
                    mostrarMensaje("Ya hay un vehículo con ese número de serie.");
                    return false;
                }
            } else {
                return true;
            }
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
        return false;
    }

    /**
     * Método para registrar un vehículo si es validad correctamente.
     *
     * @return Valor booleano.
     */
    public boolean registrarVehiculo() {
        Vehiculo vehiculo = obtenerDatos();
        try {
            if (validarDatos(vehiculo) && validarNumSerieDuplicado(vehiculo)) {
                vehiculosDAO.registrarVehiculo(vehiculo);
                numSerie = vehiculo.getNumeroSerie();
                mostrarMensaje("Vehiculo registrado");
                return true;
            }
        } catch (Exception ex) {
            mostrarMensaje(ex.getMessage());
        }
        return false;
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
        jPanelBarra = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        txtRegistrar = new javax.swing.JLabel();
        lblNombrePersona = new javax.swing.JLabel();
        lblNumeroSerie = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        lblMarca = new javax.swing.JLabel();
        lblNuevaPlaca = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        lblColor1 = new javax.swing.JLabel();
        lblNumeroSerie1 = new javax.swing.JLabel();
        txtNumeroSerie = new javax.swing.JTextField();
        txtLinea = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        lblColor2 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        lblNumeroSerie2 = new javax.swing.JLabel();
        lblNumeroSerie3 = new javax.swing.JLabel();

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

        txtRegistrar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        txtRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        txtRegistrar.setText("Registrar Vehículo");

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
                .addComponent(txtRegistrar)
                .addGap(18, 18, 18)
                .addComponent(lblNombrePersona)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(txtRegistrar)
                .addComponent(lblNombrePersona))
        );

        lblNumeroSerie.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNumeroSerie.setForeground(new java.awt.Color(124, 63, 163));
        lblNumeroSerie.setText("Número de ");

        txtMarca.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMarcaKeyTyped(evt);
            }
        });

        lblMarca.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblMarca.setForeground(new java.awt.Color(124, 63, 163));
        lblMarca.setText("Marca");

        lblNuevaPlaca.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNuevaPlaca.setForeground(new java.awt.Color(124, 63, 163));
        lblNuevaPlaca.setText("Linea");

        lblColor.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblColor.setForeground(new java.awt.Color(124, 63, 163));
        lblColor.setText("Color");

        btnRegistrar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        lblColor1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblColor1.setForeground(new java.awt.Color(124, 63, 163));
        lblColor1.setText("Modelo");

        lblNumeroSerie1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblNumeroSerie1.setForeground(new java.awt.Color(124, 63, 163));
        lblNumeroSerie1.setText("serie");

        txtNumeroSerie.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtNumeroSerie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumeroSerieKeyTyped(evt);
            }
        });

        txtLinea.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLineaKeyTyped(evt);
            }
        });

        txtModelo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });

        txtColor.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        txtColor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtColorKeyTyped(evt);
            }
        });

        lblColor2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblColor2.setForeground(new java.awt.Color(124, 63, 163));
        lblColor2.setText("Tipo");

        cbxTipo.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automovil" }));
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        lblNumeroSerie2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 10)); // NOI18N
        lblNumeroSerie2.setForeground(new java.awt.Color(124, 63, 163));
        lblNumeroSerie2.setText("Formato (AAA-123)");

        lblNumeroSerie3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 10)); // NOI18N
        lblNumeroSerie3.setForeground(new java.awt.Color(124, 63, 163));
        lblNumeroSerie3.setText("(Año)");

        javax.swing.GroupLayout jPanelFondoMenuLayout = new javax.swing.GroupLayout(jPanelFondoMenu);
        jPanelFondoMenu.setLayout(jPanelFondoMenuLayout);
        jPanelFondoMenuLayout.setHorizontalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBarra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblColor)
                                    .addComponent(lblColor1)
                                    .addComponent(lblColor2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtColor)
                                    .addComponent(cbxTipo, 0, 229, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFondoMenuLayout.createSequentialGroup()
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca)
                                    .addComponent(lblNuevaPlaca))
                                .addGap(62, 62, 62)
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMarca)
                                    .addComponent(txtLinea)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelFondoMenuLayout.createSequentialGroup()
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblNumeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblNumeroSerie1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNumeroSerie2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                                        .addComponent(txtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNumeroSerie3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelFondoMenuLayout.setVerticalGroup(
            jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNumeroSerie2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addComponent(lblNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNumeroSerie1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jToolBarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(216, 216, 216))
                    .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                                .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMarca))
                                .addGap(18, 18, 18)
                                .addComponent(lblNuevaPlaca))
                            .addGroup(jPanelFondoMenuLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColor1))
                        .addGap(1, 1, 1)
                        .addComponent(lblNumeroSerie3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColor2))))
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondoMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Método action del botón volver para regresar al menú.
     *
     * @param evt Evento del botón.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        FrmTramitarPlacas frmtp = new FrmTramitarPlacas(personasDAO, vehiculosDAO, tramitesDAO, personaSeleccionada, "");
        this.setVisible(false);
        frmtp.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     * Método action del botón registrar para registrar un auto y volver al
     * frame de tramitar placas.
     *
     * @param evt Evento del botón.
     */
    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (registrarVehiculo()) {
            FrmTramitarPlacas frmtp = new FrmTramitarPlacas(personasDAO, vehiculosDAO, tramitesDAO, personaSeleccionada, numSerie);
            frmtp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed
    /**
     * Evento Item del comboboxTipo, cambia el valor de la variable tipo
     * dependiendo del item seleccionado.
     *
     * @param evt Evento del textField.
     */
    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            tipo = (String) this.cbxTipo.getSelectedItem();
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged
    /**
     * Evento KeyTyped del txtMarca para verificar que se escriban letras o
     * digitos con un máximo de 20 carácteres.
     *
     * @param evt Evento del textField.
     */
    private void txtMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMarcaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c) || txtMarca.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtMarcaKeyTyped
    /**
     * Evento KeyTyped del txtLinea para verificar que se escriban letras o
     * digitos con un máximo de 20 carácteres.
     *
     * @param evt Evento del textField.
     */
    private void txtLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetterOrDigit(c) && !Character.isSpaceChar(c) || txtLinea.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtLineaKeyTyped
    /**
     * Evento KeyTyped del txtColor para verificar que se escriban letras o
     * digitos con un máximo de 20 carácteres.
     *
     * @param evt Evento del textField.
     */
    private void txtColorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtColorKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c) && !Character.isSpaceChar(c) || txtColor.getText().length() >= 20) {
            evt.consume();
        }
    }//GEN-LAST:event_txtColorKeyTyped
    /**
     * Evento KeyTyped del txtModelo para verificar que se escriban letras o
     * digitos con un máximo de 20 carácteres.
     *
     * @param evt Evento del textField.
     */
    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txtModelo.getText().length() >= 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtModeloKeyTyped
    /**
     * Evento KeyTyped del txtNumeroSerie para verificar que se escriban letras
     * o digitos con un máximo de 6 carácteres y un formato específico.
     *
     * @param evt Evento del textField.
     */
    private void txtNumeroSerieKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumeroSerieKeyTyped
        String numeroSerie = txtNumeroSerie.getText();
        char c = evt.getKeyChar();
        if (!(Character.isLetterOrDigit(c) || c == '-') || numeroSerie.length() >= 7) {
            evt.consume();
        } else if (numeroSerie.length() == 3 && c != '-') {
            evt.consume();
        } else if (numeroSerie.length() == 4 && !Character.isDigit(c)) {
            evt.consume();
        } else if (numeroSerie.length() == 5 && !Character.isDigit(c)) {
            evt.consume();
        } else if (numeroSerie.length() == 6 && !Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNumeroSerieKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelFondoMenu;
    private javax.swing.JToolBar jToolBarMenu;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblColor1;
    private javax.swing.JLabel lblColor2;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombrePersona;
    private javax.swing.JLabel lblNuevaPlaca;
    private javax.swing.JLabel lblNumeroSerie;
    private javax.swing.JLabel lblNumeroSerie1;
    private javax.swing.JLabel lblNumeroSerie2;
    private javax.swing.JLabel lblNumeroSerie3;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumeroSerie;
    private javax.swing.JLabel txtRegistrar;
    // End of variables declaration//GEN-END:variables
}

/**
 * Clase FrmSeleccionarPersona.java creada el 29/03/2023.
 */
package com.itson.proyecto2_233410_233023.UI;

import com.itson.proyecto2_233410_233023.dominio.Persona;
import com.itson.proyecto2_233410_233023.implementaciones.*;
import com.itson.proyecto2_233410_233023.interfaces.*;
import java.awt.event.ItemEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gabriel x Kim
 */
public class FrmSeleccionarPersona extends javax.swing.JFrame {

    private final IPersonasDAO personasDAO;
    IVehiculosDAO vehiculosDAO;
    ITramitesDAO tramitesDAO;
    IHistorialDAO historialDAO;

    private ConfiguracionPaginado paginado;
    private Validador validador = new Validador();
    private int numeroPagina = 0;
    private int elementosPorPagina = 3;
    private String filtro = null;
    private Persona personaSeleccionada = null;
    private Boolean tramite;
    PaginacionLista paginacionLista;

    /**
     * Método constructor que inicializa sus atributos al valor de los
     * parámetros enviados.
     */
    public FrmSeleccionarPersona(IPersonasDAO personasDAO, IVehiculosDAO vehiculosDAO, Boolean tramite, ITramitesDAO tramitesDAO, IHistorialDAO historialDAO) {
        this.historialDAO = historialDAO;
        this.personasDAO = personasDAO;
        this.vehiculosDAO = vehiculosDAO;
        this.tramitesDAO = tramitesDAO;
        this.paginado = new ConfiguracionPaginado(this.numeroPagina, this.elementosPorPagina);
        this.tramite = tramite;
        initComponents();
        cargarTablaPersonas();
    }

    /**
     * Método para validar el TextField de búsqueda el cuál valida dependiendo
     * de la opción seleccionada.
     *
     * @return Valor booleano para comprobar la validación.
     */
    public boolean validarBusqueda() throws PersistenciaException {
        if (filtro.equals("id")) {
            return validador.validaID(obtenerBusqueda());
        } else if (filtro.equals("nombre")) {
            return validador.validaNombre(obtenerBusqueda());
        } else {
            return validador.validaRFC(obtenerBusqueda());
        }
    }

    /**
     * Método para cargar la tabla de personas en la interfaz de usuario. Si no
     * se ha seleccionado o escrito ningún filtro simplemente muestra todos los
     * registros de Persona.
     */
    public void cargarTablaPersonas() {
        List<Persona> personas;
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (filtro != null && !txtBusqueda.getText().isEmpty()) {
            try {
                if (validarBusqueda()) {
                    personas = personasDAO.consultarPersonasFiltro(this.filtro, this.txtBusqueda.getText(), paginado);
                    paginacionLista = new PaginacionLista(personas, paginado.getElementosPorPagina(), paginado.getNumeroPagina());
                    if (filtro.equals("nombre")) {
                        personas = paginacionLista.obtenerPaginaActual();
                    }
                    DefaultTableModel modeloTablaPersonas = (DefaultTableModel) this.tblPersonas.getModel();
                    modeloTablaPersonas.setRowCount(0);
                    if (personas != null) {
                        for (Persona persona : personas) {
                            Object[] filaNueva = {persona.getId(), persona.getNombre() + " "
                                + persona.getApellidoPaterno(), persona.getRfc(),
                                formatter.format(((GregorianCalendar) persona.getFechaNacimiento()).getTime()),
                                persona.getDiscapacitado(), persona.getTelefono()};
                            modeloTablaPersonas.addRow(filaNueva);
                        }
                    } else {
                        mostrarMensaje("No se encontraron más personas");
                    }
                }
            } catch (PersistenciaException ex) {
                mostrarMensaje(ex.getMessage());
            }
        } else {
            personas = personasDAO.consultarPersonas(paginado);
            DefaultTableModel modeloTablaPersonas = (DefaultTableModel) this.tblPersonas.getModel();
            modeloTablaPersonas.setRowCount(0);
            for (Persona persona : personas) {
                Object[] filaNueva = {persona.getId(), persona.getNombre() + " "
                    + persona.getApellidoPaterno(), persona.getRfc(),
                    formatter.format(((GregorianCalendar) persona.getFechaNacimiento()).getTime()),
                    persona.getDiscapacitado(), persona.getTelefono()};
                modeloTablaPersonas.addRow(filaNueva);
            }
        }
    }

    /**
     * Método para obtener el texto del TextField de búsqueda.
     *
     * @return Texto de búsqueda.
     */
    public String obtenerBusqueda() {
        if (!txtBusqueda.getText().isEmpty() || txtBusqueda.getText() != null) {
            return txtBusqueda.getText();
        }
        return "";
    }

    /**
     * Método para obtener la ID del TextField de ID.
     *
     * @return ID obtenida.
     */
    public String obtenerID() {
        if (!txtBusqueda.getText().isEmpty() || txtid.getText() != null) {
            return txtid.getText();
        }
        return "";

    }

    public boolean validarPersona() throws PersistenciaException {
        String id = obtenerID();
        if (validador.validaID(id)) {
            Persona personaObtenida = personasDAO.obtenerPersona(Long.parseLong(obtenerID()));
            if (personaObtenida != null) {
                this.personaSeleccionada = personaObtenida;
                return true;
            }
        }
        return false;
    }

    public void validarPersonaMayor18() throws PersistenciaException {
        Calendar fechaNacimiento = personaSeleccionada.getFechaNacimiento();
        Calendar fechaActual = Calendar.getInstance();
        LocalDate fechaNacimientoLD = LocalDate.of(fechaNacimiento.get(Calendar.YEAR), fechaNacimiento.get(Calendar.MONTH) + 1, fechaNacimiento.get(Calendar.DAY_OF_MONTH));
        LocalDate fechaActualLD = LocalDate.of(fechaActual.get(Calendar.YEAR), fechaActual.get(Calendar.MONTH) + 1, fechaActual.get(Calendar.DAY_OF_MONTH));
        Period diferencia = Period.between(fechaNacimientoLD, fechaActualLD);
        int anios = diferencia.getYears();
        System.out.println(anios);
        if (anios < 18) {
            throw new PersistenciaException("Persona menor de 18 años");
        }

    }
    public void validarPersonaSinLicencia() throws Exception {
        if (tramitesDAO.buscarLicenciaActiva(personaSeleccionada) == null) {
            throw new PersistenciaException("Esta persona no tiene licencia activa");
        }
    }
    public void validarPersonaSinTelefono() throws Exception {
        if (personaSeleccionada.getTelefono() == null) {
            throw new PersistenciaException("Esta persona no tiene teléfono");
        }
    }

    /**
     * Método para obtener la persona a partir de la ID recuperada.
     */
    public boolean seleccionarPersona() {
        try {
            if (validarPersona()) {
                return true;
            } else {
                mostrarMensaje("La ID que has proporcionado no existe.");
                return false;
            }
        } catch (PersistenciaException ex) {
            mostrarMensaje(ex.getMessage());
            return false;
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
     * Método para mostrar un Frame de trámite dependiendo su elección.
     */
    private void mostrarFrm() {
        JFrame frm;
        try{
        if (this.tramite) {
                validarPersonaSinTelefono();
                validarPersonaMayor18();
            frm = new FrmTramitarLicencias(personasDAO, vehiculosDAO, personaSeleccionada, tramitesDAO, historialDAO);
        } else {
                validarPersonaSinLicencia();
            frm = new FrmTramitarPlacas(personasDAO, vehiculosDAO, tramitesDAO, personaSeleccionada, "", historialDAO);
        }
        mostrarMensaje(personaSeleccionada.getNombre() + " " + personaSeleccionada.getApellidoPaterno() + " " + "ha sido seleccionado.");
        this.setVisible(false);
        frm.setVisible(true);
        }catch(Exception ex){
            mostrarMensaje(ex.getMessage());
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

        btnGrupo = new javax.swing.ButtonGroup();
        jPanelFondo = new javax.swing.JPanel();
        jPanelBarra = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        lblAutoPapeleo = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        rbnNombre = new javax.swing.JRadioButton();
        rbnRFC = new javax.swing.JRadioButton();
        rbnID = new javax.swing.JRadioButton();
        jLblIndicacion = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        btnSeleccionar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblUsuarios = new javax.swing.JLabel();
        cbxPaginado = new javax.swing.JComboBox<>();
        btnConsultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccionar persona");
        setPreferredSize(new java.awt.Dimension(683, 455));

        jPanelFondo.setBackground(new java.awt.Color(233, 219, 253));
        jPanelFondo.setForeground(new java.awt.Color(233, 219, 253));
        jPanelFondo.setMaximumSize(new java.awt.Dimension(683, 455));
        jPanelFondo.setMinimumSize(new java.awt.Dimension(683, 455));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(683, 455));

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

        lblAutoPapeleo.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        lblAutoPapeleo.setForeground(new java.awt.Color(255, 255, 255));
        lblAutoPapeleo.setText("Selecciona Persona");

        javax.swing.GroupLayout jPanelBarraLayout = new javax.swing.GroupLayout(jPanelBarra);
        jPanelBarra.setLayout(jPanelBarraLayout);
        jPanelBarraLayout.setHorizontalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBarraLayout.createSequentialGroup()
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAutoPapeleo)
                .addGap(0, 530, Short.MAX_VALUE))
        );
        jPanelBarraLayout.setVerticalGroup(
            jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addComponent(lblAutoPapeleo))
        );

        txtBusqueda.setFont(new java.awt.Font("Microsoft JhengHei", 2, 12)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(124, 63, 163));
        txtBusqueda.setToolTipText("");
        txtBusqueda.setBorder(null);

        rbnNombre.setBackground(new java.awt.Color(233, 219, 253));
        btnGrupo.add(rbnNombre);
        rbnNombre.setForeground(new java.awt.Color(124, 63, 163));
        rbnNombre.setText("Nombre");
        rbnNombre.setBorder(null);
        rbnNombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbnNombreItemStateChanged(evt);
            }
        });
        rbnNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbnNombreActionPerformed(evt);
            }
        });

        rbnRFC.setBackground(new java.awt.Color(233, 219, 253));
        btnGrupo.add(rbnRFC);
        rbnRFC.setForeground(new java.awt.Color(124, 63, 163));
        rbnRFC.setText("RFC");
        rbnRFC.setBorder(null);
        rbnRFC.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbnRFCItemStateChanged(evt);
            }
        });

        rbnID.setBackground(new java.awt.Color(233, 219, 253));
        btnGrupo.add(rbnID);
        rbnID.setForeground(new java.awt.Color(124, 63, 163));
        rbnID.setText("ID");
        rbnID.setBorder(null);
        rbnID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbnIDItemStateChanged(evt);
            }
        });

        jLblIndicacion.setFont(new java.awt.Font("Microsoft JhengHei", 0, 12)); // NOI18N
        jLblIndicacion.setForeground(new java.awt.Color(129, 0, 127));
        jLblIndicacion.setText("(Id de la persona a la cual se quiere seleccionar)");

        lblid.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(129, 0, 127));
        lblid.setText("ID:");

        txtid.setFont(new java.awt.Font("Microsoft JhengHei", 2, 12)); // NOI18N
        txtid.setForeground(new java.awt.Color(124, 63, 163));
        txtid.setToolTipText("");
        txtid.setBorder(null);
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtidKeyTyped(evt);
            }
        });

        btnSiguiente.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(129, 0, 127));
        btnSiguiente.setText("Siguiente página");
        btnSiguiente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        tblPersonas.setBackground(new java.awt.Color(233, 219, 253));
        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "RFC", "Fecha Nacimiento", "Discapacitado", "Teléfono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane.setViewportView(tblPersonas);

        btnSeleccionar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnSeleccionar.setForeground(new java.awt.Color(129, 0, 127));
        btnSeleccionar.setText("Seleccionar persona");
        btnSeleccionar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        btnRegresar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(129, 0, 127));
        btnRegresar.setText("Regresar página");
        btnRegresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblUsuarios.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        lblUsuarios.setForeground(new java.awt.Color(129, 0, 127));
        lblUsuarios.setText("Usuarios por página:");

        cbxPaginado.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        cbxPaginado.setForeground(new java.awt.Color(124, 63, 163));
        cbxPaginado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "5", "10" }));
        cbxPaginado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPaginadoItemStateChanged(evt);
            }
        });
        cbxPaginado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPaginadoActionPerformed(evt);
            }
        });

        btnConsultar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        btnConsultar.setForeground(new java.awt.Color(129, 0, 127));
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(124, 63, 163)));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rbnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbnRFC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(rbnID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLblIndicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(212, 212, 212))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(lblUsuarios)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxPaginado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addComponent(jPanelBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbnRFC)
                            .addComponent(rbnNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbnID))
                    .addComponent(txtBusqueda))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar)
                            .addComponent(btnSiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblUsuarios)
                            .addComponent(cbxPaginado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnConsultar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblid)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblIndicacion))
                        .addGap(70, 70, 70))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Evento que ocurre cuando un usuario da un click en el botón para volver
     * al menú.
     *
     * @param evt Evento al dar click en el botón.
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        FrmMenu frmm = new FrmMenu(personasDAO, vehiculosDAO, tramitesDAO, historialDAO);
        this.setVisible(false);
        frmm.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     * Evento que ocurre cuando un usuario da un click en el botón siguiente del
     * paginado.
     *
     * @param evt Evento al dar click en el botón.
     */
    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        this.paginado.avanzarPagina();
        cargarTablaPersonas();
    }//GEN-LAST:event_btnSiguienteActionPerformed
    /**
     * Evento que ocurre cuando un usuario da un click en el botón para
     * seleccionar una persona.
     *
     * @param evt Evento al dar click en el botón.
     */
    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if (seleccionarPersona()) {
            mostrarFrm();
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed
    /**
     * Evento que ocurre cuando un usuario da un click en el botón para regresar
     * del paginado.
     *
     * @param evt Evento al dar click en el botón.
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.paginado.retrocederPagina();
        cargarTablaPersonas();
    }//GEN-LAST:event_btnRegresarActionPerformed
    /**
     * Evento que ocurre cuando un usuario cambia de opción en el Combobox de
     * paginado.
     *
     * @param evt Evento al cambiar de selección.
     */
    private void cbxPaginadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPaginadoItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int elementosPorPagina = Integer.parseInt((String) this.cbxPaginado.getSelectedItem());
            this.paginado.setElementosPorPagina(elementosPorPagina);
            this.cargarTablaPersonas();
        }
    }//GEN-LAST:event_cbxPaginadoItemStateChanged
    /**
     * Evento que ocurre cuando un usuario cambia de opción en el grupo de
     * radiobutton.
     *
     * @param evt Evento al cambiar de selección.
     */
    private void rbnNombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbnNombreItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            this.filtro = "nombre";
        }
    }//GEN-LAST:event_rbnNombreItemStateChanged
    /**
     * Evento que ocurre cuando un usuario cambia de opción en el grupo de
     * radiobutton.
     *
     * @param evt Evento al cambiar de selección.
     */
    private void rbnRFCItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbnRFCItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.filtro = "rfc";
        }
    }//GEN-LAST:event_rbnRFCItemStateChanged
    /**
     * Evento que ocurre cuando un usuario cambia de opción en el grupo de
     * radiobutton.
     *
     * @param evt Evento al cambiar de selección.
     */
    private void rbnIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbnIDItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.filtro = "id";
        }
    }//GEN-LAST:event_rbnIDItemStateChanged
    /**
     * Evento que ocurre cuando un usuario da un click en el botón para
     * consultar la tabla.
     *
     * @param evt Evento al dar click en el botón.
     */
    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        cargarTablaPersonas();
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void rbnNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbnNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbnNombreActionPerformed

    private void cbxPaginadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPaginadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPaginadoActionPerformed

    private void txtidKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtidKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.ButtonGroup btnGrupo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cbxPaginado;
    private javax.swing.JLabel jLblIndicacion;
    private javax.swing.JPanel jPanelBarra;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblAutoPapeleo;
    private javax.swing.JLabel lblUsuarios;
    private javax.swing.JLabel lblid;
    private javax.swing.JRadioButton rbnID;
    private javax.swing.JRadioButton rbnNombre;
    private javax.swing.JRadioButton rbnRFC;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}

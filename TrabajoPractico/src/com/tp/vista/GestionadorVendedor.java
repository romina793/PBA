package com.tp.vista;

import com.tp.controlador.ControllerCiudad;
import com.tp.controlador.ControllerPersona;
import com.tp.modelo.Articulo;
import com.tp.modelo.Ciudad;
import com.tp.modelo.Vendedor;
import com.tp.util.HibernateUtil;
import com.tp.util.Utiles;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class GestionadorVendedor extends javax.swing.JFrame {

    private final ControllerPersona controllerPersona;
    private final ControllerCiudad controllerCiudad;
    private final SessionFactory sessionFactory;

    private Transaction tx = null;
    private List<Vendedor> vendedores;
    private List<Ciudad> ciudades;
    private List<Articulo> articulos;
    private int filaSeleccionada = 0;

    /**
     * Creates new form GestionadorVendedor
     */
    public GestionadorVendedor() {
        controllerPersona = new ControllerPersona();
        controllerCiudad = new ControllerCiudad();
        sessionFactory = HibernateUtil.getSessionFactory();
        vendedores = new ArrayList<>();
        ciudades = new ArrayList<>();
        articulos = new ArrayList<>();

        initComponents();
        
        cargarVendedores();
        cargarCiudades();
        cargarTotalRegistros();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVendedores = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelCuit = new javax.swing.JLabel();
        jTextFieldCuit = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jLabelCiudad = new javax.swing.JLabel();
        jComboBoxCiudad = new javax.swing.JComboBox<>();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelApellido = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        jLabelComision = new javax.swing.JLabel();
        jTextFieldApellido = new javax.swing.JTextField();
        jTextFieldDireccion = new javax.swing.JTextField();
        jTextFieldComision = new javax.swing.JTextField();
        jLabelAccion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabelTotalRegistros = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jButtonBorrar = new javax.swing.JButton();
        jMenuBarSalir = new javax.swing.JMenuBar();
        jMenuSalir = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelTitulo.setBackground(new java.awt.Color(102, 153, 255));

        jLabelTitulo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Gestionador de Vendedores");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTableVendedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Dirección", "CUIT", "Comisión", "Ciudad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVendedores.setToolTipText("");
        jTableVendedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableVendedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableVendedores);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabelNombre.setText("Nombre:");

        jLabelCuit.setText("CUIT:");

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setEnabled(false);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabelCiudad.setText("Ciudad:");

        jComboBoxCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin especificar" }));

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabelApellido.setText("Apellido: ");

        jLabelDireccion.setText("Dirección: ");

        jLabelComision.setText("Comisión: ");

        jLabelAccion.setText("Acciones");

        jLabelTotalRegistros.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabelTotalRegistros.setText("Total de registros:");

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setEnabled(false);
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jMenuSalir.setText("Opciones");

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuSalir.add(jMenuItemSalir);

        jMenuBarSalir.add(jMenuSalir);

        setJMenuBar(jMenuBarSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelNombre)
                                .addComponent(jLabelCuit))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldCuit, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelApellido)
                                .addComponent(jLabelComision))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldComision, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelCiudad)
                                .addComponent(jLabelDireccion))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxCiudad, 0, 191, Short.MAX_VALUE)
                                .addComponent(jTextFieldDireccion)))
                        .addComponent(jLabelAccion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTotalRegistros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jButtonAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonActualizar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellido)
                    .addComponent(jLabelDireccion)
                    .addComponent(jTextFieldApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCuit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCuit)
                    .addComponent(jLabelCiudad)
                    .addComponent(jComboBoxCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelComision)
                    .addComponent(jTextFieldComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelAccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalRegistros)
                    .addComponent(jLabelTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String requeridos = evaluarDatosRequeridos();
        if (requeridos.isEmpty()) {
            String provincia = jComboBoxCiudad.getSelectedItem().toString();
            Ciudad ciudad = ciudadSegunProvincia(provincia);

            Vendedor vendedor = new Vendedor(
                    Integer.valueOf(jTextFieldCuit.getText().trim()),
                    Double.valueOf(jTextFieldComision.getText().trim()),
                    articulos,
                    ciudad,
                    jTextFieldNombre.getText().trim(),
                    jTextFieldApellido.getText().trim(),
                    jTextFieldDireccion.getText().trim()
            );
            boolean esVendedorExistente = esVendedorExistente(vendedor);
            if (esVendedorExistente) {
                JOptionPane.showMessageDialog(this, "El vendedor ya existe en la lista");
            } else {
                registrar(vendedor);
                JOptionPane.showMessageDialog(this, "Vendedor agregado!");
            }
        } else {
            JOptionPane.showMessageDialog(this, requeridos);
        }
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        String requeridos = evaluarDatosRequeridos();
        if (requeridos.isEmpty()) {
            Vendedor vendedor = actualizarVendedor();
            registrar(vendedor);
            JOptionPane.showMessageDialog(this, "Vendedor actualizado!");
        } else {
            JOptionPane.showMessageDialog(this, requeridos);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jTableVendedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableVendedoresMouseClicked
        jButtonActualizar.setEnabled(true);
        jButtonBorrar.setEnabled(true);

        filaSeleccionada = jTableVendedores.rowAtPoint(evt.getPoint());
        Vendedor vendedorSeleccionado = vendedores.get(filaSeleccionada);

        jTextFieldNombre.setText(vendedorSeleccionado.getNombre());
        jTextFieldApellido.setText(vendedorSeleccionado.getApellido());
        jTextFieldDireccion.setText(vendedorSeleccionado.getDireccion());
        jTextFieldCuit.setText(String.valueOf(vendedorSeleccionado.getCuit()));
        jTextFieldComision.setText(String.valueOf(vendedorSeleccionado.getPorcentajeDeComision()));

        Ciudad ciudad = vendedorSeleccionado.getCiudad();
        if (ciudad == null) {
            jComboBoxCiudad.setSelectedIndex(0);
        } else {
            int indexOf = ciudades.indexOf(ciudad);
            jComboBoxCiudad.setSelectedIndex(indexOf + 1);
        }
    }//GEN-LAST:event_jTableVendedoresMouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        try {
            Vendedor vendedor = vendedores.get(filaSeleccionada);
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            controllerPersona.borrar(session, vendedor);
            tx.commit();
            limpiar();
            session.clear();
            session.close();
            JOptionPane.showMessageDialog(this, "Vendedor eliminado!");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar un vendedor");
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void cargarVendedores() {
        Session session = sessionFactory.openSession();
        vendedores = controllerPersona.obtenerVendedores(session);
        vendedores.forEach(vendedor -> {
            agregarFila(vendedor);
        });
        session.clear();
        session.close();
    }

    private void cargarCiudades() {
        Session session = sessionFactory.openSession();
        ciudades = controllerCiudad.obtener(session);
        ciudades.forEach(ciudad -> {
            jComboBoxCiudad.addItem(ciudad.getProvincia());
        });
        session.clear();
        session.close();
    }

    private void cargarTotalRegistros() {
        jLabelTotal.setText(String.valueOf(vendedores.size()));
    }

    private String evaluarDatosRequeridos() {
        if (jTextFieldNombre.getText().isEmpty()) {
            return "Nombre es un dato requerido";
        }
        if (jTextFieldApellido.getText().isEmpty()) {
            return "Apellido es un dato requerido";
        }
        if (jTextFieldDireccion.getText().isEmpty()) {
            return "Dirección es un dato requerido";
        }
        if (jTextFieldCuit.getText().isEmpty()) {
            return "Cuit es un dato requerido";
        }
        if (!Utiles.esNumerico(jTextFieldCuit.getText())) {
            jTextFieldCuit.setText("");
            return "Cuit debe ser un dato númerico";
        }        
        if (jTextFieldComision.getText().isEmpty()) {
            return "Comisión es un dato requerido";
        }
        if (!Utiles.esDouble(jTextFieldComision.getText())) {
            jTextFieldComision.setText("");
            return "Comisión debe ser un dato númerico";
        }
        if (jComboBoxCiudad.getSelectedItem().toString() == "Sin especificar") {
            return "Ciudad es un dato requerido";
        }
        return "";
    }

    private Vendedor actualizarVendedor() {
        Vendedor vendedor = vendedores.get(filaSeleccionada);

        vendedor.setNombre(jTextFieldNombre.getText().trim());
        vendedor.setApellido(jTextFieldApellido.getText().trim());
        vendedor.setDireccion(jTextFieldDireccion.getText().trim());
        vendedor.setCuit(Integer.valueOf(jTextFieldCuit.getText().trim()));
        vendedor.setPorcentajeDeComision(Double.valueOf(jTextFieldComision.getText().trim()));

        String provincia = jComboBoxCiudad.getSelectedItem().toString();
        Ciudad ciudad = ciudadSegunProvincia(provincia);
        vendedor.setCiudad(ciudad);

        return vendedor;
    }

    private void registrar(Vendedor vendedor) {
        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            controllerPersona.registrar(session, vendedor);
            tx.commit();
            limpiar();
            session.clear();
            session.close();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar un vendedor");
        }
    }

    private void agregarFila(Vendedor vendedor) {
        String[] fila = {
            vendedor.getNombre(),
            vendedor.getApellido(),
            vendedor.getDireccion(),
            String.valueOf(vendedor.getCuit()),
            String.valueOf(vendedor.getPorcentajeDeComision()),
            vendedor.getCiudad() != null ? vendedor.getCiudad().getProvincia() : "Sin especificar"
        };
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableVendedores.getModel();
        defaultTableModel.addRow(fila);
    }

    private void borrarFila() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableVendedores.getModel();
        defaultTableModel.removeRow(filaSeleccionada);
        vendedores.remove(filaSeleccionada);
    }

    private void limpiar() {
        jButtonActualizar.setEnabled(false);
        jButtonBorrar.setEnabled(false);

        jTextFieldNombre.setText("");
        jTextFieldApellido.setText("");
        jTextFieldDireccion.setText("");
        jTextFieldCuit.setText("");
        jTextFieldComision.setText("");
        jComboBoxCiudad.setSelectedIndex(0);

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableVendedores.getModel();
        defaultTableModel.setNumRows(0);
        cargarVendedores();
        cargarTotalRegistros();
    }

    private Ciudad ciudadSegunProvincia(String descripcion) {
        Ciudad resultado = new Ciudad("Argentina", "Sin especificar");
        for (Ciudad ciudad : ciudades) {
            if (ciudad.getProvincia().equals(descripcion)) {
                resultado = ciudad;
                break;
            }
        }
        return resultado;
    }

    private boolean esVendedorExistente(Vendedor vendedor) {
        return vendedores.stream().anyMatch((ven) -> (ven.equals(vendedor)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxCiudad;
    private javax.swing.JLabel jLabelAccion;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelCiudad;
    private javax.swing.JLabel jLabelComision;
    private javax.swing.JLabel jLabelCuit;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalRegistros;
    private javax.swing.JMenuBar jMenuBarSalir;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableVendedores;
    private javax.swing.JTextField jTextFieldApellido;
    private javax.swing.JTextField jTextFieldComision;
    private javax.swing.JTextField jTextFieldCuit;
    private javax.swing.JTextField jTextFieldDireccion;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}

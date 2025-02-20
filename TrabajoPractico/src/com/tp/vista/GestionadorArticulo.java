package com.tp.vista;

import com.tp.controlador.ControllerArticulo;
import com.tp.controlador.ControllerMarca;
import com.tp.controlador.ControllerPersona;
import com.tp.modelo.Articulo;
import com.tp.modelo.Marca;
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
public class GestionadorArticulo extends javax.swing.JFrame {

    private final ControllerArticulo controllerArticulo;
    private final ControllerMarca controllerMarca;
    private final ControllerPersona controllerPersona;
    private final SessionFactory sessionFactory;

    private Transaction tx = null;
    private List<Articulo> articulos;
    private List<Marca> marcas;
    private List<Vendedor> vendedores;
    private int filaSeleccionada = 0;

    /**
     * Creates new form GestionadorArticulo
     */
    public GestionadorArticulo() {
        controllerArticulo = new ControllerArticulo();
        controllerMarca = new ControllerMarca();
        controllerPersona = new ControllerPersona();
        sessionFactory = HibernateUtil.getSessionFactory();
        articulos = new ArrayList<>();
        marcas = new ArrayList<>();
        vendedores = new ArrayList<>();

        initComponents();

        cargarMarcas();
        cargarVendedores();
        cargarArticulos();
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
        jTableArticulos = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jLabelCodigo = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelDescripcion = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jButtonActualizar = new javax.swing.JButton();
        jLabelPrecioCosto = new javax.swing.JLabel();
        jTextFieldPrecioCosto = new javax.swing.JTextField();
        jLabelPrecioVenta = new javax.swing.JLabel();
        jTextFieldPrecioVenta = new javax.swing.JTextField();
        jLabelMarca = new javax.swing.JLabel();
        jComboBoxMarcas = new javax.swing.JComboBox<>();
        jButtonLimpiar = new javax.swing.JButton();
        jLabelVendedor = new javax.swing.JLabel();
        jComboBoxVendedor = new javax.swing.JComboBox<>();
        jLabelAccion = new javax.swing.JLabel();
        jSeparator = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
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
        jLabelTitulo.setText("Gestionador de Artículos");

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

        jTableArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Descripción", "Precio Costo", "Precio Venta", "Marca", "Cuit Vendedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableArticulos.setToolTipText("");
        jTableArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableArticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableArticulos);

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabelCodigo.setText("Código:");

        jLabelNombre.setText("Nombre:");

        jLabelDescripcion.setText("Descripción:");

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setEnabled(false);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabelPrecioCosto.setText("Precio de Costo: $");

        jLabelPrecioVenta.setText("Precio de Venta: $");

        jLabelMarca.setText("Marca:");

        jComboBoxMarcas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin especificar" }));

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabelVendedor.setText("Cuit Vendedor:");

        jComboBoxVendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin especificar" }));

        jLabelAccion.setText("Acciones");

        jLabel1.setText("Asociar artículo a un vendedor");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTotal)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelVendedor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabelDescripcion)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelCodigo)
                                                .addGap(25, 25, 25)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabelNombre)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextFieldNombre))
                                            .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabelAccion))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelMarca)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jComboBoxMarcas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelPrecioCosto)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabelPrecioVenta)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTextFieldPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecioCosto)
                    .addComponent(jTextFieldPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecioVenta)
                    .addComponent(jTextFieldPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescripcion)
                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMarca)
                    .addComponent(jComboBoxMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAccion)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jLabelVendedor)
                    .addComponent(jComboBoxVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBorrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalRegistros)
                    .addComponent(jLabelTotal))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        String requeridos = evaluarDatosRequeridos();
        if (requeridos.isEmpty()) {
            String descripcion = jComboBoxMarcas.getSelectedItem().toString();
            Marca marca = marcaSegunDescripcion(descripcion);
            Articulo articulo = new Articulo(
                    Integer.valueOf(jTextFieldCodigo.getText().trim()),
                    jTextFieldNombre.getText().trim(),
                    jTextFieldDescripcion.getText().trim(),
                    Double.valueOf(jTextFieldPrecioCosto.getText().trim()),
                    Double.valueOf(jTextFieldPrecioVenta.getText().trim()),
                    marca
            );
            boolean esArticuloExistente = esArticuloExistente(articulo);
            if (esArticuloExistente) {
                JOptionPane.showMessageDialog(this, "El articulo ya existe en la lista");
            } else {
                registrar(articulo);
                JOptionPane.showMessageDialog(this, "Artículo agregado!");
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
            Articulo articulo = actualizarArticulo();
            registrar(articulo);
            JOptionPane.showMessageDialog(this, "Artículo actualizado!");
        } else {
            JOptionPane.showMessageDialog(this, requeridos);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jTableArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableArticulosMouseClicked
        jButtonActualizar.setEnabled(true);
        jButtonBorrar.setEnabled(true);

        filaSeleccionada = jTableArticulos.rowAtPoint(evt.getPoint());
        Articulo articuloSeleccionado = articulos.get(filaSeleccionada);

        jTextFieldCodigo.setText(String.valueOf(articuloSeleccionado.getCodigo()));
        jTextFieldNombre.setText(articuloSeleccionado.getNombre());
        jTextFieldDescripcion.setText(articuloSeleccionado.getDescripcion());
        jTextFieldPrecioCosto.setText(String.valueOf(articuloSeleccionado.getPrecioCosto()));
        jTextFieldPrecioVenta.setText(String.valueOf(articuloSeleccionado.getPrecioVenta()));

        Marca marca = articuloSeleccionado.getMarca();
        if (marca == null) {
            jComboBoxMarcas.setSelectedIndex(0);
        } else {
            int indexOf = marcas.indexOf(marca);
            jComboBoxMarcas.setSelectedIndex(indexOf + 1);
        }
        Vendedor vendedor = getVendedor(articuloSeleccionado);
        if (vendedor == null) {
            jComboBoxVendedor.setSelectedIndex(0);
        } else {
            int indexOf = vendedores.indexOf(vendedor);
            jComboBoxVendedor.setSelectedIndex(indexOf + 1);
        }
    }//GEN-LAST:event_jTableArticulosMouseClicked

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        try {
            Articulo articulo = articulos.get(filaSeleccionada);
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            controllerArticulo.borrar(session, articulo);
            tx.commit();
            limpiar();
            session.clear();
            session.close();
            JOptionPane.showMessageDialog(this, "Artículo eliminado!");
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar un artículo");
        }
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void cargarMarcas() {
        Session session = sessionFactory.openSession();
        marcas = controllerMarca.obtener(session);
        marcas.forEach(marca -> {
            jComboBoxMarcas.addItem(marca.getDescripcion());
        });
        session.clear();
        session.close();
    }

    private void cargarVendedores() {
        Session session = sessionFactory.openSession();
        vendedores = controllerPersona.obtenerVendedores(session);
        vendedores.forEach(vendedor -> {
            jComboBoxVendedor.addItem(String.valueOf(vendedor.getCuit()));
        });
        session.clear();
        session.close();
    }

    private void cargarArticulos() {
        Session session = sessionFactory.openSession();
        articulos = controllerArticulo.obtener(session);
        articulos.forEach(articulo -> {
            agregarFila(articulo);
        });
        session.clear();
        session.close();
    }

    private String evaluarDatosRequeridos() {
        if (jTextFieldCodigo.getText().isEmpty()) {
            return "Código es un dato requerido";
        }
        if (!Utiles.esNumerico(jTextFieldCodigo.getText())) {
            jTextFieldCodigo.setText("");
            return "Código debe ser un dato númerico";
        }
        if (jTextFieldNombre.getText().isEmpty()) {
            return "Nombre es un dato requerido";
        }
        if (jTextFieldPrecioCosto.getText().isEmpty()) {
            return "Precio de Costo es un dato requerido";
        }
        if (!Utiles.esDouble(jTextFieldPrecioCosto.getText())) {
            jTextFieldPrecioCosto.setText("");
            return "Precio de Costo debe ser un dato númerico";
        }
        if (jTextFieldPrecioVenta.getText().isEmpty()) {
            return "Precio de Venta es un dato requerido";
        }
        if (!Utiles.esDouble(jTextFieldPrecioVenta.getText())) {
            jTextFieldPrecioVenta.setText("");
            return "Precio de Venta debe ser un dato númerico";
        }
        if (jTextFieldDescripcion.getText().isEmpty()) {
            return "Descripción es un dato requerido";
        }
        if (jComboBoxMarcas.getSelectedItem().toString().equals("Sin especificar")) {
            return "Marca es un dato requerido";
        }
        return "";
    }

    private Articulo actualizarArticulo() {
        Articulo articulo = articulos.get(filaSeleccionada);

        articulo.setCodigo(Integer.valueOf(jTextFieldCodigo.getText().trim()));
        articulo.setNombre(jTextFieldNombre.getText().trim());
        articulo.setDescripcion(jTextFieldDescripcion.getText().trim());
        articulo.setPrecioCosto(Double.valueOf(jTextFieldPrecioCosto.getText().trim()));
        articulo.setPrecioVenta(Double.valueOf(jTextFieldPrecioVenta.getText().trim()));

        String descripcion = jComboBoxMarcas.getSelectedItem().toString();
        Marca marca = marcaSegunDescripcion(descripcion);
        articulo.setMarca(marca);

        return articulo;
    }

    private void registrar(Articulo articulo) {
        try {
            Session session = sessionFactory.openSession();
            tx = session.beginTransaction();
            controllerArticulo.registrar(session, articulo);
            asociarVendedor(articulo);
            tx.commit();
            limpiar();
            session.clear();
            session.close();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, "Error al registrar un artículo");
        }
    }

    private boolean estaAsociadoVendedor(Articulo articulo) {
        Vendedor vendedor = getVendedor();
        if (vendedor != null) {
            return vendedor.getArticulos().contains(articulo);
        }
        return false;
    }

    private boolean esArticuloExistente(Articulo articulo) {
        return articulos.stream().anyMatch((art) -> (art.equals(articulo)));
    }

    private void agregarFila(Articulo articulo) {
        String[] fila = {
            String.valueOf(articulo.getCodigo()),
            articulo.getNombre(),
            articulo.getDescripcion(),
            String.valueOf(articulo.getPrecioCosto()),
            String.valueOf(articulo.getPrecioVenta()),
            articulo.getMarca() != null ? articulo.getMarca().getDescripcion() : "Sin especificar",
            getCuitVendedorSegunArticulo(articulo)
        };
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableArticulos.getModel();
        defaultTableModel.addRow(fila);
    }

    private void borrarFila() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableArticulos.getModel();
        defaultTableModel.removeRow(filaSeleccionada);
        articulos.remove(filaSeleccionada);
    }

    private void asociarVendedor(Articulo articulo) {
        Vendedor vendedor = getVendedor();
        if (vendedor != null) {
            vendedor.getArticulos().add(articulo);
            JOptionPane.showMessageDialog(this, "Artículo asociado al vendedor: "
                    + vendedor.toString());
        }
    }

    private void limpiar() {
        jButtonActualizar.setEnabled(false);
        jButtonBorrar.setEnabled(false);

        jTextFieldCodigo.setText("");
        jTextFieldNombre.setText("");
        jTextFieldDescripcion.setText("");
        jTextFieldPrecioCosto.setText("");
        jTextFieldPrecioVenta.setText("");
        jComboBoxMarcas.setSelectedIndex(0);
        jComboBoxVendedor.setSelectedIndex(0);

        DefaultTableModel defaultTableModel = (DefaultTableModel) jTableArticulos.getModel();
        defaultTableModel.setNumRows(0);
        cargarArticulos();
        cargarTotalRegistros();
    }

    private void cargarTotalRegistros() {
        jLabelTotal.setText(String.valueOf(articulos.size()));
    }

    private Vendedor getVendedor() {
        String cuitVendedor = jComboBoxVendedor.getSelectedItem().toString();
        for (Vendedor vendedor : vendedores) {
            if (String.valueOf(vendedor.getCuit()).equals(cuitVendedor)) {
                return vendedor;
            }
        }
        return null;
    }

    private Vendedor getVendedor(Articulo articulo) {
        String cuitVendedor = getCuitVendedorSegunArticulo(articulo);
        if (!cuitVendedor.equals("Sin especificar")) {
            for (Vendedor vendedor : vendedores) {
                if (String.valueOf(vendedor.getCuit()).equals(cuitVendedor)) {
                    return vendedor;
                }
            }
        }
        return null;
    }

    private String getCuitVendedorSegunArticulo(Articulo articulo) {
        for (Vendedor vendedor : vendedores) {
            List<Articulo> articulosVendedor = vendedor.getArticulos();
            if (articulosVendedor.contains(articulo)) {
                return String.valueOf(vendedor.getCuit());
            }
        }
        return "Sin especificar";
    }

    private Marca marcaSegunDescripcion(String descripcion) {
        Marca resultado = new Marca(1, "Sin especificar");
        for (Marca marca : marcas) {
            if (marca.getDescripcion().equals(descripcion)) {
                resultado = marca;
                break;
            }
        }
        return resultado;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxMarcas;
    private javax.swing.JComboBox<String> jComboBoxVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAccion;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelPrecioCosto;
    private javax.swing.JLabel jLabelPrecioVenta;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotalRegistros;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JMenuBar jMenuBarSalir;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator;
    private javax.swing.JTable jTableArticulos;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPrecioCosto;
    private javax.swing.JTextField jTextFieldPrecioVenta;
    // End of variables declaration//GEN-END:variables
}

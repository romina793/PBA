package com.tp.vista;

import com.tp.util.HibernateUtil;
import org.hibernate.SessionFactory;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jbtnGestionarArticulo = new javax.swing.JButton();
        jbtnGestionarVendedor = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setBackground(new java.awt.Color(204, 204, 255));
        getContentPane().setLayout(new java.awt.CardLayout());

        jLabel1.setText("Administración de vendedores");

        jbtnGestionarArticulo.setText("GESTIONAR - ARTICULOS");
        jbtnGestionarArticulo.setFocusPainted(false);
        jbtnGestionarArticulo.setFocusable(false);
        jbtnGestionarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGestionarArticuloActionPerformed(evt);
            }
        });

        jbtnGestionarVendedor.setText("GESTIONAR - VENDEDORES");
        jbtnGestionarVendedor.setFocusable(false);
        jbtnGestionarVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGestionarVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnGestionarArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnGestionarVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnGestionarArticulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnGestionarVendedor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        jMenu.setText("Opciones");

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemSalir);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnGestionarVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGestionarVendedorActionPerformed
        GestionadorVendedor gestionadorVendedor = new GestionadorVendedor();
        gestionadorVendedor.setVisible(true);
    }//GEN-LAST:event_jbtnGestionarVendedorActionPerformed

    private void jbtnGestionarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGestionarArticuloActionPerformed
        GestionadorArticulo gestionadorArticulo = new GestionadorArticulo();
        gestionadorArticulo.setVisible(true);
    }//GEN-LAST:event_jbtnGestionarArticuloActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.close();

        this.dispose();
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnGestionarArticulo;
    private javax.swing.JButton jbtnGestionarVendedor;
    // End of variables declaration//GEN-END:variables
}

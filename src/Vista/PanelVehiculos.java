/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerContactos;
import Controlador.ControllerVehiculos;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author danlo
 */
public class PanelVehiculos extends javax.swing.JPanel {

    /**
     * Creates new form PanelVehiculos
     */
    public PanelVehiculos() {
        initComponents();

        String[] header = {"ID", "Personal", "Carnet", "Placa", "Color", "Id personal", "Modificar", "Eliminar", "Registro"};
        model = new DefaultTableModel(null, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        CargarTablaVehiculos();
        TbVehiculos.removeColumn(TbVehiculos.getColumnModel().getColumn(5));
        TbVehiculos.removeColumn(TbVehiculos.getColumnModel().getColumn(0));
        TbVehiculos.setDefaultRenderer(Object.class, new RenderTable());
        TbVehiculos.setFont(ValidacionesSistema.ValidacionesBeep_Go.font);
    }

    int idvehiculo;
    UWPButton btnModificar = new UWPButton();
    UWPButton btnEliminar = new UWPButton();
    UWPButton btnReporte = new UWPButton();
    ImageIcon modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    ImageIcon eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    ImageIcon reporte = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));

    final void CargarTablaVehiculos() {

        TbVehiculos.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            rs = ControllerVehiculos.CargarTabla();
            while (rs.next()) {
                btnModificar.setIcon(modificar);
                btnEliminar.setIcon(eliminar);
                btnReporte.setIcon(reporte);
                btnModificar.setBackground(new Color(231, 234, 239));
                btnEliminar.setBackground(new Color(231, 234, 239));
                btnReporte.setBackground(new Color(231, 234, 239));
                Object[] oValues = {rs.getInt("idVehiculo"), rs.getString("Personal"), rs.getString("Carnet"), rs.getString("placa"), rs.getString("color"), rs.getInt("idPersonal"), btnModificar, btnEliminar, btnReporte};
                model.addRow(oValues);
            }
        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelFondo = new Controles_Personalizados.Paneles.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblVehiculos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        btnInforme = new Controles_Personalizados.Botones.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        scrollBarCustom1 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbVehiculos = new Controles_Personalizados.Tables.Table();

        setBackground(new java.awt.Color(42, 36, 56));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelFondo.setPreferredSize(new java.awt.Dimension(1270, 620));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(1240, 135));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVehiculos.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblVehiculos.setForeground(new java.awt.Color(58, 50, 75));
        lblVehiculos.setText("Vehiculos");
        jPanel4.add(lblVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 70));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 40));

        btnAgregar.setBackground(new java.awt.Color(58, 50, 75));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar Blanco.png"))); // NOI18N
        btnAgregar.setText(" Agregar");
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        btnInforme.setBackground(new java.awt.Color(58, 50, 75));
        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        btnInforme.setText("Informe");
        btnInforme.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel5.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 40));

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(231, 234, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(461, 403));
        jPanel3.setLayout(new java.awt.BorderLayout());

        scrollBarCustom1.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom1.setForeground(new java.awt.Color(58, 50, 75));
        jPanel3.add(scrollBarCustom1, java.awt.BorderLayout.EAST);

        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        TbVehiculos = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int indexRow, int indexCol){
                return false;
            }
        };
        TbVehiculos.setBackground(new java.awt.Color(231, 234, 239));
        TbVehiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TbVehiculos.setGridColor(new java.awt.Color(58, 50, 75));
        TbVehiculos.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        TbVehiculos.setMinimumSize(new java.awt.Dimension(90, 880));
        TbVehiculos.setPreferredSize(new java.awt.Dimension(450, 880));
        TbVehiculos.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbVehiculos.setShowVerticalLines(false);
        TbVehiculos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TbVehiculosMouseMoved(evt);
            }
        });
        TbVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbVehiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbVehiculos);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        PanelFondo.add(jPanel1, gridBagConstraints);

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    FrmPersonal_AggVehiculo add = new FrmPersonal_AggVehiculo();
    FrmAgg_Vehiculos frmVehiculos = new FrmAgg_Vehiculos();
    ControllerVehiculos objVehiculos = new ControllerVehiculos();

    DefaultTableModel model = new DefaultTableModel();
    ResultSet rs;

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (add.isVisible()) {
            add.toFront();
        } else {
            add.setVisible(true);
        }
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {                                           
        ImprimirReporte();
    }                                          

    private void TbVehiculosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVehiculosMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_TbVehiculosMouseMoved

    private void TbVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVehiculosMouseClicked
        // TODO add your handling code here:
        int column = TbVehiculos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbVehiculos.getRowHeight();
        btnModificar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporte.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            idvehiculo = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Vehiculos.setIdvehiculo((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Vehiculos.setPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Vehiculos.setCarnet(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Vehiculos.setPlaca(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Vehiculos.setColor(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            ValidacionesSistema.Parametros_Vehiculos.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 5));
        }
        if (row < TbVehiculos.getRowCount() || row >= 0 || column < TbVehiculos.getColumnCount() || column >= 0) {
            Object vals = TbVehiculos.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    frmVehiculos = new FrmAgg_Vehiculos(ValidacionesSistema.Parametros_Vehiculos.getIdvehiculo());
                    frmVehiculos.setVisible(true);
                    //this.setEnabled(false);
                    CargarTablaVehiculos();
                    //Actualizar Contacto metodo
                }
                if (btns.getName().equals("btnReporte")) {
                    Imprimir1();
                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = JOptionPane.YES_NO_OPTION;
                    int a = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el vehiculo con placa: " + ValidacionesSistema.Parametros_Vehiculos.getPlaca() + "?", "Proceso de Eliminar", confirmar);
                    if (a == 0) {
                        ControllerVehiculos.idvehiculo = ValidacionesSistema.Parametros_Vehiculos.getIdvehiculo();
                        if (ControllerVehiculos.EliminarVehiculo_Controller() == true) {
                            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso de eliminacion", "Registro del vehiculo eliminado con exito", 1);
                            CargarTablaVehiculos();
                        }
                    }
                    // Eliminar Contacto metodo

                }
            }
        }

    }//GEN-LAST:event_TbVehiculosMouseClicked


    void ImprimirReporte() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String path = "src/DocsReport/VehiculosReporte.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map param = new HashMap();
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Pie", "src\\Recursos_Proyecto\\TextoLogin.png");
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    void Imprimir1() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String path = "src/DocsReport/InformeVehiculos.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map param = new HashMap<>();
            param.put("idVehiculo", idvehiculo);
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Pie", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(idvehiculo);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private Controles_Personalizados.Tables.Table TbVehiculos;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private Controles_Personalizados.Botones.UWPButton btnInforme;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblVehiculos;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerBuscador;
import Controlador.ControllerConexion;
import Controlador.ControllerPersonal;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author ferna
 */
public class PanelProfesores extends javax.swing.JPanel {

    DefaultTableModel ModelProf;
    public final UWPButton btnActualizar = new UWPButton();
    public final UWPButton btnEliminar = new UWPButton();
    public final UWPButton btnReporteP = new UWPButton();
    private ControllerPersonal objControllerP = new ControllerPersonal();
    public Font font = new Font("Roboto Black", Font.PLAIN, 18);
    private ImageIcon modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    private ImageIcon eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    private ImageIcon reporteimg = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));
    private int ID;
    private int panelperoes = PanelOpcionesPersonal.showinter;
    public DefaultTableModel modelo = new DefaultTableModel();
    String respuesta;
    String carnet;
    ControllerBuscador objC = new ControllerBuscador();
    private int frmstate;

    /**
     * Creates new form PanelProfesores
     */
    public PanelProfesores() {
        initComponents();
        String[] TitulosProf = {"IdPersonal", "Nombres", "Apellidos", "Nacimiento", "Documento", "Carnet", "Tipo Personal", "IDTD", "IDG", "Genero", "IDTP", "Tipo Documento", "Direccion", "Correo", "Modificar", "Eliminar", "Registro"};
        ModelProf = new DefaultTableModel(null, TitulosProf) {
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        TbProfesoresWhite.setModel(ModelProf);
        TbProfesoresWhite.setDefaultRenderer(Object.class, new RenderTable());
        cargarTablaProf();
        TbProfesoresWhite.setFont(font);
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(0));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(12));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(11));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(10));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(9));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(8));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(7));
        TbProfesoresWhite.removeColumn(TbProfesoresWhite.getColumnModel().getColumn(6));

    }

    final void refresh() {
        if (frmstate == 1 && !(add.isActive())) {
            cargarTablaProf();
            frmstate = 0;
        }
    }

    public void cargarTablaProf() {
        while (ModelProf.getRowCount() > 0) {
            ModelProf.removeRow(0);
        }
        try {
            ResultSet rs = objControllerP.MostrarProfesoresController();
            while (rs.next()) {
                btnActualizar.setBackground(new Color(231, 234, 239));
                btnActualizar.setFont(font);
                btnReporteP.setBackground(new Color(231, 234, 239));
                btnReporteP.setFont(font);
                btnEliminar.setBackground(new Color(231, 234, 239));
                btnEliminar.setFont(font);
                btnEliminar.setIcon(eliminar);
                btnActualizar.setIcon(modificar);
                btnReporteP.setIcon(reporteimg);
                Object[] campos = {rs.getInt("idPersonal"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("fecha_nacimiento"), rs.getString("documento"), rs.getString("Carnet"), rs.getString("tipo_personal"), rs.getInt("idTipoDocumento"), rs.getInt("idGenero"), rs.getString("genero"), rs.getInt("idTipoPersonal"), rs.getString("tipo_documento"), rs.getString("direccion"), rs.getString("correo"), btnActualizar, btnEliminar, btnReporteP};
                ModelProf.addRow(campos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar cargar la informacion", "Error al cargar", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
        }
    }

    void ImprimironePersonal() {

        Connection con = ControllerConexion.getConnectionModel();
        try {
            String dir = "src/DocsReport/PersonalReporte.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map param = new HashMap<>();
            param.put("idP", ID);
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Foot", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(ID);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    void imprimirPersonales() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String dir = "src/DocsReport/InformePersonal.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map param = new HashMap<>();
            param.put("Logo1", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Foot", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(param);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
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
        lblPersonal = new javax.swing.JLabel();
        txtBuscar = new Controles_Personalizados.textfields.TextField();
        jPanel5 = new javax.swing.JPanel();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        BtnInforme = new Controles_Personalizados.Botones.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        scrollBarCustom2 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbProfesoresWhite = new Controles_Personalizados.Tables.Table();

        setBackground(new java.awt.Color(42, 36, 56));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelFondoMouseMoved(evt);
            }
        });
        PanelFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(231, 234, 239));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersonal.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(58, 50, 75));
        lblPersonal.setText("Personal");
        jPanel4.add(lblPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        txtBuscar.setBackground(new java.awt.Color(231, 234, 239));
        txtBuscar.setForeground(new java.awt.Color(58, 50, 75));
        txtBuscar.setCaretColor(new java.awt.Color(58, 50, 75));
        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtBuscar.setLabelText("Buscar");
        txtBuscar.setLineColor(new java.awt.Color(58, 50, 75));
        txtBuscar.setSelectionColor(new java.awt.Color(58, 50, 75));
        jPanel4.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 450, 60));

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 60));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setBackground(new java.awt.Color(58, 50, 75));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar Blanco.png"))); // NOI18N
        btnAgregar.setText(" Agregar");
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 40));

        BtnInforme.setBackground(new java.awt.Color(58, 50, 75));
        BtnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        BtnInforme.setText("Informe");
        BtnInforme.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInformeActionPerformed(evt);
            }
        });
        jPanel5.add(BtnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 40));

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(231, 234, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(461, 403));
        jPanel3.setLayout(new java.awt.BorderLayout());

        scrollBarCustom2.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom2.setForeground(new java.awt.Color(58, 50, 75));
        jPanel3.add(scrollBarCustom2, java.awt.BorderLayout.EAST);

        jScrollPane2.setVerticalScrollBar(scrollBarCustom2);

        TbProfesoresWhite = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int indexRow, int indexCol){
                return false;
            }
        };
        TbProfesoresWhite.setBackground(new java.awt.Color(231, 234, 239));
        TbProfesoresWhite.setModel(new javax.swing.table.DefaultTableModel(
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
        TbProfesoresWhite.setGridColor(new java.awt.Color(58, 50, 75));
        TbProfesoresWhite.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        TbProfesoresWhite.setMinimumSize(new java.awt.Dimension(90, 880));
        TbProfesoresWhite.setPreferredSize(new java.awt.Dimension(450, 880));
        TbProfesoresWhite.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbProfesoresWhite.setShowVerticalLines(false);
        TbProfesoresWhite.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TbProfesoresWhiteMouseMoved(evt);
            }
        });
        TbProfesoresWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbProfesoresWhiteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbProfesoresWhite);

        jPanel3.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 500;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        PanelFondo.add(jPanel1, gridBagConstraints);

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!add.isVisible()) {
            add.setVisible(true);
            add.typestaff = 2; //student
        } else {
            add.toFront();
        }
        frmstate = 1;
    }//GEN-LAST:event_btnAgregarActionPerformed


    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed

    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved


    private void BtnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInformeActionPerformed
        // TODO add your handling code here:
        imprimirPersonales();
    }//GEN-LAST:event_BtnInformeActionPerformed

    private void TbProfesoresWhiteMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbProfesoresWhiteMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_TbProfesoresWhiteMouseMoved

    private void TbProfesoresWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbProfesoresWhiteMouseClicked
        // TODO add your handling code here:
        int column = TbProfesoresWhite.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbProfesoresWhite.getRowHeight();
        btnActualizar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporteP.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            ID = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Personal.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Personal.setnombre_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Personal.setApellido_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Personal.setFecha_nacimiento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Personal.setCarnet(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            ValidacionesSistema.Parametros_Personal.setDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            ValidacionesSistema.Parametros_Personal.setTipoPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            ValidacionesSistema.Parametros_Personal.setGenero(rcp.getModel().getValueAt(rcp.getSelectedRow(), 9).toString());
            ValidacionesSistema.Parametros_Personal.setTipoDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 11).toString());
            ValidacionesSistema.Parametros_Personal.setDireccion(rcp.getModel().getValueAt(rcp.getSelectedRow(), 12).toString());
            ValidacionesSistema.Parametros_Personal.setCorreo(rcp.getModel().getValueAt(rcp.getSelectedRow(), 13).toString());
        }

        if (row < TbProfesoresWhite.getRowCount() || row >= 0 || column < TbProfesoresWhite.getColumnCount() || column >= 0) {
            Object vals = TbProfesoresWhite.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    FrmAgg_Personal frmAgg_Personal = null;
                    frmAgg_Personal = new FrmAgg_Personal(ValidacionesSistema.Parametros_Personal.getIdPersonal());
                    frmAgg_Personal.setVisible(true);
                    frmstate = 1;

                    //Actualizar Contacto metodo
                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = JOptionPane.YES_NO_OPTION;
                    int a = JOptionPane.showConfirmDialog(this, "??Desea Eliminar el registro de: " + ValidacionesSistema.Parametros_Personal.getnombre_personal() + "?", "Proceso de Eliminar", confirmar);
                    if (a == 0) {
                        objControllerP.idpersonal = ValidacionesSistema.Parametros_Personal.getIdPersonal();
                        if (objControllerP.EliminarRegistroController() == true) {
                            JOptionPane.showMessageDialog(null, "Su registro a sido Eliminado", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    // Eliminar Contacto metodo

                }
                if (btns.getName().equals("btnReporte")) {
                    ImprimironePersonal();
                }
            }
        }
    }//GEN-LAST:event_TbProfesoresWhiteMouseClicked

    final void CargarResultados() {
        while (ModelProf.getRowCount() > 0) {
            ModelProf.removeRow(0);
        }
        panelperoes = 1;
        ResultSet rs;
        respuesta = txtBuscar.getText();

        objC.setCarnetVehiculo(respuesta);
        rs = objC.CargarVehiculosCarnetController(respuesta);
        switch (panelperoes) {
            case 1:
                try {
                    while (rs.next()) {

                        Object[] obj = {rs.getInt("idPersonal"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("fecha_nacimiento"), rs.getString("documento"), rs.getString("Carnet"), rs.getString("tipo_personal"), rs.getInt("idTipoDocumento"), rs.getInt("idGenero"), rs.getString("genero"), rs.getInt("idTipoPersonal"), rs.getString("tipo_documento"), rs.getString("direccion"), rs.getString("correo"), btnActualizar, btnEliminar};
                        ModelProf.addRow(obj);
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.toString());
                    System.out.println(e.toString());
                }
                break;
        }
    }

    FrmAgg_Personal add = new FrmAgg_Personal();


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Botones.UWPButton BtnInforme;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private Controles_Personalizados.Tables.Table TbProfesoresWhite;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPersonal;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom2;
    private Controles_Personalizados.textfields.TextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerPersonal;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import Controles_Personalizados.Tables.Table;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class PanelEstudiantes extends javax.swing.JPanel {

    private FrmAgg_Personal add = new FrmAgg_Personal();
    private ControllerPersonal objControllerP = new ControllerPersonal();
    public final DefaultTableModel ModelAlumnos;
    public final UWPButton btnActualizar = new UWPButton();
    public final UWPButton btnEliminar = new UWPButton();
    public final UWPButton btnReporteP = new UWPButton();
    //Codigo para colocar la letra que se utilza en el proyecto
    //(private Font font = new Font("Roboto Black", Font.PLAIN, 18);
    private ImageIcon modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    private ImageIcon eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    private ImageIcon reporteimg = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));
    public int frmstate;
    private int ID;

    /**
     * Creates new form PanelPersonal
     */
    public PanelEstudiantes() {
        initComponents();
        //Titulos de los campos que se cargan en la tabla
        String[] TitulosAlumnos = {"IDPersonal", "Nombres", "Apellidos", " Nacimiento", "Documento", "Carn??", "Tipo Personal", "Direccion", "Correo", "IDTD", "IDTP", "IDG", "Genero", "Tipo Documento", "Modificar", "Eliminar", "Registro"};
        ModelAlumnos = new DefaultTableModel(null, TitulosAlumnos) {
            //Codigo para no porder modificar texto en la tabla
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        TbAlumnos.setModel(ModelAlumnos);
        TbAlumnos.setDefaultRenderer(Object.class, new RenderTable());
        cargarTabla();
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(0));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(12));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(11));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(10));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(9));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(8));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(7));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(6));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(5));
        TbAlumnos.setFont(ValidacionesSistema.ValidacionesBeep_Go.font);
    }

    final void refresh() {
        if (frmstate == 1 && !(add.isActive())) {
            cargarTabla();
            frmstate = 0;
        }
    }

    public void cargarTabla() {
        while (ModelAlumnos.getRowCount() > 0) {
            ModelAlumnos.removeRow(0);
        }
        try {
            ResultSet rs = objControllerP.MostrarEstudiantesController();
            while (rs.next()) {
                btnEliminar.setIcon(eliminar);
                btnActualizar.setIcon(modificar);
                btnReporteP.setIcon(reporteimg);
                btnReporteP.setBackground(new Color(231, 234, 239));
                btnActualizar.setBackground(new Color(231, 234, 239));
                btnEliminar.setBackground(new Color(231, 234, 239));
                Object[] Campos = {rs.getInt("idPersonal"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("fecha_nacimiento"), rs.getString("documento"), rs.getString("Carnet"), rs.getString("tipo_personal"), rs.getString("direccion"), rs.getString("correo"), rs.getInt("idTipoDocumento"), rs.getInt("idTipoPersonal"), rs.getInt("idGenero"), rs.getString("genero"), rs.getString("tipo_documento"), btnActualizar, btnEliminar, btnReporteP};
                ModelAlumnos.addRow(Campos);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar tablas");
            System.out.println(e.toString());
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
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        BtnReporte = new Controles_Personalizados.Botones.UWPButton();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        jPanel5 = new javax.swing.JPanel();
        lblPersonal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        scrollBarCustom1 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbAlumnos = new Controles_Personalizados.Tables.Table();

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

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 60));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        BtnReporte.setBackground(new java.awt.Color(58, 50, 75));
        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        BtnReporte.setText("Informe");
        BtnReporte.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });
        jPanel4.add(BtnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 40));
        BtnReporte.getAccessibleContext().setAccessibleDescription("");

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel4.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 40));

        jPanel1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersonal.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(58, 50, 75));
        lblPersonal.setText("Estudiantes");
        jPanel5.add(lblPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel1.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setBackground(new java.awt.Color(231, 234, 239));
        jPanel2.setLayout(new java.awt.BorderLayout());

        scrollBarCustom1.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom1.setForeground(new java.awt.Color(58, 50, 75));
        jPanel2.add(scrollBarCustom1, java.awt.BorderLayout.EAST);

        jScrollPane2.setVerticalScrollBar(scrollBarCustom1);

        TbAlumnos = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int indexRow, int indexCol){
                return false;
            }
        };
        TbAlumnos.setBackground(new java.awt.Color(231, 234, 239));
        TbAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        TbAlumnos.setGridColor(new java.awt.Color(58, 50, 75));
        TbAlumnos.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        TbAlumnos.setMinimumSize(new java.awt.Dimension(90, 880));
        TbAlumnos.setPreferredSize(new java.awt.Dimension(450, 880));
        TbAlumnos.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbAlumnos.setShowVerticalLines(false);
        TbAlumnos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TbAlumnosMouseMoved(evt);
            }
        });
        TbAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAlumnosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbAlumnos);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 500;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        PanelFondo.add(jPanel3, gridBagConstraints);

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!add.isVisible()) {
            add.setVisible(true);
            add.typestaff = 2; //student
        } else {
            add.toFront();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_BtnReporteActionPerformed

    private void TbAlumnosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAlumnosMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_TbAlumnosMouseMoved

    private void TbAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAlumnosMouseClicked
        // TODO add your handling code here:
        Table tb = (Table) evt.getSource();
        JTable rcp = (JTable) evt.getSource();
        int column = TbAlumnos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbAlumnos.getRowHeight();
        btnActualizar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporteP.setName("btnReport");
        if (evt.getClickCount() == 1) {
            ID = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Personal.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Personal.setnombre_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Personal.setApellido_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Personal.setFecha_nacimiento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Personal.setDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            //ValidacionesSistema.Parametros_Personal.setCarnet(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            ValidacionesSistema.Parametros_Personal.setCorreo(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            ValidacionesSistema.Parametros_Personal.setDireccion(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            ValidacionesSistema.Parametros_Personal.setIdTipoPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 10));
            ValidacionesSistema.Parametros_Personal.setIdTipoDocumento((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 9));
            ValidacionesSistema.Parametros_Personal.setIdGenero((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 11));
            ValidacionesSistema.Parametros_Personal.setTipoPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            ValidacionesSistema.Parametros_Personal.setTipoDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 13).toString());
            ValidacionesSistema.Parametros_Personal.setGenero(rcp.getModel().getValueAt(rcp.getSelectedRow(), 12).toString());
        }
        if (row < TbAlumnos.getRowCount() || row >= 0 || column < TbAlumnos.getColumnCount() || column >= 0) {
            Object vals = TbAlumnos.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    if (rcp.getModel().getValueAt(rcp.getSelectedRow(), 5) == null) {
                        JOptionPane.showMessageDialog(null, "Ocurrieron problemas, al intentar cargar la informacion debido que este registro no tiene carn??", "Error de carn??", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println(ValidacionesSistema.Parametros_Personal.getCarnet());
                        FrmAgg_Personal frmAgg_Personal = new FrmAgg_Personal(ValidacionesSistema.Parametros_Personal.getIdPersonal());
                        frmAgg_Personal.show();
                        frmstate = 1;
                    }

                    //Actualizar Contacto metodo
                }
                if (btns.getName().equals("btnReport")) {
                    imprimironly1();

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
                    /*switch (confirmar) {
                        case JOptionPane.YES_OPTION:
                        objControllerP.idpersonal = ValidacionesSistema.Parametros_Personal.getIdPersonal();
                        if (objControllerP.EliminarRegistroController() == true) {
                            JOptionPane.showMessageDialog(null, "Su registro a sido Eliminado", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                        case JOptionPane.NO_OPTION:
                        System.out.println("No se elimino");
                        break;
                        default:
                        break;
                    }*/
                    // Eliminar Contacto metodo

                }
            }
        }
    }//GEN-LAST:event_TbAlumnosMouseClicked
    void imprimironly1() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String dir = "src/DocsReport/EstudianteReporte.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map param = new HashMap<>();
            param.put("idPersonal", ID);
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Nombre", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(param);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    void imprimir() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String dir = "src/DocsReport/InformeEstudiantes.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map param = new HashMap<>();
            param.put("Logo1", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Texto", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(param);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Botones.UWPButton BtnReporte;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private Controles_Personalizados.Tables.Table TbAlumnos;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPersonal;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}

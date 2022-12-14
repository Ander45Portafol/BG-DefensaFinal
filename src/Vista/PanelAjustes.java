/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerAjustes;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author danlo
 */
public class PanelAjustes extends javax.swing.JPanel {

    /**
     * Creates new form PanelAjustes
     */
    
    public String user;
    FrmConfigConection objcon = new FrmConfigConection();
    ControllerAjustes objcontroller = new ControllerAjustes();
    private String ContraA;
    FrmLogin objlog = new FrmLogin();

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public PanelAjustes(String usuario) {
        initComponents();
        txtPIN.setEchoChar('•');
        txtConfirmarPIN.setEchoChar('•');
        txtContraAntigua.setEchoChar('•');
        txtContra.setEchoChar('•');
        txtConfirmarContra.setEchoChar('•');
        user = usuario;
        txtUsuarioPIN.setText(usuario);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        PanelFondo = new Controles_Personalizados.Paneles.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        lblAjustes = new javax.swing.JLabel();
        PanelContenedorCambioContra = new Controles_Personalizados.Paneles.PanelRound();
        txtUsuarioPIN = new Controles_Personalizados.textfields.TextField();
        lblCambioClave = new javax.swing.JLabel();
        imgCambio = new javax.swing.JLabel();
        btnCambiarPIN = new Controles_Personalizados.Botones.UWPButton();
        txtConfirmarPIN = new Controles_Personalizados.textfields.PasswordField();
        txtPIN = new Controles_Personalizados.textfields.PasswordField();
        PanelContenedorIdiomas = new Controles_Personalizados.Paneles.PanelRound();
        lblIdiomas = new javax.swing.JLabel();
        panelRound5 = new Controles_Personalizados.Paneles.PanelRound();
        PanelContenedorCambioContra1 = new Controles_Personalizados.Paneles.PanelRound();
        lblCambioClave1 = new javax.swing.JLabel();
        imgCambio1 = new javax.swing.JLabel();
        txtCambiarContra = new Controles_Personalizados.Botones.UWPButton();
        txtConfirmarContra = new Controles_Personalizados.textfields.PasswordField();
        txtContraAntigua = new Controles_Personalizados.textfields.PasswordField();
        txtContra = new Controles_Personalizados.textfields.PasswordField();
        PanelContenedorConfiguracion = new Controles_Personalizados.Paneles.PanelRound();
        textoConfig = new javax.swing.JLabel();
        VerificarTipo = new Controles_Personalizados.Botones.UWPButton();
        PanelContenedorTemas = new Controles_Personalizados.Paneles.PanelRound();
        lblTemas = new javax.swing.JLabel();
        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        panelRound2 = new Controles_Personalizados.Paneles.PanelRound();

        setBackground(new java.awt.Color(42, 36, 56));
        setPreferredSize(new java.awt.Dimension(1250, 620));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelFondo.setPreferredSize(new java.awt.Dimension(1270, 620));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(231, 234, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAjustes.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblAjustes.setForeground(new java.awt.Color(58, 50, 75));
        lblAjustes.setText("Ajustes");
        jPanel1.add(lblAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        PanelContenedorCambioContra.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorCambioContra.setRoundBottomLeft(30);
        PanelContenedorCambioContra.setRoundBottomRight(30);
        PanelContenedorCambioContra.setRoundTopLeft(30);
        PanelContenedorCambioContra.setRoundTopRight(30);
        PanelContenedorCambioContra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuarioPIN.setEditable(false);
        txtUsuarioPIN.setBackground(new java.awt.Color(42, 36, 56));
        txtUsuarioPIN.setForeground(new java.awt.Color(231, 234, 239));
        txtUsuarioPIN.setCaretColor(new java.awt.Color(231, 234, 239));
        txtUsuarioPIN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtUsuarioPIN.setLabelText("Usuario");
        txtUsuarioPIN.setLineColor(new java.awt.Color(231, 234, 239));
        txtUsuarioPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioPINActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra.add(txtUsuarioPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 70));

        lblCambioClave.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblCambioClave.setForeground(new java.awt.Color(231, 234, 239));
        lblCambioClave.setText("Cambio de PIN de seguridad");
        PanelContenedorCambioContra.add(lblCambioClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        imgCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/pinajustes.png"))); // NOI18N
        PanelContenedorCambioContra.add(imgCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        btnCambiarPIN.setBackground(new java.awt.Color(42, 36, 56));
        btnCambiarPIN.setText("Confirmar Cambio");
        btnCambiarPIN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCambiarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPINActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra.add(btnCambiarPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 245, 140, 40));

        txtConfirmarPIN.setBackground(new java.awt.Color(42, 36, 56));
        txtConfirmarPIN.setForeground(new java.awt.Color(231, 234, 239));
        txtConfirmarPIN.setCaretColor(new java.awt.Color(231, 234, 239));
        txtConfirmarPIN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtConfirmarPIN.setLabelText("Confirmar PIN");
        txtConfirmarPIN.setLineColor(new java.awt.Color(231, 234, 239));
        txtConfirmarPIN.setPreferredSize(new java.awt.Dimension(45, 6));
        txtConfirmarPIN.setShowAndHide(true);
        txtConfirmarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmarPINActionPerformed(evt);
            }
        });
        txtConfirmarPIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmarPINKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarPINKeyTyped(evt);
            }
        });
        PanelContenedorCambioContra.add(txtConfirmarPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, 70));

        txtPIN.setBackground(new java.awt.Color(42, 36, 56));
        txtPIN.setForeground(new java.awt.Color(231, 234, 239));
        txtPIN.setCaretColor(new java.awt.Color(231, 234, 239));
        txtPIN.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtPIN.setLabelText("PIN Nuevo");
        txtPIN.setLineColor(new java.awt.Color(231, 234, 239));
        txtPIN.setPreferredSize(new java.awt.Dimension(45, 6));
        txtPIN.setShowAndHide(true);
        txtPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPINActionPerformed(evt);
            }
        });
        txtPIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPINKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPINKeyTyped(evt);
            }
        });
        PanelContenedorCambioContra.add(txtPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 70));

        jPanel1.add(PanelContenedorCambioContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 460, 300));

        PanelContenedorIdiomas.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorIdiomas.setRoundBottomLeft(30);
        PanelContenedorIdiomas.setRoundBottomRight(30);
        PanelContenedorIdiomas.setRoundTopLeft(30);
        PanelContenedorIdiomas.setRoundTopRight(30);
        PanelContenedorIdiomas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdiomas.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblIdiomas.setForeground(new java.awt.Color(231, 234, 239));
        lblIdiomas.setText("Idiomas - Beep&Go");
        PanelContenedorIdiomas.add(lblIdiomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelRound5.setBackground(new java.awt.Color(58, 50, 75));
        panelRound5.setRoundBottomLeft(30);
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        PanelContenedorIdiomas.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 240, 240));

        jPanel1.add(PanelContenedorIdiomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 320, 280, 300));

        PanelContenedorCambioContra1.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorCambioContra1.setRoundBottomLeft(30);
        PanelContenedorCambioContra1.setRoundBottomRight(30);
        PanelContenedorCambioContra1.setRoundTopLeft(30);
        PanelContenedorCambioContra1.setRoundTopRight(30);
        PanelContenedorCambioContra1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCambioClave1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblCambioClave1.setForeground(new java.awt.Color(231, 234, 239));
        lblCambioClave1.setText("Cambio de contraseña");
        PanelContenedorCambioContra1.add(lblCambioClave1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        imgCambio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/reset-adentrosystem.png"))); // NOI18N
        PanelContenedorCambioContra1.add(imgCambio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        txtCambiarContra.setBackground(new java.awt.Color(42, 36, 56));
        txtCambiarContra.setText("Confirmar Cambio");
        txtCambiarContra.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambiarContraActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra1.add(txtCambiarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 245, 140, 40));

        txtConfirmarContra.setBackground(new java.awt.Color(42, 36, 56));
        txtConfirmarContra.setForeground(new java.awt.Color(231, 234, 239));
        txtConfirmarContra.setCaretColor(new java.awt.Color(231, 234, 239));
        txtConfirmarContra.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtConfirmarContra.setLabelText("Confirmar contraseña ");
        txtConfirmarContra.setLineColor(new java.awt.Color(231, 234, 239));
        txtConfirmarContra.setPreferredSize(new java.awt.Dimension(45, 6));
        txtConfirmarContra.setShowAndHide(true);
        txtConfirmarContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtConfirmarContraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConfirmarContraKeyTyped(evt);
            }
        });
        PanelContenedorCambioContra1.add(txtConfirmarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, 70));

        txtContraAntigua.setBackground(new java.awt.Color(42, 36, 56));
        txtContraAntigua.setForeground(new java.awt.Color(231, 234, 239));
        txtContraAntigua.setCaretColor(new java.awt.Color(231, 234, 239));
        txtContraAntigua.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtContraAntigua.setLabelText("Contraseña antigua");
        txtContraAntigua.setLineColor(new java.awt.Color(231, 234, 239));
        txtContraAntigua.setPreferredSize(new java.awt.Dimension(45, 6));
        txtContraAntigua.setShowAndHide(true);
        txtContraAntigua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraAntiguaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraAntiguaKeyTyped(evt);
            }
        });
        PanelContenedorCambioContra1.add(txtContraAntigua, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 180, 70));

        txtContra.setBackground(new java.awt.Color(42, 36, 56));
        txtContra.setForeground(new java.awt.Color(231, 234, 239));
        txtContra.setCaretColor(new java.awt.Color(231, 234, 239));
        txtContra.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtContra.setLabelText("Contraseña nueva");
        txtContra.setLineColor(new java.awt.Color(231, 234, 239));
        txtContra.setPreferredSize(new java.awt.Dimension(45, 6));
        txtContra.setShowAndHide(true);
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });
        PanelContenedorCambioContra1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 70));

        jPanel1.add(PanelContenedorCambioContra1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 320, 460, 300));

        PanelContenedorConfiguracion.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorConfiguracion.setRoundBottomLeft(30);
        PanelContenedorConfiguracion.setRoundBottomRight(30);
        PanelContenedorConfiguracion.setRoundTopLeft(30);
        PanelContenedorConfiguracion.setRoundTopRight(30);
        PanelContenedorConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Indicacion Config.png"))); // NOI18N
        PanelContenedorConfiguracion.add(textoConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        VerificarTipo.setBackground(new java.awt.Color(42, 36, 56));
        VerificarTipo.setText("Verificar mi usuario");
        VerificarTipo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        VerificarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarTipoActionPerformed(evt);
            }
        });
        PanelContenedorConfiguracion.add(VerificarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 170, 50));

        jPanel1.add(PanelContenedorConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 460, 230));

        PanelContenedorTemas.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorTemas.setRoundBottomLeft(30);
        PanelContenedorTemas.setRoundBottomRight(30);
        PanelContenedorTemas.setRoundTopLeft(30);
        PanelContenedorTemas.setRoundTopRight(30);
        PanelContenedorTemas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTemas.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblTemas.setForeground(new java.awt.Color(231, 234, 239));
        lblTemas.setText("Temas - Beep&Go");
        PanelContenedorTemas.add(lblTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelContenedorTemas.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 330, 160));

        panelRound2.setBackground(new java.awt.Color(58, 50, 75));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        PanelContenedorTemas.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 330, 160));

        jPanel1.add(PanelContenedorTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 750, 230));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        PanelFondo.add(jPanel1, gridBagConstraints);

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public static int exitdash = 0;

    public static int getExitdash() {
        return exitdash;
    }
    
    FrmLogin login = new FrmLogin();
  
    private void VerificarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarTipoActionPerformed
        // TODO add your handling code here:
        String tipo = FrmLogin.tipo;
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if(tipo.equals("Root")){
            if(objcon.isVisible()){
                objcon.toFront();
                frame.dispose();
            }else{
                objcon.setVisible(true);
                frame.dispose();
            }
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Permisos insuficientes", "Debe ser un usuario root para acceder a este apartado", 3);
        }
    }//GEN-LAST:event_VerificarTipoActionPerformed

    private void txtUsuarioPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioPINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioPINActionPerformed

    private void txtPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPINActionPerformed

    private void txtConfirmarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmarPINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmarPINActionPerformed

    void CambiarPIN(){
       if(txtPIN.getText().equals("") || txtConfirmarPIN.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Campos vacios");
        }else if(! txtPIN.getText().equals(txtConfirmarPIN.getText())){
            JOptionPane.showMessageDialog(this, "Los PIN no coinciden");
        }else if(txtPIN.getText().length() < 4){
            JOptionPane.showMessageDialog(this, "El PIN ingresado no tiene el formato correcto");
        }else{
            objcontroller.setUsuario(txtUsuarioPIN.getText());
            String PIN = ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(txtPIN.getText());
            objcontroller.setPIN(PIN);
            boolean respuesta = objcontroller.CambiarPIN();
            if(respuesta == true){
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado","PIN actualizado",1);
                txtPIN.setText("");
                txtConfirmarPIN.setText("");
            }else{
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso no pudo ser completado","El PIN no pudo ser actualizado",3);
            }
        } 
    }
    
    private void btnCambiarPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPINActionPerformed
        // TODO add your handling code here
        CambiarPIN();
    }//GEN-LAST:event_btnCambiarPINActionPerformed

    void CargarContraAntigua(){
        ResultSet rs;
        objcontroller.setUsuario(txtUsuarioPIN.getText());
        rs = objcontroller.BuscarContraAntigua();
        try {
            if (rs.next()) {
                ContraA = rs.getString("contraseña");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }
    
    void CambiarContra(){
        if(txtContra.getText().equals("") || txtConfirmarContra.getText().equals("") || txtContraAntigua.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Campos vacios");
        }else if(txtContra.getText().equals(txtContraAntigua.getText())){
            JOptionPane.showMessageDialog(this, "La contraseña a cambiar es igual a la contraseña antigua");
        }else if(! txtContra.getText().equals(txtConfirmarContra.getText())){
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
        }else if(txtContra.getText().length() < 8){
            JOptionPane.showMessageDialog(this, "La contraseña ingresada no tiene el formato correcto");
        }else{
            CargarContraAntigua();
            if(! ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(txtContraAntigua.getText()).equals(ContraA)){
                JOptionPane.showMessageDialog(this, "La contraseña antigua es incorrecta");
            }else{
                String contra = ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(txtContra.getText());
                objcontroller.setUsuario(txtUsuarioPIN.getText());
                objcontroller.setContra(contra);
                
                boolean respuesta = objcontroller.CambiarContra();
                if(respuesta == true){
                    ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado","Su contraseña ha sido actualizada",1);
                    
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();
                    objlog.setVisible(true);
                }else{
                     ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso no pudo ser completado","Su contraseña no pudo ser actualizada",3);
                }
            }
        }
    }
    
    private void txtCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambiarContraActionPerformed
        // TODO add your handling code here:
        CambiarContra();
    }//GEN-LAST:event_txtCambiarContraActionPerformed

    private void txtPINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPINKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ! txtPIN.getText().equals("") && ! txtConfirmarPIN.getText().equals("")) {
            CambiarPIN();
        }else if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtPINKeyPressed

    private void txtConfirmarPINKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarPINKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ! txtPIN.getText().equals("") && ! txtConfirmarPIN.getText().equals("")) {
            CambiarPIN();
        }else if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtConfirmarPINKeyPressed

    private void txtPINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPINKeyTyped
        // TODO add your handling code here:
        if(txtPIN.getText().length() >= 5){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SoloNumeros(evt);
        }
    }//GEN-LAST:event_txtPINKeyTyped

    private void txtConfirmarPINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarPINKeyTyped
        // TODO add your handling code here:
        if(txtConfirmarPIN.getText().length() >= 5){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SoloNumeros(evt);
        }
    }//GEN-LAST:event_txtConfirmarPINKeyTyped

    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        // TODO add your handling code here:
        if(txtContra.getText().length() >= 30){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtContraKeyTyped

    private void txtConfirmarContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarContraKeyTyped
        // TODO add your handling code here:
        if(txtConfirmarContra.getText().length() >= 30){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtConfirmarContraKeyTyped

    private void txtContraAntiguaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraAntiguaKeyTyped
        // TODO add your handling code here:
        if(txtContraAntigua.getText().length() >= 30){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtContraAntiguaKeyTyped

    private void txtContraAntiguaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraAntiguaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ! txtContra.getText().equals("") && ! txtConfirmarContra.getText().equals("") && ! txtContraAntigua.getText().equals("")) {
            CambiarContra();
        }else if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtContraAntiguaKeyPressed

    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ! txtContra.getText().equals("") && ! txtConfirmarContra.getText().equals("") && ! txtContraAntigua.getText().equals("")) {
            CambiarContra();
        }else if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtContraKeyPressed

    private void txtConfirmarContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConfirmarContraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && ! txtContra.getText().equals("") && ! txtConfirmarContra.getText().equals("") && ! txtContraAntigua.getText().equals("")) {
            CambiarContra();
        }else if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtConfirmarContraKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorCambioContra;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorCambioContra1;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorConfiguracion;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorIdiomas;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorTemas;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private Controles_Personalizados.Botones.UWPButton VerificarTipo;
    private Controles_Personalizados.Botones.UWPButton btnCambiarPIN;
    private javax.swing.JLabel imgCambio;
    private javax.swing.JLabel imgCambio1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAjustes;
    private javax.swing.JLabel lblCambioClave;
    private javax.swing.JLabel lblCambioClave1;
    private javax.swing.JLabel lblIdiomas;
    private javax.swing.JLabel lblTemas;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.Paneles.PanelRound panelRound2;
    private Controles_Personalizados.Paneles.PanelRound panelRound5;
    private javax.swing.JLabel textoConfig;
    private Controles_Personalizados.Botones.UWPButton txtCambiarContra;
    private Controles_Personalizados.textfields.PasswordField txtConfirmarContra;
    private Controles_Personalizados.textfields.PasswordField txtConfirmarPIN;
    private Controles_Personalizados.textfields.PasswordField txtContra;
    private Controles_Personalizados.textfields.PasswordField txtContraAntigua;
    private Controles_Personalizados.textfields.PasswordField txtPIN;
    private Controles_Personalizados.textfields.TextField txtUsuarioPIN;
    // End of variables declaration//GEN-END:variables
}

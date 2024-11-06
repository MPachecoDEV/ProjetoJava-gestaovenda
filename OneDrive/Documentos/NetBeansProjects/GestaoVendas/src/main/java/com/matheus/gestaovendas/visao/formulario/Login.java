package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.LoginControlador;
import com.matheus.gestaovendas.visao.componentes.PanelBoard;
import com.matheus.gestaovendas.visao.componentes.PanelLoading;
import com.matheus.gestaovendas.visao.util.MensagemUtil;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

public class Login extends javax.swing.JFrame {
    
    private int x;
    private int y;
    private LoginControlador loginControlador;
    private MigLayout layout;
    private PanelLoading loading;
    private MensagemUtil mostrarMensagem;

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        loginControlador = new LoginControlador(this);
        moveTelaLogin(this);
        
        layout = new MigLayout("fill, insets");
        loading = new PanelLoading();
        background.setLayout(layout);
        background.add(loading, "pos 0 0 100% 100%");
        background.add(panelBoard1, "pos 0 0 100% 100%");
        mostrarMensagem = new MensagemUtil(background, layout);
        fechaTela();
        evento();
    }

    public MensagemUtil getMostrarMensagem() {
        return mostrarMensagem;
    }
   
    private void moveTelaLogin(JFrame frame) {
        panelMovimento.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = getX();
                y = getY();
            }
        });
        
        panelMovimento.addMouseMotionListener(new MouseAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) {
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }
    
    private void evento() {
        botaoLogin.addActionListener(loginControlador);
    }

    public PanelLoading getPanelLoading() {
        return loading;
    }

    public PanelBoard getPanelBoard2() {
        return panelBoard1;
    }
    
    private void fechaTela() {
        labelFechar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Sair", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
        
        labelFechar.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                labelFechar.setBackground(Color.RED);
                labelFechar.setForeground(Color.WHITE);
                labelFechar.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                labelFechar.setBackground(Color.WHITE);
                labelFechar.setForeground(Color.WHITE);
                labelFechar.setOpaque(false);
            }
         });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoard1 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        panelMovimento = new javax.swing.JPanel();
        labelFechar = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        campoDeTextoEmail = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDaSenha = new com.matheus.gestaovendas.visao.componentes.CampoDaSenha();
        botaoLogin = new com.matheus.gestaovendas.visao.componentes.Botao();
        background = new javax.swing.JLayeredPane();

        panelBoard1.setColor1(new java.awt.Color(0, 100, 148));
        panelBoard1.setColor2(new java.awt.Color(0, 53, 84));

        panelMovimento.setOpaque(false);

        labelFechar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelFechar.setForeground(new java.awt.Color(255, 255, 255));
        labelFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFechar.setText("X");

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\Logo_login.png")); // NOI18N

        javax.swing.GroupLayout panelMovimentoLayout = new javax.swing.GroupLayout(panelMovimento);
        panelMovimento.setLayout(panelMovimentoLayout);
        panelMovimentoLayout.setHorizontalGroup(
            panelMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovimentoLayout.createSequentialGroup()
                .addContainerGap(177, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(146, 146, 146)
                .addComponent(labelFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        panelMovimentoLayout.setVerticalGroup(
            panelMovimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovimentoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelMovimentoLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(labelFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        campoDeTextoEmail.setColor(new java.awt.Color(255, 255, 255));
        campoDeTextoEmail.setDica("Email");
        campoDeTextoEmail.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\mail.png")); // NOI18N

        campoDaSenha.setColor(new java.awt.Color(255, 255, 255));
        campoDaSenha.setDica("Senha");
        campoDaSenha.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\pass.png")); // NOI18N
        campoDaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDaSenhaActionPerformed(evt);
            }
        });

        botaoLogin.setBackground(new java.awt.Color(0, 166, 251));
        botaoLogin.setForeground(new java.awt.Color(255, 255, 255));
        botaoLogin.setText("LOGIN");
        botaoLogin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoard1Layout = new javax.swing.GroupLayout(panelBoard1);
        panelBoard1.setLayout(panelBoard1Layout);
        panelBoard1Layout.setHorizontalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMovimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addGroup(panelBoard1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDeTextoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoard1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );
        panelBoard1Layout.setVerticalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard1Layout.createSequentialGroup()
                .addComponent(panelMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(campoDeTextoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(botaoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoLoginActionPerformed

    private void campoDaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDaSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDaSenhaActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoLogin;
    private com.matheus.gestaovendas.visao.componentes.CampoDaSenha campoDaSenha;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoEmail;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFechar;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard1;
    private javax.swing.JPanel panelMovimento;
    // End of variables declaration//GEN-END:variables

    public JButton getBotaoLogin() {
        return botaoLogin;
    }

    public JTextField getCampoTextoLoginEmail() {
        return campoDeTextoEmail;
    }

    public JPasswordField getCampoTextoLoginSenha() {
        return campoDaSenha;
    }
}

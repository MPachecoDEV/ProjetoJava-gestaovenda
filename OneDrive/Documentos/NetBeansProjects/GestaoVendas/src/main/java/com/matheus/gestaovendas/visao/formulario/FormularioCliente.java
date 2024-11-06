package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.FormularioClienteControlador;
import com.matheus.gestaovendas.visao.componentes.BarraDeRolar;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.CampoDeTexto;
import com.matheus.gestaovendas.visao.componentes.Mensagem;
import com.matheus.gestaovendas.visao.componentes.Tabela;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class FormularioCliente extends javax.swing.JPanel {
    
    private final FormularioClienteControlador formularioClienteControlador;
    private int menuSelectionadoIndex = -1;
    private Cabecalho cabecalho;
    private Long usuarioId;
    private MigLayout layout;

    public FormularioCliente(Long usuarioId, Cabecalho cabecalho) {
        initComponents();
        setOpaque(false);
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new BarraDeRolar());
        this.usuarioId = usuarioId;
        
        formularioClienteControlador = new FormularioClienteControlador(this);
        this.cabecalho = cabecalho;
        this.layout = new MigLayout("fill, insets");
        background.setLayout(layout);
        background.add(panelBoard2);
        evento();
        eventoDoTeclado();
    }

    public Cabecalho getCabecalho() {
        return cabecalho;
    }

    public int getMenuSelectionadoIndex() {
        return menuSelectionadoIndex;
    }

    public void setMenuSelectionadoIndex(int menuSelectionadoIndex) {
        this.menuSelectionadoIndex = menuSelectionadoIndex;
    }
    
    public void eventoDoTeclado() {
        cabecalho.getPesquisar().addKeyListener(formularioClienteControlador);
    }

    private void evento() {
        botaoAdicionar.addActionListener(formularioClienteControlador);
        botaoAtualizar.addActionListener(formularioClienteControlador);
        botaoRemover.addActionListener(formularioClienteControlador);
        botaoSalvar.addActionListener(formularioClienteControlador);
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Tabela getTabelaCliente() {
        return tabelaCliente;
    }

    public JButton getBotaoAdicionar() {
        return botaoAdicionar;
    }

    public JButton getBotaoAtualizar() {
        return botaoAtualizar;
    }

    public JDialog getDialogCadastro() {
        return dialogCadastro;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }

    public CampoDeTexto getCampoDeTextoNome() {
        return campoDeTextoNome;
    }

    public CampoDeTexto getCampoDeTextoCPF() {
        return campoDeTextoCPF;
    }

    public CampoDeTexto getCampoDeTextoMorada() {
        return campoDeTextoMorada;
    }
    
    public void mostrMensagem(Mensagem.TipoDeMensagem tipoDeMensagem, String mensagem) {
        Mensagem ms = new Mensagem();
        ms.mostrarMensagem(tipoDeMensagem, mensagem);
        
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isMostrarMensagem()) {
                    background.add(ms, "pos 0.5al 20", 0); // adicionar no primeiro indice
                    ms.setVisible(true);
                    background.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                
                if (ms.isMostrarMensagem()) {
                    f = 20 * (1f - fraction);
                } else {
                    f = 20 * fraction;
                }

                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 20));
                background.repaint();
                background.revalidate();
            }

            @Override
            public void end() {
                if (ms.isMostrarMensagem()) {
                    background.remove(ms);
                    background.repaint();
                    background.revalidate();
                } else {
                    ms.setMostrarMensagem(true);
                }
            }
        };
        
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        
        new Thread(
                () ->{
                    try {
                        Thread.sleep(2000);
                        animator.start();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }).start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCadastro = new javax.swing.JDialog();
        background = new javax.swing.JLayeredPane();
        panelBoard2 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        labelTitulo = new javax.swing.JLabel();
        campoDeTextoNome = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoCPF = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoMorada = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        botaoSalvar = new com.matheus.gestaovendas.visao.componentes.Botao();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        panelBoard1 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new com.matheus.gestaovendas.visao.componentes.Tabela();

        dialogCadastro.setBackground(new java.awt.Color(255, 255, 255));

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dialogCadastroLayout = new javax.swing.GroupLayout(dialogCadastro.getContentPane());
        dialogCadastro.getContentPane().setLayout(dialogCadastroLayout);
        dialogCadastroLayout.setHorizontalGroup(
            dialogCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        dialogCadastroLayout.setVerticalGroup(
            dialogCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        panelBoard2.setColor1(new java.awt.Color(255, 255, 255));
        panelBoard2.setColor2(new java.awt.Color(255, 255, 255));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(5, 130, 202));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Registro de Venda");

        campoDeTextoNome.setForeground(new java.awt.Color(0, 0, 0));
        campoDeTextoNome.setDica("Nome do Cliente");
        campoDeTextoNome.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\user.png")); // NOI18N

        campoDeTextoCPF.setForeground(new java.awt.Color(0, 0, 0));
        campoDeTextoCPF.setDica("CPF");
        campoDeTextoCPF.setName(""); // NOI18N
        campoDeTextoCPF.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\id.png")); // NOI18N

        campoDeTextoMorada.setForeground(new java.awt.Color(0, 0, 0));
        campoDeTextoMorada.setDica("Endereço");
        campoDeTextoMorada.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\morada.png")); // NOI18N

        botaoSalvar.setBackground(new java.awt.Color(5, 130, 202));
        botaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setText("Salvar");
        botaoSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout panelBoard2Layout = new javax.swing.GroupLayout(panelBoard2);
        panelBoard2.setLayout(panelBoard2Layout);
        panelBoard2Layout.setHorizontalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoDeTextoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoDeTextoCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(campoDeTextoMorada, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoard2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );
        panelBoard2Layout.setVerticalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDeTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDeTextoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDeTextoMorada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("> Cliente");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        botaoAdicionar.setBackground(new java.awt.Color(0, 0, 70));
        botaoAdicionar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(botaoAdicionar);

        botaoAtualizar.setBackground(new java.awt.Color(0, 0, 70));
        botaoAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        botaoAtualizar.setText("Atualizar");
        jPanel1.add(botaoAtualizar);

        botaoRemover.setBackground(new java.awt.Color(0, 0, 70));
        botaoRemover.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoRemover.setForeground(new java.awt.Color(255, 255, 255));
        botaoRemover.setText("Remover");
        botaoRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoverActionPerformed(evt);
            }
        });
        jPanel1.add(botaoRemover);

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaCliente);

        javax.swing.GroupLayout panelBoard1Layout = new javax.swing.GroupLayout(panelBoard1);
        panelBoard1.setLayout(panelBoard1Layout);
        panelBoard1Layout.setHorizontalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );
        panelBoard1Layout.setVerticalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoRemover;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoSalvar;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoCPF;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoMorada;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoNome;
    private javax.swing.JDialog dialogCadastro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard1;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard2;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaCliente;
    // End of variables declaration//GEN-END:variables
}

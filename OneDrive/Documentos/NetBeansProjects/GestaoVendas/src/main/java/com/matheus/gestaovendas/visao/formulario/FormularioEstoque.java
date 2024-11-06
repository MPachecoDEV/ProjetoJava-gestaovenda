package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.FormularioEstoqueControlador;
import com.matheus.gestaovendas.visao.componentes.BarraDeRolar;
import com.matheus.gestaovendas.visao.componentes.Botao;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.CampoDeTexto;
import com.matheus.gestaovendas.visao.componentes.Tabela;
import com.matheus.gestaovendas.visao.util.MensagemUtil;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;

public class FormularioEstoque extends javax.swing.JPanel {
    
    private final FormularioEstoqueControlador formularioEstoqueControlador;
    private final FormularioPrincipal formularioPrincipal;
    private int menuSelectionadoIndex = -1;
    private Cabecalho cabecalho;
    private Long usuarioId;
    private MigLayout layout;
    private MensagemUtil mensagem;

    public FormularioEstoque(Long usuarioId, Cabecalho cabecalho, FormularioPrincipal formularioPrincipal) {
        initComponents();
        setOpaque(false);
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new BarraDeRolar());
        this.usuarioId = usuarioId;
        
        this.cabecalho = cabecalho;
        this.formularioPrincipal = formularioPrincipal;
        formularioEstoqueControlador = new FormularioEstoqueControlador(this);
        
        this.layout = new MigLayout("fill, insets");
        background.setLayout(layout);
        background.add(panelBoard2);
        mensagem = new MensagemUtil(background, layout);
        
        evento();
        eventoDoTeclado();
    }

    public FormularioPrincipal getFormularioPrincipal() {
        return formularioPrincipal;
    }
    
    public MensagemUtil getMensagem() {
        return mensagem;
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
    
    private void eventoDoTeclado() {
        cabecalho.getPesquisar().addKeyListener(formularioEstoqueControlador);
        campoDeTextoNome.addKeyListener(formularioEstoqueControlador);
    }
    
    private void eventoCliqueNoMouse() {
        tabelaEstoque.addMouseListener(formularioEstoqueControlador);
    }

    private void evento() {
        botaoAdicionar.addActionListener(formularioEstoqueControlador);
        botaoAtualizar.addActionListener(formularioEstoqueControlador);
        botaoRemover.addActionListener(formularioEstoqueControlador);
        botaoSalvar.addActionListener(formularioEstoqueControlador);
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Tabela getTabela() {
        return tabelaEstoque;
    }

    public JButton getBotaoAdicionar() {
        return botaoAdicionar;
    }

    public JButton getBotaoAtualizar() {
        return botaoAtualizar;
    }
    
    public JButton getBotaoRemover() {
        return botaoRemover;
    }

    public JDialog getDialog() {
        return jDialog1;
    }

    public CampoDeTexto getCampoDeTextoNome() {
        return campoDeTextoNome;
    }

    public CampoDeTexto getCampoDeTextoObservacao() {
        return campoDeTextoObservacao;
    }

    public CampoDeTexto getCampoDeTextoQuantidade() {
        return campoDeTextoQuantidade;
    }

    public JLabel getLabelProduto() {
        return labelProduto;
    }

    public Botao getBotaoSalvar() {
        return botaoSalvar;
    }

    public JRadioButton getRadioAtivo() {
        return radioAtivo;
    }

    public JRadioButton getRadioDesativo() {
        return radioDesativo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        background = new javax.swing.JLayeredPane();
        panelBoard2 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        labelTitulo = new javax.swing.JLabel();
        campoDeTextoNome = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoQuantidade = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoObservacao = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        labelProduto = new javax.swing.JLabel();
        radioAtivo = new javax.swing.JRadioButton();
        radioDesativo = new javax.swing.JRadioButton();
        botaoSalvar = new com.matheus.gestaovendas.visao.componentes.Botao();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        panelBoard1 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEstoque = new com.matheus.gestaovendas.visao.componentes.Tabela();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        panelBoard2.setBackground(new java.awt.Color(255, 255, 255));
        panelBoard2.setColor1(new java.awt.Color(255, 255, 255));
        panelBoard2.setColor2(new java.awt.Color(255, 255, 255));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(0, 153, 153));
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("Registro de Estoque");

        campoDeTextoNome.setDica("Nome/ID do Produto");
        campoDeTextoNome.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\produto1.png")); // NOI18N

        campoDeTextoQuantidade.setDica("Quantidade");
        campoDeTextoQuantidade.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\quantidade.png")); // NOI18N

        campoDeTextoObservacao.setDica("Observação");
        campoDeTextoObservacao.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\observacao.png")); // NOI18N

        buttonGroup1.add(radioAtivo);
        radioAtivo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioAtivo.setForeground(new java.awt.Color(0, 153, 153));
        radioAtivo.setSelected(true);
        radioAtivo.setText("Ativo");

        buttonGroup1.add(radioDesativo);
        radioDesativo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        radioDesativo.setForeground(new java.awt.Color(0, 153, 153));
        radioDesativo.setText("Desativo");

        botaoSalvar.setBackground(new java.awt.Color(0, 53, 84));
        botaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        botaoSalvar.setText("Salvar");
        botaoSalvar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelBoard2Layout = new javax.swing.GroupLayout(panelBoard2);
        panelBoard2.setLayout(panelBoard2Layout);
        panelBoard2Layout.setHorizontalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoard2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addComponent(radioAtivo)
                        .addGap(18, 18, 18)
                        .addComponent(radioDesativo))
                    .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(campoDeTextoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDeTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoDeTextoObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBoard2Layout.setVerticalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoDeTextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDeTextoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoDeTextoObservacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioAtivo)
                    .addComponent(radioDesativo))
                .addGap(0, 0, 0)
                .addComponent(labelProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(botaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("> Estoque");

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

        tabelaEstoque.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaEstoque);

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
    private javax.swing.ButtonGroup buttonGroup1;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoNome;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoObservacao;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoQuantidade;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelTitulo;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard1;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard2;
    private javax.swing.JRadioButton radioAtivo;
    private javax.swing.JRadioButton radioDesativo;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaEstoque;
    // End of variables declaration//GEN-END:variables
}

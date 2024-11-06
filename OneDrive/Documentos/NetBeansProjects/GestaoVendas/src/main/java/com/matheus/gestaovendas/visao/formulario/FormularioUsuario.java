package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.FormularioUsuarioControlador;
import com.matheus.gestaovendas.visao.componentes.BarraDeRolar;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.Tabela;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class FormularioUsuario extends javax.swing.JPanel {
    
    private final FormularioUsuarioControlador formularioUsuarioControlador;
    private int menuSelectionadoIndex = -1;
    private Cabecalho cabecalho;
    private Long usuarioId;

    public FormularioUsuario(Long usuarioId, Cabecalho cabecalho) {
        initComponents();
        setOpaque(false);
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new BarraDeRolar());
        dialogPermissao.setBackground(Color.WHITE);
        dialogCadastro.setResizable(false);
        textoFoto.setColumns(15);
        this.usuarioId = usuarioId;
        
        formularioUsuarioControlador = new FormularioUsuarioControlador(this);
        this.cabecalho = cabecalho;
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
        cabecalho.getPesquisar().addKeyListener(formularioUsuarioControlador);
    }

    private void evento() {
        botaoAdicionar.addActionListener(formularioUsuarioControlador);
        botaoAtualizar.addActionListener(formularioUsuarioControlador);
        botaoPermissao.addActionListener(formularioUsuarioControlador);
        botaoRemover.addActionListener(formularioUsuarioControlador);
        botaoSalvar.addActionListener(formularioUsuarioControlador);
        botaoFoto.addActionListener(formularioUsuarioControlador);
        botaoSalvarPermissao.addActionListener(formularioUsuarioControlador);
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Tabela getTabelaUsuario() {
        return tabelaUsuario;
    }

    public JButton getBotaoAdicionar() {
        return botaoAdicionar;
    }

    public JButton getBotaoAtualizar() {
        return botaoAtualizar;
    }

    public JButton getBotaoPermissao() {
        return botaoPermissao;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }

    public JDialog getDialogCadastro() {
        return dialogCadastro;
    }

    public JTextField getTextoNome() {
        return textoNome;
    }

    public JTextField getTextoEmail() {
        return textoEmail;
    }

    public JPasswordField getTextoSenha() {
        return textoSenha;
    }

    public JComboBox<String> getComboboxPerfil() {
        return comboboxPerfil;
    }

    public JButton getBotaoSalvar() {
        return botaoSalvar;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }

    public JLabel getLabelMensagem() {
        return labelMensagem;
    }

    public JRadioButton getRadioBotaoAtivo() {
        return radioBotaoAtivo;
    }

    public JRadioButton getRadioBotaoDesativo() {
        return radioBotaoDesativo;
    }

    public JDialog getDialogPermissao() {
        return dialogPermissao;
    }

    public JLabel getLabelUsuarioName() {
        return labelUsuarioName;
    }

    public JTextField getTextoFoto() {
        return textoFoto;
    }

    public JButton getBotaoFoto() {
        return botaoFoto;
    }

    public JCheckBox getCheckPermissaoUsuarioSalvar() {
        return checkPermissaoUsuarioSalvar;
    }

    public JCheckBox getCheckPermissaoUsuarioEncontrarSomenteDados() {
        return checkPermissaoUsuarioEncontrarSomenteDados;
    }

    public JCheckBox getCheckPermissaoUsuarioEncontrarTodos() {
        return checkPermissaoUsuarioEncontrarTodos;
    }

    public JCheckBox getCheckPermissaoUsuarioRemover() {
        return checkPermissaoUsuarioRemover;
    }

    public JCheckBox getCheckPermissaoCategoriaRemove() {
        return checkPermissaoCategoriaRemover;
    }

    public JCheckBox getCheckPermissaoCategoriaSalva() {
        return checkPermissaoCategoriaSalvar;
    }

    public JCheckBox getCheckPermissaoVendaRemove() {
        return checkPermissaoVendaRemover;
    }

    public JCheckBox getCheckPermissaoSalva() {
        return checkPermissaoSalvar;
    }

    public JCheckBox getCheckPermissaoClienteRemove() {
        return checkPermissaoClienteRemover;
    }

    public JCheckBox getCheckPermissaoEstoqueRemove() {
        return checkPermissaoEstoqueRemover;
    }

    public JCheckBox getCheckPermissaoEstoqueSalva() {
        return checkPermissaoEstoqueSalvar;
    }

    public JCheckBox getCheckPermissaoProdutoRemove() {
        return checkPermissaoProdutoRemover;
    }

    public JCheckBox getCheckPermissaoProdutoSalva() {
        return checkPermissaoProdutoSalvar;
    }

    public JCheckBox getCheckPermissaoRemove() {
        return checkPermissaoVendaRemover;
    }

    public JCheckBox getCheckPermissaoVendaAtualiza() {
        return checkPermissaoVendaAtualizar;
    }

    public JCheckBox getCheckPermissaoVendaSalva() {
        return checkPermissaoVendaSalvar;
    }

    public JCheckBox getCheckPermissaoEstoqueHistoricoTodo() {
        return checkPermissaoEstoqueHistoricoTodo;
    }

    public JCheckBox getCheckPermissaoEstoqueSomente() {
        return checkPermissaoEstoqueSomente;
    }
    
    public JButton getBotaoSalvaPermissao() {
        return botaoSalvarPermissao;
    }

    public JLabel getLabelPermissaoMensagem() {
        return labelPermissaoMensagem;
    }
    
    
    public List<JCheckBox> allCheckBox() {
        List<JCheckBox> lista = new ArrayList<>();
        
        lista.add(checkPermissaoCategoriaRemover);
        lista.add(checkPermissaoCategoriaSalvar);
        lista.add(checkPermissaoClienteRemover);
        lista.add(checkPermissaoUsuarioEncontrarSomenteDados);
        lista.add(checkPermissaoUsuarioEncontrarTodos);
        lista.add(checkPermissaoUsuarioSalvar);
        lista.add(checkPermissaoUsuarioRemover);
        lista.add(checkPermissaoEstoqueRemover);
        lista.add(checkPermissaoEstoqueSalvar);
        lista.add(checkPermissaoProdutoRemover);
        lista.add(checkPermissaoProdutoSalvar);
        lista.add(checkPermissaoSalvar);
        lista.add(checkPermissaoVendaSalvar);
        lista.add(checkPermissaoVendaAtualizar);
        lista.add(checkPermissaoVendaRemover);
        lista.add(checkPermissaoEstoqueHistoricoTodo);
        lista.add(checkPermissaoEstoqueSomente);
        
        return lista;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogCadastro = new javax.swing.JDialog();
        panelBoard2 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        labelTitulo = new javax.swing.JLabel();
        labelMensagem = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoNome = new javax.swing.JTextField();
        textoEmail = new javax.swing.JTextField();
        textoSenha = new javax.swing.JPasswordField();
        textoFoto = new javax.swing.JTextField();
        botaoFoto = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboboxPerfil = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        radioBotaoAtivo = new javax.swing.JRadioButton();
        radioBotaoDesativo = new javax.swing.JRadioButton();
        botaoSalvar = new javax.swing.JButton();
        dialogPermissao = new javax.swing.JDialog();
        labelUsuarioName = new javax.swing.JLabel();
        labelPermissaoMensagem = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        checkPermissaoUsuarioSalvar = new javax.swing.JCheckBox();
        checkPermissaoUsuarioEncontrarSomenteDados = new javax.swing.JCheckBox();
        checkPermissaoUsuarioEncontrarTodos = new javax.swing.JCheckBox();
        checkPermissaoUsuarioRemover = new javax.swing.JCheckBox();
        checkPermissaoEstoqueSalvar = new javax.swing.JCheckBox();
        checkPermissaoEstoqueRemover = new javax.swing.JCheckBox();
        checkPermissaoEstoqueHistoricoTodo = new javax.swing.JCheckBox();
        checkPermissaoEstoqueSomente = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        checkPermissaoProdutoSalvar = new javax.swing.JCheckBox();
        checkPermissaoProdutoRemover = new javax.swing.JCheckBox();
        checkPermissaoCategoriaSalvar = new javax.swing.JCheckBox();
        checkPermissaoCategoriaRemover = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        checkPermissaoVendaSalvar = new javax.swing.JCheckBox();
        checkPermissaoVendaAtualizar = new javax.swing.JCheckBox();
        checkPermissaoVendaRemover = new javax.swing.JCheckBox();
        checkPermissaoSalvar = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        checkPermissaoClienteRemover = new javax.swing.JCheckBox();
        botaoSalvarPermissao = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        botaoPermissao = new javax.swing.JButton();
        panelBoard1 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuario = new com.matheus.gestaovendas.visao.componentes.Tabela();

        panelBoard2.setBackground(new java.awt.Color(255, 255, 255));
        panelBoard2.setColor1(new java.awt.Color(255, 255, 255));
        panelBoard2.setColor2(new java.awt.Color(255, 255, 255));

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("CADASTRO");

        labelMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Email:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Senha:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Perfil:");

        textoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoSenhaActionPerformed(evt);
            }
        });

        textoFoto.setEnabled(false);

        botaoFoto.setText("Selecionar");
        botaoFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFotoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Foto");

        comboboxPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Perfil", "ADMIN", "PADRAO" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Estado:");

        buttonGroup1.add(radioBotaoAtivo);
        radioBotaoAtivo.setSelected(true);
        radioBotaoAtivo.setText("Ativo");

        buttonGroup1.add(radioBotaoDesativo);
        radioBotaoDesativo.setText("Desativo");

        botaoSalvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoSalvar.setText("Salvar");

        javax.swing.GroupLayout panelBoard2Layout = new javax.swing.GroupLayout(panelBoard2);
        panelBoard2.setLayout(panelBoard2Layout);
        panelBoard2Layout.setHorizontalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoNome)
                                .addComponent(textoEmail)
                                .addComponent(textoSenha)
                                .addComponent(comboboxPerfil, 0, 300, Short.MAX_VALUE))
                            .addGroup(panelBoard2Layout.createSequentialGroup()
                                .addComponent(textoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoFoto))))
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBotaoAtivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioBotaoDesativo)))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBoard2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSalvar)
                .addGap(211, 211, 211))
        );
        panelBoard2Layout.setVerticalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addComponent(labelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(comboboxPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFoto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(radioBotaoAtivo)
                    .addComponent(radioBotaoDesativo))
                .addGap(29, 29, 29)
                .addComponent(botaoSalvar)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogCadastroLayout = new javax.swing.GroupLayout(dialogCadastro.getContentPane());
        dialogCadastro.getContentPane().setLayout(dialogCadastroLayout);
        dialogCadastroLayout.setHorizontalGroup(
            dialogCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogCadastroLayout.setVerticalGroup(
            dialogCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBoard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        dialogPermissao.setTitle("Permissão");
        dialogPermissao.setBackground(new java.awt.Color(255, 255, 255));

        labelUsuarioName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelUsuarioName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUsuarioName.setText("Nome Usuario");

        labelPermissaoMensagem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Usuario");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Estoque");

        checkPermissaoUsuarioSalvar.setText("Salvar");
        checkPermissaoUsuarioSalvar.setName("usuario:salvar"); // NOI18N

        checkPermissaoUsuarioEncontrarSomenteDados.setText("Somente os Proprios dados");
        checkPermissaoUsuarioEncontrarSomenteDados.setName("usuario:somente_proprio"); // NOI18N

        checkPermissaoUsuarioEncontrarTodos.setText("Buscar Todos");
        checkPermissaoUsuarioEncontrarTodos.setName("usuario:buscar_todos"); // NOI18N

        checkPermissaoUsuarioRemover.setText("Remover");
        checkPermissaoUsuarioRemover.setName("usuario:remover"); // NOI18N

        checkPermissaoEstoqueSalvar.setText("Salvar");
        checkPermissaoEstoqueSalvar.setName("estoque:salvar"); // NOI18N

        checkPermissaoEstoqueRemover.setText("Remover");
        checkPermissaoEstoqueRemover.setName("estoque:remover"); // NOI18N

        checkPermissaoEstoqueHistoricoTodo.setText("Todo Historico");
        checkPermissaoEstoqueHistoricoTodo.setName("estoque:todo_historico"); // NOI18N

        checkPermissaoEstoqueSomente.setText("Somente o Proprio");
        checkPermissaoEstoqueSomente.setName("estoque:somente_proprio"); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Produto");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Categoria");

        checkPermissaoProdutoSalvar.setText("Salvar");
        checkPermissaoProdutoSalvar.setName("produto:salvar"); // NOI18N

        checkPermissaoProdutoRemover.setText("Remover");
        checkPermissaoProdutoRemover.setName("produto:remover"); // NOI18N

        checkPermissaoCategoriaSalvar.setText("Salvar");
        checkPermissaoCategoriaSalvar.setName("categoria:salvar"); // NOI18N

        checkPermissaoCategoriaRemover.setText("Remover");
        checkPermissaoCategoriaRemover.setName("categoria:remover"); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Venda");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Permissão");

        checkPermissaoVendaSalvar.setText("Salvar");
        checkPermissaoVendaSalvar.setName("venda:salvar"); // NOI18N

        checkPermissaoVendaAtualizar.setText("Atualizar");
        checkPermissaoVendaAtualizar.setName("venda:atualizar"); // NOI18N

        checkPermissaoVendaRemover.setText("Remover");
        checkPermissaoVendaRemover.setName("venda:remover"); // NOI18N

        checkPermissaoSalvar.setText("Salvar");
        checkPermissaoSalvar.setName("permissao:salvar"); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Cliente");

        checkPermissaoClienteRemover.setText("Remover");
        checkPermissaoClienteRemover.setName("cliente:remover"); // NOI18N

        botaoSalvarPermissao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoSalvarPermissao.setText("Salvar");
        botaoSalvarPermissao.setActionCommand("permissaosalvar");

        javax.swing.GroupLayout dialogPermissaoLayout = new javax.swing.GroupLayout(dialogPermissao.getContentPane());
        dialogPermissao.getContentPane().setLayout(dialogPermissaoLayout);
        dialogPermissaoLayout.setHorizontalGroup(
            dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelUsuarioName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelPermissaoMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(149, 149, 149))
            .addComponent(jSeparator1)
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkPermissaoUsuarioRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoUsuarioEncontrarTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoUsuarioSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoUsuarioEncontrarSomenteDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkPermissaoEstoqueSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoEstoqueRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoEstoqueHistoricoTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoEstoqueSomente, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(137, 137, 137))
            .addComponent(jSeparator2)
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkPermissaoProdutoRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(checkPermissaoProdutoSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkPermissaoCategoriaSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoCategoriaRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(133, 133, 133))
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogPermissaoLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel16))
                    .addGroup(dialogPermissaoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(checkPermissaoClienteRemover))
                    .addGroup(dialogPermissaoLayout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(botaoSalvarPermissao)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkPermissaoVendaRemover, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(checkPermissaoVendaAtualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkPermissaoVendaSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkPermissaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dialogPermissaoLayout.setVerticalGroup(
            dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogPermissaoLayout.createSequentialGroup()
                .addComponent(labelUsuarioName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelPermissaoMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoUsuarioSalvar)
                    .addComponent(checkPermissaoEstoqueSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoUsuarioEncontrarSomenteDados)
                    .addComponent(checkPermissaoEstoqueRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoUsuarioEncontrarTodos)
                    .addComponent(checkPermissaoEstoqueHistoricoTodo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoUsuarioRemover)
                    .addComponent(checkPermissaoEstoqueSomente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoProdutoSalvar)
                    .addComponent(checkPermissaoCategoriaSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoProdutoRemover)
                    .addComponent(checkPermissaoCategoriaRemover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogPermissaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkPermissaoVendaSalvar)
                    .addComponent(checkPermissaoSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkPermissaoVendaAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkPermissaoVendaRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkPermissaoClienteRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(botaoSalvarPermissao)
                .addGap(33, 33, 33))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("> Usuário");

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

        botaoPermissao.setBackground(new java.awt.Color(0, 0, 70));
        botaoPermissao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoPermissao.setForeground(new java.awt.Color(255, 255, 255));
        botaoPermissao.setText("Permissão");
        botaoPermissao.setActionCommand("permissao");
        botaoPermissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPermissaoActionPerformed(evt);
            }
        });
        jPanel1.add(botaoPermissao);

        tabelaUsuario.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaUsuario);

        javax.swing.GroupLayout panelBoard1Layout = new javax.swing.GroupLayout(panelBoard1);
        panelBoard1.setLayout(panelBoard1Layout);
        panelBoard1Layout.setHorizontalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        panelBoard1Layout.setVerticalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
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

    private void botaoPermissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPermissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPermissaoActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void textoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoSenhaActionPerformed

    private void botaoFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoFotoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoFoto;
    private javax.swing.JButton botaoPermissao;
    private javax.swing.JButton botaoRemover;
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JButton botaoSalvarPermissao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkPermissaoCategoriaRemover;
    private javax.swing.JCheckBox checkPermissaoCategoriaSalvar;
    private javax.swing.JCheckBox checkPermissaoClienteRemover;
    private javax.swing.JCheckBox checkPermissaoEstoqueHistoricoTodo;
    private javax.swing.JCheckBox checkPermissaoEstoqueRemover;
    private javax.swing.JCheckBox checkPermissaoEstoqueSalvar;
    private javax.swing.JCheckBox checkPermissaoEstoqueSomente;
    private javax.swing.JCheckBox checkPermissaoProdutoRemover;
    private javax.swing.JCheckBox checkPermissaoProdutoSalvar;
    private javax.swing.JCheckBox checkPermissaoSalvar;
    private javax.swing.JCheckBox checkPermissaoUsuarioEncontrarSomenteDados;
    private javax.swing.JCheckBox checkPermissaoUsuarioEncontrarTodos;
    private javax.swing.JCheckBox checkPermissaoUsuarioRemover;
    private javax.swing.JCheckBox checkPermissaoUsuarioSalvar;
    private javax.swing.JCheckBox checkPermissaoVendaAtualizar;
    private javax.swing.JCheckBox checkPermissaoVendaRemover;
    private javax.swing.JCheckBox checkPermissaoVendaSalvar;
    private javax.swing.JComboBox<String> comboboxPerfil;
    private javax.swing.JDialog dialogCadastro;
    private javax.swing.JDialog dialogPermissao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel labelMensagem;
    private javax.swing.JLabel labelPermissaoMensagem;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelUsuarioName;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard1;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard2;
    private javax.swing.JRadioButton radioBotaoAtivo;
    private javax.swing.JRadioButton radioBotaoDesativo;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaUsuario;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoFoto;
    private javax.swing.JTextField textoNome;
    private javax.swing.JPasswordField textoSenha;
    // End of variables declaration//GEN-END:variables
}

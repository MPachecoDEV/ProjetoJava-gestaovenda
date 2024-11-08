package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.FormularioVendaControlador;
import com.matheus.gestaovendas.modelo.entidade.VendaItem;
import com.matheus.gestaovendas.visao.componentes.BarraDeRolar;
import com.matheus.gestaovendas.visao.componentes.Botao;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.CampoDeTexto;
import com.matheus.gestaovendas.visao.componentes.ComboBox;
import com.matheus.gestaovendas.visao.componentes.Mensagem;
import com.matheus.gestaovendas.visao.componentes.Tabela;
import com.matheus.gestaovendas.visao.util.MensagemUtil;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class FormularioVenda extends javax.swing.JPanel {
    
    private final FormularioVendaControlador formularioVendaControlador;
    private FormularioPrincipal formularioPrincipal;
    private FormularioEstoque formularioEstoque;
    private int menuSelectionadoIndex = -1;
    private boolean mostrar = true;
    private Cabecalho cabecalho;
    private MigLayout layout;
    private Long usuarioId;
    private MensagemUtil mensagem;

    public FormularioVenda(Long usuarioId, Cabecalho cabecalho, 
            FormularioPrincipal formularioPrincipal, FormularioEstoque formularioEstoque) {
        initComponents();
        setOpaque(false);
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new BarraDeRolar());
        this.usuarioId = usuarioId;
        inicializacao();
        
        formularioVendaControlador = new FormularioVendaControlador(this);
        this.formularioPrincipal = formularioPrincipal;
        this.formularioEstoque = formularioEstoque;
        this.cabecalho = cabecalho;
        layout = new MigLayout("fill, insets");
        background.setLayout(layout);
        background.add(panelBoard2, "pos 0 0 100% 100%");
        this.mensagem = new MensagemUtil(background, layout);
        evento();
        eventoDoTeclado();
        
        jScrollPane3.getViewport().setBackground(new Color(0,0,66));
        jScrollPane3.setVerticalScrollBar(new BarraDeRolar());
        jScrollPane3.setHorizontalScrollBar(new BarraDeRolar());               
    }

    public MensagemUtil getMensagem() {
        return mensagem;
    }
    
    private void inicializacao() {
        panelCarrinho.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        panelCarrinho.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                panelCarrinho.setBackground(new Color(0, 0, 70));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                List<VendaItem> vendaItems = new ArrayList<>();
                
                VendaItem vendaItem = new VendaItem();
                vendaItems.add(vendaItem);
                
                if (!vendaItems.isEmpty()) {
                    mostrar = !mostrar;
                    mostrarCarrinho();
                } else {
                    mensagem.mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, "Carrinho vazio!");
                }
            }
        });
        
        panelCarrinho.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                panelCarrinho.setBackground(new Color(28,181,224));
            }
            
        });
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
        cabecalho.getPesquisar().addKeyListener(formularioVendaControlador);
        campoDeTextoBuscarPeloId.addKeyListener(formularioVendaControlador);
        campoDeTextoQuantidade.addKeyListener(formularioVendaControlador);
        campoDeTextoDesconto.addKeyListener(formularioVendaControlador);
        tabelaCarrinho.addMouseListener(formularioVendaControlador);
    }

    private void evento() {
        botaoAdicionar.addActionListener(formularioVendaControlador);
        botaoAtualizar.addActionListener(formularioVendaControlador);
        botaoDetalhes.addActionListener(formularioVendaControlador);
        botaoRemover.addActionListener(formularioVendaControlador);
        botaoAdicionarNoCarrinho.addActionListener(formularioVendaControlador);
        botaoCarrinhoLimpar.addActionListener(formularioVendaControlador);
        botaoCarrinhoRemover.addActionListener(formularioVendaControlador);
        botaoVender.addActionListener(formularioVendaControlador);
        botaoPesquisar.addActionListener(formularioVendaControlador);
        botaoLimpar.addActionListener(formularioVendaControlador);
        comboBoxCategoria.addActionListener(formularioVendaControlador);
        comboBoxProduto.addActionListener(formularioVendaControlador);
    }
    
        public void mostrarCarrinho() {
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!mostrar) {
                    background.add(panelBoard4, "pos 0.5al 240", 0); // adicionar no primeiro indice
                    panelBoard4.setVisible(true);
                    background.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                
                if (mostrar) {
                    f = 240 * (1f - fraction);
                } else {
                    f = 240 * fraction;
                }

                layout.setComponentConstraints(panelBoard4, "pos 0.5al " + (int) (f - 240));
                background.repaint();
                background.revalidate();
            }

            @Override
            public void end() {
                if (mostrar) {
                    background.remove(panelBoard4);
                    background.repaint();
                    background.revalidate();
                } else {
                    mostrar = false;
                }
            }
        };
        
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        
    }

    public FormularioPrincipal getFormularioPrincipal() {
        return formularioPrincipal;
    }

    public FormularioEstoque getFormularioEstoque() {
        return formularioEstoque;
    }
        
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Tabela getTabela() {
        return tabelaVenda;
    }

    public Tabela getTabelaCarrinho() {
        return tabelaCarrinho;
    }
    
    public JButton getBotaoAdicionar() {
        return botaoAdicionar;
    }

    public JButton getBotaoAtualizar() {
        return botaoAtualizar;
    }

    public JButton getBotaoDetalhe() {
        return botaoDetalhes;
    }

    public JButton getBotaoRemover() {
        return botaoRemover;
    }

    public JDialog getDialog() {
        return jDialog1;
    }
    
    public JLabel getLabelProdutoNome() {
        return labelProdutoNome;
    }

    public JLabel getLabelEstoqueQuantidade() {
        return labelEstoqueQuantidade;
    }

    public JLabel getLabelProdutoPreco() {
        return labelProdutoPreco;
    }
    
    public JLabel getLabelVendaTotal() {
        return labelVendaTotal;
    }
    
    public JLabel getLabelVendaValorPago() {
        return labelVendaValorPago;
    }

    public JLabel getLabelVendaDesconto() {
        return labelVendaDesconto;
    }

    public JLabel getLabelVendaTroco() {
        return labelVendaTroco;
    }

    public CampoDeTexto getCampoDeTextoBuscarPeloId() {
        return campoDeTextoBuscarPeloId;
    }

    public CampoDeTexto getCampoDeTextoClienteCPF() {
        return campoDeTextoClienteCPF;
    }

    public CampoDeTexto getCampoDeTextoDesconto() {
        return campoDeTextoDesconto;
    }

    public CampoDeTexto getCampoDeTextoQuantidade() {
        return campoDeTextoQuantidade;
    }

    public CampoDeTexto getCampoDeTextoValorPago() {
        return campoDeTextoValorPago;
    }

    public Botao getBotaoAdicionarNoCarrinho() {
        return botaoAdicionarNoCarrinho;
    }

    public Botao getBotaoCarrinhoLimpar() {
        return botaoCarrinhoLimpar;
    }

    public Botao getBotaoCarrinhoRemover() {
        return botaoCarrinhoRemover;
    }

    public Botao getBotaoLimpar() {
        return botaoLimpar;
    }

    public JButton getBotaoPermissao() {
        return botaoDetalhes;
    }

    public Botao getBotaoVender() {
        return botaoVender;
    }

    public ComboBox getComboBoxCategoria() {
        return comboBoxCategoria;
    }

    public ComboBox getComboBoxProduto() {
        return comboBoxProduto;
    }

    public JDialog getDialogDetalhes() {
        return dialogDetalhes;
    }

    public JLabel getLabelDetalheTotal() {
        return labelDetalheTotal;
    }

    public JLabel getLabelDetalhesAtendente() {
        return labelDetalhesAtendente;
    }

    public JLabel getLabelDetalhesCliente() {
        return labelDetalhesCliente;
    }

    public JLabel getLabelDetalhesData() {
        return labelDetalhesData;
    }

    public JLabel getLabelDetalhesTroco() {
        return labelDetalhesTroco;
    }

    public JLabel getLabelDetalhesValorPago() {
        return labelDetalhesValorPago;
    }

    public JLabel getLabelDetalhesVendaId() {
        return labelDetalhesVendaId;
    }

    public JLabel getLabelQuantidadeCarrinho() {
        return labelQuantidadeCarrinho;
    }
    
    public JList<String> getListaDetalhesVenda() {
        return listaDetalhesVenda;
    }

    public JDateChooser getDataInicial() {
        return dataInicial;
    }

    public JDateChooser getDataFinal() {
        return dataFinal;
    }

    public JButton getBotaoPesquisar() {
        return botaoPesquisar;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        background = new javax.swing.JLayeredPane();
        panelBoard2 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jLabel4 = new javax.swing.JLabel();
        campoDeTextoBuscarPeloId = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        comboBoxCategoria = new com.matheus.gestaovendas.visao.componentes.ComboBox();
        comboBoxProduto = new com.matheus.gestaovendas.visao.componentes.ComboBox();
        campoDeTextoQuantidade = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoDesconto = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoValorPago = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        campoDeTextoClienteCPF = new com.matheus.gestaovendas.visao.componentes.CampoDeTexto();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botaoAdicionarNoCarrinho = new com.matheus.gestaovendas.visao.componentes.Botao();
        botaoVender = new com.matheus.gestaovendas.visao.componentes.Botao();
        botaoLimpar = new com.matheus.gestaovendas.visao.componentes.Botao();
        panelBoard3 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelEstoqueQuantidade = new javax.swing.JLabel();
        labelProdutoPreco = new javax.swing.JLabel();
        labelVendaTotal = new javax.swing.JLabel();
        labelVendaValorPago = new javax.swing.JLabel();
        labelVendaDesconto = new javax.swing.JLabel();
        labelVendaTroco = new javax.swing.JLabel();
        labelProdutoNome = new javax.swing.JLabel();
        panelCarrinho = new com.matheus.gestaovendas.visao.componentes.PanelCiclo();
        labelQuantidadeCarrinho = new javax.swing.JLabel();
        dialogDetalhes = new javax.swing.JDialog();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        labelDetalhesVendaId = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        labelDetalhesCliente = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        labelDetalheTotal = new javax.swing.JLabel();
        labelDetalhesValorPago = new javax.swing.JLabel();
        labelDetalhesTroco = new javax.swing.JLabel();
        labelDetalhesAtendente = new javax.swing.JLabel();
        labelDetalhesData = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaDetalhesVenda = new javax.swing.JList<>();
        panelBoard4 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaCarrinho = new com.matheus.gestaovendas.visao.componentes.Tabela();
        jPanel3 = new javax.swing.JPanel();
        botaoCarrinhoRemover = new com.matheus.gestaovendas.visao.componentes.Botao();
        botaoCarrinhoLimpar = new com.matheus.gestaovendas.visao.componentes.Botao();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        botaoAdicionar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        botaoRemover = new javax.swing.JButton();
        botaoDetalhes = new javax.swing.JButton();
        panelBoard1 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVenda = new com.matheus.gestaovendas.visao.componentes.Tabela();
        jLabel12 = new javax.swing.JLabel();
        dataInicial = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        dataFinal = new com.toedter.calendar.JDateChooser();
        botaoPesquisar = new javax.swing.JButton();

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 130, 202));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Registro de Venda");

        campoDeTextoBuscarPeloId.setDica("Buscar produto pelo ID");
        campoDeTextoBuscarPeloId.setName(""); // NOI18N
        campoDeTextoBuscarPeloId.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\produto1.png")); // NOI18N

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a Categoria", " " }));
        comboBoxCategoria.setActionCommand("comboboxcategoria");

        comboBoxProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione o Produto", " " }));
        comboBoxProduto.setActionCommand("comboboxproduto");

        campoDeTextoQuantidade.setDica("Quantidade");
        campoDeTextoQuantidade.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\quantidade.png")); // NOI18N

        campoDeTextoDesconto.setDica("Desconto");
        campoDeTextoDesconto.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\desconto.png")); // NOI18N

        campoDeTextoValorPago.setDica("Valor Pago");
        campoDeTextoValorPago.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\preco.png")); // NOI18N

        campoDeTextoClienteCPF.setDica("CPF/CNPJ");
        campoDeTextoClienteCPF.setPrefixoIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\id.png")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Detalhes da venda");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        botaoAdicionarNoCarrinho.setBackground(new java.awt.Color(5, 130, 202));
        botaoAdicionarNoCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        botaoAdicionarNoCarrinho.setText("Salvar");
        botaoAdicionarNoCarrinho.setActionCommand("carrinho");
        botaoAdicionarNoCarrinho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(botaoAdicionarNoCarrinho);

        botaoVender.setBackground(new java.awt.Color(5, 130, 202));
        botaoVender.setForeground(new java.awt.Color(255, 255, 255));
        botaoVender.setText("Vender");
        botaoVender.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(botaoVender);

        botaoLimpar.setBackground(new java.awt.Color(5, 130, 202));
        botaoLimpar.setForeground(new java.awt.Color(255, 255, 255));
        botaoLimpar.setText("Limpar");
        botaoLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(botaoLimpar);

        panelBoard3.setBackground(new java.awt.Color(0, 53, 84));
        panelBoard3.setForeground(new java.awt.Color(255, 255, 255));
        panelBoard3.setColor1(new java.awt.Color(0, 53, 84));
        panelBoard3.setColor2(new java.awt.Color(0, 53, 84));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome do Produto: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Qtd. Estoque:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preço:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total da venda:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Valor pago:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Desconto:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Troco:");

        labelEstoqueQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelEstoqueQuantidade.setForeground(new java.awt.Color(255, 255, 255));
        labelEstoqueQuantidade.setText("0");

        labelProdutoPreco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelProdutoPreco.setForeground(new java.awt.Color(255, 255, 255));
        labelProdutoPreco.setText("0");

        labelVendaTotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelVendaTotal.setForeground(new java.awt.Color(255, 255, 255));
        labelVendaTotal.setText("0");

        labelVendaValorPago.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelVendaValorPago.setForeground(new java.awt.Color(255, 255, 255));
        labelVendaValorPago.setText("0");

        labelVendaDesconto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelVendaDesconto.setForeground(new java.awt.Color(255, 255, 255));
        labelVendaDesconto.setText("0");

        labelVendaTroco.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelVendaTroco.setForeground(new java.awt.Color(255, 255, 255));
        labelVendaTroco.setText("0");

        labelProdutoNome.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelBoard3Layout = new javax.swing.GroupLayout(panelBoard3);
        panelBoard3.setLayout(panelBoard3Layout);
        panelBoard3Layout.setHorizontalGroup(
            panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoard3Layout.createSequentialGroup()
                        .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelVendaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelVendaValorPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelVendaDesconto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelVendaTroco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelBoard3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelProdutoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addGroup(panelBoard3Layout.createSequentialGroup()
                        .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12)
                        .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelProdutoPreco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelEstoqueQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelBoard3Layout.setVerticalGroup(
            panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelProdutoNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelEstoqueQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProdutoPreco)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelVendaTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelVendaValorPago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(labelVendaDesconto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelVendaTroco))
                .addGap(16, 16, 16))
        );

        panelCarrinho.setBackground(new java.awt.Color(0, 53, 84));

        labelQuantidadeCarrinho.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelQuantidadeCarrinho.setForeground(new java.awt.Color(255, 255, 255));
        labelQuantidadeCarrinho.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\venda.png")); // NOI18N
        labelQuantidadeCarrinho.setText("0");

        javax.swing.GroupLayout panelCarrinhoLayout = new javax.swing.GroupLayout(panelCarrinho);
        panelCarrinho.setLayout(panelCarrinhoLayout);
        panelCarrinhoLayout.setHorizontalGroup(
            panelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarrinhoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelQuantidadeCarrinho)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCarrinhoLayout.setVerticalGroup(
            panelCarrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarrinhoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(labelQuantidadeCarrinho)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBoard2Layout = new javax.swing.GroupLayout(panelBoard2);
        panelBoard2.setLayout(panelBoard2Layout);
        panelBoard2Layout.setHorizontalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBoard2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelBoard2Layout.createSequentialGroup()
                                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(campoDeTextoBuscarPeloId, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(campoDeTextoClienteCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoDeTextoValorPago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoDeTextoDesconto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoDeTextoQuantidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(panelBoard2Layout.createSequentialGroup()
                                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(comboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelBoard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelBoard2Layout.setVerticalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addComponent(campoDeTextoBuscarPeloId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelBoard2Layout.createSequentialGroup()
                                .addComponent(comboBoxProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(1, 1, 1)))
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoDeTextoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDeTextoDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDeTextoValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoDeTextoClienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelBoard3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 0, 66));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SOFT");

        labelDetalhesVendaId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetalhesVendaId.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalhesVendaId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDetalhesVendaId.setText("Extrato No.");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        labelDetalhesCliente.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalhesCliente.setText("CPF/CNPJ do consumidor:");

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        labelDetalheTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetalheTotal.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalheTotal.setText("TOTAL R$");

        labelDetalhesValorPago.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalhesValorPago.setText("Valor Pago:");

        labelDetalhesTroco.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalhesTroco.setText("Troco:");

        labelDetalhesAtendente.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalhesAtendente.setText("Atendente:");

        labelDetalhesData.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelDetalhesData.setForeground(new java.awt.Color(255, 255, 255));
        labelDetalhesData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(0, 0, 70));
        jScrollPane3.setBorder(null);
        jScrollPane3.setOpaque(false);

        listaDetalhesVenda.setBackground(new java.awt.Color(0, 0, 70));
        listaDetalhesVenda.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        listaDetalhesVenda.setForeground(new java.awt.Color(255, 255, 255));
        listaDetalhesVenda.setOpaque(false);
        jScrollPane3.setViewportView(listaDetalhesVenda);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(labelDetalhesVendaId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addComponent(labelDetalhesData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(labelDetalhesCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDetalhesAtendente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDetalhesTroco, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDetalhesValorPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDetalheTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelDetalhesVendaId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelDetalhesCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelDetalheTotal)
                .addGap(0, 0, 0)
                .addComponent(labelDetalhesValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelDetalhesTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelDetalhesAtendente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelDetalhesData, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogDetalhesLayout = new javax.swing.GroupLayout(dialogDetalhes.getContentPane());
        dialogDetalhes.getContentPane().setLayout(dialogDetalhesLayout);
        dialogDetalhesLayout.setHorizontalGroup(
            dialogDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDetalhesLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dialogDetalhesLayout.setVerticalGroup(
            dialogDetalhesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogDetalhesLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        panelBoard4.setColor1(new java.awt.Color(255, 255, 255));
        panelBoard4.setColor2(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(5, 130, 202));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Checkout");

        tabelaCarrinho.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaCarrinho);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        botaoCarrinhoRemover.setBackground(new java.awt.Color(5, 130, 202));
        botaoCarrinhoRemover.setForeground(new java.awt.Color(255, 255, 255));
        botaoCarrinhoRemover.setText("removercarrinho");
        botaoCarrinhoRemover.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel3.add(botaoCarrinhoRemover);

        botaoCarrinhoLimpar.setBackground(new java.awt.Color(5, 130, 202));
        botaoCarrinhoLimpar.setForeground(new java.awt.Color(255, 255, 255));
        botaoCarrinhoLimpar.setText("Limpar");
        botaoCarrinhoLimpar.setActionCommand("limparcarrinho");
        botaoCarrinhoLimpar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel3.add(botaoCarrinhoLimpar);

        javax.swing.GroupLayout panelBoard4Layout = new javax.swing.GroupLayout(panelBoard4);
        panelBoard4.setLayout(panelBoard4Layout);
        panelBoard4Layout.setHorizontalGroup(
            panelBoard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelBoard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelBoard4Layout.setVerticalGroup(
            panelBoard4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("> Venda");

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

        botaoDetalhes.setBackground(new java.awt.Color(0, 0, 70));
        botaoDetalhes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoDetalhes.setForeground(new java.awt.Color(255, 255, 255));
        botaoDetalhes.setText("Detalhes");
        botaoDetalhes.setActionCommand("detalhes");
        botaoDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDetalhesActionPerformed(evt);
            }
        });
        jPanel1.add(botaoDetalhes);

        tabelaVenda.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaVenda);

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
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jLabel12.setText("Data inicial:");

        jLabel13.setText("Data final:");

        botaoPesquisar.setBackground(new java.awt.Color(0, 0, 70));
        botaoPesquisar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        botaoPesquisar.setText("Pesquisar");
        botaoPesquisar.setActionCommand("pesquisar");
        botaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                    .addComponent(panelBoard1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoPesquisar)))
                    .addComponent(dataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoverActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoRemoverActionPerformed

    private void botaoDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDetalhesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoDetalhesActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    private javax.swing.JButton botaoAdicionar;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoAdicionarNoCarrinho;
    private javax.swing.JButton botaoAtualizar;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoCarrinhoLimpar;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoCarrinhoRemover;
    private javax.swing.JButton botaoDetalhes;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoLimpar;
    private javax.swing.JButton botaoPesquisar;
    private javax.swing.JButton botaoRemover;
    private com.matheus.gestaovendas.visao.componentes.Botao botaoVender;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoBuscarPeloId;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoClienteCPF;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoDesconto;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoQuantidade;
    private com.matheus.gestaovendas.visao.componentes.CampoDeTexto campoDeTextoValorPago;
    private com.matheus.gestaovendas.visao.componentes.ComboBox comboBoxCategoria;
    private com.matheus.gestaovendas.visao.componentes.ComboBox comboBoxProduto;
    private com.toedter.calendar.JDateChooser dataFinal;
    private com.toedter.calendar.JDateChooser dataInicial;
    private javax.swing.JDialog dialogDetalhes;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel labelDetalheTotal;
    private javax.swing.JLabel labelDetalhesAtendente;
    private javax.swing.JLabel labelDetalhesCliente;
    private javax.swing.JLabel labelDetalhesData;
    private javax.swing.JLabel labelDetalhesTroco;
    private javax.swing.JLabel labelDetalhesValorPago;
    private javax.swing.JLabel labelDetalhesVendaId;
    private javax.swing.JLabel labelEstoqueQuantidade;
    private javax.swing.JLabel labelProdutoNome;
    private javax.swing.JLabel labelProdutoPreco;
    private javax.swing.JLabel labelQuantidadeCarrinho;
    private javax.swing.JLabel labelVendaDesconto;
    private javax.swing.JLabel labelVendaTotal;
    private javax.swing.JLabel labelVendaTroco;
    private javax.swing.JLabel labelVendaValorPago;
    private javax.swing.JList<String> listaDetalhesVenda;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard1;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard2;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard3;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard4;
    private com.matheus.gestaovendas.visao.componentes.PanelCiclo panelCarrinho;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaCarrinho;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaVenda;
    // End of variables declaration//GEN-END:variables
}

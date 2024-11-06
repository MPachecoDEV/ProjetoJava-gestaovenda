package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.FormularioPrincipalControlador;
import com.matheus.gestaovendas.visao.componentes.BarraDeRolar;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.Cartao;
import com.matheus.gestaovendas.visao.componentes.Tabela;
import com.matheus.gestaovendas.visao.modelo.CartaoModelo;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FormularioPrincipal extends javax.swing.JPanel {
    
    private String totalProduto;
    private String totalEstoque;
    private String totalVenda;
    private FormularioPrincipalControlador controlador;
    private Long usuarioId;
    private Cabecalho cabecalho;
    private int menuSelectionadoIndex = 0;

    public FormularioPrincipal(Long usuarioId, Cabecalho cabecalho) {
        initComponents();
        setOpaque(false);
        
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new BarraDeRolar());
        this.usuarioId = usuarioId;
        this.cabecalho = cabecalho;
        controlador = new FormularioPrincipalControlador(this);
        inicializarCartao();
        
        evento();
        eventoDoTeclado();
    }

    public int getMenuSelectionadoIndex() {
        return menuSelectionadoIndex;
    }

    public void setMenuSelectionadoIndex(int menuSelectionadoIndex) {
        this.menuSelectionadoIndex = menuSelectionadoIndex;
    }
    
    private void eventoDoTeclado() {
        cabecalho.getPesquisar().addKeyListener(controlador);
    }

    private void inicializarCartao() {
        cartao2.setData(new CartaoModelo(new ImageIcon(path() + "\\venda.png"), "Venda", totalVenda));
        cartao3.setData(new CartaoModelo(new ImageIcon(path() + "\\stock.png"), "Estoque", totalEstoque));
        cartao1.setData(new CartaoModelo(new ImageIcon(path() + "\\produto.png"), "Produto", totalProduto));
    }
    
    private void evento() {
        cartao1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                cartao1.setBackground(new Color(242,242,242));
                cartao1.setColor1(new Color(0,180,219));
            }
        });
        
        cartao1.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cartao1.setColor1(new Color(255, 228, 122));
                cartao1.setBackground(Color.WHITE);
            }
        });
       
        cartao2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                cartao2.setBackground(new Color(242,242,242));
                cartao2.setColor1(new Color(48,43,99));
            }
        });
        
        cartao2.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cartao2.setColor1(new Color(255, 228, 122));
                cartao2.setBackground(Color.WHITE);
            }
        });
        
        cartao3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                cartao3.setBackground(new Color(242,242,242));
                cartao3.setColor1(new Color(176,106,179));
            }
        });
        
        cartao3.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                cartao3.setColor1(new Color(255, 228, 122));
                cartao3.setBackground(Color.WHITE);
            }
        });
    }

    public Cabecalho getCabecalho() {
        return cabecalho;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
    
    public void setTotalEstoque(String totalEstoque) {
        this.totalEstoque = totalEstoque;
    }

    public void setTotalProduto(String totalProduto) {
        this.totalProduto = totalProduto;
    }

    public void setTotalVenda(String totalVenda) {
        this.totalVenda = totalVenda;
    }
    
    private String path() {
        return System.getProperty("user.dir") + "\\src\\main\\java\\com\\mathe8s\\gestaovendas\\visao\\icon";
    }

    public Cartao getCartao1() {
        return cartao1;
    }

    public void setCartao1(Cartao cartao1) {
        this.cartao1 = cartao1;
    }

    public Cartao getCartao2() {
        return cartao2;
    }

    public void setCartao2(Cartao cartao2) {
        this.cartao2 = cartao2;
    }

    public Cartao getCartao3() {
        return cartao3;
    }

    public void setCartao3(Cartao cartao3) {
        this.cartao3 = cartao3;
    }

    public Tabela getTabela() { 
        return tabelaHistoricoEstoque;
    }

    public JLabel getLabelTitulo() {
        return labelTitulo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cartao1 = new com.matheus.gestaovendas.visao.componentes.Cartao();
        cartao2 = new com.matheus.gestaovendas.visao.componentes.Cartao();
        cartao3 = new com.matheus.gestaovendas.visao.componentes.Cartao();
        panelBoard2 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        labelTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaHistoricoEstoque = new com.matheus.gestaovendas.visao.componentes.Tabela();

        jPanel1.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        cartao1.setColor1(new java.awt.Color(0, 166, 251));
        cartao1.setColor2(new java.awt.Color(0, 0, 0));
        jPanel1.add(cartao1);

        cartao2.setColor1(new java.awt.Color(255, 255, 0));
        cartao2.setColor2(new java.awt.Color(0, 0, 0));
        jPanel1.add(cartao2);

        cartao3.setColor1(new java.awt.Color(255, 0, 51));
        cartao3.setColor2(new java.awt.Color(0, 0, 0));
        jPanel1.add(cartao3);

        labelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        labelTitulo.setForeground(new java.awt.Color(153, 153, 153));
        labelTitulo.setText("Historico do estoque");

        tabelaHistoricoEstoque.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaHistoricoEstoque);

        javax.swing.GroupLayout panelBoard2Layout = new javax.swing.GroupLayout(panelBoard2);
        panelBoard2.setLayout(panelBoard2Layout);
        panelBoard2Layout.setHorizontalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBoard2Layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        panelBoard2Layout.setVerticalGroup(
            panelBoard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelBoard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoard2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.matheus.gestaovendas.visao.componentes.Cartao cartao1;
    private com.matheus.gestaovendas.visao.componentes.Cartao cartao2;
    private com.matheus.gestaovendas.visao.componentes.Cartao cartao3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitulo;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard2;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaHistoricoEstoque;
    // End of variables declaration//GEN-END:variables
}

package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.FormularioRelatorioControlador;
import com.matheus.gestaovendas.visao.componentes.BarraDeRolar;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.ComboBox;
import com.matheus.gestaovendas.visao.componentes.Tabela;
import java.awt.Color;
import javax.swing.JButton;

public class FormularioRelatorio extends javax.swing.JPanel {

    private int menuSelectionadoIndex = -1;
    private Cabecalho cabecalho;
    private FormularioRelatorioControlador formularioRelatorioControlador;
    private Long usuarioId;  
    
    
    public FormularioRelatorio(Long usuarioId, Cabecalho cabecalho) {
        initComponents();
        setOpaque(false); 
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        jScrollPane1.setVerticalScrollBar(new BarraDeRolar());
        
        this.usuarioId = usuarioId;
        formularioRelatorioControlador = new FormularioRelatorioControlador(this);
        comboBoxRelatorio.addActionListener(formularioRelatorioControlador);   
        botaoGerarPDF.addActionListener(formularioRelatorioControlador);
    }

    public JButton getBotaoGerarPDF() {
        return botaoGerarPDF;
    }

    public ComboBox getComboBoxRelatorio() {
        return comboBoxRelatorio;
    }

    public Tabela getTabelaRelatorio() {
        return tabelaRelatorio;
    }
    
    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setMenuSelectionadoIndex(int menuSelectionadoIndex) {
        this.menuSelectionadoIndex = menuSelectionadoIndex;
    }

    public int getMenuSelectionadoIndex() {
        return menuSelectionadoIndex;
    }
    
    private void eventoDoTeclado() {
        cabecalho.getPesquisar().addKeyListener(formularioRelatorioControlador);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoard1 = new com.matheus.gestaovendas.visao.componentes.PanelBoard();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaRelatorio = new com.matheus.gestaovendas.visao.componentes.Tabela();
        jLabel4 = new javax.swing.JLabel();
        comboBoxRelatorio = new com.matheus.gestaovendas.visao.componentes.ComboBox();
        botaoGerarPDF = new javax.swing.JButton();

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setOpaque(false);

        tabelaRelatorio.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelaRelatorio.setOpaque(false);
        jScrollPane1.setViewportView(tabelaRelatorio);

        javax.swing.GroupLayout panelBoard1Layout = new javax.swing.GroupLayout(panelBoard1);
        panelBoard1.setLayout(panelBoard1Layout);
        panelBoard1Layout.setHorizontalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panelBoard1Layout.setVerticalGroup(
            panelBoard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoard1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 130, 202));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Relatorio");

        comboBoxRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        comboBoxRelatorio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a Tabela", "Produto", "Cliente", "Usuario", "Venda", "Estoque", "EstoqueHistorico" }));
        comboBoxRelatorio.setActionCommand("combobox");

        botaoGerarPDF.setBackground(new java.awt.Color(0, 0, 70));
        botaoGerarPDF.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botaoGerarPDF.setForeground(new java.awt.Color(255, 255, 255));
        botaoGerarPDF.setText("Gerar PDF");
        botaoGerarPDF.setActionCommand("gerarpdf");
        botaoGerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboBoxRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoGerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoGerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBoard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoGerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarPDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoGerarPDFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoGerarPDF;
    private com.matheus.gestaovendas.visao.componentes.ComboBox comboBoxRelatorio;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.matheus.gestaovendas.visao.componentes.PanelBoard panelBoard1;
    private com.matheus.gestaovendas.visao.componentes.Tabela tabelaRelatorio;
    // End of variables declaration//GEN-END:variables
}

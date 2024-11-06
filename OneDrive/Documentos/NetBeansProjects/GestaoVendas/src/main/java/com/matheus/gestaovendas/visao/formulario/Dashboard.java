package com.matheus.gestaovendas.visao.formulario;

import com.matheus.gestaovendas.Controlador.DashboardControlador;
import com.matheus.gestaovendas.modelo.entidade.Usuario;
import com.matheus.gestaovendas.visao.componentes.Cabecalho;
import com.matheus.gestaovendas.visao.componentes.Menu;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Dashboard extends javax.swing.JFrame {
    private DashboardControlador dashboardControlador;
    private Formulario formulario;
    private FormularioProduto formularioProduto;
    private FormularioEstoque formularioEstoque;
    private FormularioCliente formularioCliente;
    private FormularioVenda formularioVenda;
    private FormularioPrincipal formularioPrincipal;
    private FormularioUsuario formularioUsuario;
    private FormularioRelatorio formularioRelatorio;
    private Usuario usuario;
    private int menuSelecionadoIndex = 0;

    public Dashboard(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
        inicializaFormulario(usuario.getId(), cabecalho1, this);
        menu1.addEventoMenuSelecionado(e -> {
            menuSelecionadoIndex = e;
            formularioUsuario.setMenuSelectionadoIndex(e);
            formularioCliente.setMenuSelectionadoIndex(e);
            formularioProduto.setMenuSelectionadoIndex(e);
            formularioEstoque.setMenuSelectionadoIndex(e);
            formularioVenda.setMenuSelectionadoIndex(e);
            formularioPrincipal.setMenuSelectionadoIndex(e);
            formularioRelatorio.setMenuSelectionadoIndex(e);
            System.out.println(e);
           switch (e) {
               case 0 -> { setForm(formularioPrincipal); }
               case 1 -> { setForm(formularioProduto); }
               case 2 -> { setForm(formularioEstoque); }
               case 3 -> { setForm(formularioCliente); }
               case 4 -> { setForm(formularioVenda); }
               case 5 -> { setForm(formularioUsuario); }
               case 10 -> { setForm(formularioRelatorio);}
               case 11 -> { fecharTela();}
            }
        });
        
        setForm(formularioPrincipal);
        
        if (usuario == null) 
            throw new RuntimeException("Usuario deve estar logado");
        
        this.usuario = usuario;
        menu1.inicializar(usuario);
        dashboardControlador = new DashboardControlador(this);
    }

    private void fecharTela() {
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza?", "Sair", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }   

    private void inicializaFormulario(Long usuarioId, Cabecalho cabecalho, Dashboard dashboard) {
        System.out.println("DASHBOARD: " + usuarioId);
        formularioPrincipal = new FormularioPrincipal(usuarioId, cabecalho);
        formularioProduto = new FormularioProduto(usuarioId, cabecalho, dashboard);
        formularioEstoque = new FormularioEstoque(usuarioId, cabecalho, formularioPrincipal);
        formularioCliente = new FormularioCliente(usuarioId, cabecalho);
        formularioVenda = new FormularioVenda(usuarioId, cabecalho, formularioPrincipal, formularioEstoque);
        formularioUsuario = new FormularioUsuario(usuarioId, cabecalho);
        formularioRelatorio = new FormularioRelatorio(usuarioId, cabecalho);
        
        formulario = new Formulario(formularioProduto);
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setForm(JComponent component) {
        panelPrincipal.removeAll();
        panelPrincipal.add(component);
        panelPrincipal.repaint();
        panelPrincipal.revalidate();
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Menu getMenu() {
        return menu1;
    }

    public FormularioUsuario getFormularioUsuario() {
        return formularioUsuario;
    }

    public Cabecalho getCabecalho() {
        return cabecalho1;
    }

    public int getMenuSelectionadoIndex() {
        return menuSelecionadoIndex;
    }

    public FormularioPrincipal getFormularioPrincipal() {
        return formularioPrincipal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cabecalho1 = new com.matheus.gestaovendas.visao.componentes.Cabecalho();
        panelPrincipal = new javax.swing.JPanel();
        menu1 = new com.matheus.gestaovendas.visao.componentes.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelPrincipal.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(menu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cabecalho1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(menu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.matheus.gestaovendas.visao.componentes.Cabecalho cabecalho1;
    private com.matheus.gestaovendas.visao.componentes.Menu menu1;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}

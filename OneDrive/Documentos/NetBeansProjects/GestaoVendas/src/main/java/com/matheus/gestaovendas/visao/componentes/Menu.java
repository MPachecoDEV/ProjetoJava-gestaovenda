package com.matheus.gestaovendas.visao.componentes;

import com.matheus.gestaovendas.modelo.entidade.Usuario;
import com.matheus.gestaovendas.visao.evento.EventoMenuSelecionado;
import com.matheus.gestaovendas.visao.modelo.MenuModelo;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static com.matheus.gestaovendas.visao.modelo.MenuModelo.TipoMenu.MENU;
import static com.matheus.gestaovendas.visao.modelo.MenuModelo.TipoMenu.VAZIO;
import java.awt.RenderingHints;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Menu extends javax.swing.JPanel {
    
    private EventoMenuSelecionado evento;

    public Menu() { 
        initComponents();
        setOpaque(false);
        jPanel1.setOpaque(false);
        listaMenu1.setOpaque(false);
        inicializarMenu();
    }
    
    public void inicializar(Usuario usuario) {
        labelNomeDoUsuario.setText(usuario.getNome());
        if(usuario.getUrlFoto() != null && !usuario.getUrlFoto().isBlank()) {
            try {
                File file = new File(usuario.getUrlFoto());
                if (file.isFile())  {
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    imageAvatar1.setImage(icon);
                }
            } catch (Exception e) {
                System.out.println("Error ao carregar imagem do usuario: " + e);
            }
        }
    }

    public JLabel getLabelNomeDoUsuario() {
        return labelNomeDoUsuario;
    }    
    
    private void inicializarMenu() {
        listaMenu1.adicionarItem(new MenuModelo("1", "Dashboard", MENU));
        listaMenu1.adicionarItem(new MenuModelo("2", "Produto", MENU));
        listaMenu1.adicionarItem(new MenuModelo("3", "Estoque", MENU));
        listaMenu1.adicionarItem(new MenuModelo("4", "Cliente", MENU));
        listaMenu1.adicionarItem(new MenuModelo("5", "Venda", MENU));
        listaMenu1.adicionarItem(new MenuModelo("6", "Usuário", MENU));
        
        listaMenu1.adicionarItem(new MenuModelo("", "", VAZIO));
        listaMenu1.adicionarItem(new MenuModelo("", "", VAZIO));
        listaMenu1.adicionarItem(new MenuModelo("", "", VAZIO));
        listaMenu1.adicionarItem(new MenuModelo("", "", VAZIO));
        listaMenu1.adicionarItem(new MenuModelo("8", "Relatório", MENU));
        listaMenu1.adicionarItem(new MenuModelo("10", "Sair", MENU));
    }
    
    public void addEventoMenuSelecionado(EventoMenuSelecionado evento) {
        this.evento = evento;
        listaMenu1.addEventoMenuSelecionado(evento);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("#0582CA"), 0, getHeight(), Color.decode("#003554"));
        graphics2D.setPaint(gradientPaint);
        
        graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        graphics2D.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
        
        super.paintComponent(g); 
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        labelNomeDoUsuario = new javax.swing.JLabel();
        imageAvatar1 = new com.matheus.gestaovendas.visao.componentes.ImageAvatar();
        listaMenu1 = new com.matheus.gestaovendas.visao.componentes.ListaMenu<>();

        setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\Logo_login.png")); // NOI18N
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        labelNomeDoUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelNomeDoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        labelNomeDoUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeDoUsuario.setText("Nome do Usuario");

        imageAvatar1.setImage(new javax.swing.ImageIcon("C:\\Users\\mathe\\OneDrive\\Documentos\\NetBeansProjects\\GestaoVendas\\src\\main\\java\\com\\matheus\\gestaovendas\\visao\\icon\\FotoPadrao_Usuario.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(labelNomeDoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
            .addComponent(listaMenu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNomeDoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(listaMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.matheus.gestaovendas.visao.componentes.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelNomeDoUsuario;
    private com.matheus.gestaovendas.visao.componentes.ListaMenu<String> listaMenu1;
    // End of variables declaration//GEN-END:variables
}

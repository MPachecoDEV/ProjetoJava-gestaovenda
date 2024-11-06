package com.matheus.gestaovendas.visao.componentes;

import com.matheus.gestaovendas.visao.modelo.MenuModelo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static com.matheus.gestaovendas.visao.modelo.MenuModelo.TipoMenu.*;
import java.awt.Font;
import java.awt.RenderingHints;

public class MenuItem extends javax.swing.JPanel {
    
    private boolean selected;
    private boolean over;

    public MenuItem(MenuModelo menuModelo) {
        initComponents();
        setOpaque(false); 
        
        switch(menuModelo.getTipoMenu()) {
            case MENU -> {
                labelMenuItemIcon.setIcon(menuModelo.toIcon());
                labelMenuItem.setText(menuModelo.getNome());
            }
            case TITULO -> {
                labelMenuItemIcon.setText(menuModelo.getNome());
                labelMenuItemIcon.setFont(new Font("sanserif", 1, 12));
                labelMenuItem.setVisible(false);
            }
            case VAZIO -> {
                labelMenuItem.setText(" ");
            }
        }
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public void setOver(boolean over) {
        this.over = over;
        repaint();
    }    

    @Override
    protected void paintComponent(Graphics g) {
        if (selected || over) {
            Graphics2D graphics2D = (Graphics2D) g;
        
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            if (selected) {
                graphics2D.setColor(new Color(255, 255, 255, 80));
            } else{
                graphics2D.setColor(new Color(255, 255, 255, 20));
            }
            
            graphics2D.fillRoundRect(10, 0, getWidth() - 20, getHeight(), 5, 5);
        }
        super.paintComponent(g); 
    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMenuItemIcon = new javax.swing.JLabel();
        labelMenuItem = new javax.swing.JLabel();

        setOpaque(false);

        labelMenuItemIcon.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuItemIcon.setText(" ");

        labelMenuItem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelMenuItem.setForeground(new java.awt.Color(255, 255, 255));
        labelMenuItem.setText("Menu item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(labelMenuItemIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(labelMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMenuItemIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelMenuItem;
    private javax.swing.JLabel labelMenuItemIcon;
    // End of variables declaration//GEN-END:variables
}

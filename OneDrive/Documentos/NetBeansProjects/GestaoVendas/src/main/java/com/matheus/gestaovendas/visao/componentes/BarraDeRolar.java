package com.matheus.gestaovendas.visao.componentes;

import com.matheus.gestaovendas.visao.componentes.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class BarraDeRolar extends JScrollBar {

    public BarraDeRolar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setBackground(new Color(242, 242, 242));
        setUnitIncrement(20);
    }
    
    
}

package com.matheus.gestaovendas.Controlador;

//import com.dxc.gestao.venda.controlador.FormularioUsuarioControlador;
import com.matheus.gestaovendas.modelo.entidade.Usuario;
import com.matheus.gestaovendas.visao.formulario.Dashboard;

public class DashboardControlador {
    
    private static Dashboard dashboard;
//    private final FormularioUsuarioControlador formularioUsuarioControlador;

    public DashboardControlador(Dashboard dashboard) {
        DashboardControlador.dashboard = dashboard;
//        formularioUsuarioControlador = new FormularioUsuarioControlador(dashboard.getFormularioUsuario());
    }

    public Dashboard getDashboard() {
        return dashboard;
    }
    
    public static void inicializarMenu(Usuario usuario) {
        dashboard.getMenu().inicializar(usuario);
    }

}
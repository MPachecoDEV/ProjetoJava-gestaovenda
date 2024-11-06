package com.matheus.gestaovendas.Controlador;

import com.matheus.gestaovendas.modelo.dto.LoginResponse;
import com.matheus.gestaovendas.modelo.servico.LoginServico;
import com.matheus.gestaovendas.visao.componentes.Mensagem;
import com.matheus.gestaovendas.visao.formulario.Dashboard;
import com.matheus.gestaovendas.visao.formulario.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginControlador implements ActionListener{
    
    private Login login;
    private LoginServico loginServico;

    public LoginControlador(Login login) {
        this.login = login;
        loginServico = new LoginServico();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch(e.getActionCommand().toLowerCase()) {
            case "login" -> {
                login();
            }
        }
        
    }
    
    private void login() {
        validaCampos();
        String email = login.getCampoTextoLoginEmail().getText();
        String senha = String.valueOf(login.getCampoTextoLoginSenha().getPassword());
        LoginResponse loginResponse = loginServico.login(email, senha);
        if (loginResponse.isResposta()) {
            login.getMostrarMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.SUCESSO, "Login com sucesso!");
            login.getPanelLoading().setVisible(true);
            new Thread(
                    () -> {
                        try {
                            Thread.sleep(2000);
                            login.setVisible(false);
                            limpaTela();
                            new Dashboard(loginResponse.getUsuario()).setVisible(true);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(LoginControlador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
            ).start();
        } else {
            login.getMostrarMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, "Email ou Senha invalida...");
        }
    }

    private void limpaTela() {
        login.getCampoTextoLoginEmail().setText("");
        login.getCampoTextoLoginSenha().setText("");
    }

    private void validaCampos() {
        String email = login.getCampoTextoLoginEmail().getText();
        String senha = login.getCampoTextoLoginSenha().getText();

        if (email.isBlank() || senha.isBlank()) {
            String mensagem = "Os campos email e senha são obrigatorios...";
            login.getMostrarMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, mensagem);
            throw new RuntimeException(mensagem);
        }
    }
    
}

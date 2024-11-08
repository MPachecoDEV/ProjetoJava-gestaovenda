package com.matheus.gestaovendas.Controlador;

import com.matheus.gestaovendas.modelo.ModelosTabela.ClienteModelo;
import com.matheus.gestaovendas.modelo.entidade.Cliente;
import com.matheus.gestaovendas.modelo.servico.ClienteServico;
import com.matheus.gestaovendas.modelo.servico.PermissaoServico;
import com.matheus.gestaovendas.visao.componentes.Mensagem;
import com.matheus.gestaovendas.visao.formulario.FormularioCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;

public class FormularioClienteControlador implements ActionListener, KeyListener{
    
    private FormularioCliente formularioCliente;
    private final ClienteServico clienteServico;
    private final PermissaoServico permissaoServico;
    private ClienteModelo clienteModelo;
    private static List<Cliente> clientes;
    private static Long clienteId;
    private final long PERMISSAO_ID_PARA_REMOVER_CLIENTE = 17;
    
    public FormularioClienteControlador(FormularioCliente formularioCliente) {
        this.formularioCliente = formularioCliente;
        clienteServico = new ClienteServico();
        permissaoServico = new PermissaoServico();
        atualizaTabela();
    }
    
    private void atualizaTabela() {
        clientes = clienteServico.encontrarTodos();
        clienteModelo = new ClienteModelo(clientes);
        formularioCliente.getTabelaCliente().setModel(clienteModelo);
    }
    
    private void adicionar() {
        limpaCampo();
        formularioCliente.getDialogCadastro().pack();
        formularioCliente.getDialogCadastro().setLocationRelativeTo(null);
        formularioCliente.getDialogCadastro().setVisible(true);
    }
    
    private void salvar() {
        String nome = formularioCliente.getCampoDeTextoNome().getText().trim();
        String cpf = formularioCliente.getCampoDeTextoCPF().getText().trim();
        String morada = formularioCliente.getCampoDeTextoMorada().getText().trim();
        
        Cliente cliente = Cliente.builder()
                .id(clienteId)
                .nome(nome)
                .cpf(cpf)
                .morada(morada)
                .build();
        
        String mensagem = clienteServico.salvar(cliente);
        
        if (mensagem.startsWith("Cliente salvo")) {
            formularioCliente.mostrMensagem(Mensagem.TipoDeMensagem.SUCESSO, mensagem);
            atualizaTabela();
            limpaCampo();
        } else {
            formularioCliente.mostrMensagem(Mensagem.TipoDeMensagem.ERRO, mensagem);
        }
    }
    
    private void limpaCampo() {
        clienteId = null;
        formularioCliente.getCampoDeTextoNome().setText("");
        formularioCliente.getCampoDeTextoCPF().setText("");
        formularioCliente.getCampoDeTextoMorada().setText("");
    }
    
    private Cliente selecionaClienteNaTabela() {
        int index = formularioCliente.getTabelaCliente().getSelectedRow();
        
        if (index != -1) {
            return clientes.get(index);
        }
        
        JOptionPane.showMessageDialog(null, "Seleciona um cliente na tabela");
        throw new RuntimeException();
    }
    
    private void remover() {
        permissaoServico.validaPermissao(formularioCliente.getUsuarioId(), PERMISSAO_ID_PARA_REMOVER_CLIENTE);
        Cliente cliente = selecionaClienteNaTabela();
        
        int confirma = JOptionPane.showConfirmDialog(null, "Tens certeza?"
                + "Nome: " + cliente.getNome() , "Remover cliente", JOptionPane.ERROR_MESSAGE);
        
        if (confirma == JOptionPane.YES_OPTION) {
            String mensagem = clienteServico.remover(cliente.getId());
            atualizaTabela();
            JOptionPane.showMessageDialog(null, mensagem);
        }
    }
    
    private void atualizar() {
        Cliente cliente = selecionaClienteNaTabela();
        
        clienteId = cliente.getId();
        formularioCliente.getCampoDeTextoNome().setText(cliente.getNome());
        formularioCliente.getCampoDeTextoCPF().setText(cliente.getCpf());
        formularioCliente.getCampoDeTextoMorada().setText(cliente.getMorada());
        
        formularioCliente.getDialogCadastro().pack();
        formularioCliente.getDialogCadastro().setLocationRelativeTo(null);
        formularioCliente.getDialogCadastro().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();
        
        switch(action) {
            case "adicionar" -> {adicionar();}
            case "salvar" -> { salvar(); }
            case "remover" -> {remover();}
            case "atualizar" -> { atualizar();}
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if (formularioCliente.getMenuSelectionadoIndex() == 3) {
            String texto = formularioCliente.getCabecalho().getPesquisar().getText().trim();
            encontrarClientePeloAtributo(texto);
        }
    }
    
    private void encontrarClientePeloAtributo(String texto) {
        if (texto.isBlank()) {
            atualizaTabela();
        } else {
            clientes = clienteServico.encontrarClientePeloAtributo(texto);
            clienteModelo = new ClienteModelo(clientes);
            formularioCliente.getTabelaCliente().setModel(clienteModelo);
        }
    }
    
    
    
}

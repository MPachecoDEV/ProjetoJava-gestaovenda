package com.matheus.gestaovendas.Controlador;

import com.matheus.gestaovendas.modelo.ModelosTabela.EstoqueHistoricoModelo;
import com.matheus.gestaovendas.modelo.ModelosTabela.EstoqueModelo;
import com.matheus.gestaovendas.modelo.dto.EstoqueDto;
import com.matheus.gestaovendas.modelo.entidade.Estoque;
import com.matheus.gestaovendas.modelo.entidade.EstoqueHistorico;
import com.matheus.gestaovendas.modelo.entidade.EstoqueTipo;
import com.matheus.gestaovendas.modelo.entidade.Produto;
import com.matheus.gestaovendas.modelo.servico.EstoqueHistoricoServico;
import com.matheus.gestaovendas.modelo.servico.EstoqueServico;
import com.matheus.gestaovendas.modelo.servico.PermissaoServico;
import com.matheus.gestaovendas.modelo.servico.ProdutoServico;
import com.matheus.gestaovendas.visao.componentes.Mensagem;
import com.matheus.gestaovendas.visao.formulario.FormularioEstoque;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;

public class FormularioEstoqueControlador implements ActionListener, KeyListener, MouseListener {
    
    private final FormularioEstoque formularioEstoque;
    private final EstoqueServico estoqueServico;
    private final ProdutoServico produtoServico;
    private final PermissaoServico permissaoServico;
    private final EstoqueHistoricoServico estoqueHistoricoServico;
    private EstoqueModelo estoqueModelo;
    private static List<EstoqueDto> estoques;
    private static Long estoqueId;
    private static Optional<Produto> produto;
    private final long PERMISSAO_ID_PARA_SALVAR_ESTOQUE = 5;
    private final long PERMISSAO_ID_PARA_REMOVE_ESTOQUE = 6;

    public FormularioEstoqueControlador(FormularioEstoque formularioEstoque) {
        this.formularioEstoque = formularioEstoque;
        estoqueServico = new EstoqueServico();
        produtoServico = new ProdutoServico();
        permissaoServico = new PermissaoServico();
        estoqueHistoricoServico = new EstoqueHistoricoServico(formularioEstoque.getUsuarioId());
        
        atualizaTabela();
    }
    
    private void atualizaTabela() {
        estoques = estoqueServico.encontrarTodos();
        estoqueModelo = new EstoqueModelo(estoques);
        formularioEstoque.getTabela().setModel(estoqueModelo);
    }
    
    private void atualizaTabelaHistorico() {
        List<EstoqueHistorico> estoqueHistoricos = estoqueHistoricoServico.encontraTodos();
        EstoqueHistoricoModelo modelo = new EstoqueHistoricoModelo(estoqueHistoricos);
        formularioEstoque.getFormularioPrincipal().getTabela().setModel(modelo);
        formularioEstoque.getFormularioPrincipal().getCartao3().getLabelCartaoValor().setText(String.format("Total %s", estoques.size()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();
        
        switch(action) {
            case "adicionar" -> { adicionar(); } 
            case "salvar" -> { salvar(); }
            case "atualizar" -> { atualizar(); }
            case "remover" -> { remover(); }
        }        
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {

        if (formularioEstoque.getMenuSelectionadoIndex() == 2) {
            String texto = formularioEstoque.getCabecalho().getPesquisar().getText().trim();
            
            if (!texto.isBlank()) {
                List<EstoqueDto> estoquePesquisa = estoques.stream()
                                        .filter(estoque -> estoque.getProduto()
                                                .toLowerCase().contains(texto.toLowerCase()))
                                        .toList();
                estoqueModelo = new EstoqueModelo(estoquePesquisa);
                formularioEstoque.getTabela().setModel(estoqueModelo);
            } else {
                estoqueModelo = new EstoqueModelo(estoques);
                formularioEstoque.getTabela().setModel(estoqueModelo);
            }
            
        }
        String produtoIdOrNome = formularioEstoque.getCampoDeTextoNome().getText().trim();
        
        if (!produtoIdOrNome.isBlank()) {
            try {
                long produtoId = Long.parseLong(produtoIdOrNome);
                produto = produtoServico.encontrarPeloId(produtoId);
            } catch (Exception ex) {
                produto = Optional.ofNullable(produtoServico.encontraPeloNome(produtoIdOrNome));
            }
            if (produto.isPresent()) {
                formularioEstoque.getLabelProduto().setText(produto.get().getNome());
            } else {
                formularioEstoque.getLabelProduto().setText("");
            }
        }
        
    }

    private void adicionar() {
        permissaoServico.validaPermissao(formularioEstoque.getUsuarioId(), PERMISSAO_ID_PARA_SALVAR_ESTOQUE);
        formularioEstoque.getDialog().pack();
        formularioEstoque.getDialog().setLocationRelativeTo(null);
        formularioEstoque.getDialog().setVisible(true);
    }
    
    private void validaCampoVazio(String texto) {
        if (texto.isBlank()) {
            formularioEstoque.getMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, "Campo obrigatorio");
        }
    }

    private void salvar() {
        String produtoIdOrNome = formularioEstoque.getCampoDeTextoNome().getText().trim();
        String quantidadeString = formularioEstoque.getCampoDeTextoQuantidade().getText().trim();
        String observacao = formularioEstoque.getCampoDeTextoObservacao().getText().trim();

        validaCampoVazio(produtoIdOrNome);
        validaCampoVazio(quantidadeString);
        
        if (produto.isEmpty()) {
            formularioEstoque.getMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, "Produto nao encontrado");
            throw new RuntimeException("Produto nao encontrado");
        }
        
        Integer quantidade = 0;
        Estoque estoque;
        EstoqueHistorico estoqueHistorico = new EstoqueHistorico();
        
        try {
            quantidade = Integer.valueOf(quantidadeString);
            
            if (quantidade < 0) {
                String mensagem = "Não é permitido numeros negativos";
                formularioEstoque.getMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, mensagem);
                throw new RuntimeException(mensagem);
            } 
            
            estoque = estoqueServico.encontrarPeloAtributoProdutoId(produto.get().getId());
            if (estoqueId == null) {
                if (estoque == null) {
                    estoque = new Estoque();
                }
                estoqueHistorico.setQuantidade(quantidade);
                quantidade = estoque.getQuantidade() == null ? quantidade : estoque.getQuantidade() + quantidade;
                estoque.setQuantidade(quantidade);
                estoqueHistorico.setObservacao("adicionar: " + observacao);
            } else {
                validaCampoVazio(observacao);
                estoqueHistorico.setQuantidade(quantidade);
                estoqueHistorico.setObservacao("ALTERAR: " + observacao);
                int confirma = JOptionPane.showConfirmDialog(null, 
                        """ 
                        Tem certeza que quer atualizar? \n                                        
                        OBS: Na atualização o valor da quantidade sera substituido pelo atual """, 
                        "Atualizar o estoque", JOptionPane.YES_NO_OPTION);
                
                if (confirma == JOptionPane.YES_OPTION)
                    estoque.setQuantidade(quantidade);
                else
                    throw new RuntimeException("Nao atualizar estoque");
            }
            
            estoque.setEstado(formularioEstoque.getRadioAtivo().isSelected());
            estoque.setProdutoId(produto.get().getId());
            estoque.setUsuarioId(formularioEstoque.getUsuarioId());
            estoque.setDataCriacao(LocalDateTime.now());
            
            String mensagem = estoqueServico.salvar(estoque);
            
            if (mensagem.startsWith("Estoque registrado")) {
                
                estoqueHistorico.setProduto(produto.get().getNome());
                estoqueHistorico.setTipo(EstoqueTipo.ENTRADA.name());
                estoqueHistorico.setDataCriacao(estoque.getDataCriacao());
                estoqueHistorico.setUsuario(estoque.getUsuarioId().toString());
                estoqueHistoricoServico.salvar(estoqueHistorico);
                
                formularioEstoque.getMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.SUCESSO, mensagem);
                limpo();
                atualizaTabela();
                atualizaTabelaHistorico();
            } else {
                formularioEstoque.getMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, mensagem);
            }
        } catch (Exception e) {
            formularioEstoque.getMensagem().mostrarMensagem(Mensagem.TipoDeMensagem.ERRO, e.getMessage());
            throw new RuntimeException(e);
        }
    }
    
    private void limpo() {
        produto = Optional.empty();
        estoqueId = null;
        formularioEstoque.getLabelProduto().setText("");
        formularioEstoque.getCampoDeTextoNome().setText("");
        formularioEstoque.getCampoDeTextoQuantidade().setText("");
        formularioEstoque.getCampoDeTextoObservacao().setText("");
        formularioEstoque.getRadioAtivo().setSelected(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
        estoqueSelecionadoNaTabela();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    private EstoqueDto estoqueSelecionadoNaTabela() {
        int index = formularioEstoque.getTabela().getSelectedRow();
        
        if (index != -1) {
            return estoques.get(index);
        }
        String mensagem = "É necessário selecionar o estoque na tabela";
        JOptionPane.showMessageDialog(null, "É necessário selecionar item na tabela", "Selecionar", JOptionPane.ERROR_MESSAGE);
        throw new RuntimeException(mensagem);
    }

    private void atualizar() {
        permissaoServico.validaPermissao(formularioEstoque.getUsuarioId(), PERMISSAO_ID_PARA_SALVAR_ESTOQUE);
        EstoqueDto estoque = estoqueSelecionadoNaTabela();
        estoqueId = estoque.getId();
        Produto produtoEncontrado = produtoServico.encontraPeloNome(estoque.getProduto());
        produto = Optional.ofNullable(produtoEncontrado);
        preencherCampos(estoque);
        adicionar();
    }
    
    private void preencherCampos(EstoqueDto estoqueDto) {
        formularioEstoque.getLabelProduto().setText(estoqueDto.getProduto());
        formularioEstoque.getCampoDeTextoNome().setText(estoqueDto.getProduto());
        formularioEstoque.getCampoDeTextoQuantidade().setText(estoqueDto.getQuantidade().toString());
        formularioEstoque.getCampoDeTextoObservacao().setText("");
        formularioEstoque.getRadioAtivo().setSelected(estoqueDto.isEstado());
    }

    private void remover() {
        permissaoServico.validaPermissao(formularioEstoque.getUsuarioId(), PERMISSAO_ID_PARA_REMOVE_ESTOQUE);
        EstoqueDto estoque = estoqueSelecionadoNaTabela();
        int confirma = JOptionPane.showConfirmDialog(null, """
                                                           Tem certeza?
                                                           Nome: """ + estoque.getProduto()
                + "\nQuantidade: " + estoque.getQuantidade(), "Remover estoque", JOptionPane.YES_NO_OPTION);
        
        if (confirma == JOptionPane.YES_OPTION) {   
            estoqueId = estoque.getId();
            String mensagem = estoqueServico.remover(estoqueId);
            JOptionPane.showMessageDialog(null, mensagem);
            EstoqueHistorico estoqueHistorico = EstoqueHistorico.builder()
                    .produto(estoque.getProduto())
                    .quantidade(estoque.getQuantidade())
                    .observacao("REMOCAO DO ESTOQUE")
                    .usuario(formularioEstoque.getUsuarioId().toString())
                    .tipo(EstoqueTipo.SAIDA.name())
                    .dataCriacao(LocalDateTime.now())
                    .build();
            
            estoqueHistoricoServico.salvar(estoqueHistorico);
            atualizaTabela();
            atualizaTabelaHistorico();
            limpo();
        }
    }
}

package com.matheus.gestaovendas.Controlador;

import com.itextpdf.text.BadElementException;
import com.matheus.gestaovendas.modelo.ModelosTabela.*;
import com.matheus.gestaovendas.modelo.dto.EstoqueDto;
import com.matheus.gestaovendas.modelo.dto.ProdutoDto;
import com.matheus.gestaovendas.modelo.dto.VendaResponseDto;
import com.matheus.gestaovendas.modelo.entidade.Cliente;
import com.matheus.gestaovendas.modelo.entidade.EstoqueHistorico;
import com.matheus.gestaovendas.modelo.entidade.Usuario;
import com.matheus.gestaovendas.modelo.repositorio.impl.VendaRepositorioImpl;
import com.matheus.gestaovendas.modelo.servico.ClienteServico;
import com.matheus.gestaovendas.modelo.servico.EstoqueHistoricoServico;
import com.matheus.gestaovendas.modelo.servico.EstoqueServico;
import com.matheus.gestaovendas.modelo.servico.ProdutoServico;
import com.matheus.gestaovendas.modelo.servico.UsuarioServico;
import com.matheus.gestaovendas.visao.formulario.FormularioRelatorio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.FileNotFoundException;

public class FormularioRelatorioControlador implements KeyListener, ActionListener {

    private FormularioRelatorio formularioRelatorio;
    private final EstoqueServico estoqueServico;
    private final ProdutoServico produtoServico;
    private final ClienteServico clienteServico;
    private final EstoqueHistoricoServico estoqueHistoricoServico;
    private final VendaRepositorioImpl vendaRepositorio;
    private final UsuarioServico usuarioServico;
    private ClienteModelo clienteModelo;
    private EstoqueHistoricoModelo estoqueHistoricoModelo;
    private EstoqueModelo estoqueModelo;
    private ProdutoModelo produtoModelo;
    private VendaModelo vendaModelo;
    private UsuarioModelo usuarioModelo;
    private int selecionadoIndex = 0;
    private String selecionadoItem;
    
    public FormularioRelatorioControlador(FormularioRelatorio formularioRelatorio) {
        this.formularioRelatorio = formularioRelatorio;
        estoqueServico = new EstoqueServico();
        produtoServico = new ProdutoServico();
        clienteServico = new ClienteServico();
        usuarioServico = new UsuarioServico();
        estoqueHistoricoServico = new EstoqueHistoricoServico(formularioRelatorio.getUsuarioId());
        vendaRepositorio = new VendaRepositorioImpl();
    }

    private void atualizarTabelaModelo(String selecionado) {
        List<ProdutoDto> dadosProduto = produtoServico.encontrarTodos();
        List<Cliente> dadosCliente = clienteServico.encontrarTodos();
        List<EstoqueHistorico> dadosEstoqueHist = estoqueHistoricoServico.encontraTodos();
        List<EstoqueDto> dadosEstoque = estoqueServico.encontrarTodos();
        List<Usuario> dadosUsuario = usuarioServico.encontrarTodos();
        List<VendaResponseDto> dadosVenda = vendaRepositorio.encontrarTodosPersonalizado();

        switch (selecionado) {
            case "Produto" -> {
                produtoModelo = new ProdutoModelo(dadosProduto);
                formularioRelatorio.getTabelaRelatorio().setModel(produtoModelo);
            }
            case "Cliente" -> {
                clienteModelo = new ClienteModelo(dadosCliente);
                formularioRelatorio.getTabelaRelatorio().setModel(clienteModelo);
            }
            case "Usuario" -> {
                usuarioModelo = new UsuarioModelo(dadosUsuario);
                formularioRelatorio.getTabelaRelatorio().setModel(usuarioModelo);
            }
            case "Venda" -> {
                vendaModelo = new VendaModelo(dadosVenda);
                formularioRelatorio.getTabelaRelatorio().setModel(vendaModelo);
            }
            case "Estoque" -> {
                estoqueModelo = new EstoqueModelo(dadosEstoque);
                formularioRelatorio.getTabelaRelatorio().setModel(estoqueModelo);
            }
            case "EstoqueHistorico" -> {
                estoqueHistoricoModelo = new EstoqueHistoricoModelo(dadosEstoqueHist);
                formularioRelatorio.getTabelaRelatorio().setModel(estoqueHistoricoModelo);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand().toLowerCase();
        
        switch (action) {
            case "combobox" -> {
                JComboBox combobox = (JComboBox) e.getSource();
                selecionadoIndex = combobox.getSelectedIndex();
                selecionadoItem = combobox.getSelectedItem().toString();
                atualizarTabelaModelo(combobox.getSelectedItem().toString());
            }
            case "gerarpdf" -> {
            try { 
                if(selecionadoIndex > 0) {
                    String pdfPath = escolherESalvarPDF(formularioRelatorio.getTabelaRelatorio(), selecionadoItem);
                    abrirPDFnoBrowser(pdfPath);
                } else {
                    JOptionPane.showMessageDialog(null, "Tabela não selecionada", "Selecione a tabela", JOptionPane.ERROR_MESSAGE);
                    throw new RuntimeException("tabela nao selecionada");
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FormularioRelatorioControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                Logger.getLogger(FormularioRelatorioControlador.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FormularioRelatorioControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }     

    private static String escolherESalvarPDF(JTable table, String selecionado) throws FileNotFoundException, DocumentException, BadElementException, IOException {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar PDF");
        fileChooser.setSelectedFile(new File(".pdf"));
        
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("PDF Files", "pdf"));
        int userSelection = fileChooser.showSaveDialog(null);
        
         if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            if (!fileToSave.getAbsolutePath().endsWith(".pdf")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".pdf");
            }

            Document document = new Document();
            PdfWriter.getInstance(document, new java.io.FileOutputStream(fileToSave));
            document.open();
            
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 24, Font.BOLD);
            Paragraph title = new Paragraph("Relatorio de " + selecionado, titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(50);
            document.add(title);
   
            TableModel model = table.getModel();

            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());

            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(new Phrase(model.getColumnName(i)));
            }

            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object cellValue = model.getValueAt(row, col);
                    pdfTable.addCell(cellValue != null ? cellValue.toString() : "");
                }
            }

            document.add(pdfTable);

            document.close();

            System.out.println("PDF gerado com sucesso em: " + fileToSave.getAbsolutePath());
            return fileToSave.getAbsolutePath();
        } else {
            System.out.println("Operação cancelada pelo usuário.");
            return null;
        }      
    }

    private void abrirPDFnoBrowser(String pdfFilePath) {
        if (pdfFilePath != null) {
            try {
                if (Desktop.isDesktopSupported()) {
                    Desktop desktop = Desktop.getDesktop();
                    File pdfFile = new File(pdfFilePath);

                    if (pdfFile.exists()) {
                        desktop.open(pdfFile);  
                    } else {
                        System.out.println("O arquivo PDF não foi encontrado.");
                    }
                } else {
                    System.out.println("O sistema não suporta a funcionalidade de Desktop.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    
    }
        
    
}

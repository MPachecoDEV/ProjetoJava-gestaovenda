package com.matheus.gestaovendas.modelo.ModelosTabela;

import com.matheus.gestaovendas.modelo.entidade.EstoqueHistorico;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EstoqueHistoricoModelo extends AbstractTableModel {
    
    private List<EstoqueHistorico> estoqueHistoricos;
    private final String [] colunas = {"ID", "Nome", "Quantidade", "Estado", "Motivo", "Data"};
    
    public EstoqueHistoricoModelo (List<EstoqueHistorico> estoqueHistoricos) {
        this.estoqueHistoricos = estoqueHistoricos;
    }

    @Override
    public int getRowCount() {
       return estoqueHistoricos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EstoqueHistorico historico = estoqueHistoricos.get(rowIndex);
        
        switch (columnIndex) {
            case 0 -> {return historico.getId();}
            case 1 -> {return historico.getProduto();}
            case 2 -> {return historico.getQuantidade();}
            case 3 -> {return historico.getTipo();}
            case 4 -> {return historico.getObservacao();}
            case 5 -> {return historico.getDataCriacao();}
        }
        
        return null;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; 
    }

    public List<EstoqueHistorico> getEstoqueHistoricos() {
        return estoqueHistoricos;
    }

    public void setEstoqueHistoricos(List<EstoqueHistorico> estoqueHistoricos) {
        this.estoqueHistoricos = estoqueHistoricos;
    }
    
}

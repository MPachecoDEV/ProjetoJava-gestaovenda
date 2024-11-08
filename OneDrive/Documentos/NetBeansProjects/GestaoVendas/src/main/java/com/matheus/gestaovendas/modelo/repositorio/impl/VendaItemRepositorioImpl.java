package com.matheus.gestaovendas.modelo.repositorio.impl;

import com.matheus.gestaovendas.modelo.dto.VendaItemDto;
import com.matheus.gestaovendas.modelo.entidade.VendaItem;
import com.matheus.gestaovendas.modelo.repositorio.impl.CrudRepositorioImpl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendaItemRepositorioImpl extends CrudRepositorioImpl<VendaItem> {

    public VendaItemRepositorioImpl() {
        super(VendaItem.class);
    }

    public boolean removerVendaItemPeloId(Long id) {
        Map<String, Object> map = new HashMap<>();
        map.put("vendaId", id);
        
        if (existePeloAtributoEValor(map)) {
            try {
                String SQL = "DELETE FROM vendaItem WHERE vendaId = ?";
                PreparedStatement preparedStatement = getConexao().obterConexao()
                        .prepareStatement(SQL);
                preparedStatement.setLong(1, id);

                int resultado = preparedStatement.executeUpdate();

                if (resultado == 0) {
                    throw new SQLException("Erro ao delete a entidade");
                }

                return true;
            } catch (SQLException e) {
                System.out.println("ERROR" + e);
                throw new RuntimeException(e);
            }
        }

        return false;
    }

    public List<VendaItemDto> encontrarVendaItemPelaVendaId(Long vendaId) {
        List<VendaItemDto> lista = new ArrayList<>();
        try {
            String SQL = "SELECT p.id, p.preco, p.nome, vi.quantidade, vi.total, vi.desconto FROM vendaitem vi, produto p WHERE vi.produtoid = p.id AND vi.vendaid = ?";
            
            PreparedStatement preparedStatement = getConexao()
                    .obterConexao()
                    .prepareStatement(SQL);
            
            preparedStatement.setLong(1, vendaId);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                lista.add(getVendaItemDto(resultSet));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    private VendaItemDto getVendaItemDto(ResultSet resultSet) throws SQLException {
        return VendaItemDto.builder()
                .produtoId(resultSet.getLong("id"))
                .produtoNome(resultSet.getString("nome"))
                .preco(resultSet.getBigDecimal("preco"))
                .quantidade(resultSet.getInt("quantidade"))
                .total(resultSet.getBigDecimal("total"))
                .desconto(resultSet.getBigDecimal("desconto"))
                .build();
    }
}

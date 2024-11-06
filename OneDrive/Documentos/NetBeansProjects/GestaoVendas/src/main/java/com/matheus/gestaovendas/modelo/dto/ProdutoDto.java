package com.matheus.gestaovendas.modelo.dto;

import com.matheus.gestaovendas.modelo.entidade.Categoria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProdutoDto {
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Categoria categoria;
    private LocalDateTime dataCriacao;
    
}

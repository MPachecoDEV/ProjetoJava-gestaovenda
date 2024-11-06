package com.matheus.gestaovendas.modelo.entidade;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Venda {
    private Long id;
    private BigDecimal totalVenda;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private BigDecimal desconto;
    private Long clienteId;
    private Long usuarioId;
    private LocalDateTime dataCriacao;
    private LocalDateTime ultimaAtualizacao;
}

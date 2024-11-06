package com.matheus.gestaovendas.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VendaResponseDto {
    private Long id;
    private BigDecimal totalVenda;
    private BigDecimal valorPago;
    private BigDecimal troco;
    private BigDecimal desconto;
    private String cliente;
    private String usuario;
    private LocalDateTime dataCriacao;
    private List<VendaItemDto> vendaItemDtos;
}

package com.matheus.gestaovendas.modelo.dto;

import com.matheus.gestaovendas.modelo.entidade.Venda;
import com.matheus.gestaovendas.modelo.entidade.VendaItem;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VendaRequestDto {
    private Venda venda;
    private List<VendaItem> vendaItems;
}

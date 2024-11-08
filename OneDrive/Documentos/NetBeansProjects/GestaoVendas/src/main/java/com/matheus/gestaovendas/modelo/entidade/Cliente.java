package com.matheus.gestaovendas.modelo.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cliente {
    
    private Long id;
    private String nome;
    private String cpf;
    private String morada;    
}

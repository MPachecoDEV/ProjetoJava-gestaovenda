package com.matheus.gestaovendas.modelo.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Permissao {
    private Long id;
    private String nome;
    private String descricao;
        
}

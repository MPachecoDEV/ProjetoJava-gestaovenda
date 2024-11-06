package com.matheus.gestaovendas.modelo.dto;

import com.matheus.gestaovendas.modelo.entidade.Usuario;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private Usuario usuario;
    private boolean resposta;
}

package com.matheus.gestaovendas.modelo.servico;

import com.matheus.gestaovendas.modelo.entidade.Produto;
import com.matheus.gestaovendas.modelo.entidade.Usuario;
import com.matheus.gestaovendas.modelo.repositorio.CrudRepositorio;
import com.matheus.gestaovendas.modelo.repositorio.impl.CrudRepositorioImpl;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EntidadeServico {
    
    private final CrudRepositorio repositorio;
    private PermissaoServico permissaoServico;

    public EntidadeServico() {
        repositorio = new CrudRepositorioImpl(Produto.class) {};
        permissaoServico = new PermissaoServico();
    }
    
    public boolean salva() {
        Usuario usuario1 = Usuario.builder()
//                .id(8L)
                .nome("Quitumba Ferreira")
                .email("quitumba@email.com")
                .senha(hashPassword("1234"))
                .perfil("ADMIN")
                .estado(true)
                .dataCriacao(LocalDateTime.now())
                .build();        
        Usuario usuario2 = Usuario.builder()
                .nome("Inock")
                .email("inock@email.com")
                .senha("1234")
                .perfil("ADMIN")
                .estado(true)
                .build();

        Map<String, Object> map = new HashMap<>();
        String email = usuario1.getEmail();
        map.put("email", email);
        
        repositorio.salvar(usuario1);

        return true;
    }
    
    private String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
    
    public List<Usuario> encontrarTodos() {
        return repositorio.encontrarTodos();
    }
    
    public static void main(String[] args) {
        EntidadeServico servico = new EntidadeServico();

        servico.salva();
        System.out.println(servico.repositorio.encontrarPeloId(1L));
    }
    
    private void validarSenha(String email, String senha) {
        Map<String, Object> map = new HashMap<>();
        map.put("email", email);
    }
}

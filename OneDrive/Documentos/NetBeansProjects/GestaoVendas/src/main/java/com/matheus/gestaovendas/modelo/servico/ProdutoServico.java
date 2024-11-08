package com.matheus.gestaovendas.modelo.servico;

import com.matheus.gestaovendas.modelo.dto.ProdutoDto;
import com.matheus.gestaovendas.modelo.entidade.Categoria;
import com.matheus.gestaovendas.modelo.entidade.Produto;
import com.matheus.gestaovendas.modelo.repositorio.CrudRepositorio;
import com.matheus.gestaovendas.modelo.repositorio.impl.CrudRepositorioImpl;
import com.matheus.gestaovendas.modelo.repositorio.impl.ProdutoRepositorioImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProdutoServico {
    private ProdutoRepositorioImpl produtoRepositorio;
    private CrudRepositorio categoriaRepositorio;

    public ProdutoServico() {
        produtoRepositorio = new ProdutoRepositorioImpl();
        categoriaRepositorio = new CrudRepositorioImpl(Categoria.class) {};
    }
    
    public Long quantidadeDeProduto() {
        return produtoRepositorio.totalDeArquivo();
    }
    
    public List<ProdutoDto> encontrarTodos() {
        List<Produto> lista = produtoRepositorio.encontrarTodos();
        
        return getProdutoDtos(lista);
    }
    
    private List<ProdutoDto> getProdutoDtos(List<Produto> produtos) {
        return produtos.stream()
             .map(p -> {
                    Optional<Categoria> categoria = categoriaRepositorio.encontrarPeloId(p.getCategoriaId());
                    return ProdutoDto.builder()
                            .id(p.getId())
                            .nome(p.getNome())
                            .descricao(p.getDescricao())
                            .preco(p.getPreco())
                            .categoria(categoria.get())
                            .dataCriacao(p.getDataCriacao())
                            .build();
             }).collect(Collectors.toList());
    }
    
    public String salva(Produto produto) {
        Map<String, Object> map = new HashMap<>();
        map.put("nome", produto.getNome());
        
        if (produto.getId() == null && produtoRepositorio.existePeloAtributoEValor(map)) {
            return "Produto ja encontra-se cadastrado...";
        }
        
        try {
            boolean resultado = produtoRepositorio.salvar(produto);
            System.out.println("RESULTADO: " + resultado);
            if (resultado) 
                return "Produto cadastrado com sucesso";
        } catch (Exception e) {
            System.out.println("error: " + e);
            return e.getMessage();
        }
        
        return "erro ao cadastrar o produto";
    }
    
    public String remover(Long id) {
        try {
            boolean resultado = produtoRepositorio.removerPeloId(id);
            
            if (resultado) 
                return "Produto removido com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Erro ao remover o produto";
    }
    
    public List<ProdutoDto> encontrarPeloAtributo(String texto) {
        Map<String, Object> map = new HashMap<>();
        map.put("nome", texto);
        map.put("preco", texto);
        
        List<Produto> lista = produtoRepositorio.encontrarPeloAtributoUsandoOR(map, true);
        
        return getProdutoDtos(lista);
    }
    
    public Optional<Produto> encontrarPeloId(Long id) {
        return produtoRepositorio.encontrarPeloId(id);
    }
    
    public Produto encontraPeloNome(String nome) {
        Map<String, Object> map = new HashMap<>();
        map.put("nome", nome);
        
        List<Produto> lista = produtoRepositorio.encontrarPeloAtributoUsandoAND(map, false);
        System.out.println("LISTA: " + lista);
        if (lista.size() != 1)
            return null;
//            throw new RuntimeException("Erro ao buscar somente um produto");
        
       return lista.get(0);
    }
    
    public List<Produto> encontraTodosPelaCategoriaNome(String categoriaNome) {
        return produtoRepositorio.encontraTodosPelaCategoriaNome(categoriaNome);
    }
}

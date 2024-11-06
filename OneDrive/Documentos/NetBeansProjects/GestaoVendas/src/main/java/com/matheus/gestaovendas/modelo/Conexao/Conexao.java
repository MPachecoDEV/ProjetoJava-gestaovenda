package com.matheus.gestaovendas.modelo.Conexao;

import java.sql.Connection;
import java.sql.SQLException;

public interface Conexao {
    
    public Connection obterConexao() throws SQLException;
    public void fecharConexao() throws SQLException;
}

package com.matheus.gestaovendas.modelo.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL implements Conexao{
    
    private static Connection connection;
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/gestaovendabd";
    private static final String USER = "root";
    private static final String PASSWORD = "mp0061716882";
   
    @Override
    public Connection obterConexao() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
                
        return connection;
    }
    
    @Override
    public void fecharConexao() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
    
    
}

package org.senai.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public static Connection conexao() {

        //conexao com o banco
        final String URL = "jdbc:mysql://localhost:3306/primeira_api";
        final String USER = "root";
        final String PASSWORD = "Hwbfaa65@";

        Connection conexao = null;
        try {
            DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conexao;
    }
}

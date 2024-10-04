package org.senai;

import org.senai.infra.MySQLConnection;

import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {


       // MySQLConnection connector = new MySQLConnection();

        //outro exemplo
        Connection conexao = MySQLConnection.conexao();

        String comando = "SELECT * FROM usuario";

        try {
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(comando);
            System.out.println(resultado);

            while (resultado.next()) {
                System.out.println(resultado.getInt("id"));
                int id = resultado.getInt("id");
                System.out.println(resultado.getString("nome"));
                String nome = resultado.getString("nome");
                System.out.println(resultado.getString("email"));
                System.out.println(id);
                String email = resultado.getString("email");
                System.out.println("Oi " + nome + " seu email é " + email + "?");

            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
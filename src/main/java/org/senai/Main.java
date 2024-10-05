package org.senai;

import org.senai.infra.MySQLConnection;

import javax.swing.*;
import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

       // MySQLConnection connector = new MySQLConnection();

        //outro exemplo
        Connection conexao = MySQLConnection.conexao();
        System.out.println("Insita o nome do usuário: ");
        String name = sc.nextLine();

        System.out.println("Insira o e-mail do usuário");
        String e_mail = sc.nextLine();

        String insertCommand = "INSERT INTO usuario (nome, email) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(insertCommand);
            stmt.setString(1, name);
            stmt.setString(2, e_mail);

            int rowInserted = stmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("Dados inseridos com sucesso!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        String comando = "SELECT * FROM usuario";

        try {
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(comando);
            System.out.println(resultado);

            while (resultado.next()) {

                int id = resultado.getInt("id");
                System.out.println(resultado.getString("nome"));
                String nome = resultado.getString("nome");
                System.out.println(resultado.getString("email"));
                System.out.println(id);
                String email = resultado.getString("email");
                System.out.println("Oi " + nome + " seu email é " + email + "?");

            }
            conexao.close();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
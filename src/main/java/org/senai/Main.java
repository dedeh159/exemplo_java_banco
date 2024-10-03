package org.senai;

import org.senai.infra.MySQLConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        MySQLConnection connector = new MySQLConnection();
        connector.conexao();

    }

}
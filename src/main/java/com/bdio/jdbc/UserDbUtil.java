package com.bdio.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.bdio.jdbc.User;

public class UserDbUtil {

    static String Url = "jdbc:mysql://localhost:3306/userdb";
    static String Utilisateur = "root";
    static String Password = "test";

    public static int insertUser(User user) {
        int res = 0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connexion = DriverManager.getConnection(Url,Utilisateur,Password);

            System.out.println("conn gosood"+Url);

            String insertSQL = "INSERT INTO user (username, password, mobile) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connexion.prepareStatement(insertSQL)) {

                preparedStatement.setString(1, user.getUsername());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getMobile());
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Insert successful.");
                } else {
                    System.out.println("Insert failed.");
                }
                res = rowsAffected;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
    public boolean loginUser(String username, String password) {
        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (
                Connection connection = DriverManager.getConnection(Url, Utilisateur, Password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

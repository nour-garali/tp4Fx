package com.example.tp4base;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    private static String login = "root";
    private static String password ="";
    private static String url = "jdbc:mysql://localhost/projetjava";



    @Override
    public void start(Stage stage) throws IOException {
        Connection conn=connexion.getCn();
        if (conn != null) {
            System.out.println("Database connected!");
        } else {
            System.out.println("Database connection failed!");
        }
    }


       /* String sql = "INSERT INTO person (prenom, nom, email) VALUES (?, ?, ?)";

       try (

    PreparedStatement stmt = conn.prepareStatement(sql)) {
            // Set the parameter values for the SQL query
           stmt.setString(1, "Loussaief");
            stmt.setString(2, "Dalel");
            stmt.setString(3, "Dalel@gmail.com");

            // Execute the SQL query
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println(rows + " row(s) inserted.");
            } else {
                System.out.println("No rows inserted.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/




    public static void main(String[] args){
        launch();


    }

}



package com.example.tp4base;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private TextField tfnom;
    private TextField prenomField;
    private RadioButton tfF;
    private RadioButton tfM;
    private int  idE;
    private Button ajoutbtn;
    private Button supprimbtn;
    private Button modifbtn;
    private ComboBox<String> filiereComboBox;
    @FXML
    private TableView<Etudiant> tableEtudiant;
    @FXML
    private TableColumn<Etudiant, String> nomCol;
    @FXML
    private TableColumn<Etudiant, String> prenomCol;
    private TableColumn<Etudiant, String> sexeCol;
    @FXML
    private TableColumn<Etudiant, String> filiereCol;
    private ObservableList<Etudiant> etudiantData = FXCollections.observableArrayList();
    private Connection cnx = connexion.getCn();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public boolean create(Etudiant etudiant) {
        try {
            // Récupérer la connexion à la base de données
            Connection connection = connexion.getCn();

            String query = "INSERT INTO etudiant(nom, prenom, email, adresse) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getSexe());
            preparedStatement.setString(4, etudiant.getFiliere());

            int ligneinsere = preparedStatement.executeUpdate();
            if (ligneinsere > 0) {
                System.out.println("Un nouvel étudiant a été ajouté à la base de données.");
                return true;
            } else {
                System.out.println("Impossible d'ajouter l'étudiant à la base de données.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'étudiant à la base de données: " + e.getMessage());
            return false;
        }
    }


}

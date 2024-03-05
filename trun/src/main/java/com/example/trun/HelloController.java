package com.example.trun;

import com.example.trun.model.BD;
import com.example.trun.model.Classe;
import com.example.trun.model.Etudiant;
import com.example.trun.repository.ClasseRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    BD bd;
    Connection con = null;
    @FXML
    private TableColumn<?, ?> cclasse;

    @FXML
    private TableColumn<?, ?> cemail;

    @FXML
    private TextField champemail;

    @FXML
    private TextField champnom;

    @FXML
    private TextField champprenom;

    @FXML
    private TableColumn<?, ?> cid;

    @FXML
    private TableColumn<?, ?> cmatricule;

    @FXML
    private TableColumn<?, ?> cnom;

    @FXML
    private ComboBox<Classe> combo;

    @FXML
    private TableColumn<?, ?> cprenom;

    @FXML
    private TableView<?> table;

    @FXML
    void btncreate(ActionEvent event) {
        Etudiant etudiant = new Etudiant();
        etudiant.setPrenom(champprenom.getText());
        etudiant.setNom(champnom.getText());
        etudiant.setEmail(champemail.getText());

    }

    @FXML
    void btndelete(ActionEvent event) {

    }

    @FXML
    void btnreset(ActionEvent event) {

    }

    @FXML
    void btnupdate(ActionEvent event) {

    }

    @FXML
    void pageclasse(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("classe.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Classe");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        @Override
        public void initialize (URL url, ResourceBundle resourceBundle){
            bd = new BD();
            con = bd.getConnection();
            ClasseRepository classeRepository = new ClasseRepository();
            ObservableList<Classe> classes = FXCollections.observableArrayList();
            classes.addAll(classeRepository.getAllClasse());
            combo.setItems(classes);


        }

    }

package com.example.trun;
import com.example.trun.model.BD;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class ClasseController implements Initializable {
    BD bd;
    Connection con = null;
    @FXML
    private TextField champLibelle;

    @FXML
    void btnadd(ActionEvent event) {
        try {
            String sql = "insert into classe(libelle) values(?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, champLibelle.getText());
            pst.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       bd = new BD();
         con = bd.getConnection();
    }
}

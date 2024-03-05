package com.example.trun.repository;

import com.example.trun.model.BD;
import com.example.trun.model.Classe;
import com.example.trun.model.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClasseRepository {
    BD bd;
    Connection connection;

    public ClasseRepository() {
        bd = new BD();
        connection = bd.getConnection();
    }

    public List<Classe> getAllClasse() {
        // List<Medecin> liste = null;
        ArrayList<Classe> list = new ArrayList<Classe>();
        //ObservableList<Classe> list = null;
        try {
            String sql = "select * from classe";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classe classe = new Classe();
                classe.setId(rs.getInt("id"));
                classe.setLibelle(rs.getString("libelle"));
                list.add(classe);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }
}
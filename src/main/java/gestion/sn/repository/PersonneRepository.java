package gestion.sn.repository;

import gestion.sn.model.BD;
import gestion.sn.model.Compte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneRepository {
     BD bd=new BD();
     static Connection connection;
    public ObservableList<Compte> getAllCompte() {
        connection = bd.getConnection();
        // List<Medecin> liste = null;
        ObservableList<Compte> list = null;
        try {
            list = FXCollections.observableArrayList();
            String sql = "SELECT * FROM compte ";
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Compte compte = new Compte();
                compte.setId(rs.getInt(1));
                compte.setNumero(rs.getString(2));
                compte.setMontant(rs.getInt(3));
                compte.setType(rs.getString(4));
                list.add(compte);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public static void update(Compte compte) {
        try {
            String sql = "UPDATE compte SET numero = ? , montant= ?, typecompte = ? where id =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, compte.getNumero());
            statement.setInt(2, compte.getMontant());
            statement.setString(3, compte.getType());

            statement.executeUpdate();
            System.out.println("COMPTE updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

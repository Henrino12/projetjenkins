package com.example.trun.repository;

import com.example.trun.model.BD;
import com.example.trun.model.Etudiant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EtudiantRepository {
      BD bd ;
      Connection connection;

    public EtudiantRepository() {
        bd = new BD();
        connection = bd.getConnection();
    }

    public void createEtudiant(Etudiant etudiant) {
        try {
            String sql = "insert into etudiant(nom,prenom,matricule,id_classe,email) values(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getMatricule());
            ps.setInt(4, etudiant.getId_classe());
            ps.setString(5, etudiant.getEmail());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void updateEtudiant(Etudiant etudiant) {
        try {
            String sql = "update etudiant set nom=?,prenom=?,matricule=?,id_classe=?,email=? where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, etudiant.getNom());
            ps.setString(2, etudiant.getPrenom());
            ps.setString(3, etudiant.getMatricule());
            ps.setInt(4, etudiant.getId_classe());
            ps.setString(5, etudiant.getEmail());
            ps.setInt(6, etudiant.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void deleteEtudiant(int id) {
        try {
            String sql = "delete from etudiant where id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public List<Etudiant> readEtudiant() {
        List<Etudiant> list = new ArrayList<>();
        try {
            String sql = "select * from etudiant";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(rs.getInt("id"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setEmail(rs.getString("email"));
                etudiant.setId_classe(rs.getInt("id_classe"));
                list.add(etudiant);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }


    public List<Etudiant> readEtudiantByClasse(int id_classe) {
        List<Etudiant> list = new ArrayList<>();
        try {
            String sql = "select * from etudiant where id_classe=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_classe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Etudiant etudiant = new Etudiant();
                etudiant.setId(rs.getInt("id"));
                etudiant.setPrenom(rs.getString("prenom"));
                etudiant.setNom(rs.getString("nom"));
                etudiant.setEmail(rs.getString("email"));
                etudiant.setId_classe(rs.getInt("id_classe"));
                list.add(etudiant);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return list;
    }
}
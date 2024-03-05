package gestion.sn;

import gestion.sn.model.BD;
import gestion.sn.model.Compte;
import gestion.sn.repository.PersonneRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class HelloController implements Initializable {
    BD bd;
    Connection con = null;
    @FXML
    private TextField cmotant;

    @FXML
    private TextField cnumero;

    @FXML
    private TableColumn<Compte, String> colNumero;

    @FXML
    private TableColumn<Compte, Integer> colmontant;

    @FXML
    private TableColumn<Compte, String> coltypem;
    @FXML
    private TableColumn<Compte, Integer> colid;
    @FXML
    private ComboBox<String> combo;

    @FXML
    private TableView<Compte> table;
    @FXML
    private Button ajouter;
    @FXML
    private Button delete;
    @FXML
    private Button annuler;
    @FXML
    private TextField searchFild;

    @FXML
    void btnAjouter(ActionEvent event) {
        String sql = "insert into compte(numero,montant,typecompte) values(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cnumero.getText());
            pst.setDouble(2, Integer.parseInt(cmotant.getText()));
            pst.setString(3, combo.getValue());
            pst.execute();
            System.out.println("Ajouté");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       afficher();

    }

    @FXML
    void btndelete(ActionEvent event) {
        int id=this.table.getSelectionModel().getSelectedItem().getId();
        try {
            String sql=" DELETE FROM compte WHERE id = ?";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
            afficher();

        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }


    public void afficher()
    {
        PersonneRepository personneRepository=new PersonneRepository();
        ObservableList<Compte> list = personneRepository.getAllCompte();
        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
        coltypem.setCellValueFactory(new PropertyValueFactory<>("type"));
        table.setItems(list);
    }
    @FXML
    void charger(MouseEvent event) {
        Compte compte=new Compte();
      if (event.getClickCount()==1)
      {
        cnumero.setText(compte.getNumero());
        colmontant.setText(Integer.toString(compte.getMontant()));

      }
    }

    @FXML
    void btnModif(ActionEvent event) {

       // Compte compte = new Compte(colNumero.getText(),combo.getValue()
               // Integer.parseInt(coltypem.getText();

        //PersonneRepository.update(compte);
       // afficher()
      //  annuler(event);



    }

    @FXML
    void annuler(ActionEvent event) {
         cnumero.setText("");
         cmotant.setText("");
    }

    @FXML
    void btnSearch(ActionEvent event) {
        String sql="SELECT * FROM compte WHERE numero LIKE ?";
        try {
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1,"%"+searchFild.getText()+"%");
            ResultSet rs=statement.executeQuery();
            ObservableList<Compte> list=FXCollections.observableArrayList();
            while (rs.next())
            {
                Compte compte=new Compte();
                compte.setId(rs.getInt(1));
                compte.setNumero(rs.getString(2));
                compte.setMontant(rs.getInt(3));
                compte.setType(rs.getString(4));
                list.add(compte);
            }
            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
            colmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
            coltypem.setCellValueFactory(new PropertyValueFactory<>("type"));
            table.setItems(list);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    void btnSearche(ActionEvent event) {
        String sql="SELECT * FROM compte WHERE numero LIKE ?";
        try {
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(1,"%"+searchFild.getText()+"%");
            ResultSet rs=statement.executeQuery();
            ObservableList<Compte> list=FXCollections.observableArrayList();
            while (rs.next())
            {
                Compte compte=new Compte();
                compte.setId(rs.getInt(1));
                compte.setNumero(rs.getString(2));
                compte.setMontant(rs.getInt(3));
                compte.setType(rs.getString(4));
                list.add(compte);
            }
            colid.setCellValueFactory(new PropertyValueFactory<>("id"));
            colNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
            colmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
            coltypem.setCellValueFactory(new PropertyValueFactory<>("type"));
            table.setItems(list);
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bd = new BD();
        con = bd.getConnection();
        afficher();
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("Epargne", "Courant", "Bloqué");
        combo.setItems(list);


    }

}
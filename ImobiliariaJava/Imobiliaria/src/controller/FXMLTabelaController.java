/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ClienteDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import view.Imobiliaria;

/**
 * FXML Controller class
 *
 * @author localhost
 */
public class FXMLTabelaController implements Initializable {
     @FXML
    private TableView<Cliente> tabela;
    @FXML
    private TableColumn<Cliente, Integer> colid;

    @FXML
    private TableColumn<Cliente, String> colNome;

    @FXML
    private TableColumn<Cliente, String> colEmail;

    @FXML
    private TableColumn<Cliente, String> colSenha;

    @FXML
    private TableColumn<Cliente, String> colSexo;
    ClienteDAO dao = new ClienteDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTabela();   
    }    
    public void initTabela() {
        
        colid.setCellValueFactory(new PropertyValueFactory<>("numero"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colSenha.setCellValueFactory(new PropertyValueFactory<>("senha")); 
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));         
        tabela.setItems(listaCliente());       
    }
    public ObservableList<Cliente> listaCliente(){
        List<Cliente> lista =  dao.pesquisarAll();
        return FXCollections.observableArrayList(lista);        
    }
    @FXML
    void voltar() {
        Imobiliaria.trocaTela("inicio");
    }
}

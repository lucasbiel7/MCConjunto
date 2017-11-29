/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.ManipularConjunto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego Soares
 */
public class ProdutoCartesianoController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private ComboBox<Conjunto<Character>> cbPrimeiroConjunto;
    @FXML
    private Label lbPrimeiroConjunto;
    private List<Conjunto<Character>> conjuntos;
    private ManipularConjunto manipularConjunto;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            if(apPrincipal.getUserData()!=null){
                conjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
                cbPrimeiroConjunto.getItems().setAll(conjuntos);

            }
        });
        manipularConjunto=new ManipularConjunto();
    }
    @FXML
    public void onActionPrimeiroConjunto (ActionEvent ae) {
lbPrimeiroConjunto.setText(manipularConjunto.apresentarConjunto(cbPrimeiroConjunto.getSelectionModel().getSelectedItem()));
    } 
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.ManipularConjunto;
import br.com.MCConjunto.model.ParOrdenado;
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
    private ComboBox<Conjunto<Character>> cbSegundoConjunto;

    @FXML
    private Label lbPrimeiroConjunto;
    @FXML
    private Label lbSegundoConjunto;
    @FXML
    private Label lbResultado;

    private List<Conjunto<Character>> conjuntos;
    private ManipularConjunto manipularConjunto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            if (apPrincipal.getUserData() != null) {
                conjuntos = (List<Conjunto<Character>>) apPrincipal.getUserData();
                cbPrimeiroConjunto.getItems().setAll(conjuntos);

            }
        });
        manipularConjunto = new ManipularConjunto();
    }

    @FXML
    public void onActionPrimeiroConjunto(ActionEvent ae) {
        if (cbPrimeiroConjunto.getSelectionModel().getSelectedItem() != null) {
            lbPrimeiroConjunto.setText(manipularConjunto.apresentarConjunto(cbPrimeiroConjunto.getSelectionModel().getSelectedItem()));
            cbSegundoConjunto.getSelectionModel().clearSelection();
            cbSegundoConjunto.getItems().setAll(conjuntos);
            cbSegundoConjunto.getItems().remove(cbPrimeiroConjunto.getSelectionModel().getSelectedItem());
        } else {
            lbPrimeiroConjunto.setText("");
            cbSegundoConjunto.getItems().clear();
        }
    }

    @FXML
    private void onActionSegundoConjunto(ActionEvent ae) {
        if (cbSegundoConjunto.getSelectionModel().getSelectedItem() != null) {
            lbSegundoConjunto.setText(manipularConjunto.apresentarConjunto(cbSegundoConjunto.getSelectionModel().getSelectedItem()));
        } else {
            lbSegundoConjunto.setText("");
        }
    }

    @FXML
    private void onGerar(ActionEvent ae) {
        if (cbPrimeiroConjunto.getSelectionModel().getSelectedItem() != null && cbSegundoConjunto.getSelectionModel().getSelectedItem() != null) {
            Conjunto<ParOrdenado<Character, Character>> resultado = manipularConjunto.produtoCartesiano(cbPrimeiroConjunto.getSelectionModel().getSelectedItem(), cbSegundoConjunto.getSelectionModel().getSelectedItem());
            
        } else {
            new Alert(Alert.AlertType.ERROR, "É necessário selecionar dois conjuntos para gerar o produto cartesiano entre eles").showAndWait();
        }
    }

}

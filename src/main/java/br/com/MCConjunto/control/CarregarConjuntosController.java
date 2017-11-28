/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.GerenciadorDeJanela;
import br.com.MCConjunto.model.ManipularConjunto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author berna
 */
public class CarregarConjuntosController implements Initializable {

    @FXML
    private AnchorPane tlPrincipal;
    @FXML
    private ComboBox<Conjunto<Character>> cbConjunto;
    @FXML
    private TextField tfNomeElemento;
    @FXML
    private TableView<Conjunto<Character>> tvConjuntos;
    @FXML
    private TableColumn<Conjunto<Character>, String> tcNome;
    @FXML
    private TableColumn<Conjunto<Character>, String> tcElementos;

    private List<Conjunto<Character>> listaDeConjuntos;

    private ManipularConjunto manipularConjunto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(() -> {
            if (tlPrincipal.getUserData() instanceof List) {
                listaDeConjuntos = (List<Conjunto<Character>>) tlPrincipal.getUserData();
                cbConjunto.getItems().setAll(listaDeConjuntos);
                tvConjuntos.getItems().setAll(listaDeConjuntos);
            }
        });
        manipularConjunto = new ManipularConjunto();
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcElementos.setCellValueFactory((TableColumn.CellDataFeatures<Conjunto<Character>, String> param) -> {
            return new SimpleStringProperty(manipularConjunto.apresentarConjunto(param.getValue()));
        });
    }

    @FXML
    private void onActionBtVoltar(ActionEvent ae) {
        try {
            GerenciadorDeJanela gerenciadorDeJanela = new GerenciadorDeJanela(tlPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("Menu", listaDeConjuntos));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void onActionAdicionar(ActionEvent ae) {
        String[] elementos = tfNomeElemento.getText().split(";");
        for (String elemento : elementos) {
            if (elemento.matches("^([A-Za-z0-9](1))")) {
                cbConjunto.getSelectionModel().getSelectedItem().getElementos().add(elemento.charAt(0));
                new Alert(Alert.AlertType.INFORMATION, "Elemento" + elemento + "foi adicionado com sucesso").showAndWait();
            } else {
                new Alert(Alert.AlertType.ERROR, "Elemento" + elemento + "não é válido.").showAndWait();
            }
            tvConjuntos.getItems().setAll(listaDeConjuntos);
            tfNomeElemento.clear();
        }
    }
}

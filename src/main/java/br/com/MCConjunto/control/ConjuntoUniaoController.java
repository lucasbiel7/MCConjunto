/*
 * ouvir Skillet depois
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.GerenciadorDeJanela;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class ConjuntoUniaoController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private ComboBox<Conjunto<Character>> cbPrimeiroConjunto;
    @FXML
    private ComboBox<Conjunto<Character>> cbSegundoConjunto;
    

    private List<Conjunto<Character>> listaDeConjuntos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (apPrincipal.getUserData() !=null) {
            listaDeConjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
            cbPrimeiroConjunto.getItems().setAll(listaDeConjuntos);
        }
    }
    
    @FXML
    private void onActionConjuntoUniao(ActionEvent ae){
        
    }
    
    @FXML
    public void onActionCbPrimeiroConjunto(ActionEvent ae){
        cbSegundoConjunto.getItems().setAll(listaDeConjuntos.stream().filter((Conjunto<Character> conjunto) -> !conjunto.equals(cbPrimeiroConjunto.getSelectionModel().getSelectedItem())  ).collect(Collectors.toList()));
    }
    
    @FXML
    public void onVoltar(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ManipularConjunto",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }

}

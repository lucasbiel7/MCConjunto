/*
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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class AdicionarConjuntoController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    
    @FXML
    private TableView<Conjunto<String>> tvConjuntos;
    
    private List<Conjunto<String>> conjuntos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            conjuntos=(List<Conjunto<String>>) apPrincipal.getUserData();
        });
    }
    
    private void carregarTabela(){
        tvConjuntos.getItems().setAll(conjuntos);
    }
    
    @FXML
    private void btAdicionarConjunto(ActionEvent ae){
        
    }
    
    @FXML
    private void btVoltar(ActionEvent ae){
         try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("Menu",conjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
}

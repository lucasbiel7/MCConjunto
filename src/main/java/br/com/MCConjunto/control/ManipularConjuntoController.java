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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class ManipularConjuntoController implements Initializable {

    
    @FXML
    private AnchorPane apPrincipal;
    
    private List<Conjunto<Character>> listaDeConjuntos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(()->{
            if(apPrincipal.getUserData() != null){
                listaDeConjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
            }
        });
    }    
    
    @FXML
    private void onActionCompararConjunto(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ComparaConjunto",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void onActionConjuntoPotencia(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ConjuntoPotencia",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void onActionPertenceAoConjunto(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("PertenceAoConjunto",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void onActionConjuntoUniao(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ConjuntoUniao",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
   
    @FXML
    private void onActionConjuntoIntersecao(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ConjuntoIntersecao",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void onActionConjuntoDiferenca(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ConjuntoDiferenca",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void onProdutoCartesiano(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ProdutoCartesiano",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void onVoltar(){
         try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("Menu",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
}
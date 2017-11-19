/*
 * ouvir Skillet depois
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
import java.util.stream.Collectors;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    @FXML
    private Label lbResultado;
    
    @FXML
    private Label lbPrimeiroConjunto;
    @FXML
    private Label lbSegundoConjunto;
    private List<Conjunto<Character>> listaDeConjuntos;
    
    private Conjunto<Character> resultado;
    private ManipularConjunto manipularConjunto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(()->{
            if (apPrincipal.getUserData() != null) {
                listaDeConjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
                cbPrimeiroConjunto.getItems().setAll(listaDeConjuntos);
            }
        });
        manipularConjunto=new ManipularConjunto();
    }
    
    @FXML
    private void onActionConjuntoUniao(ActionEvent ae){
        if(cbPrimeiroConjunto.getSelectionModel().getSelectedItem()!=null && cbSegundoConjunto.getSelectionModel().getSelectedItem()!=null){
            
            resultado=manipularConjunto.conjuntoUniao(cbPrimeiroConjunto.getSelectionModel().getSelectedItem(), cbSegundoConjunto.getSelectionModel().getSelectedItem());
            lbResultado.setText(manipularConjunto.apresentarConjunto(resultado));
        }else{
            new Alert(Alert.AlertType.ERROR, "É necessário selecionar os dois conjuntos primeiro!").showAndWait();
        }
    }
    
    
    @FXML
    public void onActionCbPrimeiroConjunto(ActionEvent ae){
         if(cbPrimeiroConjunto.getSelectionModel().getSelectedItem()!=null)
            lbPrimeiroConjunto.setText(manipularConjunto.apresentarConjunto(cbPrimeiroConjunto.getSelectionModel().getSelectedItem()));
        else
            lbPrimeiroConjunto.setText("");
        cbSegundoConjunto.getSelectionModel().clearSelection();
        cbSegundoConjunto.getItems().setAll(listaDeConjuntos.stream().filter((Conjunto<Character> conjunto) -> !conjunto.equals(cbPrimeiroConjunto.getSelectionModel().getSelectedItem())  ).collect(Collectors.toList()));
    }
    
     @FXML
    public void onActionCbSegundoConjunto(ActionEvent ae){
         System.out.println("aaa");
        if(cbSegundoConjunto.getSelectionModel().getSelectedItem()!=null)
            lbSegundoConjunto.setText(manipularConjunto.apresentarConjunto(cbSegundoConjunto.getSelectionModel().getSelectedItem()));
        else
            lbSegundoConjunto.setText("");
    }
    
    
    @FXML
    public void onActionAdicionarResultado(ActionEvent ae){
        if(resultado!=null){
            if(!listaDeConjuntos.contains(resultado)){
                listaDeConjuntos.add(resultado);
            }else{
                new Alert(Alert.AlertType.ERROR, "Esse resultado já foi adicionado!").showAndWait();
            }
        }else{
            new Alert(Alert.AlertType.ERROR, "Não há resultados para ser adicionado!").showAndWait();
        }
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
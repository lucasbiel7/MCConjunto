/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.GerenciadorDeJanela;
import br.com.MCConjunto.model.ManipularConjunto;
import br.com.MCConjunto.model.Order;
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
public class ConjuntoPotenciaController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private Label lbValor;
    @FXML
    private ComboBox<Conjunto<Character>> cbConjunto;
    @FXML
    private Label lbResultado;
    
    
    private List<Conjunto<Character>> listaDeConjuntos;
    
    private Conjunto<Conjunto<Character>> resultado;
    private ManipularConjunto manipularConjunto;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(() -> {
            if(apPrincipal.getUserData()!=null && apPrincipal.getUserData() instanceof List){
                listaDeConjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
                cbConjunto.getItems().setAll(listaDeConjuntos);
            }
        });
        manipularConjunto=new ManipularConjunto();
    }
    
    @FXML
    private void onActionConjunto(ActionEvent ae){
        if (cbConjunto.getSelectionModel().getSelectedItem()!=null) {
            lbValor.setText(manipularConjunto.apresentarConjunto(cbConjunto.getSelectionModel().getSelectedItem()));
        }else{
            lbValor.setText("");
        }
    }
    
    @FXML
    private void onActionConjuntoPotencia(ActionEvent ae){
        if (cbConjunto.getSelectionModel().getSelectedItem()!=null) {
            resultado=manipularConjunto.conjuntoPotencia(cbConjunto.getSelectionModel().getSelectedItem());
            //TODO implementar a forma para ser apresentado o resulto
            StringBuilder stringBuilder=new StringBuilder(resultado.toString());
            stringBuilder.append(" = {");
            List<Conjunto<Character>> listaOrdenada=resultado.getElementos().stream().collect(Collectors.toList());
            listaOrdenada.sort((Conjunto<Character> primeiroConjunto,Conjunto<Character> segundoConjunto)->primeiroConjunto.compareTo(segundoConjunto));
            for (Conjunto<Character> listaDeConjunto : listaOrdenada) {
                stringBuilder.append(manipularConjunto.apresentarConjunto(listaDeConjunto));
                stringBuilder.append(", ");
            }
            if(!resultado.getElementos().isEmpty()){
                stringBuilder.delete(stringBuilder.toString().length()-2, stringBuilder.toString().length());
            }
            
            stringBuilder.append("}");
            lbResultado.setText(stringBuilder.toString());
        }else{
            new Alert(Alert.AlertType.ERROR, "Primeiro você deve selecionar um conjunto!").showAndWait();
        }
    }

    @FXML
    private void onActionVoltar(ActionEvent ae) {
        try {
            GerenciadorDeJanela gerenciadorDeJanela = new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ManipularConjunto", listaDeConjuntos));
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
}
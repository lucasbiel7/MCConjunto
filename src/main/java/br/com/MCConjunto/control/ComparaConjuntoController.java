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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class ComparaConjuntoController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private VBox vbConjuntos;
    @FXML
    private VBox vbResposta;
    
    
    
    
    private List<Conjunto<Character>> listaDeConjuntos;
    private ManipularConjunto manipularConjunto;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            if(apPrincipal.getUserData()!=null){
                listaDeConjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
                carregarConjuntos();
            }
        });
        manipularConjunto=new ManipularConjunto();
    }
    
    @FXML
    private void onVerificarIgualdade(ActionEvent ae){
        vbResposta.getChildren().clear();
        
        for (Conjunto<Character> conjuntoAtual : listaDeConjuntos) {
            StringBuilder builder=new StringBuilder(conjuntoAtual.getNome());
            for (Conjunto<Character> conjuntoVerificado : listaDeConjuntos) {
                if(!conjuntoAtual.equals(conjuntoVerificado)){
                   if(manipularConjunto.compararConjunto(conjuntoAtual, conjuntoVerificado)){
                       builder.append(" = ");
                       builder.append(conjuntoVerificado.getNome());
                   }
                }
            }
            vbResposta.getChildren().add(new Label(builder.toString()));
        }
    }
    
    @FXML
    private void onVoltar(ActionEvent actionEvent){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ManipularConjunto",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }

    private void carregarConjuntos() {
        vbConjuntos.getChildren().clear();
        for (Conjunto<Character> conjunto : listaDeConjuntos) {
            Label label=new Label(conjunto.toString());
            vbConjuntos.getChildren().add(label);
        }
    }
}

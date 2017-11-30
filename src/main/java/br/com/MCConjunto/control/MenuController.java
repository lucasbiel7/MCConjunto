/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.GerenciadorDeJanela;
import java.net.URL;
import java.util.ArrayList;
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
public class MenuController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    
    private List<Conjunto<Character>> listaDeConjuntos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            if(apPrincipal.getUserData() instanceof List){
                listaDeConjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
            }
        });
        if(listaDeConjuntos==null){
            listaDeConjuntos=new ArrayList<>();
            //TODO mock adicionado para testes
            //Remover ao entregar o projeto
            Conjunto<Character> c1=new Conjunto<>("A");
            c1.getElementos().add('a');
            c1.getElementos().add('b');
            c1.getElementos().add('b');
            c1.getElementos().add('c');
            c1.getElementos().add('d');
            c1.getElementos().add('e');
            c1.getElementos().add('f');
            c1.getElementos().add('g');
            c1.getElementos().add('h');
            c1.getElementos().add('i');
            c1.getElementos().add('j');
            c1.getElementos().add('k');
            c1.getElementos().add('l');
            c1.getElementos().add('m');
            c1.getElementos().add('n');
            c1.getElementos().add('o');
            c1.getElementos().add('p');
            c1.getElementos().add('q');
            c1.getElementos().add('r');
            c1.getElementos().add('s');
            c1.getElementos().add('t');
            c1.getElementos().add('u');
            c1.getElementos().add('v');
            c1.getElementos().add('w');
            c1.getElementos().add('x');
            c1.getElementos().add('y');
            c1.getElementos().add('A');
            c1.getElementos().add('B');
            c1.getElementos().add('C');
            c1.getElementos().add('D');
            c1.getElementos().add('E');
            c1.getElementos().add('F');
            c1.getElementos().add('G');
            c1.getElementos().add('H');
            c1.getElementos().add('I');
            c1.getElementos().add('J');
            c1.getElementos().add('K');
            c1.getElementos().add('L');
            c1.getElementos().add('M');
            c1.getElementos().add('N');
            c1.getElementos().add('O');
            c1.getElementos().add('P');
            c1.getElementos().add('Q');
            c1.getElementos().add('R');
            c1.getElementos().add('S');
            c1.getElementos().add('T');
            c1.getElementos().add('U');
            c1.getElementos().add('V');
            c1.getElementos().add('W');
            c1.getElementos().add('X');
            c1.getElementos().add('Y');
            c1.getElementos().add('Z');
            c1.getElementos().add('1');
            c1.getElementos().add('2');
            c1.getElementos().add('3');
            c1.getElementos().add('4');
            c1.getElementos().add('5');
            Conjunto<Character> c2=new Conjunto<>("B");
            c2.getElementos().add('a');
            c2.getElementos().add('d');
            c2.getElementos().add('2');
            c2.getElementos().add('f');
            c2.getElementos().add('8');
             Conjunto<Character> c3=new Conjunto<>("C");
            c3.getElementos().add('a');
            c3.getElementos().add('x');
            c3.getElementos().add('2');
            c3.getElementos().add('b');
             Conjunto<Character> c4=new Conjunto<>("D");
            c4.getElementos().add('a');
            c4.getElementos().add('b');
            listaDeConjuntos.add(c1);
            listaDeConjuntos.add(c2);
            listaDeConjuntos.add(c3);
            listaDeConjuntos.add(c4);
        }
    }
    
    @FXML
    public void btAdicionarConjunto(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("AdicionarConjunto",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void btCarregarConjuntos(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("CarregarConjuntos",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
    
    @FXML
    private void btManipularConjuntos(ActionEvent ae){
        try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("ManipularConjunto",listaDeConjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
}

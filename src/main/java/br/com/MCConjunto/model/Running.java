/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lucas
 */
public class Running extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GerenciadorDeJanela gerenciadorDeJanela = new GerenciadorDeJanela();
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            Platform.exit();
            System.exit(0);
        });
        gerenciadorDeJanela.mostrarJanela(primaryStage, gerenciadorDeJanela.carregarComponente("Menu"), "Início").show();
    }

    public static void main(String[] args) {
        //launch(args);
        Conjunto<Character> c1 = new Conjunto<>("A");
        c1.getElementos().add('a');
        c1.getElementos().add('b');
        c1.getElementos().add('x');
        c1.getElementos().add('2');
        Conjunto<Character> c2 = new Conjunto<>("B");
        c2.getElementos().add('a');
        c2.getElementos().add('d');
        c2.getElementos().add('2');
        c2.getElementos().add('f');
        c2.getElementos().add('8');
        IManipularConjunto temp = new ManipularConjunto();
        Conjunto<ParOrdenado<Character, Character>> resultado = temp.produtoCartesiano(c1, c2);
        

    }
}

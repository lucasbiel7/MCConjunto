/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author lucas
 */
public class Running extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela();
        primaryStage.setOnCloseRequest((WindowEvent event) -> {
            Platform.exit();
            System.exit(0);
        });
        gerenciadorDeJanela.mostrarJanela(primaryStage, gerenciadorDeJanela.carregarComponente("Menu"), "Início").show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class Running extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela();
        gerenciadorDeJanela.mostrarJanela(primaryStage, gerenciadorDeJanela.carregarComponente("Menu"), "Início").show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}

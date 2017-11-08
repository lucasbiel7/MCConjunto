/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.model;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author lucas
 */
public class GerenciadorDeJanela {
    
    public static final String PACOTE_VIEW="/br/com/MCConjunto/view/";
    private Scene scene;

    public GerenciadorDeJanela() {
    }

    public GerenciadorDeJanela(Scene scene) {
        this.scene = scene;
    }
    
    
    public Stage mostrarJanela(Stage primaryStage,Parent parent,String title){
        primaryStage.setTitle(title);
        scene=new Scene(parent);
        primaryStage.setScene(scene);
        return primaryStage;
    }
    
    public void trocarCena(Parent parent) {
        if(parent!=null){
            scene.setRoot(parent);
        }
    }
    
    public Parent carregarComponente(String tela) {
        try{
            return FXMLLoader.load(getClass().getResource(PACOTE_VIEW+""+tela+".fxml")); 
        }catch(IOException e){
            return null;
        }
    }
    
    public Parent carregarComponente(String tela,Object object){
        Parent parent=carregarComponente(tela);
        if(parent!=null){
            parent.setUserData(object);
        }
        return parent;
    }
}

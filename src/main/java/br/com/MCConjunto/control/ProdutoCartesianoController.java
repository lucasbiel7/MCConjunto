/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Diego Soares
 */
public class ProdutoCartesianoController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    
    private List<Conjunto<Character>> conjuntos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            if(apPrincipal.getUserData()!=null){
                conjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
            }
        });
    }    
    
}

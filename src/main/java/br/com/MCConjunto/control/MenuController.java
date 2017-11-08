/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class MenuController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    
    private List<Conjunto<String>> listaDeConjuntos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaDeConjuntos=new ArrayList<>();
    }
    
    @FXML
    public void btAdicionarConjunto(ActionEvent ae){
        
    }
    
    @FXML
    private void btCarregarConjuntos(ActionEvent ae){
        
    }
    
    @FXML
    private void btManipularConjuntos(ActionEvent ae){
        
    }
}

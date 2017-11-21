 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.MCConjunto.control;

import br.com.MCConjunto.model.Conjunto;
import br.com.MCConjunto.model.GerenciadorDeJanela;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author lucas
 */
public class AdicionarConjuntoController implements Initializable {

    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private TextField tfNome;
    
    @FXML
    private TableView<Conjunto<String>> tvConjuntos;
    @FXML
    private TableColumn<Conjunto<String>,String> tcNomeConjunto;
    @FXML
    private TableColumn<Conjunto<String>,Conjunto<String>> tcFuncao;
    
    private List<Conjunto<String>> conjuntos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            conjuntos=(List<Conjunto<String>>) apPrincipal.getUserData();
            carregarTabela();
        });
        tcNomeConjunto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcFuncao.setCellValueFactory((TableColumn.CellDataFeatures<Conjunto<String>, Conjunto<String>> param) -> new SimpleObjectProperty<>(param.getValue()));
        tcFuncao.setCellFactory((TableColumn<Conjunto<String>, Conjunto<String>> param) -> new TableCell<Conjunto<String>, Conjunto<String>>(){
            @Override
            protected void updateItem(Conjunto<String> item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setGraphic(null);
                }else{
                    Button button=new Button("Excluir");
                    button.setOnAction((ActionEvent event) -> {
                        conjuntos.remove(item);
                        carregarTabela();
                    });
                    setAlignment(Pos.CENTER);
                    setGraphic(button);
                }
            }
        });
    }
    
    private void carregarTabela(){
        tvConjuntos.getItems().setAll(conjuntos);
    }
    
    @FXML
    private void btAdicionarConjunto(ActionEvent ae){
        if(tfNome.getText().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Digite um nome para o conjunto").showAndWait();
            return;
        }
        conjuntos.add(new Conjunto<>(tfNome.getText()));
        carregarTabela();
        tfNome.clear();
        new Alert(Alert.AlertType.INFORMATION,"Conjunto adicionado com sucesso!").showAndWait();
        tfNome.requestFocus();
    }
    
    @FXML
    private void btVoltar(ActionEvent ae){
         try{
            GerenciadorDeJanela gerenciadorDeJanela=new GerenciadorDeJanela(apPrincipal.getScene());
            gerenciadorDeJanela.trocarCena(gerenciadorDeJanela.carregarComponente("Menu",conjuntos));
        }catch(Exception e){
            new Alert(Alert.AlertType.ERROR, "Módulo ainda não foi construido", ButtonType.OK).showAndWait();
        }
    }
}

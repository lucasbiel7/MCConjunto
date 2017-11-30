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
import java.util.stream.Collectors;
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
    private TableView<Conjunto<Character>> tvConjuntos;
    @FXML
    private TableColumn<Conjunto<Character>,String> tcNomeConjunto;
    @FXML
    private TableColumn<Conjunto<Character>,Conjunto<Character>> tcFuncao;
    
    private List<Conjunto<Character>> conjuntos;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Platform.runLater(()->{
            conjuntos=(List<Conjunto<Character>>) apPrincipal.getUserData();
            carregarTabela();
        });
        tcNomeConjunto.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcFuncao.setCellValueFactory((TableColumn.CellDataFeatures<Conjunto<Character>, Conjunto<Character>> param) -> new SimpleObjectProperty<>(param.getValue()));
        tcFuncao.setCellFactory((TableColumn<Conjunto<Character>, Conjunto<Character>> param) -> new TableCell<Conjunto<Character>, Conjunto<Character>>(){
            @Override
            protected void updateItem(Conjunto<Character> item, boolean empty) {
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
        if(!conjuntos.stream().map(Conjunto::getNome).filter((String nome)->nome.equalsIgnoreCase(tfNome.getText())).collect(Collectors.toList()).isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Já existe um conjunto com esse nome").showAndWait();
            return;
        }
        if(!tfNome.getText().matches("^([A-Z]{1})$")){
            new Alert(Alert.AlertType.ERROR,"O nome do conjunto deve ser uma letra entre A-Z").showAndWait();
            return ;
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

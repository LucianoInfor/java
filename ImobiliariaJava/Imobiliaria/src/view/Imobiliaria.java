
package view;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author localhost
 */
public class Imobiliaria extends Application {
    private static Stage stage;
    private static Scene inicio,tabela;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stage = primaryStage;
        Parent fxmlCadastror = FXMLLoader.load(getClass().getResource("FXMLCadastror.fxml"));
        inicio = new Scene(fxmlCadastror,570 , 350);
        
        Parent fxmlTabela = FXMLLoader.load(getClass().getResource("FXMLTabela.fxml"));
        tabela = new Scene(fxmlTabela,570 , 350);
        
       stage.setResizable(false);
       stage.setTitle("Cadastra");
       stage.setScene(inicio);
       stage.show();
    }
     public static void trocaTela(String op){
         switch(op){
             case "inicio":
                 stage.setTitle("Cadastra");
                 stage.setScene(inicio);
             break;
             case "tabela":
                 stage.setTitle("Tabela");
                 stage.setScene(tabela);
             break;
         }
     }
    public static void main(String[] args) {
        launch(args);
    }
    
}

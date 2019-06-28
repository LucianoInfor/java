
package controller;


import dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import model.Cliente;

/**
 * FXML Controller class
 *
 * @author localhost
 */
public class FXMLCadastrorController implements Initializable {

     @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private RadioButton rbmM;

    @FXML
    private RadioButton rbmF;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void salvar() {
        Cliente c = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        c.setNome(txtNome.getText());
        c.setEmail(txtEmail.getText());
        c.setSenha(txtSenha.getText());
        if(rbmM.isSelected()){
           c.setSexo("M"); 
        }else if(rbmF.isSelected()){
           c.setSexo("F");
        }
        dao.salvar(c);
    }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

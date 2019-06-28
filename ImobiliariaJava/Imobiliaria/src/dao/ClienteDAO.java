package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import view.Imobiliaria;

/**
 *
 * @author localhost
 */
public class ClienteDAO {
    public void salvar(Cliente c){
          Connection con = ConexaoImobiliaria.getConnection();
          PreparedStatement stmt = null;
          
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (nome, email, senha, sexo) VALUES (?,?,?,?)");
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEmail());
            stmt.setString(3, c.getSenha());
            stmt.setString(4, c.getSexo());
            
            stmt.executeUpdate();
           JOptionPane.showMessageDialog(null,"Salvo com Sucesso!!");
           Imobiliaria.trocaTela("tabela");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salva!!"+ex);
        }finally{
            ConexaoImobiliaria.fechaConexao(con, stmt);
        }
        
    } 
    public List<Cliente> pesquisarAll(){
        List<Cliente> lista = new ArrayList<>();
        Connection con = ConexaoImobiliaria.getConnection();
        PreparedStatement stmt = null;
        try {            
            stmt = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setNumero(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setSexo(rs.getString("sexo"));
                lista.add(cliente);                
            }
            return lista;
        } catch (Exception e) {
        }
        return null;
    }
}

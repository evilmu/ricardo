
package model.dao;

import conection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.bean.Clientes;




public class ClientesDAO {
    
    
    private Connection con = null;

    public ClientesDAO() {
        con = ConectionFactory.getConnection();
        
    }
    
    
    //metodo para cadastrar com FK
    public boolean save(Clientes clientes){
       
        String sql = "INSERT INTO clientes (fantasia, cep, uf, logradouro, nr, cidade, bairro, contato, email, fixo, celular, obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = null;
        
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, clientes.getFantasia());
            pst.setString(2, clientes.getCep());
            pst.setString(3, clientes.getUf());
            pst.setString(4, clientes.getLogradouro());
            pst.setString(5, clientes.getNr());
            pst.setString(6, clientes.getCidade());
            pst.setString(7, clientes.getBairro());
            pst.setString(8, clientes.getContato());
            pst.setString(9, clientes.getEmail());
            pst.setString(10, clientes.getFixo());
            pst.setString(11, clientes.getCelular());
            pst.setString(12, clientes.getObs());
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao Salvar!"+ex);
           return false;
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
    }
    
    
    //  CADASTRAR NO BANCO
    public void create(Clientes c){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("INSERT INTO clientes (fantasia, cep, uf, logradouro, nr, cidade, bairro, contato, email, fixo, celular, obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, c.getFantasia());
            pst.setString(2, c.getCep());
            pst.setString(3, c.getUf());
            pst.setString(4, c.getLogradouro());
            pst.setString(5, c.getNr());
            pst.setString(6, c.getCidade());
            pst.setString(7, c.getBairro());
            pst.setString(8, c.getContato());
            pst.setString(9, c.getEmail());
            pst.setString(10, c.getFixo());
            pst.setString(11, c.getCelular());
            pst.setString(12, c.getObs());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!"+ex);
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
}

  //METODO PARA BUSCA    
public List<Clientes> buscaNome(String nome){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Clientes> cliente = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("SELECT * from clientes WHERE fantasia LIKE ?");
            pst.setString(1, "%"+nome+"%");
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Clientes clientes = new Clientes();
                clientes.setCodigo(rs.getInt("codigo"));
                clientes.setFantasia(rs.getString("fantasia"));
                clientes.setCep(rs.getString("cep"));
                clientes.setUf(rs.getString("uf"));
                clientes.setLogradouro(rs.getString("logradouro"));
                clientes.setNr(rs.getString("nr"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setContato(rs.getString("contato"));
                clientes.setEmail(rs.getString("email"));
                clientes.setFixo(rs.getString("fixo"));
                clientes.setCelular(rs.getString("celular"));
                clientes.setObs(rs.getString("obs"));
                cliente.add(clientes); 
            }
        } catch (SQLException ex) {
         
        }finally{
            ConectionFactory.closeConnection(con, pst, rs);
        }
        return cliente;
}  
    

//METODO PARA LISTAR NA JTABLE    
public List<Clientes> read(){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Clientes> cliente = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("SELECT * from clientes ORDER BY fantasia");
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Clientes clientes = new Clientes();
                clientes.setCodigo(rs.getInt("codigo"));
                clientes.setFantasia(rs.getString("fantasia"));
                clientes.setCep(rs.getString("cep"));
                clientes.setUf(rs.getString("uf"));
                clientes.setLogradouro(rs.getString("logradouro"));
                clientes.setNr(rs.getString("nr"));
                clientes.setCidade(rs.getString("cidade"));
                clientes.setBairro(rs.getString("bairro"));
                clientes.setContato(rs.getString("contato"));
                clientes.setEmail(rs.getString("email"));
                clientes.setFixo(rs.getString("fixo"));
                clientes.setCelular(rs.getString("celular"));
                clientes.setObs(rs.getString("obs"));
                cliente.add(clientes); 
            }
        } catch (SQLException ex) {
         
        }finally{
            ConectionFactory.closeConnection(con, pst, rs);
        }
        return cliente;
}

    //  ATUALIZAAR NO BANCO
    public void update(Clientes c){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("UPDATE clientes SET fantasia = ?, cep = ?, uf = ?, logradouro = ?, nr = ?, cidade = ?, bairro = ?, contato = ?, email = ?, fixo = ?, celular = ?, obs = ? WHERE codigo = ?");
            pst.setString(1, c.getFantasia());
            pst.setString(2, c.getCep());
            pst.setString(3, c.getUf());
            pst.setString(4, c.getLogradouro());
            pst.setString(5, c.getNr());
            pst.setString(6, c.getCidade());
            pst.setString(7, c.getBairro());
            pst.setString(8, c.getContato());
            pst.setString(9, c.getEmail());
            pst.setString(10, c.getFixo());
            pst.setString(11, c.getCelular());
            pst.setString(12, c.getObs());
            pst.setInt(13, c.getCodigo());
            
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!"+ex);
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
}
    
    //  DELETAR NO BANCO
    public void delete(Clientes c){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("DELETE FROM clientes WHERE codigo = ?");
            pst.setInt(1, c.getCodigo());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Excluir!"+ex);
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
}

    public Object getFantasia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


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
import model.bean.Usuarios;



public class UsuariosDAO {
    
    //  CADASTRAR NO BANCO
    public void create(Usuarios u){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("INSERT INTO usuarios (usuario, senha) VALUES (?,?)");
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getSenha());
        
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!"+ex);
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
}

    
//METODO PARA LISTAR NA JTABLE    
public List<Usuarios> read(){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Usuarios> usuario = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("SELECT * from usuarios ORDER BY id");
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Usuarios usuarios = new Usuarios();
                usuarios.setId(rs.getInt("id"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setSenha(rs.getString("senha"));
                
                usuario.add(usuarios); 
            }
        } catch (SQLException ex) {
         
        }finally{
            ConectionFactory.closeConnection(con, pst, rs);
        }
        return usuario;
}

    //  ATUALIZAAR NO BANCO
    public void update(Usuarios u){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("UPDATE usuarios SET usuario = ?, senha = ? WHERE id = ?");
     
           
            pst.setString(1, u.getUsuario());
            pst.setString(2, u.getSenha());
            pst.setInt(3, u.getId());

            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!"+ex);
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
}
    
    //  DELETAR NO BANCO
    public void deleteU(Usuarios u){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            pst.setInt(1, u.getId());
            
            
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Usuário Excluído com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Erro ao Excluir!"+ex);
        }finally{
            ConectionFactory.closeConnection(con, pst);
        }
}
    
    //METODO PARA BUSCA    
public List<Usuarios> buscaUsuarios(String busuarios){
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        List<Usuarios> usuario = new ArrayList<>();
        
        try {
            pst = con.prepareStatement("SELECT * from usuarios WHERE usuario LIKE ?");
            pst.setString(1, "%"+busuarios+"%");
            rs = pst.executeQuery();
            
            while (rs.next()) {                
                Usuarios usuarios = new Usuarios();
                usuarios.setId(rs.getInt("id"));
                usuarios.setUsuario(rs.getString("usuario"));
                usuarios.setSenha(rs.getString("senha"));
                usuario.add(usuarios); 
            }
        } catch (SQLException ex) {
         
        }finally{
            ConectionFactory.closeConnection(con, pst, rs);
        }
        return usuario;
}  
    
    
    
    
    
    
    
    
}


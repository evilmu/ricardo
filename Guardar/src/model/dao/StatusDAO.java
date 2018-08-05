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
import model.dao.ClientesDAO;
import model.bean.Status;

public class StatusDAO {
                
    private Connection con = null;
    private Clientes fk_cad_clientes;

    public StatusDAO() {
        con = ConectionFactory.getConnection();
    }

    //metodo para cadastrar com FK
    public boolean save(Status status) {

        String sql = "INSERT INTO status (fk_cad_clientes, produto, status, obs, valor_implantacao, mensalidade) VALUES (?,?,?,?,?,?)";
        PreparedStatement pst = null;

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, status.getIfk_cad_clientes().getCodigo());
            pst.setString(2, status.getProduto());
            pst.setString(3, status.getStatus());
            pst.setString(4, status.getObs());
            pst.setString(5, status.getValor_implantacao());
            pst.setString(6, status.getMensalidade());
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar!" + ex);
            return false;
        } finally {
            ConectionFactory.closeConnection(con, pst);
        }
    }
  

    //  CADASTRAR NO BANCO normal
    public void createS(Status s) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("INSERT INTO status (fk_cad_clientes, produto, status, obs, valor_implantacao, mensalidade) VALUES (?,?,?,?,?,?)");
            pst.setInt(1, s.getIfk_cad_clientes().getCodigo());
            pst.setString(2, s.getProduto());
            pst.setString(3, s.getStatus());
            pst.setString(4, s.getObs());
            pst.setString(5, s.getValor_implantacao());
            pst.setString(6, s.getMensalidade());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao Salvar!" + ex);
        } finally {
            ConectionFactory.closeConnection(con, pst);
        }
    }

//METODO PARA LISTAR NA JTABLE    
    public List<Status> read() {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;

        List<Status> sts = new ArrayList<>();

        try {
            //pst = con.prepareStatement("SELECT * from status ORDER BY codigo");
            
            pst = con.prepareStatement("SELECT * FROM status T INNER JOIN clientes C on T.fk_cad_clientes = C.codigo");
            rs = pst.executeQuery();
            
           // String sql = "SELECT T.codigo,C.fantasia,produto,status,T.obs,valor_implantacao,mensalidade FROM status T INNER JOIN clientes c on T.fk_cad_clientes = c.codigo";
            //pst = con.prepareStatement(sql);     
            while (rs.next()) {
                Status status = new Status();
                Clientes cl = new Clientes();
                status.setCodigo(rs.getInt("codigo"));
                status.setFk_cad_clientes(rs.getString("fantasia"));
                status.setProduto(rs.getString("produto"));
                status.setStatus(rs.getString("status"));
                status.setObs(rs.getString("obs"));
                status.setValor_implantacao(rs.getString("valor_implantacao"));
                status.setMensalidade(rs.getString("mensalidade"));             
                sts.add(status);
            }
        } catch (SQLException ex) {

        } finally {
            ConectionFactory.closeConnection(con, pst, rs);
        }
        return sts;
    }

    //  ATUALIZAAR NO BANCO
    public void updateS(Status s) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("UPDATE Status SET fk_cad_clientes = ?, produto = ?, status = ?, obs = ?, valor_implantacao = ?, mensalidade = ? WHERE codigo = ?");
            pst.setInt(1, s.getIfk_cad_clientes().getCodigo());
            pst.setString(2, s.getProduto());
            pst.setString(3, s.getStatus());
            pst.setString(4, s.getObs());
            pst.setString(5, s.getValor_implantacao());
            pst.setString(6, s.getMensalidade());
            pst.setInt(7, s.getCodigo());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao Atualizar!" + ex);
        } finally {
            ConectionFactory.closeConnection(con, pst);
        }
    }

    //  DELETAR NO BANCO
    public void deleteS(Status s) {
        Connection con = ConectionFactory.getConnection();
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement("DELETE FROM status WHERE codigo = ?");
            pst.setInt(1, s.getCodigo());

            pst.execute();

            JOptionPane.showMessageDialog(null, "Usuário Excluído com sucesso!");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro ao Excluir!" + ex);
        } finally {
            ConectionFactory.closeConnection(con, pst);
        }
    }
    //METODO PARA BUSCA    
    public List<Status> buscaStatus(String bstatus){
            Connection con = ConectionFactory.getConnection();
            PreparedStatement pst = null;
            ResultSet rs = null;

            List<Status> status = new ArrayList<>();

            try {      //SELECT * FROM status T INNER JOIN clientes C on T.fk_cad_clientes = C.codigo WHERE produto LIKE ?
                //SELECT * from status WHERE produto LIKE ?
                pst = con.prepareStatement("SELECT * FROM status T INNER JOIN clientes C on T.fk_cad_clientes = C.codigo WHERE fantasia LIKE ?");
                pst.setString(1, "%"+bstatus+"%");
                rs = pst.executeQuery();

                while (rs.next()) {                
                    Status s = new Status();
                    s.setCodigo(rs.getInt("codigo"));
                    s.setFk_cad_clientes(rs.getString("fantasia"));
                    s.setProduto(rs.getString("produto"));
                    s.setStatus(rs.getString("status"));
                    s.setObs(rs.getString("obs"));
                    s.setValor_implantacao(rs.getString("valor_implantacao"));
                    s.setMensalidade(rs.getString("mensalidade"));   
                    
                    
                    status.add(s); 
                }
            } catch (SQLException ex) {

            }finally{
                ConectionFactory.closeConnection(con, pst, rs);
            }
            return status;
    }  


}

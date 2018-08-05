
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionFactory {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/contatosrd";
    private static final String USER = "postgres";
    private static final String PASS = "root";
    
    
    public static Connection getConnection(){     
         try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);  
        }catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException(" Erro na conexão: ", ex);
        }
        }
    
    
    //METODO PARA FECHAR A CONEXAO COM O BANCO DE DADOS
    public static void closeConnection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
    
//METODO PARA FECHAR A CONEXAO COM O BANCO DE DADOS e O PREPARED STATEMENT
    public static void closeConnection(Connection con, PreparedStatement pst){
       
        closeConnection(con);
            try {
                if(pst != null)
                pst.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    
//METODO PARA FECHAR A CONEXAO COM O BANCO DE DADOS e O PREPARED STATEMENT eo RESULT SET
    public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs){
       
        closeConnection(con, pst);
            try {
                if(rs != null)
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }    


    
}

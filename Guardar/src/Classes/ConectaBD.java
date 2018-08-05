
package Classes;
import java.sql.*;
import javax.swing.JOptionPane;
public class ConectaBD {
    
        public static Connection conectabd() throws ClassNotFoundException{
            
            try{
                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contatosrd","postgres","root");
               
                return con;
                
            }
            
            catch(SQLException error){
                JOptionPane.showMessageDialog(null, error);
                        
                return null;
            }
        }

    public static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

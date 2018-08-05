
package Telas;

import java.util.logging.Level;
import java.util.logging.Logger;





public class TelaInicial extends javax.swing.JFrame {

    
    public TelaInicial() {
        initComponents();
        
        
        
        
        
        
        //INICIO BARRA CARREGAMENTO
        new Thread(){
            public void run(){
                for(int i =0; i<101; i+=25){
                    try {
                        sleep(60);
                        jProgressBar1.setValue(i);                      
                       if (jProgressBar1.getValue() <=40){
                           statusBarra.setText("Carregando Banco de Dados");
                       }else if(jProgressBar1.getValue() <=70){
                           statusBarra.setText("Carregando Tabelas");
                       }else if(jProgressBar1.getValue() <=99){
                           statusBarra.setText("Carregando Sistema");
                        
                       }else if(jProgressBar1.getValue() == 100){
                            Login ja = null;
                                 try {
                             ja = new Login();
                             } catch (ClassNotFoundException ex) {
                               Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                          }
                              ja.setVisible(true);
                              dispose();
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TelaInicial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }   
            }
        }.start();  
    }
//FIM BARRA CARREGAMENTO    

    
    
    
   
    
    
    
    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Jpanel = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        statusBarra = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Jpanel.setBackground(new java.awt.Color(0, 204, 51));
        Jpanel.setLayout(null);

        jProgressBar1.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar1.setStringPainted(true);
        Jpanel.add(jProgressBar1);
        jProgressBar1.setBounds(-10, 400, 740, 17);

        statusBarra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statusBarra.setText("e");
        Jpanel.add(statusBarra);
        statusBarra.setBounds(280, 340, 500, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/fundoteste.png"))); // NOI18N
        Jpanel.add(jLabel1);
        jLabel1.setBounds(0, -70, 725, 560);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Jpanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel statusBarra;
    // End of variables declaration//GEN-END:variables

    private void createBanco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

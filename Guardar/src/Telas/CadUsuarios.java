
package Telas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Usuarios;
import model.dao.UsuariosDAO;

public class CadUsuarios extends javax.swing.JFrame {

    
    public CadUsuarios() throws ClassNotFoundException {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        tblUsuarios.setRowSorter(new TableRowSorter(modelo));
        readJtable();
    }
    
//LISTAR USUARIOS NA JT
    public void readJtable(){
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setNumRows(0);
        
        UsuariosDAO udao = new UsuariosDAO();
        
        for(Usuarios u:udao.read()){
            modelo.addRow(new Object[]{
            u.getId(),
            u.getUsuario(),
            u.getSenha()
            }); 
        }
    }
    
    //LIMPAR CAMPOS DO FORMULARIO
    public void limparCampos(){
            jtfCodUsuario.setText("");
            jtUsuario.setText("");
            jtfSenha.setText("");
    }
//CAMPO PARA BUSCA 
    public void buscaUsuariosNome(String busuarios){
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setNumRows(0);
        
        UsuariosDAO udao = new UsuariosDAO();
        
        for(Usuarios u:udao.buscaUsuarios(busuarios)){
            
            modelo.addRow(new Object[]{
            u.getId(),
            u.getUsuario(),
            u.getSenha(),
          
            });
            
        }
    }
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfBuscaUsuarios = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfCodUsuario = new javax.swing.JTextField();
        jtUsuario = new javax.swing.JTextField();
        jtfSenha = new javax.swing.JPasswordField();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        limparCampoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CÓDIGO", "USUÁRIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Buscar:");

        jtfBuscaUsuarios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBuscaUsuariosKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Código:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Usuário:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Senha:");

        jtfCodUsuario.setEditable(false);
        jtfCodUsuario.setBackground(new java.awt.Color(153, 255, 153));
        jtfCodUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/accept.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/pencil.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/user_delete.png"))); // NOI18N
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        limparCampoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/cancel.png"))); // NOI18N
        limparCampoUsuario.setText("Limpar");
        limparCampoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(395, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtUsuario)
                                    .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(limparCampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(94, 94, 94))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jtfBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btnCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtfCodUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addComponent(limparCampoUsuario)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(797, 435));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
     
if (jtUsuario.getText().equals("") ){
    JOptionPane.showMessageDialog(null, "O campo Usuário deve ser preenchido!","Aviso",JOptionPane.WARNING_MESSAGE);
    return;
}
if (jtfSenha.getText().equals("") ){
    JOptionPane.showMessageDialog(null, "O campo Senha deve ser preenchido!","Aviso",JOptionPane.WARNING_MESSAGE);
    return;
}
  else{
        if (JOptionPane.showConfirmDialog(null, "Deseja Cadastrar o Usuário: " + jtUsuario.getText() + " ?","CADASTRO DE USUÁRIOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
    //CHAMADA PARA O CADASTRO
    Usuarios u = new Usuarios();
    UsuariosDAO dao = new UsuariosDAO();
    u.setUsuario(jtUsuario.getText());
    u.setSenha(jtfSenha.getText());
    
//quando precisar transformar string em int c.setId(Integer.parseInt(txtId.getText()));
    dao.create(u);
    readJtable();
    limparCampos();
   }
  }   
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
 if (jtfCodUsuario.getText().equals("") ){
    JOptionPane.showMessageDialog(null, "Você não selecionou o Usuário para alterar!","Aviso",JOptionPane.WARNING_MESSAGE);

    return;
}
    else{  
        
    if (JOptionPane.showConfirmDialog(null, "Deseja Alterar o Usuário: " + jtUsuario.getText() + " ?","ATUALIZAÇAO DE USUÁRIOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
    Usuarios u = new Usuarios();
    UsuariosDAO dao = new UsuariosDAO();
    u.setId(Integer.parseInt(jtfCodUsuario.getText()));
    u.setUsuario(jtUsuario.getText());
    u.setSenha(jtfSenha.getText());
    

//quando precisar transformar string em int c.setId(Integer.parseInt(txtId.getText()));
    dao.update(u);
    readJtable();
    limparCampos();
    } 
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
   if (JOptionPane.showConfirmDialog(null, "Deseja Excluir o Usuário: " + jtUsuario.getText() + " ?","EXCLUIR USUÁRIOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
        
    Usuarios u = new Usuarios();
    UsuariosDAO udao = new UsuariosDAO();
    u.setId(Integer.parseInt(jtfCodUsuario.getText()));
    udao.deleteU(u);
    readJtable();
    limparCampos();
   }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void limparCampoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampoUsuarioActionPerformed
limparCampos();
    }//GEN-LAST:event_limparCampoUsuarioActionPerformed

    private void jtfBuscaUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscaUsuariosKeyReleased
buscaUsuariosNome(jtfBuscaUsuarios.getText());
    }//GEN-LAST:event_jtfBuscaUsuariosKeyReleased

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if (tblUsuarios.getSelectedRow() != -1){
            jtfCodUsuario.setText(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 0).toString());
            jtUsuario.setText(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 1).toString());
           // jtfSenha.setText(tblUsuarios.getValueAt(tblUsuarios.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(CadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CadUsuarios().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CadUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtUsuario;
    private javax.swing.JTextField jtfBuscaUsuarios;
    private javax.swing.JTextField jtfCodUsuario;
    private javax.swing.JPasswordField jtfSenha;
    private javax.swing.JButton limparCampoUsuario;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables

    void setViseble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

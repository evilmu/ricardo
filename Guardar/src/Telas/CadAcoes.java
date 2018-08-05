
package Telas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Clientes;
import model.bean.Status;
import model.dao.ClientesDAO;
import model.dao.StatusDAO;



public final class CadAcoes extends javax.swing.JFrame {

    public CadAcoes() throws ClassNotFoundException {
        initComponents();
        
        ClientesDAO dao = new ClientesDAO();
           for(Clientes c: dao.read()){
           txtCliente.addItem(c);
           
        }
        
       DefaultTableModel modelo = (DefaultTableModel) tblAcoes.getModel();
       tblAcoes.setRowSorter(new TableRowSorter(modelo));

       readJtable(); 
    }
    
    

  //LISTAR CLIENTES NA JT
    public void readJtable(){
        
        DefaultTableModel modelo = (DefaultTableModel) tblAcoes.getModel();
        modelo.setNumRows(0);
        Clientes cli = new Clientes();
        Status sta = new Status();
        StatusDAO cdao = new StatusDAO();
        ClientesDAO dao = new ClientesDAO();
        
        for(Status c:cdao.read()){
            modelo.addRow(new Object[]{
            c.getCodigo(),  
            c.getFk_cad_clientes(),
            c.getProduto(),
            c.getStatus(),
            c.getObs(),
            c.getValor_implantacao(),
            c.getMensalidade(),
       
            });
           
        }
    }
   
    /**Status status = new Status();
    StatusDAO dao = new StatusDAO();
    status.setFk_cad_clientes(clientes);
   Clientes clientes = (Clientes) cbClientes.getSelectedItem();
       JOptionPane.showMessageDialog(null, "ID: "+clientes.getCodigo()+" Nome: "+clientes.getFantasia());
    
//LISTAR STATUS NA JT
    public void readJtable(){
        DefaultTableModel modelo = (DefaultTableModel) tblAcoes.getModel();
        modelo.setNumRows(0);
        
        Status status = new Status();
        StatusDAO dao = new StatusDAO();
        Clientes clientes = new Clientes();
        ClientesDAO cdao = new ClientesDAO();
     
        //status.setFk_cad_clientes(clientes);
        for(Status s:dao.readS()){
            modelo.addRow(new Object[]{
            s.getCodigo(),
            s.getFk_cad_clientes(),
            s.getProduto(),
            s.getStatus(),
            s.getObs(),
            s.getValor_implantacao(),
            s.getMensalidade(),
            }); 
        }
    }
    */
    
    
    //LIMPAR CAMPOS DO FORMULARIO
    public void limparCampos(){
            
            codAcoes.setText("");
            txtCliente.setSelectedItem("Selecione o Cliente");
            txtImplantacao.setText("");
            txtMensal.setText("");
            txtObs.setText("");
            txtData.setText("");
            txtProduto.setSelectedItem("Selecione o Produto");
            txtStatus.setSelectedItem("Selecione o Status");  
    }
    

//CAMPO PARA BUSCA 
    public void buscaStatusNome(String bstatus){
        DefaultTableModel modelo = (DefaultTableModel) tblAcoes.getModel();
        modelo.setNumRows(0);
        
        StatusDAO sdao = new StatusDAO();
        
        for(Status s:sdao.buscaStatus(bstatus)){
            
            modelo.addRow(new Object[]{
            s.getCodigo(),
            s.getFk_cad_clientes(),
            s.getProduto(),
            s.getStatus(),
            s.getObs(),
            s.getValor_implantacao(),
            s.getMensalidade(),
          
            });
            
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblAcoes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtfBuscaUsuarios = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        codAcoes = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        limparCampoUsuario = new javax.swing.JButton();
        txtCliente = new javax.swing.JComboBox<>();
        txtData = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JComboBox<>();
        txtProduto = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtImplantacao = new javax.swing.JTextField();
        txtMensal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblAcoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CÓDIGO", "CLIENTE", "PRODUTO", "STATUS", "OBSERVAÇÕES", "VALOR IMPLANTAÇÃO", "MENSALIDADE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAcoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAcoesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAcoes);
        if (tblAcoes.getColumnModel().getColumnCount() > 0) {
            tblAcoes.getColumnModel().getColumn(0).setPreferredWidth(30);
            tblAcoes.getColumnModel().getColumn(0).setHeaderValue("CÓDIGO");
            tblAcoes.getColumnModel().getColumn(1).setHeaderValue("CLIENTE");
            tblAcoes.getColumnModel().getColumn(2).setHeaderValue("PRODUTO");
            tblAcoes.getColumnModel().getColumn(3).setHeaderValue("STATUS");
            tblAcoes.getColumnModel().getColumn(4).setHeaderValue("OBSERVAÇÕES");
            tblAcoes.getColumnModel().getColumn(5).setHeaderValue("VALOR IMPLANTAÇÃO");
            tblAcoes.getColumnModel().getColumn(6).setHeaderValue("MENSALIDADE");
        }

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
        jLabel3.setText("Cliente:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Data do Contato:");

        codAcoes.setEditable(false);
        codAcoes.setBackground(new java.awt.Color(153, 255, 153));
        codAcoes.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        txtCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Cliente" }));
        txtCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtClienteMouseClicked(evt);
            }
        });
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Produto:");

        txtStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Status", "Primeiro Contato", "Em Negociação", "Negócio Fechado", "Negócio Perdido" }));
        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });

        txtProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o Produto", "Sistema", "Impressoras Fiscais", "Informática", "CFTV" }));

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane2.setViewportView(txtObs);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Valor Implantação:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Valor Mensal:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtImplantacao, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMensal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(limparCampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfBuscaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(codAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar)
                        .addGap(18, 18, 18)
                        .addComponent(limparCampoUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(txtImplantacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMensal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(842, 664));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        Clientes clientes = (Clientes) txtCliente.getSelectedItem();
        JOptionPane.showMessageDialog(null, "ID: "+clientes.getCodigo()+" Nome: "+clientes.getFantasia());
        
        
        
        if (txtCliente.getSelectedItem().equals("Selecione o Cliente") ){
           JOptionPane.showMessageDialog(null, "Você deve selecionar um Cliente!","Aviso",JOptionPane.WARNING_MESSAGE);
           return;
        }
        if (txtProduto.getSelectedItem().equals("Selecione o Produto") ){
            JOptionPane.showMessageDialog(null, "Você deve selecionar um Produto!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtStatus.getSelectedItem().equals("Selecione o Status") ){
            JOptionPane.showMessageDialog(null, "Você deve selecionar um Status!","Aviso",JOptionPane.WARNING_MESSAGE);
            return;
        }

        else{
              if (JOptionPane.showConfirmDialog(null, "Deseja Cadastrar um novo Status para o Cliente: " + txtCliente.getSelectedItem()+ " ?","CADASTRO DE STATUS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
          //CHAMADA PARA O CADASTRO
          Status status = new Status();
          StatusDAO dao = new StatusDAO();
          status.setIfk_cad_clientes(clientes);
          status.setProduto((String) txtProduto.getSelectedItem());
          status.setStatus((String) txtStatus.getSelectedItem());
          status.setObs(txtObs.getText());
          status.setValor_implantacao(txtImplantacao.getText());
          status.setMensalidade(txtMensal.getText());


          //pst.setInt(1, status.getFk_cad_clientes().getCodigo());
      //quando precisar transformar string em int c.setId(Integer.parseInt(txtId.getText()));
          dao.save(status);
          JOptionPane.showMessageDialog(null, "Negociação para o Cliente: "+clientes.getFantasia()+" Adicionado com sucesso!");
          readJtable();
          limparCampos();
         }
     }   


        
    
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
if (codAcoes.getText().equals("") ){
    JOptionPane.showMessageDialog(null, "Você não selecionou uma Negociação para alterar!","Aviso",JOptionPane.WARNING_MESSAGE);
   
    return;
    }
    else{  
        
    if (JOptionPane.showConfirmDialog(null, "Deseja Alterar o Negócio referente ao Cliente: " + txtCliente.getSelectedItem()+ " ?","ATUALIZAÇAO DE NEGOCIAÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
    Status s = new Status();
    StatusDAO dao = new StatusDAO();
    //s.setCodigo(Integer.parseInt(codAcoes.getText()));
    s.setProduto((String) txtProduto.getSelectedItem());
    s.setValor_implantacao((String) txtImplantacao.getText());
    s.setMensalidade(txtMensal.getText());
    s.setStatus((String) txtStatus.getSelectedItem());
    s.setObs(txtObs.getText());
    
//quando precisar transformar string em int c.setId(Integer.parseInt(txtId.getText()));
    dao.updateS(s);
    readJtable();
    limparCampos();
    } 
    }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
 if (JOptionPane.showConfirmDialog(null, "Deseja Excluir a Negociação: " + txtCliente.getSelectedItem()+ " ?","EXCLUIR NEGOCIAÇÃO", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
        
    Status s = new Status();
    StatusDAO dao = new StatusDAO();
    s.setCodigo(Integer.parseInt(codAcoes.getText()));
    dao.deleteS(s);
    readJtable();
    limparCampos();      
 }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void limparCampoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampoUsuarioActionPerformed
limparCampos();
    }//GEN-LAST:event_limparCampoUsuarioActionPerformed

    private void jtfBuscaUsuariosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscaUsuariosKeyReleased
        buscaStatusNome(jtfBuscaUsuarios.getText()); 
    }//GEN-LAST:event_jtfBuscaUsuariosKeyReleased

    private void tblAcoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAcoesMouseClicked
        if (tblAcoes.getSelectedRow() != -1){
            codAcoes.setText(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 0).toString());
            txtCliente.setSelectedItem(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 1).toString()); 
            //txtData.setText(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 2).toString());
            txtProduto.setSelectedItem(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 2).toString());
            txtImplantacao.setText(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 5).toString());
            txtMensal.setText(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 6).toString());
            txtStatus.setSelectedItem(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 3).toString());
            txtObs.setText(tblAcoes.getValueAt(tblAcoes.getSelectedRow(), 4).toString());
}            
    }//GEN-LAST:event_tblAcoesMouseClicked

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void txtClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteMouseClicked
      
    }//GEN-LAST:event_txtClienteMouseClicked

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed

    }//GEN-LAST:event_txtClienteActionPerformed

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
            java.util.logging.Logger.getLogger(CadAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadAcoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new CadAcoes().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CadAcoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JTextField codAcoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jtfBuscaUsuarios;
    private javax.swing.JButton limparCampoUsuario;
    private javax.swing.JTable tblAcoes;
    private javax.swing.JComboBox<Object> txtCliente;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtImplantacao;
    private javax.swing.JTextField txtMensal;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JComboBox<String> txtProduto;
    private javax.swing.JComboBox<String> txtStatus;
    // End of variables declaration//GEN-END:variables

    void setViseble(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void listaUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String arr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    private static class campoBox {

        private static void addItem(String string) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public campoBox() {
        }
    }

    private static class clientes {

        private static String fk_cad_clientes;
        

        public clientes() {
        }
    }
}

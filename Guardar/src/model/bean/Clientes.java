
package model.bean;


public class Clientes {

    public static Clientes getString(String fantasia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Clientes getInt(String fk_cad_clientes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int codigo;
    public String fantasia;
    private String cep;
    private String uf;
    private String logradouro;
    private String nr;
    private String cidade;
    private String bairro;
    private String contato;
    private String email;
    private String fixo;
    private String celular;
    private String obs;

    public Clientes() {
        //this(0,"","","","","","","","","","","","");
    }

    public Clientes(int codigo, String fantasia, String cep, String uf, String logradouro, String nr, String cidade, String bairro, String contato, String email, String fixo, String celular, String obs) {
        
        this.setFantasia(fantasia);
        this.setCep(cep);
        this.setUf(uf);
        this.setLogradouro(logradouro);
        this.setNr(nr);
        this.setCidade(cidade);
        this.setBairro(bairro);
        this.setContato(contato);
        this.setEmail(email);
        this.setFixo(fixo);
        this.setCelular(celular);
        this.setObs(obs);
    }

    public Clientes(String teste_de_clientes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFixo() {
        return fixo;
    }

    public void setFixo(String fixo) {
        this.fixo = fixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return getFantasia(); //To change body of generated methods, choose Tools | Templates.
    }

    public String setFk_cad_clientes(int c) {
        return getFantasia();
    }

    public void getCodigo(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}

package model.bean;


public class Status {
    private int codigo;
    public String fk_cad_clientes;
    public Clientes ifk_cad_clientes;
    private String produto;
    private String status;
    private String obs;
    private String valor_implantacao;
    private String mensalidade;

    public Status() {
        
    }

    public Status(Clientes ifk_cad_clientes,String fk_cad_clientes, String produto, String status, String obs, String valor_implantacao, String mensalidade) {
        this.ifk_cad_clientes = ifk_cad_clientes;  
        this.fk_cad_clientes = fk_cad_clientes;
        this.produto = produto;
        this.status = status;
        this.obs = obs;
        this.valor_implantacao = valor_implantacao;
        this.mensalidade = mensalidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getValor_implantacao() {
        return valor_implantacao;
    }

    public void setValor_implantacao(String valor_implantacao) {
        this.valor_implantacao = valor_implantacao;
    }

    public String getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(String mensalidade) {
        this.mensalidade = mensalidade;
    }

    public void add(Status status) {
    }

    public void setInt(int codigo) {
    }

    public void setStatus(Status status) {
        this.status = this.status;
    }

    public String getFk_cad_clientes() {
        return fk_cad_clientes;
    }

    public void setFk_cad_clientes(String fk_cad_clientes) {
        this.fk_cad_clientes = fk_cad_clientes;
       // System.out.println("bbb"+fk_cad_clientes);
    }

    public Clientes getIfk_cad_clientes() {
        return ifk_cad_clientes;
    }

    public void setIfk_cad_clientes(Clientes ifk_cad_clientes) {
        this.ifk_cad_clientes = ifk_cad_clientes;
    }

    
   

    
    
    
}
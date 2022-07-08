
package bancodedados;


public class Endereco {
    private Integer id;
    private String cep;
    private String cidade;
    private String uf;
    private String bairro;
    private String rua;
    private int numero;
    

    public Endereco() {
    }

    public Endereco(String cep, String cidade, String uf, String bairro, String rua, int numero) {
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setIn(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public void cadastroEndereco(){
        System.out.println("informe o id");
        id = Input.nextInt();
    
        System.out.println("informe a cidade ");
        cidade = Input.nextLine(true);
        
        System.out.println("informe uf ");
        uf = Input.nextLine(true);
        
        System.out.println("informe o cep ");
        cep = Input.nextLine(true);
        
        System.out.println("informe o bairro ");
        bairro = Input.nextLine(true);
        
        System.out.println("iforme a rua ");
        rua = Input.nextLine(true);
        
        
        
    }  
    public void exibirEndereco(){
    System.out.println("Endereco{" + "id=" + id + ", cep=" + cep + ", cidade=" + cidade + ", uf=" + uf + ", bairro=" + bairro + ", rua=" + rua + ", numero=" + numero + '}');
    }
    
}

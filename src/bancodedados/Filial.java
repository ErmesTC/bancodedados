
package bancodedados;


public class Filial  {
    private Integer id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private Endereco endereco;

    public Filial() {
        endereco = new Endereco();
    }

    
    public Filial(String cnpj, String nomeFantasia, String inscricaoEstadual, Endereco endereco,String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.inscricaoEstadual = inscricaoEstadual;
        this.endereco = endereco;
    }

    

    
    

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public void cadastroFilial (){
        System.out.println("informe o id");
        id = Input.nextInt();
        System.out.println("infome o cnpj");
        cnpj = Input.nextLine();
        System.out.println("informe  nome fantasia");
        nomeFantasia = Input.nextLine();
        System.out.println("informe a inscriçao estadual");
        inscricaoEstadual = Input.nextLine();
//        System.out.println("informe a razao social");
    }

    public void exibirFilial (){
        System.out.println("id"+id+ ",cnpj"+cnpj+ ",nome fantasia"+nomeFantasia+ ", inscriçao estadual"+inscricaoEstadual);
        endereco.exibirEndereco();
    }

   
    
    
}

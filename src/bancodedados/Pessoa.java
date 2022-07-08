
package bancodedados;

import java.util.Date;


public class Pessoa {
    private Integer id;
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private Date dataNascimento;
    private Endereco endereco;

    public Pessoa() {
        endereco = new Endereco();
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    
    public void cadastroPessoa (){
        System.out.println("informe o id");
        id = Input.nextInt();
        System.out.println("informe seu nome");
        nome = Input.nextLine(true);
        System.out.println("informe seu cpf");
        cpf = Input.nextLine(true);
        System.out.println("informe seu rg");
        rg = Input.nextLine(true);
        System.out.println("informe seu telefone");
        telefone = Input.nextLine(true);
        System.out.println("informe seu email");
        email = Input.nextLine(true);
        System.out.println("informe a data do seu nascimento");
        dataNascimento = Input.nextDate();
        endereco.cadastroEndereco();
       
        
            
        
    }

    public void exibirPessoa (){
        System.out.println("Pessoa{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", telefone=" + telefone + ", email=" + email + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco);
    }
    
}

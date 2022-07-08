
package bancodedados;


public class Funcionario extends Pessoa {
    private Integer id;
    private String ctps;
    private String cargo;
    private Filial filial;
    private String cnh;

    public Funcionario() {
        filial = new Filial();
    }
      
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }
    
    
    public void cadastroFuncionario(){
        super.cadastroPessoa();
        System.out.println("informe o id");
        id = Input.nextInt();
        System.out.println("informe o ctps");
        ctps = Input.nextLine();
        System.out.println("informe o cargo");
        cargo = Input.nextLine();
        filial.cadastroFilial();
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", ctps=" + ctps + ", cargo=" + cargo + ", filial=" + filial + '}';
    }
    
}

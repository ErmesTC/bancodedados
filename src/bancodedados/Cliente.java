package bancodedados;

import java.util.Date;


public class Cliente extends Pessoa{
    private String cnh;

    public Cliente() {
    }
    
    
    
    public Cliente(String cnh) {
        this.cnh = cnh;
       
    }
      

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void cadastroCliente() {
        super.cadastroPessoa();
        System.out.println("informe a cnh");
        cnh = Input.nextLine();
        
    }
    
    
    public void exibirCliente(){
        super.exibirPessoa();
        System.out.println("cnh"+cnh);
    }

    public void getDataNascimento(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

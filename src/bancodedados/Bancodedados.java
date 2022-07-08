
package bancodedados;

import bancodedados.newpackage.Main;
import bancodedados.newpackage.cliente;
import bancodedados.newpackage.listaCliente;
import bancodedados.newpackage.telaExemplo;
import static java.lang.String.format;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;


public class Bancodedados {
    
    private static ArrayList<Filial> listafilial;
    private static DaoFilial daofilial;  
    private static ArrayList<Endereco> listaendereco;
    private static DaoEndereco daoendereco;
    private static ArrayList<Cliente> listacliente;
    private static DaoCliente daocliente;

  
    public static void main(String[] args) throws SQLException {
        
        conexaoBD.abrirconexao();   
        
        /*telaExemplo tela = new telaExemplo();
        tela.setVisible(true);*/
        //cliente tel = new cliente(2);
        //tel.setVisible(true);
        Main tela = new Main();
        tela.setVisible(true);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*int resposta;
        String res;
        
        int op = -1;
        
        while (op != 0){
            String valorDigitado = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadrastrar Filial"
                    +"\nDigite 2 para casastrar cliente"
                    +"\nDigite 3 para remover filial",
                    "menu", JOptionPane.QUESTION_MESSAGE);
            
            Cliente cliente = null;
            Filial filial = null;
            switch (op) {
                case 1:
                    filial = new Filial();
                    filial.cadastroFilial();
                    daofilial.salvar(filial);
                    break;
                case 2:
                    cliente = new Cliente();
                    cliente.cadastroPessoa();
                    daocliente.salvar(cliente);
                    break;
                case 3:
                    System.out.println("Informe o Id da Filial:");
                    resposta = Input.nextInt();
                    filial = daofilial.carregarFilialId(resposta);
                    daofilial.remover(filial);
                    break;
                case 4:
                    System.out.println("Informe o Id do Cliente:");
                    resposta = Input.nextInt();
                    cliente = daocliente.carregarClienteId(resposta);
                    daocliente.remover(cliente);
                    break;
                case 5:
                    System.out.println("Informe o ID da Filial: ");
                    resposta = Input.nextInt();
                    filial = daofilial.carregarFilialId(resposta);
                    System.out.println("Qual coluna deseja editar: ");
                    res = Input.nextLine(true);
                    if ("nome".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        filial.setNomeFantasia(res);
                        daofilial.atualizar(filial);
                    }
                    if ("razao social".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        filial.setRazaoSocial(res);
                        daofilial.atualizar(filial);
                    }
                    if ("cnpj".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        filial.setCnpj(res);
                        daofilial.atualizar(filial);
                    }
                    if ("inscricao estadual".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        filial.setInscricaoEstadual(res);
                        daofilial.atualizar(filial);
                    }
                    break;
                case 6:
                    System.out.println("Informe ID do cliente: ");
                    resposta = Input.nextInt();
                    cliente = daocliente.carregarClienteId(resposta);
                    System.out.println("Qual coluna deseja editar: ");
                    res = Input.nextLine(true);
                    if ("nome".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        cliente.setNome(res);
                        daocliente.atualizar(cliente);
                    }
                    if ("cpf".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        cliente.setCpf(res);
                        daocliente.atualizar(cliente);
                    }
                    if ("rg".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        cliente.setRg(res);
                        daocliente.atualizar(cliente);
                    }
                    if ("telefone".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        cliente.setTelefone(res);
                        daocliente.atualizar(cliente);
                    }                    
                    if ("cnh".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        cliente.setCnh(res);
                        daocliente.atualizar(cliente);
                    }
                    if ("email".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        cliente.setEmail(res);
                        daocliente.atualizar(cliente);
                    }
                    if ("data nascimento".equals(res)) {
                        System.out.println("Informe a nova edição: ");
                        res = Input.nextLine();
                        try {
                            cliente.setDataNascimento(format.parse(res));
                        } catch (ParseException ex) {
                            System.out.println("erro");
                        }
                        daocliente.atualizar(cliente);
                    }
                    break;
                case 7:
                    exibirfiliais();
                    break;
                case 8:
                    exibirCliente();
                    break;
                case 9:
                    exibirfiliais();
                    exibirCliente();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Inválido!!!");
            }
        }
        
        
               
    }
    public static void exibirfiliais (){
        for (int i = 0; i < listafilial.size(); i++) {
            listafilial.get(i).exibirFilial();
            
        }
    }
    public static void exibirendereco (){
        for (int i = 0; i < listaendereco.size(); i++) {
            listaendereco.get(i).exibirEndereco();
            
        }
    }*/
    }
}

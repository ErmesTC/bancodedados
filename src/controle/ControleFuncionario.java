package controle;

import bancodedados.DaoFilial;
import bancodedados.DaoFuncionario;
import bancodedados.Filial;
import bancodedados.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControleFuncionario {

    private Funcionario funcionario;
    private ArrayList<Funcionario> listafuncionario;
    private ArrayList<Filial> listafilial;
    private DaoFuncionario dao;
    private DaoFilial daoF;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;

    public ControleFuncionario() {
        funcionario = new Funcionario();
        dao = new DaoFuncionario();
        daoF = new DaoFilial();
        listafuncionario = new ArrayList<>();
        listafilial = daoF.carregarFiliais();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<Funcionario> getListafuncionario() {
        return listafuncionario;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarFuncionario(int idFuncionario) {
        funcionario = dao.carregarFuncionarioId(idFuncionario);
    }

    public boolean salvar() throws SQLException {
        if (this.editarCadastro == true) {
            return dao.atualizar(funcionario);
        } else {
            return dao.salvar(funcionario);
        }
    }

    public ArrayList<Filial> getListafilial() {
        return listafilial;
    }
    
    public String[] getNomeFiliais(){
        String [] filiais = new String[listafilial.size()];
        for (int i = 0; i < listafilial.size(); i++) {
            filiais[i] = listafilial.get(i).getNomeFantasia();     
        }
        return filiais;
    }

    public boolean remover(Funcionario funcionario) {
        return dao.remover(funcionario);
    }

    public void carregarFuncionario() {
        listafuncionario = dao.carregarFuncionario();
    }

    public DefaultTableModel gerarTableModel() {
        carregarFuncionario();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nome");
        model.addColumn("telefone");
        for (int i = 0; i < listafuncionario.size(); i++) {
            Funcionario fil = listafuncionario.get(i);
            Object[] dados = {
                fil.getId(),
                fil.getNome(),
                fil.getTelefone()

            };
            model.addRow(dados);

        }
        return model;

    }

}

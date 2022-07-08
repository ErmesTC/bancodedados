package controle;

import bancodedados.DaoFilial;
import bancodedados.Filial;
import bancodedados.newpackage.filial;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControleFilial {

    private Filial filial;
    private ArrayList<Filial> listafilial;
    private DaoFilial dao;
    private boolean editarCadastro = false;
    private boolean removerCadastro = false;

    public ControleFilial() {
        filial = new Filial();
        dao = new DaoFilial();
        listafilial = new ArrayList<>();
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }

    public void setEditarCadastro(boolean editarCadastro) {
        this.editarCadastro = editarCadastro;
    }

    public void carregarFilial(int idFilial) {
        filial = dao.carregarFilialId(idFilial);
    }

    public ArrayList<Filial> getListafilial() {
        return listafilial;
    }

    public boolean salvar() throws SQLException {
        if (this.editarCadastro == true) {
            return dao.atualizar(filial);
        } else {
            return dao.salvar(filial);
        }
    }

    public boolean remover(Filial filial) {
        return dao.remover(filial);
    }

    public void carregarFilial() {
        listafilial = dao.carregarFiliais();
    }

    public DefaultTableModel gerarTableModel()  {
        carregarFilial();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("nome");
        model.addColumn("razao");
        for (int i = 0; i < listafilial.size(); i++) {
            Filial fil = listafilial.get(i);
            Object[] dados = {
                fil.getId(),
                fil.getNomeFantasia(),
                fil.getRazaoSocial()

            };
            model.addRow(dados);

        }
        return model;
    }

}

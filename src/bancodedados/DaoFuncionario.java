package bancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoFuncionario extends DAO {

    public DaoEndereco daoEndereco;
    public DaoFilial daoFilial;
    

    public DaoFuncionario() {
        daoEndereco = new DaoEndereco();
    }

    public ArrayList<Funcionario> carregarFuncionario() {
        ArrayList<Funcionario> funcionario = new ArrayList<>();

        try {

            String sql = "select * from funcionario"
                    + " left join endereco as ed on funcionario.id_endereco = ed.id "
                    + " left join filial as fil on funcionario.id_filial = fil.id \n";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Funcionario Funcionario = new Funcionario();
                Funcionario.setId(rs.getInt("id"));
                Funcionario.setCpf(rs.getString("cpf"));
                Funcionario.setNome(rs.getString("nome"));
                Funcionario.setRg(rs.getString("rg"));
                Funcionario.setCtps(rs.getString("ctps"));
                Funcionario.setTelefone(rs.getString("telefone"));
                Funcionario.setCnh(rs.getString("cnh"));

                if (rs.getObject("id_endereco", Integer.class) != null) {
                    Funcionario.getEndereco().setIn(rs.getInt("id_endereco"));
                    Funcionario.getEndereco().setBairro(rs.getString("bairro"));
                    Funcionario.getEndereco().setCep(rs.getString("cep"));
                    Funcionario.getEndereco().setCidade(rs.getString("cidade"));
                    Funcionario.getEndereco().setUf(rs.getString("uf"));
                    Funcionario.getEndereco().setRua(rs.getString("rua"));
                    Funcionario.getEndereco().setNumero(rs.getInt("numero"));
                }
                if (rs.getObject("id_filial", Integer.class) != null) {
                    Funcionario.getFilial().setId(rs.getInt("id_filial"));
                    Funcionario.getFilial().setNomeFantasia(rs.getString("nome"));
                    Funcionario.getFilial().setRazaoSocial(rs.getString("razao_social"));
                    Funcionario.getFilial().setCnpj(rs.getString("cnpj"));
                    Funcionario.getFilial().setInscricaoEstadual(rs.getString("inscricao_estadual"));                   
                }

                funcionario.add(Funcionario);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return funcionario;

    }

    public Funcionario carregarFuncionarioId(int idFuncionario) {
        Funcionario end = null;

        try {

            String sql = "SELECT * FROM public.funcionario" 
                    + " left join endereco as ed on funcionario.id_endereco = ed.id \n" 
                    + " left join filial as fil on funcionario.id_filial = fil.id \n"
                    + " where funcionario.id = " + idFuncionario;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                end = new Funcionario();
                end.setId(rs.getInt("id"));
                end.setCpf(rs.getString("cpf"));
                end.setNome(rs.getString("nome"));
                end.setRg(rs.getString("rg"));
                end.setCtps(rs.getString("ctps"));
                end.setTelefone(rs.getString("telefone"));
                end.setCnh(rs.getString("cnh"));

                if (rs.getObject("id_endereco", Integer.class) != null) {
                    end.getEndereco().setIn(rs.getInt("id_endereco"));
                    end.getEndereco().setBairro(rs.getString("bairro"));
                    end.getEndereco().setCep(rs.getString("cep"));
                    end.getEndereco().setCidade(rs.getString("cidade"));
                    end.getEndereco().setUf(rs.getString("uf"));
                    end.getEndereco().setRua(rs.getString("rua"));
                    end.getEndereco().setNumero(rs.getInt("numero"));
                }
                if (rs.getObject("id_filial", Integer.class) != null) {
                    end.getFilial().setId(rs.getInt("id_filial"));
                    end.getFilial().setNomeFantasia(rs.getString("nome"));
                    end.getFilial().setRazaoSocial(rs.getString("razao_social"));
                    end.getFilial().setCnpj(rs.getString("cnpj"));
                    end.getFilial().setInscricaoEstadual(rs.getString("inscricao_estadual"));                   
                }

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return end;

    }

    public boolean salvar(Funcionario end) {
        try {
            String sql = "INSERT INTO public.funcionario(\n"
                    + "	id, nome, cpf, rg, ctps, cnh, telefone, id_endereco, id_filial)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = criarPrepareStatement(sql);
            end.setId(gerarProximoId("funcionario"));
            ps.setInt(1, end.getId());
            ps.setString(2, end.getNome());
            ps.setString(3, end.getCpf());
            ps.setString(4, end.getRg());
            ps.setString(5, end.getCtps());
            ps.setString(6, end.getCnh());
            ps.setString(7, end.getTelefone());
            
            if (end.getEndereco() != null && end.getEndereco().getId() == null || end.getEndereco().getId() == 0) {
                daoEndereco.salvar(end.getEndereco());

                if (end.getEndereco() != null) {
                    ps.setInt(8, end.getEndereco().getId());
                }
            } else {
                ps.setObject(8, null);
            }
            if (end.getFilial()!= null && end.getFilial().getId() == null || end.getFilial().getId() == 0) {
                daoFilial.salvar(end.getFilial());

                if (end.getFilial()!= null) {
                    ps.setInt(9, end.getFilial().getId());
                }
            } else {
                ps.setObject(9, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar Cliente\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Funcionario funcionario) {
        try {
            String sql = "UPDATE public.funcionario\n"
                    + "	SET id=?, nome=?, cpf=?, rg=?, ctps=?, cnh=?, telefone=?, id_endereco=?, id_filial=?\n"
                    + "	WHERE  id = " + funcionario.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getCpf());
            ps.setString(3, funcionario.getRg());
            ps.setString(4, funcionario.getCtps());
            ps.setString(5, funcionario.getCnh());
            ps.setString(6, funcionario.getTelefone());
            if (funcionario.getEndereco() != null && funcionario.getEndereco().getId() != null) {
                ps.setInt(7, funcionario.getEndereco().getId());
            } else {
                ps.setObject(7, null);
            }
            if (funcionario.getFilial()!= null && funcionario.getFilial().getId() != null) {
                ps.setInt(8, funcionario.getFilial().getId());
            } else {
                ps.setObject(8, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar cliente\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM public.funcionario\n"
                    + "	WHERE id=" + funcionario.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar cliente\n" + e.getMessage());
            return false;
        }

    }

}

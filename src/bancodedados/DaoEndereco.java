package bancodedados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEndereco extends DAO {

    public ArrayList<Endereco> carregarEndereco() throws SQLException {
        ArrayList<Endereco> endereco = new ArrayList<>();

        try {

            String sql = "select * from endereco";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Endereco Endereco = new Endereco();
                Endereco.setIn(rs.getInt("id"));
                Endereco.setBairro(rs.getString("bairro"));
                Endereco.setCep(rs.getString("cep"));
                Endereco.setCidade(rs.getString("cidade"));
                Endereco.setUf(rs.getString("uf"));
                Endereco.setRua(rs.getString("rua"));
                Endereco.setNumero(rs.getInt("numero"));

                endereco.add(Endereco);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return endereco;

    }

    public Endereco carregarEnderecoId(int idEndereco) {
        Endereco end = null;

        try {

            String sql = "select * from endereco";
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                end = new Endereco();
                end.setIn(rs.getInt("id"));
                end.setBairro(rs.getString("bairro"));
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));
                end.setUf(rs.getString("uf"));
                end.setRua(rs.getString("rua"));
                end.setNumero(rs.getInt("numero"));

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return end;

    }

    public boolean salvar(Endereco end) {
        try {
            String sql = "INSERT INTO public.endereco(\n"
                    + "id, cep, cidade, uf, bairro, rua, numero)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = criarPrepareStatement(sql);
            end.setIn(gerarProximoId("endereco"));
            ps.setInt(1, end.getId());
            ps.setString(2, end.getCep());
            ps.setString(3, end.getCidade());
            ps.setString(4, end.getUf());
            ps.setString(5, end.getBairro());
            ps.setString(6, end.getRua());
            ps.setInt(7, end.getNumero());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar endereço\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Endereco endereco) throws SQLException {
        try {
            String sql = "UPDATE public.endereco\n"
                    + "	SET cidade=?, uf=?, bairro=?, rua=?, cep=?, id=?, numero=?"
                    + "	WHERE id = " + endereco.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, endereco.getBairro());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getCidade());
            ps.setString(4, endereco.getUf());
            ps.setString(5, endereco.getRua());
            ps.setInt(6, endereco.getNumero());

        } catch (SQLException e) {
            System.out.println("Falha ao editar endereco\n" + e.getMessage());

        }
        return false;
    }

    public String comandoSQLRemover(Endereco end) {
        String sql = "DELETE FROM public.endereco\n"
                + "	WHERE id=" + end.getId();
        return sql;
    }

    public boolean remover(Endereco endereco) {
        try {
            String sql = "DELETE FROM public.endereco\n"
                    + "	WHERE id=" + endereco.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar endereco\n" + e.getMessage());
            return false;
        }

    }

    public Endereco consultarCEP(String cep)  {
        cep = cep.trim();
        Endereco end = null;
        try {
            String sql = "SELECT cep, cidade, uf, bairro, rua\n"
                    + "	FROM public.cep_endereco where cep = '" + cep + "'";
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                end = new Endereco();
                end.setCep(rs.getString("cep"));
                end.setCidade(rs.getString("cidade"));
                end.setUf(rs.getString("uf"));
                end.setBairro(rs.getString("bairro"));
                end.setRua(rs.getString("rua"));
            }
        }catch (SQLException ex){
                    System.out.println("Fala ao carregar o cep \n"+ ex.getMessage());
            }
        return end;
        }
        
    

}

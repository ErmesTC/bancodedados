package bancodedados;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoCliente extends DAO {

    public DaoEndereco daoEndereco;

    public DaoCliente() {
        daoEndereco = new DaoEndereco();
    }

    public ArrayList<Cliente> carregarCliente() {
        ArrayList<Cliente> cliente = new ArrayList<>();

        try {

            String sql = "select * from cliente"
                    + " left join endereco as ed on cliente.id_endereco = ed.id ";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Cliente Cliente = new Cliente();
                Cliente.setId(rs.getInt("id"));
                Cliente.setCpf(rs.getString("cpf"));
                Cliente.setNome(rs.getString("nome"));
                Cliente.setRg(rs.getString("rg"));
                Cliente.setEmail(rs.getString("email"));
                Cliente.setDataNascimento(rs.getDate("data_nasc"));
                Cliente.setCnh(rs.getString("cnh"));

                if (rs.getObject("id_endereco", Integer.class) != null) {
                    Cliente.getEndereco().setIn(rs.getInt("id_endereco"));
                    Cliente.getEndereco().setBairro(rs.getString("bairro"));
                    Cliente.getEndereco().setCep(rs.getString("cep"));
                    Cliente.getEndereco().setCidade(rs.getString("cidade"));
                    Cliente.getEndereco().setUf(rs.getString("uf"));
                    Cliente.getEndereco().setRua(rs.getString("rua"));
                    Cliente.getEndereco().setNumero(rs.getInt("numero"));

                }

                cliente.add(Cliente);

            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return cliente;

    }

    public Cliente carregarClienteId(int idCliente) {
        Cliente end = null;

        try {

            String sql = "select * from cliente"
                    + " left join endereco as ed on cliente.id_endereco = ed.id "
                    + " where cliente.id = "+idCliente;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                end = new Cliente();
                end.setId(rs.getInt("id"));
                end.setCpf(rs.getString("cpf"));
                end.setNome(rs.getString("nome"));
                end.setRg(rs.getString("rg"));
                end.setEmail(rs.getString("email"));
                end.setDataNascimento(rs.getDate("data_nasc"));
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

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return end;

    }

    public boolean salvar(Cliente end) {
        try {
            String sql = "INSERT INTO public.cliente(\n"
                    + "	id, cpf, nome, rg, email,cnh , data_nasc,id_endereco)\n"
                    + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = criarPrepareStatement(sql);
            end.setId(gerarProximoId("cliente"));
            ps.setInt(1, end.getId());
            ps.setString(2, end.getCpf());
            ps.setString(3, end.getNome());
            ps.setString(4, end.getRg());
            ps.setString(5, end.getEmail());
            ps.setString(6, end.getCnh());
            ps.setDate(7, new java.sql.Date(end.getDataNascimento().getTime()));
            if (end.getEndereco() != null && end.getEndereco().getId() == null || end.getEndereco().getId() == 0) {
                daoEndereco.salvar(end.getEndereco());

                if (end.getEndereco() != null) {
                    ps.setInt(8, end.getEndereco().getId());
                }
            } else {
                ps.setObject(8, null);
            }

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar Cliente\n" + ex.getMessage());
            return false;
        }
    }

    public boolean atualizar(Cliente cliente) {
        try {
            String sql = "UPDATE public.cliente\n"
                    + "	SET nome=?, cpf=?, rg=?, email=?, data_nasc=?, cnh=?, id_endereco=?\n"
                    + "	WHERE id = " + cliente.getId();

            PreparedStatement ps = criarPrepareStatement(sql);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getCpf());
            ps.setString(3, cliente.getRg());           
            ps.setString(4, cliente.getEmail());
            ps.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTime()));
            ps.setString(6, cliente.getCnh());
            if (cliente.getEndereco() != null && cliente.getEndereco().getId() != null) {
                ps.setInt(7, cliente.getEndereco().getId());
           }else{
                ps.setObject(7, null);
            }
            
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao editar cliente\n" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Cliente cliente) {
        try {
            String sql = "DELETE FROM public.cliente\n"
                    + "	WHERE id=" + cliente.getId();
            executarSql(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Falha ao deletar cliente\n" + e.getMessage());
            return false;
        }

    }

}

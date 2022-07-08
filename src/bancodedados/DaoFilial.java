package bancodedados;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;

public class DaoFilial extends DAO {
private DaoEndereco daoendereco;

    public DaoFilial() {
        this.daoendereco = new DaoEndereco();
    }
    public ArrayList<Filial> carregarFiliais() {
        ArrayList<Filial> filiais = new ArrayList<>();

        try {

            String sql = "select * from filial"
                    + " left join endereco as ed on filial.id_endereco = ed.id ";
            ResultSet rs = consultaSQL(sql);
            while (rs.next()) {
                Filial filial = new Filial();
                filial.setId(rs.getInt("id"));
                filial.setCnpj(rs.getString("cnpj"));
                filial.setRazaoSocial(rs.getString("razao_social"));
                filial.setNomeFantasia(rs.getString("nome"));
                filial.setInscricaoEstadual("inscricao_estadual");
                
                if (rs.getObject("id_endereco", Integer.class) != null) {
                    filial.getEndereco().setIn(rs.getInt("id_endereco"));
                    filial.getEndereco().setBairro(rs.getString("bairro"));
                    filial.getEndereco().setCep(rs.getString("cep"));
                    filial.getEndereco().setCidade(rs.getString("cidade"));
                    filial.getEndereco().setUf(rs.getString("uf"));
                    filial.getEndereco().setRua(rs.getString("rua"));
                    filial.getEndereco().setNumero(rs.getInt("numero"));
                }
                
                       
                filiais.add(filial);
                
                
 
            }
        } catch (SQLException ex) {
            System.out.println("Erro" + ex.getMessage());
        }
        return filiais;
    }
    
    public Filial carregarFilialId(int idFilial) {
        Filial filial = null;

        try {

            String sql = "select * from filial"
                    + " left join endereco as ed on filial.id_endereco = ed.id "
                    + " where filial.id = "+idFilial;
            ResultSet rs = consultaSQL(sql);
            if (rs.next()) {
                filial = new Filial();
                filial.setId(rs.getInt("id"));
                filial.setCnpj(rs.getString("cnpj"));
                filial.setRazaoSocial(rs.getString("razao_social"));
                filial.setNomeFantasia(rs.getString("nome"));
                filial.setInscricaoEstadual(rs.getString("inscricao_estadual"));
                
                if (rs.getObject("id_endereco", Integer.class) != null) {
                    filial.getEndereco().setIn(rs.getInt("id_endereco"));
                    filial.getEndereco().setBairro(rs.getString("bairro"));
                    filial.getEndereco().setCep(rs.getString("cep"));
                    filial.getEndereco().setCidade(rs.getString("cidade"));
                    filial.getEndereco().setUf(rs.getString("uf"));
                    filial.getEndereco().setRua(rs.getString("rua"));
                    filial.getEndereco().setNumero(rs.getInt("numero"));
                }

            }
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
        return filial;
    }
        
    public boolean salvar(Filial filial) {
        try {
            String sql = "INSERT INTO public.filial(\n" +
"	id, nome, razao_social, cnpj, inscricao_estadual, id_endereco)\n" +
"	VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = criarPrepareStatement(sql);
            filial.setId(gerarProximoId("endereco"));
            ps.setInt(1, filial.getId());
            ps.setString(2, filial.getCnpj());
            ps.setString(3, filial.getRazaoSocial());
            ps.setString(4, filial.getNomeFantasia());
            ps.setString(5, filial.getInscricaoEstadual());
            //if(filial.getEndereco().getId() == null){
            //    DaoEndereco.salvar(filial.getEndereco());}   
            if (!daoendereco.salvar(filial.getEndereco())){
                return false;
            }
            ps.setInt(6, filial.getEndereco().getId());
           

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("falha ao salvar Filial\n" + ex.getMessage());
            return false;
        }
    }
    
    public boolean atualizar(Filial filial) throws SQLException{
        try {
            String sql = "UPDATE public.filial"+
	"SET id=?, nome=?, razao_social=?, cnpj=?, inscricao_estadual=?, id_endereco=?"+
	"WHERE id = "+filial.getId();
                  
        PreparedStatement ps = criarPrepareStatement(sql);
        ps.setString(1, filial.getCnpj());
        ps.setString(2, filial.getRazaoSocial());
        ps.setString(3, filial.getNomeFantasia());
        ps.setString(4, filial.getInscricaoEstadual());
        
    
            
        
        
        }catch (SQLException e){
            System.out.println("Falha ao editar filial\n"+e.getMessage());
            
        }
        return false;        
    }
    
    public String comandoSQLRemover (Filial filial){
        String sql = "DELETE FROM public.filial\n" +
                         "	WHERE id="+filial.getId();
        return sql;
    }
    
    public boolean remover (Filial filial){
        try{
            String sql = "DELETE FROM public.filial\n" +
                         "	WHERE id="+filial.getId();            
            executarSql(sql);
            return true;                            
        } catch (SQLException e){           
            System.out.println("Falha ao deletar filial\n"+e.getMessage());
            return false;
        }
        
    }
    
  

}

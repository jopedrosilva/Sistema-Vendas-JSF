package br.edu.ufrn.clientes.dao;


import br.edu.ufrn.clientes.bean.exception.ErroSistema;
import br.edu.ufrn.clientes.entidade.Cliente;
import br.edu.ufrn.clientes.util.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    public void salvar(Cliente cliente) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if (cliente.getId() == null) {
                ps = conexao.prepareStatement("INSERT INTO `cliente` (`nome`, `email`, `senha`, `telefone`, `endereco`) VALUES (?,?,?,?,?)");           
            } else {
                ps = conexao.prepareStatement("update cliente set nome=?, email=?, senha=?, telefone=?, endereco=? where id=?");
                ps.setInt(6, cliente.getId());
            }
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getSenha());
            ps.setString(4, cliente.getTelefone());
            ps.setString(5, cliente.getEndereco());
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar o cliente!", ex);
        }
    }
    
    public void deletar(Integer idCliente) throws ErroSistema {
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from cliente where id = ?");
            ps.setInt(1, idCliente);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o cliente!", ex);
        }
    }
    
    public List<Cliente> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from cliente");
            ResultSet resultSet = ps.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setSenha(resultSet.getString("senha"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEndereco(resultSet.getString("endereco"));
                clientes.add(cliente);
            }
            FabricaConexao.fecharConexao();
            return clientes;
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os clientes!", ex);
        }
    }
}

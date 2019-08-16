
package br.com.alicio.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alicio.projeto.data.ConexaoJDBC;
import br.com.alicio.projeto.data.ConexaoMysqlJDBC;
import br.com.alicio.projeto.model.Cliente;

public class ClienteDAO {

	private final ConexaoJDBC conexao;

	public ClienteDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Cliente cliente) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO cliente (nm_cliente, num_cliente, cpf_cliente) VALUES (?, ?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, cliente.getNm_cliente());
			stmt.setInt(2, cliente.getNum_cliente());
			stmt.setString(3, cliente.getCpf_cliente());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Cliente cliente) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE cliente SET num_cliente = ?, nm_cliente = ?, cpf_cliente WHERE idCliente = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, cliente.getNum_cliente());
			stmt.setString(2, cliente.getNm_cliente());
			stmt.setString(3, cliente.getCpf_cliente());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int idCliente) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM cliente WHERE idCliente = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idCliente);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Cliente selecionar(int idCliente) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM cliente WHERE idCliente= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idCliente);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Cliente> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM cliente ORDER BY idCliente";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Cliente> chamados = new ArrayList<>();

			while (rs.next()) {
				chamados.add(parser(rs));
			}

			return chamados;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Cliente parser(ResultSet resultSet) throws SQLException {
		Cliente c = new Cliente();

		c.setIdCliente(resultSet.getInt("idCliente"));
		c.setNm_cliente(resultSet.getString("nm_cliente"));
		c.setNum_cliente(resultSet.getInt("num_cliente"));

		return c;
	}
}

package br.com.alicio.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alicio.projeto.data.ConexaoJDBC;
import br.com.alicio.projeto.data.ConexaoMysqlJDBC;
import br.com.alicio.projeto.model.Conta;

public class ContaDAO {

	private final ConexaoJDBC conexao;

	public ContaDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Conta conta) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO conta (tp_conta, num_conta, saldo, limite) VALUES (?, ?, ?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, conta.getTp_conta());
			stmt.setInt(2, conta.getNum_conta());
			stmt.setDouble(3, conta.getSaldo());
			stmt.setDouble(4, conta.getLimite());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Conta conta) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE conta SET num_conta = ?, tp_conta = ?, saldo = ?, limite = ? WHERE idConta = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, conta.getNum_conta());
			stmt.setString(2, conta.getTp_conta());
			stmt.setDouble(3, conta.getSaldo());
			stmt.setDouble(4, conta.getLimite());
			stmt.setLong(5, conta.getIdConta());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int idConta) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM conta WHERE idConta = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idConta);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Conta selecionar(int idConta) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM conta WHERE idConta= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idConta);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Conta> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM conta ORDER BY idConta";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Conta> chamados = new ArrayList<>();

			while (rs.next()) {
				chamados.add(parser(rs));
			}

			return chamados;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Conta parser(ResultSet resultSet) throws SQLException {
		Conta a = new Conta();

		a.setIdConta(resultSet.getInt("idConta"));
		a.setTp_conta(resultSet.getString("tp_conta"));
		a.setNum_conta(resultSet.getInt("num_conta"));
		a.setSaldo(resultSet.getLong("saldo"));
		a.setLimite(resultSet.getLong("limite"));
		
		
		return a;
	}
}

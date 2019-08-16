package br.com.alicio.projeto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alicio.projeto.data.ConexaoJDBC;
import br.com.alicio.projeto.data.ConexaoMysqlJDBC;
import br.com.alicio.projeto.model.Agencia;

public class AgenciaDAO {

	private final ConexaoJDBC conexao;

	public AgenciaDAO() throws SQLException, ClassNotFoundException {
		this.conexao = new ConexaoMysqlJDBC();
	}

	public Long inserir(Agencia agencia) throws SQLException, ClassNotFoundException {
		Long id = null;
		String sqlQuery = "INSERT INTO agencia (nm_agencia, num_agencia) VALUES (?, ?) ";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setString(1, agencia.getNm_agencia());
			stmt.setInt(2, agencia.getNum_agencia());
			stmt.execute();

			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return id;
	}

	public int alterar(Agencia agencia) throws SQLException, ClassNotFoundException {
		String sqlQuery = "UPDATE agencia SET num_agencia = ?, nm_agencia = ? WHERE idAgencia = ?";
		int linhasAfetadas = 0;

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, agencia.getNum_agencia());
			stmt.setString(2, agencia.getNm_agencia());
			stmt.setLong(3, agencia.getIdAgencia());

			linhasAfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAfetadas;
	}

	public int excluir(int idAgencia) throws SQLException, ClassNotFoundException {
		int linhasAlfetadas = 0;
		String sqlQuery = "DELETE FROM agencia WHERE idAgencia = ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idAgencia);
			linhasAlfetadas = stmt.executeUpdate();
			this.conexao.commit();
		} catch (SQLException e) {
			this.conexao.rollback();
			throw e;
		}

		return linhasAlfetadas;
	}

	public Agencia selecionar(int idAgencia) throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM agencia WHERE idAgencia= ?";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			stmt.setInt(1, idAgencia);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return parser(rs);
			}
		} catch (SQLException e) {
			throw e;
		}

		return null;
	}

	public List<Agencia> listar() throws SQLException, ClassNotFoundException {
		String sqlQuery = "SELECT * FROM agencia ORDER BY idAgencia";

		try {
			PreparedStatement stmt = this.conexao.getConnection().prepareStatement(sqlQuery);
			ResultSet rs = stmt.executeQuery();

			List<Agencia> chamados = new ArrayList<>();

			while (rs.next()) {
				chamados.add(parser(rs));
			}

			return chamados;
		} catch (SQLException e) {
			throw e;
		}
	}

	private Agencia parser(ResultSet resultSet) throws SQLException {
		Agencia a = new Agencia();

		a.setIdAgencia(resultSet.getInt("idAgencia"));
		a.setNm_agencia(resultSet.getString("nm_agencia"));
		a.setNum_agencia(resultSet.getInt("num_agencia"));

		return a;
	}
}

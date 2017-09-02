package controles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.AdmBanco;

public class JogosDao {

	private AdmBanco banco;
	private ResultSet rs;

	public void salvarJogos(String nome, int Genero, int plataforma) {

		try {
			banco = new AdmBanco();
			Statement stmt = banco.conectar().createStatement();
			stmt.executeUpdate(
					"INSERT INTO JOGOS (NOME,FKIDGENERO,FKIDPLATAFORMA) VALUES ('" + nome + "'," + Genero + ",'"+plataforma+"')");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public int buscarIdBancoGenero(String busca) {
		

		banco = new AdmBanco();
		int valor = 0;
		try {
			Statement stmt = banco.conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM GENERO");
			while (rs.next()) {
				valor = (rs.getInt("IDGENERO"));
			}

			banco.conectar().close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;

	}
	
	
	
	
public int buscarIdBancoPlataforma(String busca) {
		

		banco = new AdmBanco();
		int valor = 0;
		try {
			Statement stmt = banco.conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM PLATAFORMA");
			while (rs.next()) {
				valor = (rs.getInt("IDPLATAFORMA"));
			}

			banco.conectar().close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valor;

	}
	
	

	public List<String> popularCombo() {
		banco = new AdmBanco();
		List<String> valores = new ArrayList<>();
		try {
			Statement stmt = banco.conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM GENERO");
			while (rs.next()) {
				valores.add(rs.getString("NOME"));

			}

			banco.conectar().close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valores;

	}

}

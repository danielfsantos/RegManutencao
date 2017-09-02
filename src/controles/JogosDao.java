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
			stmt.executeUpdate("INSERT INTO JOGOS (NOME,FKIDGENERO,FKIDPLATAFORMA) VALUES ('" + nome + "'," + Genero
					+ ",'" + plataforma + "')");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	

}

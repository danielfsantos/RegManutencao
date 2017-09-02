package controles;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import br.com.dao.AdmBanco;

public class JogosDao {

	private AdmBanco banco;

	public void salvarJogos(int ID, String nome, String Genero, String plataforma) {

		try {
			banco = new AdmBanco();
			Statement stmt = banco.conectar().createStatement();
			stmt.executeUpdate(
					"insert into JOGOS values ('" + ID + "','" + nome + "','" + Genero + "','" + plataforma + "')");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}

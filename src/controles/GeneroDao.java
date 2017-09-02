package controles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.AdmBanco;

public class GeneroDao {

	private AdmBanco banco;
	private ResultSet rs;

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
	
	
	
	
	public List<String> popularComboGenero() {
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

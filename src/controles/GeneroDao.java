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

	/**
	 * 
	 * Função que retorna o ID da tabela Genero Recebendo um indice de busca na base
	 *
	 *2 de set de 2017
	 *
	 *int
	 *	
	 *@author Daniel Fernandes
	 */
	public int buscarIdBancoGenero(String busca) {

		banco = new AdmBanco();
		int valor = 0;
		try {
			Statement stmt = banco.conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM GENERO WHERE NOME = '"+busca+"'");
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
	
	
	
	/**
	 * 
	 * Função que retorna uma Lista com as informações da tabela GENERO do Banco de dados 
	 *
	 *2 de set de 2017
	 *
	 *List<String>
	 *	
	 *@author Daniel Fernandes
	 */
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

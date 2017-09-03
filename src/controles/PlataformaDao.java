package controles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.dao.AdmBanco;

public class PlataformaDao {

	private AdmBanco banco;
	private ResultSet rs;

	
	
	/**
	 * 
	 * Função que retorna o ID da tabela PLATAFORMA Recebendo um indice de busca na base
	 *
	 *2 de set de 2017
	 *
	 *int
	 *	
	 *@author Daniel Fernandes
	 */
	public int buscarIdBancoPlataforma(String busca) {

		banco = new AdmBanco();
		int valor = 0;
		try {
			Statement stmt = banco.conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM PLATAFORMA WHERE NOME = '"+busca+"'");
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
	
	
	/**
	 * 
	 * Função que retorna uma Lista com as informações da tabela PLATAFORMA do Banco de dados 
	 *
	 *2 de set de 2017
	 *
	 *List<String>
	 *	
	 *@author Daniel Fernandes
	 */
	public List<String> popularComboPlataforma() {
		banco = new AdmBanco();
		List<String> valores = new ArrayList<>();
		try {
			Statement stmt = banco.conectar().createStatement();
			rs = stmt.executeQuery("SELECT * FROM PLATAFORMA");
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

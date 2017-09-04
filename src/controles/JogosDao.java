package controles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.dao.AdmBanco;

public class JogosDao {

	private AdmBanco banco;

	public void salvarJogos(String nome, int genero, int plataforma) {

		try {
			banco = new AdmBanco();
			Connection conexao = banco.conectar();
			PreparedStatement stmt = conexao.prepareStatement("INSERT INTO JOGOS (NOME,FKIDGENERO,FKIDPLATAFORMA) VALUES (?,?,?)");
			stmt.setString(1, nome);
			stmt.setInt(2, genero);
			stmt.setInt(3, plataforma);
			stmt.execute();
			
			JOptionPane.showMessageDialog(null, "Game Cadastrado com sucesso");
			banco.conectar().close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Não Foi possivel Cadastrar !");
		}

	}

	

}

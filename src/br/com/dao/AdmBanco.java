package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AdmBanco {

	private Connection con;
	private String userName = "daniel";
	private String passName = "root";
	private String bancoUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private ResultSet rs;
	private Statement stmt;

	/**
	 * Conexão com a base de dados Oracle.
	 * 
	 *2 de set de 2017
	 *void
	 *@author Daniel Fernandes
	 */
	public Connection conectar() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(bancoUrl, userName, passName);
			System.out.println("Conectado com sucesso !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro "+e.getMessage());
			System.err.println(e.getMessage());
		}
		return con;
	}

	/**
	 * Select dos dados de Login
	 *
	 *2 de set de 2017
	 *
	 *List<String>
	 *	
	 *@author Daniel Fernandes
	 */
	public List<String> selecionar() {
		conectar();

		List<String> userpass = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from Login");
			while (rs.next()) {
				userpass.add(rs.getString("nome"));
				userpass.add(rs.getString("senha"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userpass;

	}

	public ObservableList<String> valoresDB() {
		conectar();
		ObservableList<String> valores = FXCollections.observableArrayList();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from tabjogos");
			while (rs.next()) {
				valores.add(rs.getString("nome"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return valores;

	}

}

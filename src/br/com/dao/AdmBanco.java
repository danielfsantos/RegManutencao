package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AdmBanco {

	private Connection con;
	private String userName = "SYSTEM";
	private String passName = "Inmetrics01";
	private String bancoUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private ResultSet rs;
	private Statement stmt;

	/**
	 * Conexão com a base de dados
	 * 
	 * 
	 * 
	 * 
	 */
	public void conectar() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(bancoUrl, userName, passName);
			System.out.println("Conectado com sucesso !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro");
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 * Exemplo de select
	 * 
	 * 
	 */
	public List<String> selecionar() {
		conectar();
		
		List<String> userpass = new ArrayList<String>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from login");
			while (rs.next()) {
				userpass.add(rs.getString("usuario"));
				userpass.add(rs.getString("senha"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userpass;

	}

}

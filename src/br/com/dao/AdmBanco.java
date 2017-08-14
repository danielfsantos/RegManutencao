package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AdmBanco {

	private Connection con;
	String serverName = "localhost";
	String portNumber = "1521";
	String servico = "xe";
	String userName = "SYSTEM";
	String passName = "Inmetrics01";
	String url2 = "jdbc:oracle:thin:@localhost:1521:xe";
	ResultSet rs;
	Statement stmt;

	public void conectar() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url2, userName, passName);
			JOptionPane.showMessageDialog(null, "Conectado com sucesso !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro");
			System.err.println(e.getMessage());
		}
	}

	public void selecionar() {
		try {
			rs = stmt.executeQuery("select * from TESTE");
			while (rs.next()) {
				System.out.println(rs.getString("NOMETESTE"));
			}

		} catch (Exception e) {

		}
	}

}

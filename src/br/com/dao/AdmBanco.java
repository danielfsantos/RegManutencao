package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class AdmBanco {

	private Connection con;

	private String userName = "SYSTEM";
	private String passName = "Inmetrics01";
	private String bancoUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private ResultSet rs;
	private Statement stmt;

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

	public void selecionar() {
		try {
			conectar();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from TESTE");
			while (rs.next()) {
				System.out.println(rs.getString("NOMETESTE"));
			}

		} catch (Exception e) {
			System.err.println("Ocorreu um erro " + e.getMessage());
		}
	}

}

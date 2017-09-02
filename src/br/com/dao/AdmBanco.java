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
	private String userName = "root";
	private String passName = "root";
	private final String bancoUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String bancoUrlMysql = "jdbc:mysql://localhost:3306/GAMER";
	private ResultSet rs;
	private Statement stmt;

	/**
	 * Conexão com a base de dados Oracle.
	 * 
	 * 2 de set de 2017 void
	 * 
	 * @author Daniel Fernandes
	 */
	public Connection conectar() {
		// oracle.jdbc.driver.OracleDriver
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(bancoUrlMysql, userName, passName);
			System.out.println("Conectado com sucesso !");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro " + e.getMessage());
			System.err.println(e.getMessage());
		}
		return con;
	}
}
